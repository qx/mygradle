package com.lenovo.powersetting.visual.activity.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.lenovo.powersetting.visual.activity.UserInfoFragment;
import com.lenovo.powersetting.visual.activity.UserLoginFragment;
import com.lenovo.powersetting.visual.activity.listener.FirstPageFragmentListener;

/**
 * Created by Administrator on 2014/5/9.
 */
public class ViewPageFragmentAdapter extends FragmentPagerAdapter {
    static final int NUM_ITEMS = 3;
    private final FragmentManager mFragmentManager;
    private Fragment mFragmentAtPos0;

    public ViewPageFragmentAdapter(FragmentManager fm) {
        super(fm);
        mFragmentManager = fm;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 2) {
            if (mFragmentAtPos0 == null) {
                mFragmentAtPos0 = UserLoginFragment.newInstance(new FirstPageFragmentListener() {
                    public void onSwitchToNextFragment() {
                        mFragmentManager.beginTransaction().remove(mFragmentAtPos0).commit();
                        mFragmentAtPos0 = UserInfoFragment.newInstance();
                        notifyDataSetChanged();
                    }
                });
            }
            return mFragmentAtPos0;
        } else
            return UserInfoFragment.newInstance();
    }

    @Override
    public int getCount() {
        return NUM_ITEMS;
    }

    @Override
    public int getItemPosition(Object object) {
        if (object instanceof UserInfoFragment && mFragmentAtPos0 instanceof UserLoginFragment)
            return POSITION_NONE;
        return POSITION_UNCHANGED;
    }
}

