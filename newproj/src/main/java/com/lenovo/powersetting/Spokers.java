package com.lenovo.powersetting;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import com.lenovo.powersetting.constant.IntentConstant;

/**
 * Only on/off function controller should be defined here
 * <p/>
 * You should comment on the method first.
 */
public class Spokers {

    private LocalBroadcastManager manager;
    private static Context mContext;
    private static Spokers spokers;

    private Spokers(Context mContext) {
        this.mContext = mContext;
        manager = LocalBroadcastManager.getInstance(mContext);
    }

    public static Spokers getInstance() {
        if (spokers == null) {
            return new Spokers(mContext);
        }
        return spokers;
    }

    /**
     * example
     * start smart brightness
     *
     * @return excute resule
     */
    public boolean startSmartBrightness() {
        manager.sendBroadcast(new Intent(IntentConstant.STARTBRIGHTNESS));
        return false;
    }

    /**
     * smart brightness stop
     */
    public boolean stopSmartBrightness() {
        return false;
    }

    public void startClassiMode() {
        //TODO
    }

    public void stopClassiMode() {
        //TODO
    }

    public void startTimingChanged() {
        //TODO
    }

    public void stopTimingChanged() {
        //TODO
    }

    public void startVMX() {
        //TODO
    }

    public void stopVMX() {
        //TODO
    }

    public void startSleep() {
        //TODO
    }

    public void stopSleep() {
        //TODO
    }
}
