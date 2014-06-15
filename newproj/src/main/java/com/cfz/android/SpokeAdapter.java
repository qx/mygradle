package com.cfz.android;

import android.content.Context;
import android.support.v4.content.LocalBroadcastManager;
import com.cfz.android.impl.SystemListener;

/**
 * 开关功能适配器
 * 监听系统状态
 * 使用方法参考@initSmartBrightness()
 * Only on/off function controller should be defined here
 * <p/>
 * You should comment on the method first.
 */
public class SpokeAdapter implements SystemListener {

    private LocalBroadcastManager manager;
    private static Context mContext;
    private static SpokeAdapter SpokeAdapter;

    private SpokeAdapter(Context mContext) {
        com.cfz.android.SpokeAdapter.mContext = mContext;
        manager = LocalBroadcastManager.getInstance(mContext);
    }

    public static SpokeAdapter getInstance() {
        if (SpokeAdapter == null) {
            return new SpokeAdapter(mContext);
        }
        return SpokeAdapter;
    }

    /**
     * example
     * init smart brightness
     *
     * @return excute resule
     */
    public boolean initSmartBrightness() {

        return false;
    }

    /**
     * smart brightness destory
     */
    public boolean destorySmartBrightness() {
        return false;
    }

    public void initClassiMode() {
        //TODO
    }

    public void destoryClassiMode() {
        //TODO
    }

    public void initTimingChanged() {
        //TODO
    }

    public void destoryTimingChanged() {
        //TODO
    }

    public void initVMX() {
        //TODO
    }

    public void destoryVMX() {
        //TODO
    }

    public void initSleep() {
        //TODO
    }

    public void destorySleep() {
        //TODO
    }


    /**
     * ******************init your mode function here if necessary******************************************
     */
    @Override
    public void onScreenOn() {
        initSmartBrightness();
    }

    @Override
    public void onScrrenOff() {
        destoryClassiMode();
    }
}
