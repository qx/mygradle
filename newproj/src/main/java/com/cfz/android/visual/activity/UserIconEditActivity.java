package com.cfz.android.visual.activity;

import android.os.Bundle;
import com.cfz.android.R;

/**
 * Created by Administrator on 2014/4/27.
 */
public class UserIconEditActivity extends BaseActivity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_usericon);
    }

    @Override
    protected int getActivityTitle() {
        return R.string.title_edit_userpic;
    }

    @Override
    protected int getActivityMoreImg() {
        return R.drawable.save;
    }

    @Override
    protected int getActivityMoreTitle() {
        return R.string.null_string;
    }
}