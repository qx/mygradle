package com.example.testaplarm;

/**
 * Created by Administrator on 2014/4/23.
 */
public class AlarmStatus {
    private String app;
    /**
     * two counters for wake up alarms. the first is #RTC_WAKEUP, the second is #ELAPSED_REALTIME_WAKEUP
     */
    private int[] count;
}
