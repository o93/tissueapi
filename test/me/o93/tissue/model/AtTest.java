package me.o93.tissue.model;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Date;

import org.junit.Test;
import org.slim3.datastore.Datastore;
import org.slim3.tester.AppEngineTestCase;

public class AtTest extends AppEngineTestCase {

    private At model = new At();

    @Test
    public void test() throws Exception {
        assertThat(model, is(notNullValue()));
        
        User user = new User();
        Datastore.put(user);
        model.getUserRef().setKey(user.getKey());
        
        ArrayList<String> ranges = new ArrayList<String>();
        ranges.add("aaa");
        ranges.add("bbb");
        model.setRanges(ranges);
        
        assertThat(model.getUserRef().getKey(), is(user.getKey()));
        assertThat(model.getRanges().get(0), is("aaa"));
        assertThat(model.getRanges().get(1), is("bbb"));
    }
    
    @Test
    public void refresh() throws Exception {
        At at = new At();
        
        at.refreshDate(new Date(1000));
        
        assertThat(at.getRanges().get(0), is("D0000000000000001000"));
        assertThat(at.getRanges().get(1), is("L00000000000"));
        
        at.refreshDate(new Date(2000));
        
        assertThat(at.getRanges().get(0), is("D0000000000000002000"));
        assertThat(at.getRanges().get(1), is("L00000000000"));
        
        at.refreshLike(2);
        
        assertThat(at.getRanges().get(0), is("D0000000000000002000"));
        assertThat(at.getRanges().get(1), is("L00000000002"));
    }
}
