package com.lenovo.powersetting.visual.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;
import cn.trinea.android.common.util.ToastUtils;
import com.lenovo.powersetting.R;
import com.lenovo.powersetting.Spokers;
import com.lenovo.powersetting.UserData;
import com.lenovo.powersetting.entity.network.BackUserLoginEntity;
import com.lenovo.powersetting.impl.HttpRequestListener;
import com.lenovo.powersetting.utils.LoginUtils;
import com.lenovo.powersetting.visual.activity.listener.FirstPageFragmentListener;
import com.tencent.connect.auth.QQAuth;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;
import com.tencent.tauth.UiError;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;


/**
 * 主页TAG,用户
 * Created by Administrator on 2014/4/21.
 */
public class UserLoginFragment extends BaseFragment implements FirstPageFragmentListener {
    private static final int UPDATE_VIEW = 10000;
    private static final int SHOW_LOADING = 10001;
    private Tencent mTencent;
    private QQAuth mQQAuth;
    public static final String APPID = "101097138";
    public static final String APPKEY = "43f976aea06436196677fe2860789f1e";
    private LinearLayout waitlog;
    private LinearLayout logined;
    private ProgressBar loading;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_user_login, container, false);
        (v.findViewById(R.id.login)).setOnClickListener(this);
        (v.findViewById(R.id.loginqq)).setOnClickListener(this);
        waitlog = (LinearLayout) v.findViewById(R.id.waitlog);
        logined = (LinearLayout) v.findViewById(R.id.logined);
        loading = (ProgressBar) v.findViewById(R.id.loading);


        return v;
    }

//    @Override
//    public void onStart() {
//        super.onStart();
//        initview();
//    }


    @Override
    public void onResume() {
        super.onResume();
        System.out.println("****************************onResume");
        initview();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    public static UserLoginFragment newInstance(FirstPageFragmentListener firstPageFragmentListener) {
        UserLoginFragment f = new UserLoginFragment();
        return f;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.login:

                break;
            case R.id.loginqq:
                loginqq();

            default:
                break;

        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mTencent = Tencent.createInstance(APPID, getActivity().getApplicationContext());
        mQQAuth = QQAuth.createInstance(APPID, getActivity().getApplicationContext());
    }

    private void loginqq() {

        onClickLogin();
    }

    @Override
    public void onSwitchToNextFragment() {

    }

    private void onClickLogin() {
        if (!mQQAuth.isSessionValid()) {
            IUiListener listener = new BaseUiListener() {
                @Override
                protected void doComplete(final JSONObject values) {
                    HashMap<String, String> params = new HashMap<String, String>();
                    try {
                        params.put(LOGIN_URL_PARAMS_ID_, values.getString("openid"));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    params.put(LOGIN_URL_PARAMS_PHONE_, "1");
                    params.put(LOGIN_URL_PARAMS_PHONEID_, LoginUtils.getImei(getActivity()));

                    Spokers.getInstance().getHttpDataUseAsync(params, new HttpRequestListener() {
                        @Override
                        public void onDoing() {
                            super.onDoing();
                        }

                        @Override
                        public void onSuccess(Object o) {
                            super.onSuccess(o);
                            UserData.getInstance().isLogin = true;//数据变量发生变化自动刷新数据，本地广播，或实现观察者模式
                            mHandler.sendEmptyMessage(UPDATE_VIEW);
                        }

                        @Override
                        public void onFail() {
                            super.onFail();
                            UserData.getInstance().isLogin = false;
                        }

                        @Override
                        public void onPre() {
                            super.onPre();
                            mHandler.sendEmptyMessage(SHOW_LOADING);
                        }
                    }, LOGIN_URL, BackUserLoginEntity.class);


//                    getHttpDataUseListener(params, new HttpRequestListener() {
//                        @Override
//                        public void onPre() {
//                            mHandler.sendEmptyMessage(SHOW_LOADING);
//                            super.onPre();
//                        }
//
//                        @Override
//                        public void onDoing() {
//                            super.onDoing();
//                        }
//
//                        @Override
//                        public void onGetStatus(boolean equals) {
//                            super.onGetStatus(equals);
//                            if (equals) {
//                                System.out.println("success");
//                                UserData.getInstance().isLogin = true;//数据变量发生变化自动刷新数据，本地广播，或实现观察者模式
//                                mHandler.sendEmptyMessage(UPDATE_VIEW);
//                            } else {
//                                System.out.println("fail");
//                                UserData.getInstance().isLogin = false;
//                            }
//                        }
//                    }, LOGIN_URL, BackUserLoginEntity.class);
                }
            };
            mTencent.loginWithOEM(getActivity(), "all", listener, "10000144", "10000144", "xxxx");
        } else {
            mQQAuth.logout(getActivity());
        }
    }

    private Handler mHandler = new Handler() {
        @Override
        public void dispatchMessage(Message msg) {

            switch (msg.what) {
                case UPDATE_VIEW:
                    System.out.println("***********************getupdate message");
                    initview();
                    break;
                case SHOW_LOADING:
                    showloading();
                    break;
            }
        }
    };

    private void showloading() {
        loading.setVisibility(View.VISIBLE);
        waitlog.setVisibility(View.GONE);
    }

    private void initview() {
        loading.setVisibility(View.GONE);
        if (UserData.getInstance().isLogin) {
            waitlog.setVisibility(View.GONE);
            logined.setVisibility(View.VISIBLE);
        } else {
            logined.setVisibility(View.GONE);
            waitlog.setVisibility(View.VISIBLE);
        }
    }


    private class BaseUiListener implements IUiListener {

        protected void doComplete(final JSONObject response) {
            ToastUtils.show(getActivity(), "login success", 0);
            doComplete(response);
        }

        @Override
        public void onComplete(final Object o) {
            doComplete((JSONObject) o);
        }

        @Override

        public void onError(UiError e) {

            showResult("onError:", "code:" + e.errorCode + ", msg:"

                    + e.errorMessage + ", detail:" + e.errorDetail);

        }

        @Override

        public void onCancel() {

            showResult("onCancel", "");

        }

    }

    private void showResult(String s, String s1) {
        Toast.makeText(getActivity(), s + "||" + s1, 0).show();
    }

}