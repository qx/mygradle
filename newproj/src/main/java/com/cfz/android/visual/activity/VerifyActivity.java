package com.cfz.android.visual.activity;

import android.os.Bundle;
import com.cfz.android.R;

/**
 * Created by Administrator on 2014/4/27.
 */
public class VerifyActivity extends BaseActivity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify);
    }

    @Override
    protected int getActivityTitle() {
        return R.string.title_verify;
    }
}