package me.o93.tissue.model;

import org.slim3.datastore.Datastore;
import org.slim3.tester.AppEngineTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class AtTest extends AppEngineTestCase {

    private At model = new At();

    @Test
    public void test() throws Exception {
        assertThat(model, is(notNullValue()));
        
        model.setMonth(1);
        model.setWeek(2);
        model.setDay(3);
        model.setTimeslot(4);
        
        model.setLike(5L);
        
        User user = new User();
        Datastore.put(user);
        model.getUserRef().setKey(user.getKey());
        
        assertThat(model.getMonth(), is(1));
        assertThat(model.getWeek(), is(2));
        assertThat(model.getDay(), is(3));
        assertThat(model.getTimeslot(), is(4L));
        
        assertThat(model.getLike(), is(5L));
        
        assertThat(model.getUserRef().getKey(), is(user.getKey()));
    }
}
