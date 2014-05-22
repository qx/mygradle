package com.cfz.android.visual.activity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.cfz.android.R;
import com.cfz.android.mode.object.network.BackUserLogin;
import com.cfz.android.visual.activity.constant.URLConstant;
import com.cfz.android.visual.activity.listener.FirstPageFragmentListener;
import com.google.api.client.http.*;
import com.google.api.client.http.apache.ApacheHttpTransport;
import com.google.api.client.http.json.JsonHttpParser;
import com.google.api.client.json.jackson.JacksonFactory;

import java.io.IOException;

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

//                1:qqId
//                2:phoneType = 1
//                phoneType = 2
//                3:phoneId

                try {
                    login();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                break;
            default:
                break;

        }
    }

    @Override
    public void onSwitchToNextFragment() {

    }


    public static BackUserLogin login() throws Exception {
        try {
            HttpTransport transport = new ApacheHttpTransport();
//            GenericUrl reqUrl = new GenericUrl(PLACES_SEARCH_URL + GET_PRODUCT);
            GenericUrl reqUrl = new GenericUrl(URLConstant.LOGIN_URL);
            reqUrl.put(LOGIN_URL_PARAMS_ID_, "SADF说eQWE9984654ADF");
            reqUrl.put(LOGIN_URL_PARAMS_PHONE_, "1");
            reqUrl.put(LOGIN_URL_PARAMS_PHONEID_, "6545641251321232");
//            reqUrl.put("pageNum", 1);
            HttpRequestFactory httpRequestFactory = createRequestFactory(transport);
            HttpRequest request = httpRequestFactory.buildGetRequest(reqUrl);
            System.out.println("url="+reqUrl);
            String str = request.execute().parseAsString();
            BackUserLogin backUserLogin = request.execute().parseAs(BackUserLogin.class);

//            for (Product place : places.result) {
//                System.out.println("oyqx:name=" + place.productName);
//
//            }
            if (backUserLogin != null) {
                System.out.println(backUserLogin);
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
}