package com.example.myapp;

import com.google.api.client.util.Key;

/**
 * Created by Administrator on 2014/4/27.
 */
public class Product {

    @Key
    public String productId;

    @Key
    public String productImg;

    @Key
    public String productName;
    @Key
    public String price;
    @Key
    public String totalCnt;
    @Key
    public String currentCnt;
    @Key
    public String detail;

    @Override
    public String toString() {
        return
                productId + " - " +
                        productImg + " - " +
                        productName + " - " +
                        price + " - " +
                        totalCnt + " - " +
                        currentCnt + " - " +
                        detail;
    }
}