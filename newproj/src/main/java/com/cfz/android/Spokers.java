package com.cfz.android;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v4.content.LocalBroadcastManager;
import com.google.api.client.http.*;
import com.google.api.client.http.apache.ApacheHttpTransport;
import com.google.api.client.http.json.JsonHttpParser;
import com.google.api.client.json.jackson.JacksonFactory;
import com.cfz.android.entity.network.urlentity.BaseEntity;
import com.cfz.android.impl.HttpRequestListener;
import com.cfz.android.utils.AsyncTaskThreadPoolExecutorHelper;
import com.cfz.android.utils.LogUtil;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Only on/off function controller should be defined here
 * <p/>
 * You should comment on the method first.
 */
public class Spokers {

    private LocalBroadcastManager manager;
    private Context mContext;
    private static Spokers spokers;

    private Spokers(Context mContext) {
        if (mContext != null) {
            this.mContext = mContext;
            manager = LocalBroadcastManager.getInstance(mContext);
        }
    }

    public static Spokers getInstance() {
        if (spokers == null) {
            return new Spokers(MyApplication.getInstance());
        }
        return spokers;
    }

    public void getHttpDataUseAsync(final HashMap<String, String> key_value, final HttpRequestListener httpListener, final String url, final Class<? extends BaseEntity> baseClass) {

        AsyncTaskThreadPoolExecutorHelper.execute(new AsyncTask<Object, Object, Object>() {
            @Override
            protected void onPreExecute() {
                httpListener.onPre();
                super.onPreExecute();
            }

            @Override
            protected Object doInBackground(Object... objects) {
                httpListener.onDoing();
                return sendRequest(key_value, url, baseClass);
            }

            @Override
            protected void onPostExecute(Object o) {
                if (o == null) {
                    LogUtil.logNet("REQUEST GET NOTHING");
                    return;
                }
                if (((BaseEntity) o).status.equals("success")) {
                    httpListener.onSuccess(o);
                    LogUtil.logNet("SUCCESS");
                } else {
                    httpListener.onFail();
                    LogUtil.logNet("FAILS");
                }
                httpListener.onPost();
                super.onPostExecute(o);
            }
        });

    }

    /**
     * @param key_value method key-value
     * @param url
     * @return
     */
    private static BaseEntity sendRequest(HashMap<String, String> key_value,
                                          String url, Class<? extends BaseEntity> baseClass) {
        Iterator iterator = key_value.entrySet().iterator();
        GenericUrl reqUrl = new GenericUrl(url);
        try {
            while (iterator.hasNext()) {
                Map.Entry entry = (Map.Entry) iterator.next();
                String mkey = (String) entry.getKey();
                String mValue = (String) entry.getValue();
                reqUrl.put(mkey, mValue);
            }
            HttpTransport transport = new ApacheHttpTransport();
            HttpRequestFactory httpRequestFactory = createRequestFactory(transport);
            HttpRequest request = httpRequestFactory.buildGetRequest(reqUrl);
            LogUtil.logNet(reqUrl.build());

            BaseEntity bs= request.execute().parseAs((baseClass));

            LogUtil.logNet(bs.toString());
            return bs;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static HttpRequestFactory createRequestFactory(final HttpTransport transport) {

        return transport.createRequestFactory(new HttpRequestInitializer() {
            public void initialize(HttpRequest request) {
                JsonHttpParser parser = new JsonHttpParser(new JacksonFactory());
                request.addParser(parser);

            }
        });
    }

    /**
     * @param key_value method key-value
     * @param url
     * @return
     */
    public BaseEntity getHttpDataUseListener(HashMap<String, String> key_value,
                                             HttpRequestListener mHttpRequestListener,
                                             String url, Class<? extends BaseEntity> baseClass) {
        mHttpRequestListener.onPre();
        Iterator iterator = key_value.entrySet().iterator();
        GenericUrl reqUrl = new GenericUrl(url);
        try {
            while (iterator.hasNext()) {
                Map.Entry entry = (Map.Entry) iterator.next();
                String mkey = (String) entry.getKey();
                String mValue = (String) entry.getValue();
                reqUrl.put(mkey, mValue);
            }
            HttpTransport transport = new ApacheHttpTransport();
            HttpRequestFactory httpRequestFactory = createRequestFactory(transport);
            HttpRequest request = httpRequestFactory.buildGetRequest(reqUrl);
//            String str = request.execute().parseAsString();
            System.out.println("-----------------------------------");
            System.out.println(url);

            BaseEntity x2 = request.execute().parseAs((baseClass));
            System.out.println("******************X2************" + x2);
            if (x2.status != null) {
                mHttpRequestListener.onGetStatus(x2.status.equals("success"));
            }
            return x2;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
