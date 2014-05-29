package com.lenovo.powersetting.utils.net;

import cn.trinea.android.common.util.HttpUtils;
import cn.trinea.android.common.util.JSONUtils;
import org.json.JSONException;
import org.json.JSONObject;

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


}
