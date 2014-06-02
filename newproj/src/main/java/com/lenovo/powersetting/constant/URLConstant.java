package com.lenovo.powersetting.constant;

/**
 * Created by Administrator on 2014/5/15.
 */
public interface URLConstant {
    //product
    public static final int URL_GET_PRODUCT_DOING = 1;
    public static final int URL_GET_PRODUCT_DOING_DETAIL = 2;
    public static final int URL_GET_PRODUCT_STOPACTION = 3;
    public static final int URL_GET_PRODUCT_STOPACTION_DETAIL = 4;
    public static final int URL_GET_PRODUCT_DONE = 5;
    public static final int URL_GET_PRODUCT_DONE_DETAIL = 6;
    //user
    public static final int URL_GET_USERLOGIN = 7;
    public static final int URL_GET_USERADDRESS = 8;
    public static final int URL_GET_USERCOMMENT = 9;
    public static final int URL_GET_USERACCOUNT = 10;
    public static final int URL_GET_USERINFO = 11;
    //others
    public static final int URL_GET_UPDATE_INFO = 12;
    public static final int URL_GET_APP_EXPLAIN = 13;
    public static final int URL_GET_ADVERTISEMENT = 14;
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

