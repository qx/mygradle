package com.lenovo.powersetting.entity.network.urlentity;

import com.google.api.client.util.Key;
import com.lenovo.powersetting.entity.network.resultbean.NewProductBean;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.ArrayList;

/**
 * Created by Administrator on 2014/5/15.
 */
public class BackListProductEntity extends BaseEntity {
    @Key
    public ArrayList<NewProductBean> result;
}
