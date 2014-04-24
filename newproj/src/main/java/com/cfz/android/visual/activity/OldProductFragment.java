package com.cfz.android.visual.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.cfz.android.R;

/**
 * 主页tab 获取商品界面
 * Created by Administrator on 2014/4/21.
 */
public class OldProductFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_product_get, container, false);
    }
}