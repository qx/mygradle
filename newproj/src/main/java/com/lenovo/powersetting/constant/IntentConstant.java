package com.lenovo.powersetting.constant;

/**
 * define Intent action here,like action used in broadcast
 */
public final class IntentConstant {
    public static final String BASEINTENT = "com.lenovo.powersetting.";
    public static final String INTENT_ENTER = BASEINTENT + "enter";
    /**
     * 智能亮度开
     */
    public static final String STARTBRIGHTNESS = "STARTBRIGHTNESS";
    /**
     * 智能亮度关
     */
    public static final String STOPBRIGHTNESS = "STOPBRIGHTNESS";
    /**
     * 停止深度睡眠
     */
    public static final String STOPTSLEEP = "STOPTSLEEP";
    /**
     * 开启深度睡眠
     */
    public static final String STARTSLEEP = "STARTSLEEP";
    /**
     * VMX开启
     */
    public static final String STARTVMX = "STARTVMX";
    /**
     * 定时切换关闭
     */
    public static final String STOPTIMINGCHANGE = "STOPTIMINGCHANGE";
    /**
     * 定时切换开启
     */
    public static final String STARTIMINGCHANGE = "STARTIMINGCHANGE";
    /**
     * 停止应急省电
     */
    public static final String STOPCLASSICMODE = "STOPCLASSICMODE";
    /**
     * 开启应急省电
     */
    public static final String STARTCLASSICMODE = "STARTCLASSICMODE";
    /**
     * VMX关闭
     */
    public static final String STOPVMX = "STOPVMX";


    //product
    public static final String GET_PRODUCT_DOING = "GET_PRODUCT_DOING_DETAIL";
    public static final String GET_PRODUCT_DOING_DETAIL = "GET_PRODUCT_DOING_DETAIL";
    public static final String GET_PRODUCT_STOPACTION = "GET_PRODUCT_STOPACTION";
    public static final String GET_PRODUCT_STOPACTION_DETAIL = "GET_PRODUCT_STOPACTION_DETAIL";
    public static final String GET_PRODUCT_DONE = "GET_PRODUCT_DONE";
    public static final String GET_PRODUCT_DONE_DETAIL = "GET_PRODUCT_DONE_DETAIL";
    //user
    public static final String GET_USERLOGIN = "GET_USER_LOGIN";
    public static final String GET_USERADDRESS = "GET_USER_ADDRESS";
    public static final String GET_USERCOMMENT = "GET_USER_COMMENT";
    public static final String GET_USERACCOUNT = "GET_USER_ACCOUNT";
    public static final String GET_USERINFO = "GET_USER_INFO";
    //others
    public static final String GET_UPDATE_INFO = "GET_UPDATE_INFO";
    public static final String GET_APP_EXPLAIN = "GET_APP_EXPLAIN";
    public static final String GET_ADVERTISEMENT = "GET_ADVERTISEMENT";

}
