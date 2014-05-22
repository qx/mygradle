package com.cfz.android.mode.object.network;

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

    @Override
    public String toString() {
        return "userId=" + userId + "\n" +
                "integral=" + integral + "\n"
                +"headImg="+headImg+"\n"+
                "nickName="+nickName;
    }
}
