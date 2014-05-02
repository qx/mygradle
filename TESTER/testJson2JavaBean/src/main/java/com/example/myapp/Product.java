package com.example.myapp;

import com.example.myapp.mode.MyObject;
import com.google.api.client.util.Key;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * Created by Administrator on 2014/4/27.
 */
public class Product {


    @Key
    public String productId;
    @Key
    public MyObject myObject;

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

    //    @Override
//    public String toString() {
//        return
//                productId + " - " +
//                        productImg + " - " +
//                        productName + " - " +
//                        price + " - " +
//                        totalCnt + " - " +
//                        currentCnt + " - " +
//                        detail;
//    }
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

//    private class MyObject {
//        @Key
//        private String first;
//    }
}