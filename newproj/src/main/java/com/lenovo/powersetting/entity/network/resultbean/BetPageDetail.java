package com.lenovo.powersetting.entity.network.resultbean;

import com.google.api.client.util.Key;

/**
 * 凑份详情
 */
public class BetPageDetail extends BaseResult {

//    1：productId
//    2：productImg
//    3：activityNum
//    4：price
//    5：totalCnt
//    6：currentCnt
//    7：detail

    @Key
    public String productId;
    @Key
    public String productImg;
    @Key
    public String activityNum;
    @Key
    public String price;
    @Key
    public String totalCnt;
    @Key
    public String currentCnt;
    @Key
    public String detail;

}
