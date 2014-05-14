package com.cfz.android.visual.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.cfz.android.R;
import com.cfz.android.utils.LogUtil;
import com.cfz.android.visual.activity.constant.BaseClass;
import com.cfz.android.visual.activity.constant.HandlerConstant;
import com.cfz.android.visual.activity.constant.URLConstant;
import com.cfz.android.visual.activity.listener.RefreshListener;

/**
 * Created by Administrator on 2014/5/9.
 */
public class BaseFragment extends Fragment implements View.OnClickListener, HandlerConstant, BaseClass,URLConstant {
    protected int layoutId;
    protected FragmentActivity mAppFragmentTabActivity;
    protected View curView;
//    public static SecondPageFragment newInstance() {
//        SecondPageFragment f = new SecondPageFragment();
//        return f;
//    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mAppFragmentTabActivity = (FragmentActivity) activity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (layoutId == 0) {
            LogUtil.excep(Log_NAME_FIRST, "you must set layoutId in your fragment first");
        }
        curView = inflater.inflate(layoutId, container, false);
        return curView;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        mRefreshListener = new RefreshListener() {

        };
        mHandler = new RefreshHandler();
    }

    @Override
    public void onClick(View view) {

    }

    protected Handler mHandler = new RefreshHandler();

    protected RefreshListener mRefreshListener;

    private class RefreshHandler extends Handler {
        @Override
        public void dispatchMessage(Message message) {
            switch (message.what) {
                case Msg_first:

                    break;
                case Msg_second:

                    break;
                case Msg_third:
                    break;

                default:
                    break;
            }
        }
    }

    protected void startIntent(Class<? extends Activity> target) {
        startActivity(new Intent(getActivity(), target));
    }



}
