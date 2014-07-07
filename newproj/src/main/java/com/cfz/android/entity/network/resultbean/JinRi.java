package com.cfz.android.entity.network.resultbean;

import com.google.api.client.util.Key;

/**
 * 3:今日开奖商品(完成)
 */
public class JinRi extends BaseResult {


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
    @Key
    public String infoId;


}
