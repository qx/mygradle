package com.lenovo.powersetting.visual.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.lenovo.powersetting.R;

/**
 * 主页tab 获取商品界面
 * Created by Administrator on 2014/4/21.
 */
public class OldProductFragment extends BaseFragment {

    private View second;
    private View first;
    private MainActivity mActivity;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View mview = inflater.inflate(R.layout.fragment_product_get, container, false);
        first = mview.findViewById(R.id.first_get);
        first.setOnClickListener(this);
        second = mview.findViewById(R.id.second_get);
        second.setOnClickListener(this);
        second = mview.findViewById(R.id.third_get);
        second.setOnClickListener(this);
        return mview;
    }

    // ((MainActivity)mAppFragmentTabActivity).updateActivityData(mActivity.mModeInfo);
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.first_get:
                startActivity(new Intent(getActivity(), ProductMsgActivity.class));
                break;
            case R.id.second_get:
                startActivity(new Intent(getActivity(), ProductMsgActivity.class));
                break;
            case R.id.third_get:
                startActivity(new Intent(getActivity(), ProductMsgActivity.class));
                break;
            default:
                break;
        }
    }
}