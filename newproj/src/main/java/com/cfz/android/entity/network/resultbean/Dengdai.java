package com.cfz.android.entity.network.resultbean;

import com.google.api.client.util.Key;

/**
 * 4:等待开奖商品(完成)
 */
public class Dengdai extends BaseResult {
    //    等待开奖商品(完成)
//    "1：productId
//            2：productImg
//    3：price
//    4：nickName
//    5：userHeadImg
//    6：bettingCnt
//    7：luckyCode
//    8：publishTime
//    9: infoId "	"
//            1:商品Id
//    2:商品图片
//    3:商品价格
//    4:用户昵称
//    5:用户头像
//    6:用户凑分数
//    7:奖幸运码
//    8:开奖时间
//    9:商品信息Id"	"
//            1:字符串
//    2:字符串
//    3:float
//    4:字符串
//    5:字符串
//    6:整型
//    7:字符串
//    8:字符串
//    9:字符串"
    @Key
    public String productId;
    @Key
    public String productImg;
    @Key
    public Float price;
    @Key
    public String nickName;
    @Key
    public String userHeadImg;
    @Key
    public Integer bettingCnt;
    @Key
    public String luckyCode;
    @Key
    public String publishTime;
    @Key
    public String infoId;

}
