package com.cfz.android.entity.network.urlentity;

import com.cfz.android.entity.network.resultbean.UserLoginBean;
import com.google.api.client.util.Key;

import java.util.ArrayList;

/**
 * Created by Administrator on 2014/5/15.
 */
public class BackUserLoadEntity extends BaseEntity {
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
    public ArrayList<UserLoginBean> result;
    @Key
    public UserLoginBean bean;

}
