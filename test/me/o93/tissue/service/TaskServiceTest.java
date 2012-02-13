package me.o93.tissue.service;

import org.slim3.tester.AppEngineTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

/**
 * Look controller!
 * @author okuda
 *
 */
public class TaskServiceTest extends AppEngineTestCase {

    private TaskService service = new TaskService();

    @Test
    public void test() throws Exception {
        assertThat(service, is(notNullValue()));
    }
}
