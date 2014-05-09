package com.cfz.android.utils;

import android.util.Log;

/**
 * Created by Administrator on 2014/5/9.
 */
public class LogUtil {

    public static void excep(String TAG, String s) {
        Log.e(TAG, s);
    }

    public static void sout(String modeName, String s) {
        Log.i(modeName, s);
    }
}
