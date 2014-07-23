package com.cfz.android.entity.network.urlentity;

import com.cfz.android.entity.network.resultbean.Histroy;
import com.cfz.android.visual.activity.listener.GlobalConstant;
import com.google.api.client.util.Key;

import java.util.ArrayList;

/**
 * Created by ok on 6/10/14.
 */
public class BackHistoryEntity extends BaseEntity {
    @Key
    public ArrayList<Histroy> result;

}
