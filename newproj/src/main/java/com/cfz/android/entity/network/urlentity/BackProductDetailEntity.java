package com.cfz.android.entity.network.urlentity;

import com.cfz.android.entity.network.resultbean.BetPageDetail;
import com.google.api.client.util.Key;

import java.util.ArrayList;

/**
 * Created by Administrator on 2014/5/15.
 */
public class BackProductDetailEntity extends BaseEntity {
    @Key
    public ArrayList<BetPageDetail> result;
}
