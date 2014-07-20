package com.cfz.android.impl;

import com.cfz.android.entity.network.urlentity.BaseEntity;
import com.google.api.client.http.HttpContent;

import java.util.HashMap;

/**
 * Created by ok on 7/20/14.
 */
public interface BaseNetListener {
    public void testMethod(String Url, Class<? extends BaseEntity> backentity, HttpContent content, HttpRequestListener httpRequestListener, final HashMap<String, Object> data);

}
