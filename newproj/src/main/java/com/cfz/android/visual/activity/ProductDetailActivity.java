package com.cfz.android.visual.activity;

import android.os.Bundle;
import com.cfz.android.R;
import com.cfz.android.visual.customview.fancycoverflow.FancyCoverFlow;
import com.cfz.android.visual.customview.fancycoverflow.FancyCoverFlowSampleAdapter;

/**
 * Created by Administrator on 2014/4/26.
 */
public class ProductDetailActivity extends BaseActivity {

    private FancyCoverFlow fancyCoverFlow;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);

        this.fancyCoverFlow = (FancyCoverFlow) this.findViewById(R.id.fancyCoverFlow);

        this.fancyCoverFlow.setAdapter(new FancyCoverFlowSampleAdapter());
        this.fancyCoverFlow.setUnselectedAlpha(1.0f);
        this.fancyCoverFlow.setUnselectedSaturation(0.0f);
        this.fancyCoverFlow.setUnselectedScale(0.5f);
        this.fancyCoverFlow.setSpacing(50);
        this.fancyCoverFlow.setMaxRotation(0);
        this.fancyCoverFlow.setScaleDownGravity(0.2f);
        this.fancyCoverFlow.setActionDistance(FancyCoverFlow.ACTION_DISTANCE_AUTO);
    }

    @Override
    protected int getActivityMoreImg() {
        return super.getActivityMoreImg();
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