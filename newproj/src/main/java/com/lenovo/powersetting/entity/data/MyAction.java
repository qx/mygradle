package com.lenovo.powersetting.entity.data;

import java.util.List;

/**
 * My Action information
 * 我的凑份信息
 */
public class MyAction {
    /**
     * 往期产品凑份信息列表
     */
    public List<OldProduct> oldProductList;
    /**
     * 当期(新)产品凑份信息列表
     */
    public List<NewProduct> newProductList;
}
