package com.cfz.android.entity.network.urlentity;

import com.cfz.android.entity.network.resultbean.JinRi;
import com.google.api.client.util.Key;

import java.util.ArrayList;

/**
 * Created by ok on 7/5/14.
 */
public class BackJinRiEntity extends BaseEntity {
    @Key
    public ArrayList<JinRi> result;
}

