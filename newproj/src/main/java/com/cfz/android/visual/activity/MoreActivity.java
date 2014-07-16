package com.cfz.android.visual.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import cn.trinea.android.common.util.ToastUtils;
import com.cfz.android.R;

/**
 * Created by Administrator on 2014/4/25.
 */
public class MoreActivity extends BaseActivity  {
    @InjectView(R.id.explain)
    RelativeLayout explain;
    @InjectView(R.id.reback)
    RelativeLayout reback;
    @InjectView(R.id.callnum)
    RelativeLayout callnum;
    @InjectView(R.id.version)

    RelativeLayout version;

    public void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_more);
        super.onCreate(savedInstanceState);
        ButterKnife.inject(this);
    }

    @Override
    protected int getActivityTitle() {
        return R.string.title_more;
    }


    @OnClick({R.id.explain, R.id.reback, R.id.callnum, R.id.version})
    public void submit(View view) {
        switch (view.getId()) {
            case R.id.explain:
                ToastUtils.show(this, "explain");
                startActivity(new Intent(this,ProductExplainActivity.class));
                break;
            case R.id.reback:
                ToastUtils.show(this, "reback");
                break;
            case R.id.callnum:
                ToastUtils.show(this, "callnum");
                break;
            case R.id.version:
                ToastUtils.show(this, "version");
                break;
            default:
                break;
        }
    }
}