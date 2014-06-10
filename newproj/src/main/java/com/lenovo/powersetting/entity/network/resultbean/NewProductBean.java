package com.lenovo.powersetting.entity.network.resultbean;

import com.google.api.client.util.Key;
import com.lenovo.powersetting.BaseClass;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Created by Administrator on 2014/5/15.
 */
public class NewProductBean extends BaseResultBean   {

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
}
