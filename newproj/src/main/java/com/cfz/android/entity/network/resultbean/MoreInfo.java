package com.cfz.android.entity.network.resultbean;

import com.google.api.client.util.Key;

/**
 * 1:更多信息(完成)
 */
public class MoreInfo extends BaseResult {
    //    "1：allRight
//            2: servicePhone"	"1：产品解释
//    2: 客服电话号码"	"1：字符串
//    2: 字符串"
    @Key
    public String allRight;
    @Key
    public String servicePhone;
}
