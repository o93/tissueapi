package me.o93.tissue.model;

import org.slim3.tester.AppEngineTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class SpotTest extends AppEngineTestCase {

    private Spot model = new Spot();

    @Test
    public void test() throws Exception {
        assertThat(model, is(notNullValue()));
    }
}
