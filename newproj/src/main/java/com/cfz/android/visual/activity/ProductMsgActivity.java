package com.cfz.android.visual.activity;

import android.os.Bundle;
import com.cfz.android.R;

/**
 * Created by Administrator on 2014/4/25.
 */
public class ProductMsgActivity extends BaseActivity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_message);
    }

    @Override
    protected int getActivityTitle() {
        return R.string.title_product_msg;
    }
}