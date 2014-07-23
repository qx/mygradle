package com.cfz.android.entity.network.urlentity;

import com.cfz.android.entity.network.resultbean.BaseResult;
import com.cfz.android.visual.activity.listener.GlobalConstant;
import com.google.api.client.util.Key;

/**
 * Created by ok on 7/23/14.
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
