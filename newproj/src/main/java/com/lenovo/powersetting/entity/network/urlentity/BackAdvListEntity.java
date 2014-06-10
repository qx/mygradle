package com.lenovo.powersetting.entity.network.urlentity;

import com.google.api.client.util.Key;
import com.lenovo.powersetting.entity.network.resultbean.AdsBean;
import com.lenovo.powersetting.entity.network.resultbean.NewProductBean;

import java.util.ArrayList;

/**
 * Created by ok on 6/10/14.
 */
public class BackAdvListEntity extends BaseEntity {
    @Key
    public ArrayList<AdsBean> result;
}
