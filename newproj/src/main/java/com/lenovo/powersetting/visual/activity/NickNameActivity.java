package com.lenovo.powersetting.visual.activity;

import android.os.Bundle;
import com.lenovo.powersetting.R;

/**
 * Created by Administrator on 2014/4/25.
 */
public class NickNameActivity extends BaseActivity {
    public void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_nickname_edit);
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getActivityTitle() {
        return R.string.title_edit_nickname;
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