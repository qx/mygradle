package com.example.testaplarm;

import android.app.Activity;
import android.app.AlarmManager;
import android.content.Context;
import android.os.Bundle;

import java.util.HashMap;

public class MyActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
//        java.util.List<AlarmManager.AlarmStats>	getStats()
//        get alarm stats data.
//        android.os.Bundle	getStatsBundle()
//        get alarm stats data in a bundle.
//        void	updatePolicy(java.util.List<AlarmManager.AlarmPolicy> policies, boolean reset)
//        update alarm policies.
//        void	updatePolicyBundle(android.os.Bundle policies, boolean reset)
//        update alarm policies.
        getAppAlarmWhileSleep(1d / 3D);
    }

    private HashMap<String, AbnormalInfo> getAppAlarmWhileSleep(double v) {

        AlarmManager alarmManager=(AlarmManager) this.getSystemService(Context.ALARM_SERVICE);
        getClass(AlarmManager.class).getMethod()

    }


    private class AbnormalInfo {
        private AbnormalInfo(String appName, int times) {
            this.appName = appName;
            this.times = times;
        }

        public String getAppName() {
            return appName;
        }

        public void setAppName(String appName) {
            this.appName = appName;
        }

        private String appName;
        private int times;

        public int getTimes() {
            return times;
        }

        public void setTimes(int times) {
            this.times = times;
        }
    }
}
