package com.cfz.android.mode.object.network.entity;

import com.google.api.client.util.Key;

/**
 * 评论列表模块
 */
public class ProductedCommentListBean {
    //    "1:nickName
//            2:contents
//    3:time"
    @Key
    public String nickName;

    @Key
    public String contents;

    @Key
    public String time;


}
