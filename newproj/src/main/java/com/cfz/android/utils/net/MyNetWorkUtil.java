package com.cfz.android.utils.net;

import cn.trinea.android.common.util.HttpUtils;
import cn.trinea.android.common.util.JSONUtils;
import com.google.api.client.http.*;
import com.google.api.client.http.apache.ApacheHttpTransport;
import com.google.api.client.http.json.JsonHttpParser;
import com.google.api.client.json.jackson.JacksonFactory;
import com.cfz.android.entity.network.urlentity.BaseEntity;
import com.cfz.android.impl.HttpRequestListener;
import com.cfz.android.utils.LogUtil;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by Administrator on 2014/4/25.
 */
public class MyNetWorkUtil {

//    1:用户注册	user_loginOrReg	"1:qqId
//            2:phoneType = 1
//    phoneType = 2
//            3:phoneId        "	"1.QQ标识
//    2.安卓手机
//            苹果手机
//    3.手机序列号"	"1.字符串
//    2.字符串
//            字符串
//    3.字符串"	"1：userId
//    2：integral            "	"1.用户Id
//    2.用户积分"	"1.字符串
//    2.整型"

    //http://114.215.177.210:8080/cfz/product_getProductingList
    public static String getDataFromNet() throws JSONException {
//        return new JSONObject(HttpUtils.httpGetString("http://114.215.177.210:8080/cfz/product_getProductingList"));
        return HttpUtils.httpGetString("http://114.215.177.210:8080/cfz/product_getProductingList");
//        return JSONUtils.parseKeyAndValueToMap(HttpUtils.httpGetString("http://114.215.177.210:8080/cfz/product_getProductingList"));

    }

    public static Map<String, String> getData2MapFromNet() {
//        String objstr = HttpUtils.httpGetString("http://114.215.177.210:8080/cfz/product_getProductingList");
        String objstr = HttpUtils.httpGetString("http://192.168.1.104:8081/json2");
        try {
            JSONObject jsonObject = new JSONObject(objstr);
            return JSONUtils.parseKeyAndValueToMap(jsonObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * @param key_value method key-value
     * @param url
     * @return
     */
    public static BaseEntity getRequestInfo(HashMap<String, String> key_value,
                                            HttpRequestListener mHttpRequestListener,
                                            String url, Class<? extends BaseEntity> baseClass) {
        mHttpRequestListener.onPre();
        Iterator iterator = key_value.entrySet().iterator();
        GenericUrl reqUrl = new GenericUrl(url);
        try {
            while (iterator.hasNext()) {
                Map.Entry entry = (Map.Entry) iterator.next();
                String mkey = (String) entry.getKey();
                String mValue = (String) entry.getValue();
                reqUrl.put(mkey, mValue);
            }
            HttpTransport transport = new ApacheHttpTransport();
            HttpRequestFactory httpRequestFactory = createRequestFactory(transport);
            HttpRequest request = httpRequestFactory.buildGetRequest(reqUrl);
//            String str = request.execute().parseAsString();
            LogUtil.logNet("request base url" + reqUrl.build());

            BaseEntity x2 = request.execute().parseAs((baseClass));
            if (x2.status != null) {
                LogUtil.logNet(x2.toString());
                mHttpRequestListener.onGetStatus(x2.status.equals("success"));
            }
            return x2;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    private static HttpRequestFactory createRequestFactory(final HttpTransport transport) {

        return transport.createRequestFactory(new HttpRequestInitializer() {
            public void initialize(HttpRequest request) {
                JsonHttpParser parser = new JsonHttpParser(new JacksonFactory());
                System.out.println("oyqx:content type=" + parser.getContentType());
                request.addParser(parser);

            }
        });
    }

}