package com.lenovo.powersetting.visual.activity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import cn.trinea.android.common.util.ToastUtils;
import cn.trinea.android.common.view.DropDownListView;
import com.lenovo.powersetting.R;
import com.lenovo.powersetting.Spokers;
import com.lenovo.powersetting.constant.URLConstant;
import com.lenovo.powersetting.entity.network.urlentity.BackListProductEntity;
import com.lenovo.powersetting.entity.network.resultbean.NewProductBean;
import com.lenovo.powersetting.impl.HttpRequestListener;
import com.lenovo.powersetting.utils.AsyncTaskThreadPoolExecutorHelper;
import com.lenovo.powersetting.utils.LogUtil;
import com.lenovo.powersetting.visual.activity.adapter.ProductItemAdapter;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 主页tab 所有产品界面
 * Created by Administrator on 2014/4/21.
 */
public class NewProductFragment extends BaseFragment {
    private View second;
    private View first;
    private LinkedList<String> listItems = null;
    private DropDownListView listView = null;
    private ProductItemAdapter adapter;
    public static final int MORE_DATA_MAX_COUNT = 3;
    public int moreDataCount = 0;
    private static BackListProductEntity backNewProducts;
    private ArrayList<NewProductBean> alist;
    private static int page = 1;
    /**
     * icon cache *
     */

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

        listItems = new LinkedList<String>();
        adapter = new ProductItemAdapter(getActivity());

        listView.setAdapter(adapter);
        imageUrlList = new ArrayList<String>();
        AsyncTaskThreadPoolExecutorHelper.execute(new GetDataTask(true));
        return mview;
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
//            backNewProducts = performGetNewProduct();
            HashMap<String, String> map = new HashMap<String, String>();
            map.put(PRODUCT_URL_PARAMS_PAGE_, page + "");
            Spokers.getInstance().getHttpDataUseAsync(map, new HttpRequestListener() {
                @Override
                public void onSuccess(Object o) {
                    super.onSuccess(o);
                    backNewProducts = (BackListProductEntity) o;
                    alist = backNewProducts.result;
                    LogUtil.logNewProduct("onSuccess"+alist.toString());
                    adapter.putData(alist);
                    page++;
                }
            }, URLConstant.PRODUCT_URL, BackListProductEntity.class);
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