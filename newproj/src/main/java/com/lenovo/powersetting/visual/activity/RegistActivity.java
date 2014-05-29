package com.lenovo.powersetting.visual.activity;

import android.os.Bundle;
import com.lenovo.powersetting.R;

/**
 * Created by Administrator on 2014/4/27.
 */
public class RegistActivity extends BaseActivity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    @Override
    protected int getActivityTitle() {
        return R.string.title_register;
    }
}