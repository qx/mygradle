package com.lenovo.powersetting.visual.activity.constant;

/**
 * Created by Administrator on 2014/5/15.
 */
public interface URLConstant {

    public static final String info = "info";

    public static final String status = "status";


    public static final String BASE_URL = "http://114.215.177.210:8080/cfz/";
    /**
     * 登录
     */
    public static final String LOGIN_URL = BASE_URL + "user_loginOrReg?";
    public static final String LOGIN_URL_PARAMS_ID_ = "qqId";
    public static final String LOGIN_URL_PARAMS_PHONE_ = "phoneType";
    public static final String LOGIN_URL_PARAMS_PHONEID_ = "phoneId";


    /**
     * 当前进行商品
     */
    public static final String PRODUCT_URL = BASE_URL + "product_getProductingList?";
    public static final String PRODUCT_URL_PARAMS_PAGE_ = "pageNum";

    /**
     * 凑份商品详情
     */
    public static final String PRODUCT_URL_DETAIL_ = BASE_URL + "product_betPageDetail?";
    public static final String PRODUCT_URL_PARAMS_PRODUCTID_ = "productId";

    /**
     * 揭晓商品
     */
    public static final String PRODUCTOLD_URL = BASE_URL + "comment_getProductedCommentList?";
    public static final String PRODUCTOLD_URL_PARAMS_PAGE = "pageNum";


    public static final String success = "success";
    public static final String fail = "fail";
}

