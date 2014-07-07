package com.cfz.android.entity.network.resultbean;

import com.google.api.client.util.Key;

/**
 1:用户注册(完成)
 */
public class UserLoginBean extends BaseResult {

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
