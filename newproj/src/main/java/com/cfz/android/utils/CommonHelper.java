package com.cfz.android.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.telephony.TelephonyManager;
import com.cfz.android.MyApplication;
import com.cfz.android.visual.activity.RebackActivity;

import java.util.Map;
import java.util.Set;

/**
 * Common Helper like SharePreference,Map,String
 */
public class CommonHelper {

    private static final String COMMONSHAREFILE = "cfz.xml";

    private static Context mContext = MyApplication.getInstance();

    /**
     * save key-value pairs to android.xml
     *
     * @param key
     * @param value
     * @return
     */
    public static boolean saveObject2CommShare(Context mContext, String key, Object value) {

        try {
            SharedPreferences mPrefs = mContext.getSharedPreferences(COMMONSHAREFILE, Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = mPrefs.edit();
            if (value instanceof Map) {
                Set keys = ((Map) value).keySet();
                for (Object mapkey : keys) {
                    String pkgName = (String) mapkey;
                    Object listValue = ((Map) value).get(pkgName);
                    if (listValue instanceof Boolean) {
                        editor.putBoolean(pkgName, (Boolean) listValue);
                        editor.commit();
                    } else if (listValue instanceof Integer) {
                        editor.putInt(pkgName, (Integer) listValue);
                        editor.commit();
                    } else if (listValue instanceof String) {
                        editor.putString(pkgName, (String) listValue);
                        editor.commit();
                    } else if (listValue instanceof Long) {
                        editor.putLong(pkgName, (Long) listValue);
                        editor.commit();
                    } else if (listValue instanceof Float) {
                        editor.putFloat(pkgName, (Float) listValue);
                        editor.commit();
                    }
                }
            } else if (value instanceof Boolean) {
                editor.putBoolean(key, (Boolean) value);
                editor.commit();
            } else if (value instanceof Integer) {
                editor.putInt(key, (Integer) value);
                editor.commit();
            } else if (value instanceof String) {
                editor.putString(key, (String) value);
                editor.commit();
            } else if (value instanceof Long) {
                editor.putLong(key, (Long) value);
                editor.commit();
            } else if (value instanceof Float) {
                editor.putFloat(key, (Float) value);
                editor.commit();
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static String getImei(Context mContext) {

        TelephonyManager telephonyManager = (TelephonyManager) mContext.getSystemService(Context.TELEPHONY_SERVICE);
        return telephonyManager.getDeviceId();
    }

    public static String getAppVersion(Context mContext) {
        PackageInfo pInfo;
        try {
            pInfo = mContext.getPackageManager().getPackageInfo(mContext.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return "";
        }
        return pInfo.versionName;
    }

    /**
     * android 1
     * @param ctx
     * @return
     */
    public static String getPhoneType(Context ctx) {
        return "1";
    }


//    public static boolean storeConfigByName(Context mContext, Map<String, Object> map, String FILENAME) {
//
//        try {
//            SharedPreferences mPrefs = mContext.getSharedPreferences(FILENAME, Context.MODE_PRIVATE);
//            SharedPreferences.Editor editor = mPrefs.edit();
//
//            Set keys = map.keySet();
//            for (Object key : keys) {
//                String pkgName = (String) key;
//                Object listValue = map.get(pkgName);
//                if (listValue instanceof Boolean) {
//                    editor.putBoolean(pkgName, (Boolean) listValue);
//                    editor.commit();
//                } else if (listValue instanceof Integer) {
//                    editor.putInt(pkgName, (Integer) listValue);
//                    editor.commit();
//                } else if (listValue instanceof String) {
//                    editor.putString(pkgName, (String) listValue);
//                    editor.commit();
//                } else if (listValue instanceof Long) {
//                    editor.putLong(pkgName, (Long) listValue);
//                    editor.commit();
//                }
//            }
//            return true;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return false;
//
//    }

}
