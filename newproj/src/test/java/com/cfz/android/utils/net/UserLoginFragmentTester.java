package com.lenovo.powersetting.utils.net;

import android.content.Context;
import com.lenovo.powersetting.impl.RequestListener;
import com.lenovo.powersetting.utils.LoginUtils;
import org.junit.Test;
import org.robolectric.Robolectric;

import static com.lenovo.powersetting.visual.activity.UserLoginFragment.login;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Administrator on 2014/5/15.
 */
public class UserLoginFragmentTester {

    @Test
    public void testLogin() {
//            assertThat(ToStringBuilder.reflectionToString(getData2MapFromNet(), ToStringStyle.DEFAULT_STYLE), equalTo(null));
        try {
            Context mCtx = Robolectric.application;
            assertThat(login("9888888908", "1", LoginUtils.getImei(mCtx),new RequestListener() {
                @Override
                public void requestCompleted(boolean isSuccess) {

                }
            }).toString(), equalTo(null));
        } catch (Exception e) {
            e.printStackTrace();
        }
//        assertThat(rmSetNotInBase(mSet, mSet2), equalTo(mSet3));

    }
}
