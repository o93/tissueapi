package me.o93.tissue.service;

import java.util.Arrays;
import java.util.ConcurrentModificationException;

import javax.servlet.http.HttpServletRequest;

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
    public static final String PARAM_GEO_PT = "geoPt";
    public static final String PARAM_TAGS = "tagsArray";
    
    public Task put(HttpServletRequest request) {
        
        for (int count = 1; count <= RETRY_SIZE; count++) {
            try {
                Transaction tx = Datastore.beginTransaction();
                return put(tx, request);
            } catch (DatastoreTimeoutException e) {
                if (count == RETRY_SIZE) throw e;
            } catch (UnknownException e) {
                sleep();
                if (count == RETRY_SIZE) throw e;
            } catch (ConcurrentModificationException e) {
                sleep();
                if (count == RETRY_SIZE) throw e;
            }
        }
        return null;
    }
    
    private static Task put(Transaction tx, HttpServletRequest request) {
        Task task = null;
        
        RequestMap input = new RequestMap(request);
        String keyString = (String) input.get(PARAM_KEY);
        
        if (keyString == null) {
            task = new Task();
        } else {
            task = Datastore.get(tx, Task.class, KeyFactory.stringToKey(keyString));
        }
        BeanUtil.copy(input, task);

        task.setPoint(getGeoPt(input));

        String[] tagsArray = request.getParameterValues(PARAM_TAGS);
        task.setTags(Arrays.asList(tagsArray));
        
        task.getUserRef().setKey(KeyFactory.stringToKey((String) input.get(PARAM_USER_KEY)));
        
        String parentKeyString = (String) input.get(PARAM_PARENT_KEY);
        if (parentKeyString != null) {
            task.getParentRef().setKey(KeyFactory.stringToKey(parentKeyString));
        }
        
        Datastore.put(tx, task);
        
        return task;
    }

    private static GeoPt getGeoPt(RequestMap input) {
        String geoPtString = (String) input.get(PARAM_GEO_PT);
        if (geoPtString == null || "".equals(geoPtString)) {
            return null;
        }
        String[] geoPtArray = geoPtString.split(",");
        if (geoPtArray.length >= 2) {
            return new GeoPt(Float.parseFloat(geoPtArray[0]), Float.parseFloat(geoPtArray[1]));
        }
        return null;
    }
    
    private static void sleep() {
        try {
            Thread.sleep(20);
        } catch (Exception e1) {}
    }
}
