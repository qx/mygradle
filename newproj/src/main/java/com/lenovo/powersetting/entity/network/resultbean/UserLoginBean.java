package com.lenovo.powersetting.entity.network.resultbean;

import com.google.api.client.util.Key;

/**
 * Created by ok on 14-5-22.
 */
public class UserLoginBean extends BaseResultBean {

    @Key
    public String userId;
    @Key
    public Integer integral;
    @Key
    public String headImg;
    @Key
    public String nickName;
    @Key
    public Float money;

}
