package com.cfz.android.entity.network.urlentity;

import com.cfz.android.entity.network.resultbean.BaseResult;
import com.cfz.android.visual.activity.listener.GlobalConstant;
import com.google.api.client.util.Key;

/**
 * 揭晓商品实体类
 */
public class BaseFinishedProductResult extends BaseResult {

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

    public int productType = GlobalConstant.TYPE_UNKNOWN;
}
