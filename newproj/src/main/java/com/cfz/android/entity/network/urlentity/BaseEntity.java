package com.cfz.android.entity.network.urlentity;

import com.google.api.client.util.Key;
import com.cfz.android.BaseClass;
import com.cfz.android.entity.network.resultbean.BaseBean;

/**
 * Created by ok on 14-5-22.
 */
public class BaseEntity extends BaseClass {
    @Key
    public String info;

    @Key
    public String status;

//    @Key
//    public BaseBean bean;
}
