package com.lenovo.powersetting.entity.network.resultbean;

import com.google.api.client.util.Key;

/**
 * 获取商品评论列表
 * <p/>
 * "1：nickName
 * 2：contents
 * 3：time"
 */
public class ProductedCommentBean extends BaseResultBean  {
    @Key
    public String nickName;

    @Key
    public String contents;
    @Key
    public String time;
}
