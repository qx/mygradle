package com.lenovo.powersetting.entity.network;

import com.google.api.client.util.Key;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
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

    public BaseEntity() {
    }
    public Class getGenericType(int index) {
        Type genType = getClass().getGenericSuperclass();
        if (!(genType instanceof ParameterizedType)) {
            return Object.class;
        }
        Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
        if (index >= params.length || index < 0) {
            throw new RuntimeException("Index outof bounds");
        }
        if (!(params[index] instanceof Class)) {
            return Object.class;
        }
        return (Class) params[index];
    }
}
