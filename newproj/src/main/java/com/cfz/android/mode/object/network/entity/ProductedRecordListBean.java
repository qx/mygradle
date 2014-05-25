package com.cfz.android.mode.object.network.entity;

import com.google.api.client.util.Key;

/**
 *
 */
public class ProductedRecordListBean {
    //    "1：productId
//            2：productImg
//    3：activityNum
//    4：nickName
//    5：bettingCnt
//    6：luckyCode
//    7：publishTime
    @Key
    public String productId;
    @Key
    public String productImg;
    @Key
    public String activityNum;
    @Key
    public String nickName;
    @Key
    public String bettingCnt;
    @Key
    public String luckyCode;
    @Key
    public String publishTime;
}
