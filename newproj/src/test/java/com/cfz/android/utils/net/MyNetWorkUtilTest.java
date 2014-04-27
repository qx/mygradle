package com.cfz.android.utils.net; /**
 * Created by Administrator on 2014/4/25.
 */

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;

import static com.cfz.android.utils.net.MyNetWorkUtil.getData2MapFromNet;
import static com.cfz.android.utils.net.MyNetWorkUtil.getDataFromNet;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

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


}
