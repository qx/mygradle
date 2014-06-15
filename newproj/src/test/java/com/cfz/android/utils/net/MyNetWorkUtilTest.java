package com.cfz.android.utils.net; /**
 * Created by Administrator on 2014/4/25.
 */

import com.cfz.android.BaseClass;
import com.cfz.android.Spokers;
import com.cfz.android.UserData;
import com.cfz.android.entity.network.resultbean.UserLoginBean;
import com.cfz.android.entity.network.urlentity.BackUserLoginEntity;
import com.cfz.android.impl.HttpRequestListener;
import com.cfz.android.utils.LogUtil;
import com.cfz.android.utils.LoginUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;

import java.util.HashMap;

import static com.cfz.android.constant.URLConstant.*;
import static com.cfz.android.utils.net.MyNetWorkUtil.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class MyNetWorkUtilTest extends BaseClass {
    @Test
    public void testGetDataFromNet() {
        try {
            JSONObject jsonObject = new JSONObject(getDataFromNet().toString());
            assertThat((jsonObject.getJSONArray("result")).getJSONObject(0).getString("detail"), equalTo("success"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
//        assertThat(rmSetNotInBase(mSet, mSet2), equalTo(mSet3));
    }

    @Test
    public void testGetData2MapFromNet() {
//            assertThat(ToStringBuilder.reflectionToString(getData2MapFromNet(), ToStringStyle.DEFAULT_STYLE), equalTo(null));
        assertThat(getData2MapFromNet().toString(), equalTo(null));
//        assertThat(rmSetNotInBase(mSet, mSet2), equalTo(mSet3));
    }

    @Test
    public void testgetRequestInfo() {
        HashMap<String, String> params = new HashMap<String, String>();
        params.put(LOGIN_URL_PARAMS_ID_, "1234123k5j4352334");
        params.put(LOGIN_URL_PARAMS_PHONE_, "1");
        params.put(LOGIN_URL_PARAMS_PHONEID_, "1234123k5j4352334");
        assertThat(getRequestInfo(params, new HttpRequestListener() {
            @Override
            public void onGetStatus(boolean equals) {
                super.onGetStatus(equals);
                if (equals) {
                    LogUtil.i(NET, "SUCCESS");
                } else {
                    LogUtil.i(NET, "FAIL");
                }
            }
        }, LOGIN_URL, BackUserLoginEntity.class), equalTo(null));
    }

    @Test
    public void testgetHttpDataUseAsync() {
        HashMap<String, String> params = new HashMap<String, String>();
//        final UserLoginBean userLoginBeans;

        params.put(LOGIN_URL_PARAMS_ID_, "kjiuwieyr9898098");
        params.put(LOGIN_URL_PARAMS_PHONE_, "1");
        params.put(LOGIN_URL_PARAMS_PHONEID_, "234238743423498");

        Spokers.getInstance().getHttpDataUseAsync(params, new HttpRequestListener() {


            public UserLoginBean userLoginBeans;

            @Override
            public void onDoing() {
                super.onDoing();
            }

            @Override
            public void onSuccess(Object o) {
                super.onSuccess(o);
                BackUserLoginEntity mBackUserLoginEntity = (BackUserLoginEntity) o;
                userLoginBeans =(UserLoginBean)mBackUserLoginEntity.bean;
//                UserData.getInstance().isLogin = true;//数据变量发生变化自动刷新数据，本地广播，或实现观察者模式
//                mHandler.sendEmptyMessage(UPDATE_VIEW);
            }

            @Override
            public void onFail() {
                super.onFail();
                UserData.getInstance().isLogin = false;
            }

            @Override
            public void onPre() {
                super.onPre();
            }

            @Override
            public void onPost() {
                super.onPost();
                assertThat(userLoginBeans, equalTo(null));

            }
        }, LOGIN_URL, BackUserLoginEntity.class);

    }
}

