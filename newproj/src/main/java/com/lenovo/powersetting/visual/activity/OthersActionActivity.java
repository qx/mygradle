package com.lenovo.powersetting.visual.activity;

import android.os.Bundle;
import com.lenovo.powersetting.R;

/**
 * Created by Administrator on 2014/4/25.
 */
public class OthersActionActivity extends BaseActivity {
    public void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_others_action);
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getActivityTitle() {
        return R.string.title_others_action;
    }

//    @Override
//    protected int getActivityMoreImg() {
//        return R.drawable.save;
//    }
//
//    @Override
//    protected int getActivityMoreTitle() {
//        return R.string.null_string;
//    }
}