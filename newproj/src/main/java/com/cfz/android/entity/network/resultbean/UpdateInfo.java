package com.cfz.android.entity.network.resultbean;

import com.google.api.client.util.Key;

/**
 * Created by ok on 7/7/14.
 */
public class UpdateInfo extends BaseResult {
    //    "1:version
//            2:content
//    3:download"		"1:最新版本号
//    2:更新内容
//    3:下载地址"	"1:字符串
//    2:字符串
//    3:字符串"
    @Key
    public String version;
    @Key
    public String content;
    @Key
    public String download;
}
