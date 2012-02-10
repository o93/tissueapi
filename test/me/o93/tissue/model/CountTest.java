package me.o93.tissue.model;

import org.slim3.datastore.Datastore;
import org.slim3.tester.AppEngineTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class CountTest extends AppEngineTestCase {

    private Count model = new Count();

    @Test
    public void test() throws Exception {
        assertThat(model, is(notNullValue()));
        
        model.setValue(1);
        
        Task task = new Task();
        Datastore.put(task);
        model.getTaskRef().setModel(task);
        
        assertThat(model.getValue(), is(1));
        assertThat(model.getTaskRef().getKey(), is(task.getKey()));
    }
}
