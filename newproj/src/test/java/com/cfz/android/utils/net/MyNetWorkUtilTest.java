package com.cfz.android.utils.net; /**
 * Created by Administrator on 2014/4/25.
 */

import org.json.JSONException;
import org.junit.Test;

import static com.cfz.android.utils.net.MyNetWorkUtil.getDataFromNet;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class MyNetWorkUtilTest {
    @Test
    public void testGetDataFromNet() {
        try {
            assertThat(getDataFromNet().toString(), equalTo("bar"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
//        assertThat(rmSetNotInBase(mSet, mSet2), equalTo(mSet3));
    }


}
