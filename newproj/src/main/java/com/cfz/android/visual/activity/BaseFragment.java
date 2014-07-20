package com.cfz.android.visual.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.cfz.android.Spokers;
import com.cfz.android.constant.HandlerConstant;
import com.cfz.android.constant.URLConstant;
import com.cfz.android.entity.network.urlentity.BaseEntity;
import com.cfz.android.impl.BaseNetListener;
import com.cfz.android.impl.HttpRequestListener;
import com.cfz.android.utils.LogUtil;
import com.cfz.android.visual.activity.listener.RefreshListener;
import com.google.api.client.http.HttpContent;

import java.util.HashMap;


public class BaseFragment extends Fragment implements View.OnClickListener, HandlerConstant, URLConstant, BaseNetListener {
    protected int layoutId;
    protected FragmentActivity mAppFragmentTabActivity;
    protected View curView;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mAppFragmentTabActivity = (FragmentActivity) activity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (layoutId == 0) {
            LogUtil.excep("TITLE", "you must set layoutId in your fragment first");
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

    protected HttpContent httpContent;


    /**
     * 接口测试
     *
     * @param Url        完整URL地址
     * @param backentity 返回封装类
     * @param content    内容
     */
    @Override
    public void testMethod(String Url, Class<? extends BaseEntity> backentity, HttpContent content, HttpRequestListener httpRequestListener, final HashMap<String, Object> data) {
        LogUtil.logNet("params:" + data.toString());
        Spokers.getInstance().postHttpDataUseAsync(content, httpRequestListener, Url, backentity);
    }
}
