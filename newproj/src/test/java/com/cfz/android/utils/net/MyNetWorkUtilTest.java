package com.cfz.android.utils.net; /**
 * Created by Administrator on 2014/4/25.
 */

import com.cfz.android.BaseClass;
import com.cfz.android.Spokers;
import com.cfz.android.UserData;
import com.cfz.android.entity.network.resultbean.UserLoginResult;
import com.cfz.android.entity.network.urlentity.BackUserLoadEntity;
import com.cfz.android.impl.HttpRequestListener;
import com.cfz.android.utils.LogUtil;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;

import java.util.HashMap;

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
        params.put(URL_LOADING_QQID, "1234123k5j4352334");
        params.put(URL_LOADING_PT, "1");
        params.put(URL_LOADING_PSN, "1234123k5j4352334");
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
        }, URL_LOADING, BackUserLoadEntity.class), equalTo(null));
    }

    @Test
    public void testgetHttpDataUseAsync() {
        HashMap<String, Object> params = new HashMap<String, Object>();
//        final UserLoginBean userLoginBeans;

        params.put(URL_LOADING_QQID, "kjiuwieyr9898098");
        params.put(URL_LOADING_PT, "1");
        params.put(URL_LOADING_PSN, "234238743423498");

    }

//    @Test
//    public void testJinRi() {
//        HashMap<String, Object> data=new HashMap<String, Object>();
//        data.put(URL_LOTTERY_PN, 1);
//        HttpContent httpContent = new UrlEncodedContent(data);
//        testMethod(URL_LOTTERY, BackJinRiEntity.class, httpContent);
//
//    }


}

