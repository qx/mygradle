package com.cfz.android.visual.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import butterknife.ButterKnife;
import butterknife.InjectView;
import com.cfz.android.R;
import com.cfz.android.entity.network.urlentity.BackMoreEntity;
import com.cfz.android.entity.network.urlentity.BackProductDetailEntity;
import com.cfz.android.impl.HttpRequestListener;
import com.cfz.android.utils.LogUtil;
import com.google.api.client.http.UrlEncodedContent;

import java.util.HashMap;

/**
 * Created by ok on 7/16/14.
 */
public class ProductExplainActivity extends BaseActivity   {
    @InjectView(R.id.content)
    TextView content;
    public void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_product_explain);
        super.onCreate(savedInstanceState);
        ButterKnife.inject(this);
        HashMap<String, Object> data = new HashMap<String, Object>();
        httpContent = new UrlEncodedContent(data);
        testMethod(URL_MORE, BackMoreEntity.class, httpContent, new HttpRequestListener() {
            @Override
            public void onSuccess(Object o) {
                super.onSuccess(o);
//                    BackProductDetailEntity.

                LogUtil.i(TAG, o.toString());
            }
        }, data);
//        content.setText();
    }

    @Override
    protected int getActivityTitle() {
        return R.string.title_explain;
    }

}