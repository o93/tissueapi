package me.o93.tissue.controller.task;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import java.util.Date;

import me.o93.tissue.controller.ResponseJson;
import me.o93.tissue.model.Task;
import me.o93.tissue.model.User;

import org.junit.Test;
import org.mortbay.util.ajax.JSON;
import org.slim3.datastore.Datastore;
import org.slim3.tester.ControllerTestCase;

import com.google.appengine.api.datastore.KeyFactory;

public class PutControllerTest extends ControllerTestCase {

    @Test
    public void run() throws Exception {
        tester.start("/task/put");
        PutController controller = tester.getController();
        assertThat(controller, is(notNullValue()));
        assertThat(tester.isRedirect(), is(false));
        assertThat(tester.getDestinationPath(), is(nullValue()));
    }
    
    @Test
    public void createMin() throws Exception {
        // Put User
        User userModel = new User();
        userModel.setName("aaa");
        Datastore.put(userModel);
        
        // Set param
        tester.request.setMethod("POST");
        tester.param("name", "bbb");
        tester.param("begin", String.valueOf(new Date(500000000).getTime()));
        tester.param("end", String.valueOf(new Date(600000000).getTime()));
        tester.param("userKey", KeyFactory.keyToString(userModel.getKey()));
        // Run!
        tester.start("/task/put");
        
        System.out.println(tester.response.getOutputAsString());
        // Meta
        ResponseJson json = new ResponseJson(JSON.parse(tester.response.getOutputAsString()));
        ResponseJson meta = json.getJson("meta");
        assertThat(meta.getLong("code"), is(200L));
        // Response
        ResponseJson res = json.getJson("response");
        assertNotNull(res.getString("key"));
        assertThat(res.getString("name"), is("bbb"));
        assertThat(res.getLong("beginAt"), is(500000000L));
        assertThat(res.getLong("endAt"), is(600000000L));
        // User
        ResponseJson user = res.getJson("userRef");
        assertThat(user.getString("key"), is(KeyFactory.keyToString(userModel.getKey())));
        assertThat(user.getString("name"), is("aaa"));
        
        // Model
        Task task = Datastore.get(Task.class, KeyFactory.stringToKey(res.getString("key")));
        assertNotNull(task);
        assertThat(task.getKey(), is(KeyFactory.stringToKey(res.getString("key"))));
        assertThat(task.getName(), is("bbb"));
        assertThat(task.getBeginAt().getTime(), is(500000000L));
        assertThat(task.getEndAt().getTime(), is(600000000L));
        assertThat(task.getUserRef().getKey(), is(userModel.getKey()));
        assertThat(task.getUserRef().getModel().getName(), is("aaa"));
    }
    
    @Test
    public void createMax() throws Exception {
        // Put user
        User userModel = new User();
        userModel.setName("aaa");
        Datastore.put(userModel);
        // Put parent task
        Task parentTask = new Task();
        Datastore.put(parentTask);
        
        // Set param
        tester.request.setMethod("POST");
        tester.param("name", "bbb");
        tester.param("begin", String.valueOf(new Date(500000000).getTime()));
        tester.param("end", String.valueOf(new Date(600000000).getTime()));
        tester.param("repeat", "5");
        tester.param("spotName", "ccc");
        tester.param("spotPoint", "35.5,130.3");
        tester.paramValues("tagsArray", new String[]{"ddd", "eee"});
        tester.param("userKey", KeyFactory.keyToString(userModel.getKey()));
        tester.param("parentKey", KeyFactory.keyToString(parentTask.getKey()));
        // Run!
        tester.start("/task/put");
        
        System.out.println(tester.response.getOutputAsString());
        // Meta
        ResponseJson json = new ResponseJson(JSON.parse(tester.response.getOutputAsString()));
        ResponseJson meta = json.getJson("meta");
        assertThat(meta.getLong("code"), is(200L));
        // Response
        ResponseJson res = json.getJson("response");
        assertNotNull(res.getString("key"));
        assertThat(res.getString("name"), is("bbb"));
        assertThat(res.getLong("beginAt"), is(500000000L));
        assertThat(res.getLong("endAt"), is(600000000L));
        assertThat(res.getString("spotName"), is("ccc"));
        // Geo
        ResponseJson point = res.getJson("point");
        assertThat(point.getDouble("latitude"), is(35.5));
        assertThat(point.getDouble("longitude"), is(130.3));
        // Tags
        Object[] objs = res.getArray("tags");
        assertThat(String.valueOf(objs[0]), is("ddd"));
        assertThat(String.valueOf(objs[1]), is("eee"));
        // User
        ResponseJson user = res.getJson("userRef");
        assertThat(user.getString("key"), is(KeyFactory.keyToString(userModel.getKey())));
        assertThat(user.getString("name"), is("aaa"));
        // Parent
        assertThat(res.getString("parentRef"), is(KeyFactory.keyToString(parentTask.getKey())));
        
        // Model
        Task task = Datastore.get(Task.class, KeyFactory.stringToKey(res.getString("key")));
        assertNotNull(task);
        assertThat(task.getKey(), is(KeyFactory.stringToKey(res.getString("key"))));
        assertThat(task.getName(), is("bbb"));
        assertThat(task.getBeginAt().getTime(), is(500000000L));
        assertThat(task.getEndAt().getTime(), is(600000000L));
        assertThat(task.getRepeat(), is(5L));
        assertThat(task.getSpotName(), is("ccc"));
        // Geo
        assertThat(task.getPoint().getLatitude(), is(35.5F));
        assertThat(task.getPoint().getLongitude(), is(130.3F));
        // Tags
        assertThat(task.getTags().get(0), is("ddd"));
        assertThat(task.getTags().get(1), is("eee"));
        // USer
        assertThat(task.getUserRef().getKey(), is(userModel.getKey()));
        assertThat(task.getUserRef().getModel().getName(), is("aaa"));
        // Parent
        assertThat(task.getParentRef().getKey(), is(parentTask.getKey()));
    }
}
