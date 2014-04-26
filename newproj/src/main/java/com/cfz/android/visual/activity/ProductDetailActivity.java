package com.cfz.android.visual.activity;

import android.os.Bundle;
import com.cfz.android.R;

/**
 * Created by Administrator on 2014/4/26.
 */
public class ProductDetailActivity extends BaseActivity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);
    }

    @Override
    protected int getActivityMoreImg() {
        return R.drawable.productsinfo_button_share;
    }

    @Override
    protected int getActivityMoreTitle() {
        return R.string.product_detail_share;
    }

    @Override
    protected int getActivityTitle() {
        return R.string.title_product_detail;
    }
}