package com.cfz.android.mode.object.network.entity;

import com.google.api.client.util.Key;

/**
 * 已结束商品
 */
public class ProductedBean {
    //    "1：productId
//            2：productImg
//    3：price
//    4：nickName
//    5：userHeadImg
//    6：bettingCnt
//    7：luckyCode
//    8：publishTime   "
    @Key
    public String productId;
    @Key
    public String productImg;
    @Key
    public String price;
    @Key
    public String nickName;
    @Key
    public String userHeadImg;
    @Key
    public String bettingCnt;
    @Key
    public String luckyCode;
    @Key
    public String publishTime;
}
