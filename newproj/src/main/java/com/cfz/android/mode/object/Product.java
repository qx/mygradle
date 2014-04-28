package com.cfz.android.mode.object;

import java.util.List;

/**
 * Base product information
 * 产品基本信息
 */
public class Product {
    /**
     * product for checkout last users that lucky;
     * 商品类别(查询往期该类产品中间用户)
     */
    public int type_id;
    /**
     * 商品唯一ID
     */
    public long id;
    /**
     * 商品名称
     */
    public String produceName;
    /**
     * 商品图片地址
     */
    public String url_img;
    /**
     * 商品评论信息列表
     */
    public List<Comment> commentList;
    /**
     * 价格
     */
    public int price;
    /**
     * action number
     * 活动期号
     */
    public int id_action;
}
