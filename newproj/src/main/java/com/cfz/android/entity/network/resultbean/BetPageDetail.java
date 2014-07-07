package com.cfz.android.entity.network.resultbean;

import com.google.api.client.util.Key;

/**
 * 凑份详情
 */
public class BetPageDetail extends BaseResult {

    //    "1：activityNuM
//            2: currentCnt
//    3: productImg"	"1:活动期号
//    2:当前凑分数
//    3:产品图片"	"1:字符串
//    2:字符串
//    3:字符串"
    @Key
    public String activityNum;
    @Key
    public String currentCnt;
    @Key
    public String productImg;


}
