package com.cfz.android.entity.network.resultbean;

import com.google.api.client.util.Key;

/**
 * Created by Administrator on 2014/5/15.
 */
public class NewProductResult extends BaseResult {

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
