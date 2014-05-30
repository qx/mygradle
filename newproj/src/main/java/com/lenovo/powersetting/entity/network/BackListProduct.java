package com.lenovo.powersetting.entity.network;

import com.google.api.client.util.Key;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.ArrayList;

/**
 * Created by Administrator on 2014/5/15.
 */
public class BackListProduct extends BaseEntity {
    @Key
    public String status;

    @Key
    public ArrayList<BackNewProduct> result;

    @Key
    public String info;

    public BackListProduct() {
super();
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}
