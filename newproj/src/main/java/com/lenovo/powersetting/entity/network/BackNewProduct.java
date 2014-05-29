package com.lenovo.powersetting.entity.network;

import com.google.api.client.util.Key;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Created by Administrator on 2014/5/15.
 */
public class BackNewProduct {

    @Key
    public String productId;

    @Key
    public String productImg;
    @Key
    public String productName;
    @Key
    public Float price;
    @Key
    public Integer totalCnt;
    @Key
    public Integer currentCnt;
    @Key
    public String detail;

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}
