package com.cfz.android.visual.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import cn.trinea.android.common.util.ToastUtils;
import com.cfz.android.R;
import com.cfz.android.Spokers;
import com.cfz.android.UserData;
import com.cfz.android.entity.network.resultbean.UserLoginBean;
import com.cfz.android.entity.network.urlentity.BackUserLoadEntity;
import com.cfz.android.entity.network.urlentity.BaseEntity;
import com.cfz.android.impl.HttpRequestListener;
import com.cfz.android.utils.LoginUtils;
import com.cfz.android.visual.activity.listener.FirstPageFragmentListener;
import com.cfz.android.visual.imageutils.ImageLoader;
import com.google.api.client.http.UrlEncodedContent;
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
    private RelativeLayout my_history;
    private RelativeLayout my_product;
    private RelativeLayout my_account;
    private RelativeLayout my_address;
    private RelativeLayout my_msg;
    private ImageView img_user;
    private TextView nickname;
    private ImageLoader imageLoader;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_user_login, container, false);
        (v.findViewById(R.id.loginqq)).setOnClickListener(this);
        waitlog = (LinearLayout) v.findViewById(R.id.waitlog);
        logined = (LinearLayout) v.findViewById(R.id.logined);
        loading = (ProgressBar) v.findViewById(R.id.loading);
        my_history = (RelativeLayout) v.findViewById(R.id.my_history);
        my_product = (RelativeLayout) v.findViewById(R.id.my_product);
        my_account = (RelativeLayout) v.findViewById(R.id.my_account);
        my_address = (RelativeLayout) v.findViewById(R.id.my_address);
        my_msg = (RelativeLayout) v.findViewById(R.id.my_msg);
        my_history.setOnClickListener(this);
        my_product.setOnClickListener(this);
        my_account.setOnClickListener(this);
        my_address.setOnClickListener(this);
        my_msg.setOnClickListener(this);
        img_user = (ImageView) v.findViewById(R.id.img_user);
        nickname = (TextView) v.findViewById(R.id.nickname);
        img_user.setOnClickListener(this);
        return v;
    }


    @Override
    public void onResume() {
        super.onResume();
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
            case R.id.loginqq:
                loginqq();
//                simulateUtilslogin();
                break;
            case R.id.my_history:
                startActivity(new Intent(getActivity(), MyHistoryActivity.class));
                break;
            case R.id.my_product:
                startActivity(new Intent(getActivity(), MyGetProductActivity.class));
                break;
            case R.id.my_account:
                startActivity(new Intent(getActivity(), MyAccountActivity.class));
                break;
            case R.id.my_address:
                startActivity(new Intent(getActivity(), MyAddressActivity.class));
                break;
            case R.id.my_msg:
                startActivity(new Intent(getActivity(), MyMessageActivity.class));
                break;

            case R.id.img_user:
                startActivity(new Intent(getActivity(), UserIconEditActivity.class));
                break;

            default:
                break;

        }
    }

    private void simulateUtilslogin() {
//        bean=com.cfz.android.entity.network.resultbean.UserLoginBean@41f48cf0[
//                headImg=http://114.215.177.210:8080/imgserver/headImg/DefaultHeadImg.png
//        integral=10
//        money=0.0
//        nickName=凑分高手
//        userId=f2573152462998cc01463899fce70002
//        ]
//        result=[]
//        info=
//                status=success
//        ]
        UserData ud = UserData.getInstance();
        ud.isLogin = true;//数据变量发生变化自动刷新数据，本地广播，或实现观察者模式
        ud.setUserImage("http://114.215.177.210:8080/imgserver/headImg/DefaultHeadImg.png");
        ud.setUserintegral(10);
        ud.setUserMoney(0.0f);
        ud.setUserNickName("测试高手");
        ud.setUserUserId("f2573152462998cc01463899fce70002");
        mHandler.sendEmptyMessage(SHOW_LOADING);
        mHandler.sendEmptyMessage(UPDATE_VIEW);
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


                    HashMap<String, Object> data = new HashMap<String, Object>();
                    try {
                        data.put(URL_LOADING_QQID, values.getString("openid"));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    data.put(URL_LOADING_PT, "1");
                    data.put(URL_LOADING_PSN, LoginUtils.getImei(getActivity()));
                    httpContent = new UrlEncodedContent(data);
                    testMethod(URL_UPDATE, BaseEntity.class, httpContent, new HttpRequestListener() {
                        @Override
                        public void onSuccess(Object o) {
                            super.onSuccess(o);
                            BackUserLoadEntity mBackUserLoadEntity = (BackUserLoadEntity) o;
                            UserLoginBean userLoginBeans = (UserLoginBean) mBackUserLoadEntity.bean;
                            UserData ud = UserData.getInstance();
                            ud.isLogin = true;//数据变量发生变化自动刷新数据，本地广播，或实现观察者模式
                            ud.setUserImage(userLoginBeans.headImg);
                            ud.setUserintegral(userLoginBeans.integral);
                            ud.setUserMoney(userLoginBeans.money);
                            ud.setUserNickName(userLoginBeans.nickName);
                            ud.setUserUserId(userLoginBeans.userId);

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
                    }, data);

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

        initUserInfo();
    }

    private void initUserInfo() {
//        img_user
        imageLoader = new ImageLoader(getActivity().getApplicationContext());
        imageLoader.DisplayImage(UserData.getInstance().getUserImage(), img_user);
        nickname.setText(UserData.getInstance().getUserNickName());
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
        Toast.makeText(getActivity(), s + "||" + s1, Toast.LENGTH_SHORT).show();
    }

}