package me.o93.tissue.model;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.util.Date;

import org.junit.Test;
import org.slim3.datastore.Datastore;
import org.slim3.tester.AppEngineTestCase;

public class NotifyTest extends AppEngineTestCase {

    private Notify model = new Notify();

    @Test
    public void test() throws Exception {
        assertThat(model, is(notNullValue()));
        
        model.setCreatedAt(new Date(1000000));
        model.setText("aaa");
        
        User user = new User();
        Datastore.put(user);
        model.getUserRef().setKey(user.getKey());
        
        assertThat(model.getCreatedAt().getTime(), is(1000000L));
        assertThat(model.getText(), is("aaa"));
        assertThat(model.getUserRef().getKey(), is(user.getKey()));
    }
}
