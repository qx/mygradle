package com.cfz.android.utils.net; /**
 * Created by Administrator on 2014/4/25.
 */

import com.lenovo.powersetting.entity.network.BackUserLogin;
import com.lenovo.powersetting.impl.HttpRequestListener;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;

import java.util.HashMap;

import static com.lenovo.powersetting.utils.net.MyNetWorkUtil.getData2MapFromNet;
import static com.lenovo.powersetting.utils.net.MyNetWorkUtil.getDataFromNet;
import static com.lenovo.powersetting.utils.net.MyNetWorkUtil.getRequestInfo;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static com.lenovo.powersetting.visual.activity.constant.URLConstant.*;
public class MyNetWorkUtilTest {
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
//        try {
//            JSONObject jsonObject = new JSONObject(getDataFromNet().toString());
//            assertThat((jsonObject.getJSONArray("result")).getJSONObject(0).getString("detail"), equalTo("success"));
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }

        HashMap<String, String> params = new HashMap<String, String>();
        params.put(LOGIN_URL_PARAMS_ID_, "1234123k5j4352334");
        params.put(LOGIN_URL_PARAMS_PHONE_, "1");
        params.put(LOGIN_URL_PARAMS_PHONEID_, "1234123k5j4352334");
        assertThat(getRequestInfo(params, new HttpRequestListener() {
            @Override
            public void onGetStatus(boolean equals) {
                super.onGetStatus(equals);
                if (equals) {
                    System.out.println("success");
                } else {
                    System.out.println("fail");
                }
            }
        }, BackUserLogin.class),equalTo(null));
//        assertThat(rmSetNotInBase(mSet, mSet2), equalTo(mSet3));
    }
}
