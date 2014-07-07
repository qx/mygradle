package com.cfz.android;

/**
 * Created by ok on 7/7/14.
 */
public class RequestInsance {
    public String getRequrl() {
        return requrl;
    }

    public void setRequrl(String requrl) {
        this.requrl = requrl;
    }

    private String requrl;

    public String getBackinfo() {
        return backinfo;
    }

    public void setBackinfo(String backinfo) {
        this.backinfo = backinfo;
    }

    private String backinfo;
    private static RequestInsance ourInstance = new RequestInsance();

    public static RequestInsance getInstance() {
        return ourInstance;
    }

    private RequestInsance() {
    }
}
