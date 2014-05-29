package com.lenovo.powersetting.entity.network;

import com.google.api.client.util.Key;

import java.util.List;

/**
 * Created by ok on 14-5-22.
 */
public class BaseEntity {
    @Key
    public List<Object> result;

    @Key
    public String info;

    @Key
    public String status;


}
