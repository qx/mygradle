package com.cfz.android.entity.network.urlentity;

import com.cfz.android.entity.network.resultbean.NewProductResult;
import com.google.api.client.util.Key;

import java.util.ArrayList;

/**
 * Created by Administrator on 2014/5/15.
 */
public class BackListProductEntity extends BaseEntity {
    @Key
    public ArrayList<NewProductResult> result;
}
