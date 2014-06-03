package com.lenovo.powersetting.entity.network;

import com.google.api.client.util.Key;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.ArrayList;

/**
 * Created by Administrator on 2014/5/15.
 */
public class BackUserLoginEntity extends BaseEntity {
    //    1：userId
//    2：integral
//    3: headImg
//    4: nickName
//    1:用户Id
//    2:用户积分
//    3:系统默认头像
//    (默认头像放在客户端,应该不需要服务器返回)
//    4:系统默认昵称
    @Key
    public ArrayList<Object> result;

    public BackUserLoginEntity() {
        super();
    }


    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
