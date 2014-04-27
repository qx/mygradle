package com.example.myapp;

import com.google.api.client.util.Key;

import java.util.List;

/**
 * Created by Administrator on 2014/4/27.
 */
public class ProductList {
    @Key
    public String status;

    @Key
    public List<Product> results;

}
