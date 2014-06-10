package com.lenovo.powersetting.entity.network.urlentity;

import com.google.api.client.util.Key;
import com.lenovo.powersetting.BaseClass;

/**
 * Created by ok on 14-5-22.
 */
public class BaseEntity extends BaseClass {
    @Key
    public String info;

    @Key
    public String status;
}
