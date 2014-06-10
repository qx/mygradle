package com.lenovo.powersetting.utils;

import android.util.Log;

/**
 * Created by Administrator on 2014/5/9.
 */
public class LogUtil {
    private static final String BaseSplit = "**********=>";
    private static final String NewProduct = "|newPorduct";
    private static final String NET = "|net";

    public static void excep(String TAG, String s) {
        Log.e(TAG, s);
    }

    public static void sout(String modeName, String s) {
        Log.i(modeName, s);
    }
    public static void logNet( String s) {
        System.out.println(NET + BaseSplit + s);
    }



    public static void logNewProduct(String s) {
        System.out.println(NewProduct + BaseSplit + s);
    }

}
