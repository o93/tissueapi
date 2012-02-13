package me.o93.tissue.service;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import me.o93.tissue.model.At;
import me.o93.tissue.model.Task;
import me.o93.tissue.model.User;

import org.slim3.datastore.Datastore;
import org.slim3.datastore.S3QueryResultList;
import org.slim3.util.BeanUtil;
import org.slim3.util.RequestMap;

import com.google.appengine.api.datastore.DatastoreTimeoutException;
import com.google.appengine.api.datastore.GeoPt;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.Transaction;
import com.google.apphosting.api.ApiProxy.UnknownException;


public class TaskService {
    private static final int RETRY_SIZE = 5;
    
    public static final String PARAM_KEY = "key";
    public static final String PARAM_BEGIN = "begin";
    public static final String PARAM_END = "end";
    public static final String PARAM_USER_KEY = "userKey";
    public static final String PARAM_PARENT_KEY = "parentKey";
    public static final String PARAM_POINT = "spotPoint";
    public static final String PARAM_TAGS = "tagsArray";
    
    /**
     * Put task. Used transaction and retry.
     * @param request
     * @return
     */
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
    
    /**
     * Put task. Datastore put.
     * @param tx
     * @param request
     * @return
     */
    private Task put(Transaction tx, HttpServletRequest request) {
        RequestMap input = new RequestMap(request);
        String keyString = (String) input.get(PARAM_KEY);
        
        Task task = getTask(tx, request, input, keyString);
        At at = getAt(tx, task, keyString);
        
        Datastore.put(tx, task, at);
        
        return task;
    }

    /**
     * Get task. Request parameter -> Task model
     * @param tx
     * @param request
     * @param input
     * @param keyString
     * @return
     */
    private Task getTask(Transaction tx, HttpServletRequest request, RequestMap input, String keyString) {
        Key userKey = KeyFactory.stringToKey((String) input.get(PARAM_USER_KEY));
        
        Task task;
        if (isNull(keyString)) {
            task = new Task();
            task.setKey(Datastore.allocateId(userKey, Task.class));
        } else {
            task = Datastore.get(tx, Task.class, KeyFactory.stringToKey(keyString));
        }
        BeanUtil.copy(input, task);
        
        task.setBeginAt(new Date(Long.valueOf((String) input.get(PARAM_BEGIN))));
        task.setEndAt(new Date(Long.valueOf((String) input.get(PARAM_END))));
        
        task.setPoint(getGeoPt(input));

        String[] tagsArray = request.getParameterValues(PARAM_TAGS);
        if (tagsArray != null) {
            task.setTags(Arrays.asList(tagsArray));
        }
        task.getUserRef().setModel(Datastore.get(User.class, userKey));
        
        String parentKeyString = (String) input.get(PARAM_PARENT_KEY);
        if (isNull(parentKeyString)) {
            task.getParentRef().setKey(null);
        } else {
            task.getParentRef().setKey(KeyFactory.stringToKey(parentKeyString));
        }
        return task;
    }

    /**
     * get geo point.
     * @param input
     * @return
     */
    private GeoPt getGeoPt(RequestMap input) {
        String geoPtString = (String) input.get(PARAM_POINT);
        if (isNull(geoPtString)) {
            return null;
        }
        String[] geoPtArray = geoPtString.split(",");
        if (geoPtArray.length >= 2) {
            return new GeoPt(Float.parseFloat(geoPtArray[0]), Float.parseFloat(geoPtArray[1]));
        }
        return null;
    }
    
    /**
     * Get At. Set date and likeCount.
     * @param tx
     * @param task
     * @param keyString
     * @return
     */
    private At getAt(Transaction tx, Task task, String keyString) {
        At at = null;
        if (isNull(keyString)) {
            at = new At();
            at.setKey(Datastore.allocateId(task.getKey(), At.class));
            task.getAtRef().setKey(at.getKey());
        } else {
            at = Datastore.get(tx, At.class, task.getAtRef().getKey());
        }
        at.getUserRef().setKey(task.getUserRef().getKey());
        at.refreshDate(task.getBeginAt());
        
        task.setLikeCount(at.getLike());
        
        return at;
    }

    /**
     * Null check.
     * @param parentKeyString
     * @return
     */
    private boolean isNull(String parentKeyString) {
        return parentKeyString == null || "".equals(parentKeyString);
    }

    /**
     * Retry sleep.
     */
    private static void sleep() {
        try {
            Thread.sleep(20);
        } catch (Exception e1) {}
    }
}
