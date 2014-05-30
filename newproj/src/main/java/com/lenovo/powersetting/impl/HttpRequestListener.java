package com.lenovo.powersetting.impl;

/**
 * Created by ok on 14-5-30.
 */
public abstract class HttpRequestListener {
    public void onPre() {
    }


    public void onDoing() {
    }


    public void onPost() {
    }


    /**
     *
     * @param equals 是否成功
     */
    public void onGetStatus(boolean equals) {
    }

}
