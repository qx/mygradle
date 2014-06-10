package com.lenovo.powersetting;

import android.app.Application;
import com.lenovo.powersetting.utils.ThreadUtils;

/**
 * Created by Administrator on 2014/5/19.
 */
public class MyApplication extends Application {
    private static MyApplication myApplication;

    public static MyApplication getInstance() {
        return (MyApplication) myApplication;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        myApplication = this;
        ThreadUtils.excu(new Runnable() {
            @Override
            public void run() {
                initData();
            }
        });
    }

    private void initData() {

    }
}