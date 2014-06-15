package com.cfz.android.utils;

import android.util.Log;
import com.cfz.android.BaseClass;

/**
 * Created by Administrator on 2014/5/9.
 */
public class LogUtil extends BaseClass {
    private static final String BaseSplit = "**********=>";


    public static void excep(String TAG, String s) {
        Log.e(TAG, s);
    }

    public static void sout(String modeName, String s) {
        Log.i(modeName, s);
    }
    public static void logNet( String s) {
        Log.i(NET, BaseSplit + s);
    }



    public static void logNewProduct(String s) {
        Log.i(NewProduct, BaseSplit + s);
    }

    public static void i(String userdataUserTest, String s) {
        Log.i(userdataUserTest, s);
    }
}
