package com.lenovo.powersetting.entity.network;

import com.google.api.client.util.Key;

/**
 * Created by ok on 14-5-22.
 */
public class BaseEntity {

    @Key
    public String info;

    @Key
    public String status;

    public BaseEntity() {
    }

}
