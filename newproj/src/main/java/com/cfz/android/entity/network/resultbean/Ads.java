package com.cfz.android.entity.network.resultbean;

import com.google.api.client.util.Key;

/**
 * 1:获取广告列表(完成)
 */
public class Ads extends BaseResult {
//    ：advId
//    2：advImg
//    3：advType

    @Key
    public String advId;
    @Key
    public String advImg;
    @Key
    public String advType;
}
