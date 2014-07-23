package com.cfz.android.visual.activity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import butterknife.ButterKnife;
import butterknife.InjectView;
import cn.trinea.android.common.util.ToastUtils;
import cn.trinea.android.common.view.DropDownListView;
import com.cfz.android.R;
import com.cfz.android.entity.network.resultbean.NewProductResult;
import com.cfz.android.entity.network.urlentity.BackAdvListEntity;
import com.cfz.android.entity.network.urlentity.BackListProductEntity;
import com.cfz.android.impl.HttpRequestListener;
import com.cfz.android.utils.AsyncTaskThreadPoolExecutorHelper;
import com.cfz.android.utils.LogUtil;
import com.cfz.android.visual.activity.adapter.ProductItemAdapter;
import com.cfz.android.visual.imageutils.ImageLoader;
import com.google.api.client.http.HttpContent;
import com.google.api.client.http.UrlEncodedContent;

import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 主页tab 所有产品界面
 * Created by Administrator on 2014/4/21.
 */
public class NewProductFragment extends BaseFragment {
    private LinkedList<String> listItems = null;
    private DropDownListView listView = null;
    private ProductItemAdapter adapter;
    public static final int MORE_DATA_MAX_COUNT = 3;
    public int moreDataCount = 0;
    private static BackListProductEntity backNewProducts;
    private ArrayList<NewProductResult> alist;
    private static int page = 1;
    @InjectView(R.id.ads)
    ImageView ads;

    /**
     * icon cache *
     */
    private ImageLoader imageLoader;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View mview = inflater.inflate(R.layout.fragment_product_all, container, false);
        listView = (DropDownListView) mview.findViewById(R.id.list_view);
        listView.setOnDropDownListener(new DropDownListView.OnDropDownListener() {

            @Override
            public void onDropDown() {
                new GetDataTask(true).execute();
            }
        });
        // set on bottom listener
        listView.setOnBottomListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                new GetDataTask(false).execute();
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ToastUtils.show(getActivity(), R.string.drop_down_tip);
            }
        });

        listItems = new LinkedList<String>();

        adapter = new ProductItemAdapter(getActivity());
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
        imageUrlList = new ArrayList<String>();
        AsyncTaskThreadPoolExecutorHelper.execute(new GetDataTask(true));
        ButterKnife.inject(this, mview);
        imageLoader = new ImageLoader(getActivity().getApplicationContext());


        postAds();


        return mview;
    }

    private void postAds() {
        httpContent = new HttpContent() {
            @Override
            public long getLength() throws IOException {
                return 0;
            }

            @Override
            public String getEncoding() {
                return null;
            }

            @Override
            public String getType() {
                return null;
            }

            @Override
            public void writeTo(OutputStream outputStream) throws IOException {

            }

            @Override
            public boolean retrySupported() {
                return false;
            }
        };
        HashMap<String, Object> data = new HashMap<String, Object>();

        data.put(URL_ADS_PN, "1");
        httpContent = new UrlEncodedContent(data);
        testMethod(URL_ADS, BackAdvListEntity.class, httpContent, new HttpRequestListener() {
            @Override
            public void onSuccess(Object o) {
                super.onSuccess(o);
                imageLoader.DisplayImage(((BackAdvListEntity) o).result.get(0).advImg, ads);

            }
        }, data);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }

    @Override
    public void onPause() {
        super.onPause();
        page = 1;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    private List<String> imageUrlList;


    private class GetDataTask extends AsyncTask<Void, Void, Boolean> {

        private boolean isDropDown;

        public GetDataTask(boolean isDropDown) {
            this.isDropDown = isDropDown;

        }

        @Override
        protected Boolean doInBackground(Void... params) {

            HashMap<String, Object> data = new HashMap<String, Object>();
            data.put(URL_PRODUCTING_PN, page + "");
            httpContent = new UrlEncodedContent(data);
            testMethod(URL_PRODUCTING, BackListProductEntity.class, httpContent, new HttpRequestListener() {
                @Override
                public void onSuccess(Object o) {
                    super.onSuccess(o);
                    backNewProducts = (BackListProductEntity) o;
                    alist = backNewProducts.result;
                    LogUtil.logNewProduct("onSuccess" + alist.toString());
                    adapter.putData(alist);
                    page++;
                }
            }, data);
            return true;
        }

        @Override
        protected void onPostExecute(Boolean result) {

            if (isDropDown) {
                listItems.addFirst("Added after drop down");
                adapter.notifyDataSetChanged();
                // should call onDropDownComplete function of DropDownListView at end of drop down complete.
                SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd HH:mm:ss");
                listView.onDropDownComplete(getString(R.string.update_at) + dateFormat.format(new Date()));
            } else {
                moreDataCount++;
                listItems.add("Added after on bottom");
                adapter.notifyDataSetChanged();
                if (moreDataCount >= MORE_DATA_MAX_COUNT) {
                    listView.setHasMore(false);
                }
                // should call onBottomComplete function of DropDownListView at end of on bottom complete.
                listView.onBottomComplete();
            }
            if (backNewProducts == null) {
                LogUtil.logNewProduct("onPostExecute return null");
                return;
            }
            alist = backNewProducts.result;
            LogUtil.logNewProduct(alist.toString());
            adapter.putData(alist);
            page++;
            super.onPostExecute(result);
        }
    }


}