package com.lenovo.powersetting;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v4.content.LocalBroadcastManager;
import com.lenovo.powersetting.impl.HttpRequestListener;
import com.lenovo.powersetting.utils.AsyncTaskThreadPoolExecutorHelper;

/**
 * Only on/off function controller should be defined here
 * <p/>
 * You should comment on the method first.
 */
public class Spokers {

    private LocalBroadcastManager manager;
    private static Context mContext;
    private static Spokers spokers;

    private Spokers(Context mContext) {
        this.mContext = mContext;
        manager = LocalBroadcastManager.getInstance(mContext);
    }

    public static Spokers getInstance() {
        if (spokers == null) {
            return new Spokers(mContext);
        }
        return spokers;
    }

    public void getUserData(String url, final HttpRequestListener httpListener) {

        AsyncTaskThreadPoolExecutorHelper.execute(new AsyncTask<Object, Object, Object>() {
            @Override
            protected void onPreExecute() {
                httpListener.onPre();
                super.onPreExecute();
            }

            @Override
            protected Object doInBackground(Object... objects) {
                httpListener.onDoing();
                return null;
            }

            @Override
            protected void onPostExecute(Object o) {
                httpListener.onPost();
                super.onPostExecute(o);
            }
        });

    }


}
