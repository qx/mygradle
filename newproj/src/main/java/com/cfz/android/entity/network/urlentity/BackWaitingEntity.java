package com.cfz.android.entity.network.urlentity;

import com.cfz.android.entity.network.resultbean.Dengdai;
import com.cfz.android.visual.activity.listener.GlobalConstant;
import com.google.api.client.util.Key;

import java.util.ArrayList;

/**
 * 等待
 */
public class BackWaitingEntity extends BaseEntity {
    @Key
    public ArrayList<Dengdai> result;
}
