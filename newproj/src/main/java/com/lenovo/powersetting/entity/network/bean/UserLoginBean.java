package com.lenovo.powersetting.entity.network.bean;

import com.google.api.client.util.Key;

/**
 * Created by ok on 14-5-22.
 */
public class UserLoginBean extends BaseBean {

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

    @Override
    public String toString() {
        return "userId=" + userId + "\n" +
                "integral=" + integral + "\n"
                + "headImg=" + headImg + "\n"
                + "money=" + money + "\n" +
                "nickName=" + nickName;
    }
}
