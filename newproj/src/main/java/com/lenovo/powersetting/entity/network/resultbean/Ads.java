package com.lenovo.powersetting.entity.network.resultbean;

import com.google.api.client.util.Key;

/**
 * 广告
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
