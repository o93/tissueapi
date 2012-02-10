package me.o93.tissue.model;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.slim3.datastore.Datastore;
import org.slim3.tester.AppEngineTestCase;

import com.google.appengine.api.datastore.GeoPt;

public class TaskTest extends AppEngineTestCase {

    private Task model = new Task();

    @Test
    public void test() throws Exception {
        assertThat(model, is(notNullValue()));
        
        model.setBeginAt(new Date(1000000L));
        model.setCreatedAt(new Date(2000000L));
        model.setEndAt(new Date(3000000L));
        model.setName("aaa");
        model.setRepeat(1);
        
        model.setSpotName("bbb");
        model.setPoint(new GeoPt(1.0F, 2.0F));
        
        List<String> tags = new ArrayList<String>();
        tags.add("ccc");
        tags.add("ddd");
        model.setTags(tags);
        
        model.setUpdatedAt(new Date(4000000L));
        
        User user = new User();
        Datastore.put(user);
        model.setUser(user);
        
        Task task = new Task();
        Datastore.put(task);
        model.getParentRef().setKey(task.getKey());
        
        assertThat(model.getBeginAt().getTime(), is(1000000L));
        assertThat(model.getCreatedAt().getTime(), is(2000000L));
        assertThat(model.getEndAt().getTime(), is(3000000L));
        assertThat(model.getName(), is("aaa"));
        assertThat(model.getRepeat(), is(1L));
        
        assertThat(model.getSpotName(), is("bbb"));
        assertThat(model.getPoint().getLatitude(), is(1.0F));
        assertThat(model.getPoint().getLongitude(), is(2.0F));
        
        assertThat(model.getTags().get(0), is("ccc"));
        assertThat(model.getTags().get(1), is("ddd"));
        
        assertThat(model.getUpdatedAt().getTime(), is(4000000L));
        
        assertThat(model.getUser().getKey(), is(user.getKey()));
        
        assertThat(model.getParentRef().getKey(), is(task.getKey()));
    }
}
