package com.lenovo.powersetting.visual.activity;

import android.os.Bundle;
import com.lenovo.powersetting.R;

/**
 * Created by Administrator on 2014/4/25.
 */
public class MoreActivity extends BaseActivity {
    public void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_more);
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getActivityTitle() {
        return R.string.title_more;
    }
}