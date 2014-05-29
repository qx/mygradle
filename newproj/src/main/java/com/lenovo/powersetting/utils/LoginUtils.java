package com.lenovo.powersetting.utils;

import android.content.Context;
import android.telephony.TelephonyManager;

/**
 * Created by ok on 5/26/14.
 */
public class LoginUtils {

    public static String getImei(Context mContext) {

        TelephonyManager telephonyManager = (TelephonyManager) mContext.getSystemService(Context.TELEPHONY_SERVICE);
        return telephonyManager.getDeviceId();
    }

    public static String getPhoneType() {
        return "1";
    }
}
