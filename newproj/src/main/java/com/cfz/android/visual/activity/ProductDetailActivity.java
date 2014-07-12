package com.cfz.android.visual.activity;

import android.os.Bundle;
import com.cfz.android.R;
import com.cfz.android.entity.network.urlentity.BackProductDetailEntity;
import com.cfz.android.impl.HttpRequestListener;
import com.cfz.android.utils.LogUtil;
import com.cfz.android.visual.customview.fancycoverflow.FancyCoverFlow;
import com.cfz.android.visual.customview.fancycoverflow.FancyCoverFlowSampleAdapter;
import com.google.api.client.http.UrlEncodedContent;

import java.util.HashMap;

/**
 * 商品详情
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
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            LogUtil.i(TAG, "URL_PRODUCT_DETAIL_PID" + bundle.getString(URL_PRODUCT_DETAIL_PID) +
                    "\t" + "URL_PRODUCT_DETAIL_IID" + bundle.getString(URL_PRODUCT_DETAIL_IID));
            HashMap<String, Object> data = new HashMap<String, Object>();
            data.put(URL_PRODUCT_DETAIL_PID, bundle.getString(URL_PRODUCT_DETAIL_PID));//商品ID未知
            data.put(URL_PRODUCT_DETAIL_IID, bundle.getString(URL_PRODUCT_DETAIL_IID));
            httpContent = new UrlEncodedContent(data);
            testMethod(URL_PRODUCT_DETAIL, BackProductDetailEntity.class, httpContent, new HttpRequestListener() {
                @Override
                public void onSuccess(Object o) {
                    super.onSuccess(o);
//                    BackProductDetailEntity.
                    LogUtil.i(TAG, o.toString());
                }
            }, data);
        }

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