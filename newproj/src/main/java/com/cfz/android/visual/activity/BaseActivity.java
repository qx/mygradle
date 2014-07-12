package com.cfz.android.visual.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.cfz.android.R;
import com.cfz.android.RequestInsance;
import com.cfz.android.Spokers;
import com.cfz.android.constant.URLConstant;
import com.cfz.android.entity.network.urlentity.BaseEntity;
import com.cfz.android.impl.HttpRequestListener;
import com.cfz.android.utils.LogUtil;
import com.cfz.android.visual.activity.listener.SecondClickListener;
import com.google.api.client.http.HttpContent;

import java.util.HashMap;

/**
 * Created by Administrator on 2014/4/21.
 */
public class BaseActivity extends FragmentActivity implements SecondClickListener,URLConstant{
    protected TextView title;
    protected TextView title2;
    protected ImageView img;
    protected String TAG;
    protected HttpContent httpContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TAG = getLocalClassName()+"___";
        ButterKnife.inject(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        title = (TextView) findViewById(R.id.title);
        if (title != null) {
            title.setText(getActivityTitle());
        }
        title2 = (TextView) findViewById(R.id.title_txt_more);
        if (title2 != null) {
            title2.setText(getActivityMoreTitle());
        }
        img = (ImageView) findViewById(R.id.title_img_more);
        if (img != null) {
            img.setImageResource(getActivityMoreImg());
        }


    }

    /**
     * @return resid
     */
    protected int getActivityMoreImg() {
        return 0;
    }

    /**
     * @return resid
     */
    protected int getActivityMoreTitle() {
        return 0;
    }

    public void onReturn(View view) {
        if (view != null) {
            this.finish();
        }
    }

    public void onSecondClick(View view) {
        if (view != null) {
            secondClick();
        }
    }

    /**
     * @return resid
     */
    protected int getActivityTitle() {
        return 0;
    }

    @Override
    public void secondClick() {
    }

    /**
     * 接口测试
     *
     * @param Url        完整URL地址
     * @param backentity 返回封装类
     * @param content    内容
     */
    protected void testMethod(String Url, Class<? extends BaseEntity> backentity, HttpContent content, HttpRequestListener httpRequestListener,final HashMap<String, Object> data) {
        LogUtil.logNet("params:" + data.toString());
        Spokers.getInstance().postHttpDataUseAsync(content, httpRequestListener, Url, backentity);
    }
}