package com.example.myapp;

import com.google.api.client.util.Key;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.util.List;

/**
 * Created by Administrator on 2014/4/27.
 */
public class ProductList {
    @Key
    public String status;

    @Key
    public List<Product> result;

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}
