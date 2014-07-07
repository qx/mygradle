package com.cfz.android.entity.network.resultbean;

import com.google.api.client.util.Key;

/**
 * 用户收货地址信息
 */
public class UserAddress extends BaseResult {
    //    "1:realName
//            2:phone
//    3:city
//    4:address"
    @Key
    public String realName;
    @Key
    public String phone;
    @Key
    public String city;
    @Key
    public String address;
}
