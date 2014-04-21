package com.pivotallabs;

import org.junit.Test;

import static com.pivotallabs.MyTester.getValue;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by ok on 14-4-16.
 */
public class MyTesterTest {

    @Test
    public void testketValue() {
        assertThat(getValue("nomep"), equalTo(true));
    }


}
