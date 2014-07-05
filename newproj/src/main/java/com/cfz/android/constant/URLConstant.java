package com.cfz.android.constant;

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


//    public static final String BASE_URL = "http://114.215.177.210:8080/cfz/";
    public static final String BASE_URL = "http://192.168.199.192:8080/cfz/phone/";
    /**
     * 登录
     */
    public static final String LOGIN_URL = BASE_URL + "user_loginOrReg?";
    public static final String LOGIN_URL_PARAMS_ID_ = "qqId";
    public static final String LOGIN_URL_PARAMS_PHONE_ = "phoneType";
    public static final String LOGIN_URL_PARAMS_PHONEID_ = "phoneId";
    /**
     * 设置头像
     */
    public static final String SETHEAD_URL = BASE_URL + "user_setHeadImg?";
    public static final String SETHEAD_PARAMS_IMAGE = "image";

    /**
     * 修改昵称
     */
    public static final String SETNICK_URL = BASE_URL + "user_setNickName?";
    public static final String SETNICK_PARAMS_IMAGE = "nickName";

    /**
     * 获取收获地址
     */
    public static final String GETUSERADDRESS_URL = "user_getAddressInfo?";
    /**
     * 设置收获地址
     * address
     * 2: cityName
     * 3: phone
     * 4: realName"
     */
    public static final String SETUSERADDRESS_URL = "user_setAddressInfo?";
    public static final String SETUSERADDRESS_PARAMS_ADDRESS = "address";
    public static final String SETUSERADDRESS_PARAMS_CITYNAME = "cityName";
    public static final String SETUSERADDRESS_PARAMS_PHONE = "phone";
    public static final String SETUSERADDRESS_PARAMS_REALNAME = "realName";


    /**
     * 1：获取商品评论列表
     */
    public static final String GETPRODUCTCOMMENT_URL = "comment_getProductedCommentList?";

    /**
     * 2：用户活动商品评论功能
     */
    public static final String SETUSERCOMMENT_URL = "comment_setUserComment?";
    public static final String SETUSERCOMMENT_PARAMS_USERID = "userid";
    public static final String SETUSERCOMMENT_PARAMS_PRODUCTID = "productId";
    public static final String SETUSERCOMMENT_PARAMS_CONTENTS = "contents";

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

    /**
     * 广告
     */
    public static final String GET_PRODUCT_URL = BASE_URL + "adv_getAdvList?";
    public static final String GET_PRODUCT_PARAMS_ = "pageNum";


    public static final String success = "success";
    public static final String fail = "fail";
}

