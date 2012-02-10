package me.o93.tissue.service;

import java.util.Arrays;
import java.util.ConcurrentModificationException;

import javax.servlet.http.HttpServletRequest;

import me.o93.tissue.model.At;
import me.o93.tissue.model.Task;

import org.slim3.datastore.Datastore;
import org.slim3.util.BeanUtil;
import org.slim3.util.RequestMap;

import com.google.appengine.api.datastore.DatastoreTimeoutException;
import com.google.appengine.api.datastore.GeoPt;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.Transaction;
import com.google.apphosting.api.ApiProxy.UnknownException;


public class TaskService {
    private static final int RETRY_SIZE = 5;
    
    public static final String PARAM_KEY = "key";
    public static final String PARAM_USER_KEY = "userKey";
    public static final String PARAM_PARENT_KEY = "parentKey";
    public static final String PARAM_POINT = "point";
    public static final String PARAM_TAGS = "tagsArray";
    
    public Task put(HttpServletRequest request) {
        
        for (int count = 1; count <= RETRY_SIZE; count++) {
            Transaction tx = Datastore.beginTransaction();
            try {
                Task task = put(tx, request);
                tx.commit();
                return task;
            } catch (DatastoreTimeoutException e) {
                if (count == RETRY_SIZE) throw e;
            } catch (UnknownException e) {
                sleep();
                if (count == RETRY_SIZE) throw e;
            } catch (ConcurrentModificationException e) {
                sleep();
                if (count == RETRY_SIZE) throw e;
            } finally {
                if (tx.isActive()) {
                    tx.rollback();
                }
            }
        }
        return null;
    }
    
    private Task put(Transaction tx, HttpServletRequest request) {
        
        RequestMap input = new RequestMap(request);
        String keyString = (String) input.get(PARAM_KEY);
        
        Task task = getTask(tx, request, input, keyString);
        At at = getAt(tx, request, task, keyString);
        
        Datastore.put(tx, task, at);
        tx.commit();
        
        return task;
    }

    private Task getTask(Transaction tx, HttpServletRequest request, RequestMap input, String keyString) {
        Task task;
        if (keyString == null || "".equals(keyString)) {
            task = new Task();
            task.setKey(Datastore.allocateId(Task.class));
        } else {
            task = Datastore.get(tx, Task.class, KeyFactory.stringToKey(keyString));
        }
        BeanUtil.copy(input, task);

        task.setPoint(getGeoPt(input));

        String[] tagsArray = request.getParameterValues(PARAM_TAGS);
        task.setTags(Arrays.asList(tagsArray));
        
        task.getUserRef().setKey(KeyFactory.stringToKey((String) input.get(PARAM_USER_KEY)));
        
        String parentKeyString = (String) input.get(PARAM_PARENT_KEY);
        if (parentKeyString != null && !"".equals(parentKeyString)) {
            task.getParentRef().setKey(KeyFactory.stringToKey(parentKeyString));
        }
        return task;
    }

    private GeoPt getGeoPt(RequestMap input) {
        String geoPtString = (String) input.get(PARAM_POINT);
        if (geoPtString == null || "".equals(geoPtString)) {
            return null;
        }
        String[] geoPtArray = geoPtString.split(",");
        if (geoPtArray.length >= 2) {
            return new GeoPt(Float.parseFloat(geoPtArray[0]), Float.parseFloat(geoPtArray[1]));
        }
        return null;
    }
    
    private At getAt(Transaction tx, HttpServletRequest request, Task task, String keyString) {
        At at = null;
        if (keyString == null || "".equals(keyString)) {
            at = new At();
            at.setKey(Datastore.allocateId(task.getKey(), At.class));
            task.getAtRef().setKey(at.getKey());
        } else {
            at = Datastore.get(tx, At.class, task.getAtRef().getKey());
        }
        at.getUserRef().setKey(task.getUserRef().getKey());
        
        // TODO:timezone..umm..
        
        return at;
    }
    
    private static void sleep() {
        try {
            Thread.sleep(20);
        } catch (Exception e1) {}
    }
}
