package com.cfz.android.entity.data;

/**
 * New product for sell
 * 凑分中产品
 */
public class NewProduct extends Product {
    /**
     * 当前凑份信息
     */
    public ActionCurrent actionCurrent;
    /**
     * 往期凑份信息
     */
    public ActionPast actionPast;
}
