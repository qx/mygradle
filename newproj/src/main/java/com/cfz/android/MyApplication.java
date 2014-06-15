package com.cfz.android;

import android.app.Application;
import com.cfz.android.utils.ThreadUtils;

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

        UserData ud = UserData.getInstance();
        ud.registerObserver(new UserDataUser("test"));
    }
}
