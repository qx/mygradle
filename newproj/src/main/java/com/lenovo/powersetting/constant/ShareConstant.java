package com.lenovo.powersetting.constant;

/**
 * KEY-DEFAULTKEY must be in pairs
 */
public final class ShareConstant {
    public static final String FILENAME = "powersetting";
    //in pairs
    public static final String SHARE_FIRSTKEY = "test";
    public static final Boolean SHARE_FIRSTKEY_DEFAULT = true;
    
    public static final String SHARE_NAME = "PowerCenter_share";

    //耗电排行 begin
    public static final String POWER_AUDIO = "dsp.audio";
    public static final String POWER_BATTERY_CAPACITY = "battery.capacity";
    public static final String POWER_BLUETOOTH_ACTIVE = "bluetooth.active";
    public static final String POWER_BLUETOOTH_AT_CMD = "bluetooth.at";
    public static final String POWER_BLUETOOTH_ON = "bluetooth.on";
    public static final String POWER_CPU_ACTIVE = "cpu.active";
    public static final String POWER_CPU_AWAKE = "cpu.awake";
    public static final String POWER_CPU_IDLE = "cpu.idle";
    public static final String POWER_CPU_SPEEDS = "cpu.speeds";
    public static final String POWER_GPS_ON = "gps.on";
    public static final String POWER_NONE = "none";
    public static final String POWER_RADIO_ACTIVE = "radio.active";
    public static final String POWER_RADIO_ON = "radio.on";
    public static final String POWER_RADIO_SCANNING = "radio.scanning";
    public static final String POWER_SCREEN_FULL = "screen.full";
    public static final String POWER_SCREEN_ON = "screen.on";
    public static final String POWER_VIDEO = "dsp.video";
    public static final String POWER_WIFI_ACTIVE = "wifi.active";
    public static final String POWER_WIFI_ON = "wifi.on";
    public static final String POWER_WIFI_SCAN = "wifi.scan";
    public static final String POWER_WIFI_BATCHED_SCAN = "wifi.batchedscan";
    public static final String KEY_SHOW_APP_SELF_CONSUMPTION = "key_app_self_consumption";
    public static final Boolean  KEY_SHOW_APP_SELF_CONSUMPTION_DEFAULT = false;
    //耗电排行end
    
    
    //后台应用start
    public static final String PERSONALTAG_ABNORMAL = "abnormal ";
    public static final String VERSION_PREFS = "versionInfoPrefs";
    public static final String WHITELIST_DOWNWARD = "whiteListDownward";
    public static final String WHITELIST_PREFS = "wakelockListPrefs";
    public static final Boolean DISABLE_LESAFE_WHITELIST = false;//禁用乐安全白名单
    public static final String PERSONALTAG_SMARTAPP_CLEAN = "Intelligent application _ Cleanup ";
    public static final String VERSION_CODE_WHITELIST = "whiteListVersionCode";
    public static final String LENOVO_POWER_CENTER = "com.lenovo.powercenter";
    public static final String LENOVO_SAFE_CENTER = "com.lenovo.safecenter";
    public static final String LENOVO_SAFE_CENTER_WW = "com.lenovo.safecenter.ww";
    public static final String ANDROID_BROWER_PKG = "com.android.browser";
    public static final String LENOVO_THEME_PKG = "com.lenovo.themecenter";
    public static final String MTK_POWERONOFF = "com.mediatek.schpwronoff";
    public static final String ANDROID_SETTINGS_PKG = "com.android.settings";
    public static final Boolean CLEAR_SYS_APP_WAKELOCK = false;//系统应用wakelock是否可以被清理
    public static final String[] BU_POWER_SAVING = {"com.lenovo.powersaving", "com.android.savepower", "com.battery.view"};
    public static final Boolean CLEAR_SYS_APP = false;
    public static final String PERSONALTAG_ABNORMAL_ALARM = "abnormal_alarm ";
    public static final String BUNDLE_REFRESH_WHITELIST = "bundle_refresh_whitelist";
    public static final int TAG_FALSE = 0;
    public static final int TAG_TRUE = 1;
    public static final String PERSONALTAG_ABNORMAL_WAKELOCK = "abnormal_wakelock ";
    //后台应用end
}
