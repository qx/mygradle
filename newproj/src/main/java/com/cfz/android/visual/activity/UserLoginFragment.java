package com.cfz.android.visual.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.cfz.android.R;
import com.cfz.android.visual.activity.listener.FirstPageFragmentListener;

/**
 * 主页TAG,用户
 * Created by Administrator on 2014/4/21.
 */
public class UserLoginFragment extends BaseFragment implements FirstPageFragmentListener {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_user_login, container, false);
        (v.findViewById(R.id.login)).setOnClickListener(this);

        return v;
    }

    public static UserLoginFragment newInstance(FirstPageFragmentListener firstPageFragmentListener) {
        UserLoginFragment f = new UserLoginFragment();
        return f;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.login:
//                Fragment productDetailFragment = UserInfoFragment.newInstance();
//                FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
//                transaction.addToBackStack(null);
//                transaction.replace(R.id.pager, productDetailFragment).commit();

                break;
            default:
                break;

        }
    }

    @Override
    public void onSwitchToNextFragment() {

    }
}