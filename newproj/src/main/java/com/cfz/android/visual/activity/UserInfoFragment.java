package com.cfz.android.visual.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.cfz.android.R;

/**
 * Created by Administrator on 2014/4/27.
 */
public class UserInfoFragment extends BaseFragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_user_info, container, false);

        RelativeLayout my_account = (RelativeLayout) v.findViewById(R.id.my_account);
        RelativeLayout my_address = (RelativeLayout) v.findViewById(R.id.my_address);
        RelativeLayout my_history = (RelativeLayout) v.findViewById(R.id.my_history);
        RelativeLayout my_msg = (RelativeLayout) v.findViewById(R.id.my_msg);
        RelativeLayout my_product = (RelativeLayout) v.findViewById(R.id.my_product);

        my_account.setOnClickListener(this);
        my_address.setOnClickListener(this);
        my_history.setOnClickListener(this);
        my_msg.setOnClickListener(this);
        my_product.setOnClickListener(this);

        return v;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.my_account:
                startIntent(MyAccountActivity.class);
                break;
            case R.id.my_address:
                startIntent(MyAddressActivity.class);
                break;
            case R.id.my_history:
                startIntent(MyHistoryActivity.class);
                break;
            case R.id.my_msg:
                startIntent(MyMessageActivity.class);
                break;
            case R.id.my_product:
                startIntent(MyGetProductActivity.class);
                break;
            default:
                break;
        }
    }

    public void startIntent(Class<? extends Activity> target) {
        startActivity(new Intent(getActivity(), target));
    }
}