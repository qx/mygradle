package com.cfz.android.visual.activity;

import android.os.Bundle;
import android.view.View;
import cn.trinea.android.common.util.ToastUtils;
import com.cfz.android.R;

/**
 * Created by Administrator on 2014/4/27.
 */
public class FindPwdActivity extends BaseActivity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pwd_find);
    }

    @Override
    protected int getActivityTitle() {
        return R.string.title_pwd_find;
    }

    public void onResent(View view) {
        ToastUtils.show(this, R.string.pwd_find_next_reset);
    }

}