package com.cfz.android.visual.activity;

import android.os.Bundle;
import com.cfz.android.R;

/**
 * 分享到界面
 * Created by Administrator on 2014/4/21.
 */
public class ShareActivity extends BaseActivity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share);
    }


    @Override
    protected int getActivityTitle() {
        return R.string.title_share;
    }

}