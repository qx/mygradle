package com.cfz.android.visual.activity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;
import cn.trinea.android.common.util.ToastUtils;
import com.cfz.android.R;
import com.cfz.android.UserData;
import com.cfz.android.imple.RequestListener;
import com.cfz.android.mode.object.network.BackUserLogin;
import com.cfz.android.utils.LoginUtils;
import com.cfz.android.visual.activity.constant.URLConstant;
import com.cfz.android.visual.activity.listener.FirstPageFragmentListener;
import com.google.api.client.http.*;
import com.google.api.client.http.apache.ApacheHttpTransport;
import com.google.api.client.http.json.JsonHttpParser;
import com.google.api.client.json.jackson.JacksonFactory;
import com.tencent.connect.auth.QQAuth;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;
import com.tencent.tauth.UiError;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

/**
 * 主页TAG,用户
 * Created by Administrator on 2014/4/21.
 */
public class UserLoginFragment extends BaseFragment implements FirstPageFragmentListener {
    private static final int UPDATE_VIEW = 10000;
    private Tencent mTencent;
    private QQAuth mQQAuth;
    public static final String APPID = "101097138";
    public static final String APPKEY = "43f976aea06436196677fe2860789f1e";
    private LinearLayout waitlog;
    private LinearLayout logined;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_user_login, container, false);
        (v.findViewById(R.id.login)).setOnClickListener(this);
        (v.findViewById(R.id.loginqq)).setOnClickListener(this);
        waitlog = (LinearLayout) v.findViewById(R.id.waitlog);
        logined = (LinearLayout) v.findViewById(R.id.logined);


        return v;
    }

    @Override
    public void onStart() {
        super.onStart();
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
//                Fragment productDetailFragment = UserInfoFragment.newInstance();
//                FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
//                transaction.addToBackStack(null);
//                transaction.replace(R.id.pager, productDetailFragment).commit();

//                1:qqId
//                2:phoneType = 1
//                phoneType = 2
//                3:phoneId

                try {
                    login("098789070897089", LoginUtils.getPhoneType(), LoginUtils.getImei(getActivity()), new RequestListener() {
                        @Override
                        public void requestCompleted(boolean isSuccess) {

                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }

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
//        ThreadUtils.excu(new Runnable() {
//            @Override
//            public void run() {
//                onClickLogin();
//
//            }
//        });

                onClickLogin();
    }

    @Override
    public void onSwitchToNextFragment() {

    }

    /**
     * @param openid    get from qq
     * @param phonetype
     * @param imei      imei
     * @return
     * @throws Exception
     */
    public static BackUserLogin login(String openid, String phonetype, String imei, RequestListener requestListener) throws Exception {
        try {
            HttpTransport transport = new ApacheHttpTransport();
//            GenericUrl reqUrl = new GenericUrl(PLACES_SEARCH_URL + GET_PRODUCT);
            GenericUrl reqUrl = new GenericUrl(URLConstant.LOGIN_URL);
            reqUrl.put(LOGIN_URL_PARAMS_ID_, openid);
            reqUrl.put(LOGIN_URL_PARAMS_PHONE_, phonetype);
            reqUrl.put(LOGIN_URL_PARAMS_PHONEID_, imei);
//            reqUrl.put("pageNum", 1);
            HttpRequestFactory httpRequestFactory = createRequestFactory(transport);
            HttpRequest request = httpRequestFactory.buildGetRequest(reqUrl);
            System.out.println("************url=" + reqUrl);
            String str = request.execute().parseAsString();
            BackUserLogin backUserLogin = request.execute().parseAs(BackUserLogin.class);
            System.out.println("************back data=" + backUserLogin.toString());
//            for (Product place : places.result) {
//                System.out.println("oyqx:name=" + place.productName);
//
//            }
            if (backUserLogin != null) {
                System.out.println(backUserLogin);
                requestListener.requestCompleted(backUserLogin.status.equals(URLConstant.success));
//                requestListener(backUserLogin.getString(URLConstant.status));
            }
            return backUserLogin;

        } catch (HttpResponseException e) {
            throw e;
        } catch (IOException e) {
            throw e;
        }
    }


    public static HttpRequestFactory createRequestFactory(final HttpTransport transport) {

        return transport.createRequestFactory(new HttpRequestInitializer() {
            public void initialize(HttpRequest request) {
//                GoogleHeaders headers = new GoogleHeaders();
//                headers.setApplicationName("Google-Places-DemoApp");
//                request.setHeaders(headers);
                JsonHttpParser parser = new JsonHttpParser(new JacksonFactory());
                System.out.println("oyqx:content type=" + parser.getContentType());
                //JsonHttpParser.builder(new JacksonFactory());
                //parser.jsonFactory = new JacksonFactory();
                request.addParser(parser);

            }
        });
    }

    private void onClickLogin() {
        if (!mQQAuth.isSessionValid()) {
            IUiListener listener = new BaseUiListener() {
                @Override
                protected void doComplete(final JSONObject values) {
//                    updateUserInfo();
//                    updateLoginButton();
                    System.out.println("************complete" + values);
                    try {
                        System.out.println("************complete openid" + values.getString("openid"));
                        new AsyncTask<String, String, String>() {
                            @Override
                            protected String doInBackground(String... strings) {
                                try {
                                    login(values.getString("openid"), LoginUtils.getPhoneType(), LoginUtils.getImei(getActivity()), new RequestListener() {
                                        @Override
                                        public void requestCompleted(boolean isSuccess) {
                                            if (isSuccess) {
                                                UserData.getInstance().isLogin = true;
                                            } else {
                                                UserData.getInstance().isLogin = false;
                                            }
                                            mHandler.sendEmptyMessage(UPDATE_VIEW);

                                        }
                                    });
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                return null;
                            }

                        }.execute();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            };
            //mQQAuth.login(this, "all", listener);
            mTencent.loginWithOEM(getActivity(), "all", listener, "10000144", "10000144", "xxxx");
        } else {
            mQQAuth.logout(getActivity());
//            updateUserInfo();
//            updateLoginButton();
        }
    }

    private Handler mHandler = new Handler() {
        @Override
        public void dispatchMessage(Message msg) {
//            super.dispatchMessage(msg);
            if (msg.what == UPDATE_VIEW) {
                initview();
            }
        }
    };

    private void initview() {
        if (UserData.getInstance().isLogin) {
            waitlog.setVisibility(View.GONE);
            logined.setVisibility(View.VISIBLE);
        } else {
            logined.setVisibility(View.GONE);
            waitlog.setVisibility(View.VISIBLE);
        }
    }


    private class BaseUiListener implements IUiListener {

        protected void doComplete(JSONObject response) {
            ToastUtils.show(getActivity(), "login success", 0);

            doComplete(response);
        }

        @Override
        public void onComplete(Object o) {
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