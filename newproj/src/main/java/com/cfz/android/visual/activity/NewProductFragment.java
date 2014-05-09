package com.cfz.android.visual.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.cfz.android.R;

/**
 * 主页tab 所有产品界面
 * Created by Administrator on 2014/4/21.
 */
public class NewProductFragment extends BaseFragment {
    private View second;
    private View first;
    private MainActivity mActivity;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View mview = inflater.inflate(R.layout.fragment_product_all, container, false);
        first = mview.findViewById(R.id.first);
        first.setOnClickListener(this);
        second = mview.findViewById(R.id.second);
        second.setOnClickListener(this);
        return mview;
    }

// ((MainActivity)mAppFragmentTabActivity).updateActivityData(mActivity.mModeInfo);
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.first:
                startActivity(new Intent(getActivity(), ProductDetailActivity.class));
                break;

            case R.id.second:
                startActivity(new Intent(getActivity(), ProductDetailActivity.class));
                break;
            default:
                break;
        }
    }

}