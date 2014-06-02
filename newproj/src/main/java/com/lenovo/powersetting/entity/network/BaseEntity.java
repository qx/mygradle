package com.lenovo.powersetting.entity.network;

import com.google.api.client.util.Key;

import java.util.List;

/**
 * Created by ok on 14-5-22.
 */
public class BaseEntity {
    @Key
    public List<Object> result;

    @Key
    public String info;

    @Key
    public String status;

    public String getUrl() {
        return url;
    }
    private String url;

    protected BaseEntity(String url) {
        this.url = url;
    }

    public BaseEntity() {
    }

    public void writeInstance(BaseEntity baseEntity) {
        if (baseEntity.result != null) {
            if (this.result == null) {
                this.result = baseEntity.result;
            }
        }
        if (baseEntity.info != null) {
            if (this.info == null) {
                this.info = baseEntity.info;
            }
        }
        if (baseEntity.status != null) {
            if (this.status == null) {
                this.status = baseEntity.status;
            }
        }
        if (baseEntity.url != null) {
            if (this.url == null) {
                this.url = baseEntity.url;
            }
        }

    }

    public void setUrl(String url) {
        this.url = url;
    }
}
