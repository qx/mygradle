package com.lenovo.powersetting.utils.net;

import cn.trinea.android.common.util.HttpUtils;
import cn.trinea.android.common.util.JSONUtils;
import com.google.api.client.http.*;
import com.google.api.client.http.apache.ApacheHttpTransport;
import com.google.api.client.http.json.JsonHttpParser;
import com.google.api.client.json.jackson.JacksonFactory;
import com.lenovo.powersetting.entity.network.BackUserLogin;
import com.lenovo.powersetting.entity.network.BaseEntity;
import com.lenovo.powersetting.impl.HttpRequestListener;
import org.apache.commons.lang3.reflect.ConstructorUtils;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import static com.lenovo.powersetting.visual.activity.constant.URLConstant.LOGIN_URL;
import static com.lenovo.powersetting.visual.activity.constant.URLConstant.success;

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
     * @return
     */
    public static Object getRequestInfo(HashMap<String, String> key_value,
                                        HttpRequestListener mHttpRequestListener,
                                        Class<? extends BaseEntity> backUserLogin) {
        String requestUrl = getUrl(backUserLogin);

        Iterator iterator = key_value.entrySet().iterator();
        try {
            while (iterator.hasNext()) {
                Map.Entry entry = (Map.Entry) iterator.next();
                String mkey = (String) entry.getKey();
                String mValue = (String) entry.getValue();
                HttpTransport transport = new ApacheHttpTransport();
                GenericUrl reqUrl = new GenericUrl(requestUrl);
                reqUrl.put(mkey, mValue);
                HttpRequestFactory httpRequestFactory = createRequestFactory(transport);
                HttpRequest request = httpRequestFactory.buildGetRequest(reqUrl);
                String str = request.execute().parseAsString();
//                String clsName=backUserLogin.getDeclaringClass()

//                Generic c = new Generic();
//                System.out.println(c.array);


                backUserLogin = request.execute().parseAs(((BackUserLogin)backUserLogin).instanceArray);
                if (backUserLogin != null) {
                    System.out.println(backUserLogin);
                    mHttpRequestListener.onGetStatus((FieldUtils.getDeclaredField(backUserLogin, "status")).equals(success));
                }
                return backUserLogin;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String getUrl(Object backUserLogin) {
//        if ( backUserLogin instanceof BackUserLogin) {
//            return LOGIN_URL;
//        }
//        return null;
            return LOGIN_URL;
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