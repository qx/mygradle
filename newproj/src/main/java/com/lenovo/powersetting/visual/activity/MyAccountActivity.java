package com.lenovo.powersetting.visual.activity;

import android.os.Bundle;
import com.lenovo.powersetting.R;

/**
 * Created by Administrator on 2014/5/9.
 */
public class MyAccountActivity extends BaseActivity {
    public void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_account);
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getActivityTitle() {
        return R.string.title_account_sub;
    }
}