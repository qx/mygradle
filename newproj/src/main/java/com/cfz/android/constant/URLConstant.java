package com.cfz.android.constant;

/**
 * Created by Administrator on 2014/5/15.
 */
public interface URLConstant {
    public static final String info = "info";

    public static final String status = "status";


    public static final String BASE_URL = "http://114.215.177.210:8080/cfz/phone/";
//    public static final String BASE_URL = "http://192.168.1.105:8080/cfz/phone/";

    /**
     * 1广告
     */
    public static final String URL_ADS = BASE_URL + "adv_getAdvList";
    public static final String URL_ADS_PN = "pageNum";

    /**
     * 2当前进行商品
     */
    public static final String URL_PRODUCTING = BASE_URL + "product_getProductingList";
    public static final String URL_PRODUCTING_PN = "pageNum";

    /**
     * 3今日开奖商品(完成)
     */
    public static final String URL_LOTTERY = BASE_URL + "product_getLotteryList";
    public static final String URL_LOTTERY_PN = "pageNum";
    /**
     * 4:等待开奖商品(完成)
     */
    public static final String URL_WAITING = BASE_URL + "product_getProductWaitList";
    public static final String URL_WAITING_PN = "pageNum";
    /**
     * 5:历史开奖商品(完成)
     */
    public static final String URL_HISTORY = BASE_URL + "product_getHistoryList";
    public static final String URL_HISTORY_PN = "pageNum";
    /**
     * 6:凑分详情页面(完成)
     */
    public static final String URL_PRODUCT_DETAIL = BASE_URL + "product_getProductDetail";
    public static final String URL_PRODUCT_DETAIL_PID = "productId";
    public static final String URL_PRODUCT_DETAIL_IID = "infoId";


    /**
     * 7:同款商品往期回顾(完成)
     */
    public static final String URL_PRODUCT_SAME = BASE_URL + "product_getSameProductWinner";
    public static final String URL_PRODUCT_SAME_PN = "productId";
    public static final String URL_PRODUCT_SAME_IID = "infoId";
    /**
     * 8:获取商品的凑分记录()
     */
    public static final String URL_PRODUCT_RECORD = BASE_URL + "userProduct_getProductedRecordList";
    public static final String URL_PRODUCT_RECORD_PID = "productId";
    public static final String URL_PRODUCT_RECORD_PN = "pageNum";
    /**
     * 9:用户凑分功能
     */
    public static final String URL_USER_BET = BASE_URL + "userProduct_executeBet";
    public static final String URL_USER_BET_PID = "productId";
    public static final String URL_USER_BET_BN = "betCnt";
    /**
     * 10.更多信息(完成)
     */
    public static final String URL_MORE = BASE_URL + "system_companyRight";
    /**
     * 11.用户意见反馈(完成)
     */
    public static final String URL_USER_MESSAGE = BASE_URL + "system_userSuggest";
    public static final String URL_USER_MESSAGE_MSG = "msg";
    public static final String URL_USER_MESSAGE_MSG_PT = "phoneType";
    public static final String URL_USER_MESSAGE_MSG_VI = "version";
    /**
     * 12.版本更新检测(完成)
     */
    public static final String URL_UPDATE = BASE_URL + "system_refreshVersion";
    public static final String URL_UPDATE_PT = "phoneType";
    /**
     * 13:用户注册(完成)
     */
    public static final String URL_LOADING = BASE_URL + "user_loginOrReg";
    public static final String URL_LOADING_QQID = "qqId";
    public static final String URL_LOADING_PT = "phoneType";
    public static final String URL_LOADING_PSN = "phoneId";
    /**
     * 14:资金池和积分刷新
     */
    public static final String URL_USER_COUNT = BASE_URL + "user_refreshMoney";
    /**
     * 15：修改用户头像(完成)
     */
    public static final String URL_USER_ICON = BASE_URL + "user_setHeadImg";
    public static final String URL_USER_ICON_SET = "image";
    /**
     * 16：修改昵称(完成)
     */
    public static final String URL_USER_NICK = BASE_URL + "user_setNickName";
    public static final String URL_USER_NICK_SET = "nickName";
    /**
     * 17：获取用户收获地址(完成)
     */
    public static final String URL_USER_ADDRESS = BASE_URL + "user_getAddressInfo";
    /**
     * 18：设置用户收获地址(完成)
     */
    public static final String URL_USER_SETADDRESS = BASE_URL + "user_setAddressInfo";
    public static final String URL_USER_SETADDRESS_AD = "address";
    public static final String URL_USER_SETADDRESS_CN = "cityName";
    public static final String URL_USER_SETADDRESS_PH = "phone";
    public static final String URL_USER_SETADDRESS_REAL = "realName";
    /**
     * 19：获取商品评论列表
     */
    public static final String URL_COMMENT_GET = BASE_URL + "comment_getProductedCommentList";
    public static final String URL_COMMENT_GET_PID = "productId";
    public static final String URL_COMMENT_GET_PN = "pageNum";
    /**
     * 20：用户活动商品评论功能
     */
    public static final String URL_COMMENT_SET = BASE_URL + "comment_setUserComment";
    public static final String URL_COMMENT_SET_UID = "userId";
    public static final String URL_COMMENT_SET_PID = "productId";
    public static final String URL_COMMENT_SET_CON = "contents";







    public static final String success = "success";
    public static final String fail = "fail";


}

