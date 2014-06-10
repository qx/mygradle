package com.lenovo.powersetting.entity.network.resultbean;

import com.google.api.client.util.Key;

/**
 *升级检测
 */
public class RefreshVersionBean extends BaseResultBean {
//    1：latest
//    2：phoneType_invalid
//    3：content
//    4: version
//    5: download"
    @Key
    public String lastest;

    @Key
    public String phoneType_invalid;

    @Key
    public String content;

    @Key
    public String version;

    @Key
    public String download;

}
