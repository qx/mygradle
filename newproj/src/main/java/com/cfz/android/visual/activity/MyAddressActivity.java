package com.cfz.android.visual.activity;

import android.app.Activity;
import android.os.Bundle;
import com.cfz.android.R;

/**
 * Created by Administrator on 2014/5/9.
 */
public class MyAddressActivity extends BaseActivity {
    public void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_address);
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getActivityTitle() {
        return R.string.title_address;
    }
}