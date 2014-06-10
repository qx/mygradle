package com.cfz.android.utils;

import android.content.Context;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

import static com.lenovo.powersetting.utils.CommonHelper.saveObject2CommShare;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Administrator on 2014/5/20.
 */
@RunWith(RobolectricTestRunner.class)
public class CommonHelperTester {

    @Test
    public void testsaveObject2CommShare() {
//       Context mCtx= Robolectric.getShadowApplication().getApplicationContext();
//Robolectric.application
        Context mCtx = Robolectric.application;
//        Map<String, String> mymap = new HashMap<String, String>();
//        mymap.put("first3", "firstvalue");
//        mymap.put("second3", "secondvalue");
//        assertThat(saveObject2CommShare(mCtx,"tester", mymap), equalTo(false));
        assertThat(saveObject2CommShare(mCtx,"tester", "new"), equalTo(false));
    }
}
