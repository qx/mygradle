package com.cfz.android.entity.network.urlentity;

import com.google.api.client.util.Key;
import com.cfz.android.entity.network.resultbean.Ads;

import java.util.ArrayList;

/**
 * Created by ok on 6/10/14.
 */
public class BackAdvListEntity extends BaseEntity {
    @Key
    public ArrayList<Ads> result;
}
