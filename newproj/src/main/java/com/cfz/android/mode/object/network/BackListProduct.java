package com.cfz.android.mode.object.network;

import com.google.api.client.util.Key;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.util.ArrayList;

/**
 * Created by Administrator on 2014/5/15.
 */
public class BackListProduct {
    @Key
    public String status;

    @Key
    public ArrayList<BackNewProduct> result;

    @Key
    public String info;

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}
