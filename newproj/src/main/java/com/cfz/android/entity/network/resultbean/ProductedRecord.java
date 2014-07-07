package com.cfz.android.entity.network.resultbean;

import com.google.api.client.util.Key;

/**
 * 8:获取商品的凑分记录()
 */
public class ProductedRecord extends BaseResult {
    //    "1:headImg
//    2:nickName
//    3:bettingCnt
//    4:time"	"1:头像
//    2:昵称
//    3:凑分数量
//    4:凑分时间"	"1:字符串
//    2:字符串
//    3:字符串
//    4:字符串"
    @Key
    public String headImg;
    @Key
    public String nickName;
    @Key
    public String bettingCnt;
    @Key
    public String time;
}
