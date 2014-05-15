package com.cfz.android.visual.activity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import cn.trinea.android.common.util.ToastUtils;
import cn.trinea.android.common.view.DropDownListView;
import com.cfz.android.R;
import com.cfz.android.mode.object.NewProduct;
import com.cfz.android.mode.object.network.BackListProduct;
import com.cfz.android.mode.object.network.BackNewProduct;
import com.cfz.android.visual.activity.adapter.ProductItemAdapter;
import com.cfz.android.visual.activity.constant.URLConstant;
import com.google.api.client.http.*;
import com.google.api.client.http.apache.ApacheHttpTransport;
import com.google.api.client.http.json.JsonHttpParser;
import com.google.api.client.json.jackson.JacksonFactory;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;

/**
 * 主页tab 所有产品界面
 * Created by Administrator on 2014/4/21.
 */
public class NewProductFragment extends BaseFragment {
    private View second;
    private View first;
    private MainActivity mActivity;
    private LinkedList<String> listItems = null;
    private DropDownListView listView = null;
    //    private ArrayAdapter<String> adapter;
    private ProductItemAdapter adapter;
//    private static BackListProduct backNewProducts;


    //    private String[] mStrings = {"Aaaaaa", "Bbbbbb", "Cccccc", "Dddddd", "Eeeeee", "Ffffff",
//            "Gggggg", "Hhhhhh", "Iiiiii", "Jjjjjj", "Kkkkkk", "Llllll", "Mmmmmm", "Nnnnnn",};
    public static final int MORE_DATA_MAX_COUNT = 3;
    public int moreDataCount = 0;
    private static BackListProduct backNewProducts;
    private ArrayList<BackNewProduct> alist;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View mview = inflater.inflate(R.layout.fragment_product_all, container, false);
        first = mview.findViewById(R.id.first);
        first.setOnClickListener(this);
        second = mview.findViewById(R.id.second);
        second.setOnClickListener(this);
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
        // listView.setShowFooterWhenNoMore(true);

        listItems = new LinkedList<String>();
//        listItems.addAll(Arrays.asList(mStrings));
//        adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, listItems);
        adapter = new ProductItemAdapter(getActivity());

        listView.setAdapter(adapter);

        return mview;
    }


    private class GetDataTask extends AsyncTask<Void, Void, Boolean> {

        private boolean isDropDown;

        public GetDataTask(boolean isDropDown) {
            this.isDropDown = isDropDown;
        }

        @Override
        protected Boolean doInBackground(Void... params) {
            //                Thread.sleep(1000);
            backNewProducts = performGetNewProduct();
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
            alist = backNewProducts.result;
            adapter.putData(alist);
            super.onPostExecute(result);
        }
    }

    public static BackListProduct performGetNewProduct() {
        try {
            HttpTransport transport = new ApacheHttpTransport();
            GenericUrl reqUrl = new GenericUrl(URLConstant.PRODUCT_URL);
            reqUrl.put(PRODUCT_URL_PARAMS_PAGE_, "1");
            HttpRequestFactory httpRequestFactory = transport.createRequestFactory(new HttpRequestInitializer() {
                public void initialize(HttpRequest request) {
                    JsonHttpParser parser = new JsonHttpParser(new JacksonFactory());
                    request.addParser(parser);
                }
            });
            HttpRequest request = httpRequestFactory.buildGetRequest(reqUrl);
            String str = request.execute().parseAsString();
            System.out.println(str);
            backNewProducts = request.execute().parseAs(BackListProduct.class);
            return backNewProducts;

        } catch (HttpResponseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    // ((MainActivity)mAppFragmentTabActivity).updateActivityData(mActivity.mModeInfo);
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.first:
                startActivity(new Intent(getActivity(), ProductDetailActivity.class));
                break;

            case R.id.second:
                startActivity(new Intent(getActivity(), ProductDetailActivity.class));
                break;
            default:
                break;
        }
    }

}