package com.cfz.android.mode.object;


import java.util.List;

/**
 * My Passport information
 * 我的账号信息
 */
public class MyPassport extends BaseObject {

    /**
     * 收货地址信息列表
     */
    public List<AddressInfo> addressInfoList;
    /**
     * 凑份信息
     */
    public MyAction myAction;
    /**
     * 账号信息
     */
    public PassportInfo passportInfo;

}
