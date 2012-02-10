package me.o93.tissue.model;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.util.Date;

import org.junit.Test;
import org.slim3.datastore.Datastore;
import org.slim3.tester.AppEngineTestCase;

public class LikeTest extends AppEngineTestCase {

    private Like model = new Like();

    @Test
    public void test() throws Exception {
        assertThat(model, is(notNullValue()));
        
        model.setCreatedAt(new Date(1000000L));
        Task task = new Task();
        Datastore.put(task);
        model.getTaskRef().setKey(task.getKey());
        
        assertThat(model.getCreatedAt().getTime(), is(1000000L));
        assertThat(model.getTaskRef().getKey(), is(task.getKey()));
    }
}
