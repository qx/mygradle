package com.cfz.android.visual.activity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import butterknife.ButterKnife;
import butterknife.InjectView;
import cn.trinea.android.common.util.ToastUtils;
import cn.trinea.android.common.view.DropDownListView;
import com.cfz.android.R;
import com.cfz.android.entity.network.urlentity.BackHistoryEntity;
import com.cfz.android.entity.network.urlentity.BackJinRiEntity;
import com.cfz.android.entity.network.urlentity.BackWaitingEntity;
import com.cfz.android.impl.HttpRequestListener;
import com.cfz.android.utils.LogUtil;
import com.cfz.android.visual.activity.adapter.ProductFinishedAdapter;
import com.cfz.android.visual.activity.adapter.ProductItemAdapter;
import com.cfz.android.visual.activity.listener.GlobalConstant;
import com.cfz.android.visual.imageutils.ImageLoader;
import com.google.api.client.http.UrlEncodedContent;

import java.util.HashMap;

/**
 * 主页tab 获取商品界面
 * Created by Administrator on 2014/4/21.
 */
public class OldProductFragment extends BaseFragment implements GlobalConstant {

    private MainActivity mActivity;
    /**
     * icon cache *
     */
    private ImageLoader imageLoader;
    @InjectView(R.id.list_view)
    DropDownListView list_view;
    private ProductFinishedAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View mview = inflater.inflate(R.layout.fragment_product_get, container, false);
//        list_view.seton
        getData();
        adapter = new ProductFinishedAdapter(getActivity());
        ButterKnife.inject(this, mview);

        list_view.setOnDropDownListener(new DropDownListView.OnDropDownListener() {
            @Override
            public void onDropDown() {
                getData();
            }
        });
        list_view.setOnBottomListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getData();
            }
        });
        list_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ToastUtils.show(getActivity(), R.string.drop_down_tip);
            }
        });
        return mview;
    }

    //今日开奖商品
    boolean URL_LOTTERY_finished = false;
    //4:等待开奖商品(完成)
    boolean URL_WAITING_finished = false;
    //5:历史开奖商品(完成)
    boolean URL_HISTORY_finished = false;

    private void getData() {
        HashMap<String, Object> data = new HashMap<String, Object>();
        data.put(URL_LOTTERY_PN, "1");
        httpContent = new UrlEncodedContent(data);
        testMethod(URL_LOTTERY, BackJinRiEntity.class, httpContent, new HttpRequestListener() {
            @Override
            public void onSuccess(Object o) {
                super.onSuccess(o);
                URL_LOTTERY_finished = true;
                BackJinRiEntity be = (BackJinRiEntity) o;
                LogUtil.i(TAG, o.toString());
                adapter.putData(be.result);
            }
        }, data);

        HashMap<String, Object> data2 = new HashMap<String, Object>();
        data.put(URL_WAITING_PN, "1");
        httpContent = new UrlEncodedContent(data);
        testMethod(URL_WAITING, BackWaitingEntity.class, httpContent, new HttpRequestListener() {
            @Override
            public void onSuccess(Object o) {
                super.onSuccess(o);
                URL_WAITING_finished = true;
                BackWaitingEntity be = (BackWaitingEntity) o;
                LogUtil.i(TAG, o.toString());
                adapter.putData(be.result);
            }
        }, data2);

        HashMap<String, Object> data3 = new HashMap<String, Object>();
        data.put(URL_HISTORY_PN, "1");
        httpContent = new UrlEncodedContent(data);
        testMethod(URL_HISTORY, BackHistoryEntity.class, httpContent, new HttpRequestListener() {
            @Override
            public void onSuccess(Object o) {
                super.onSuccess(o);
                URL_HISTORY_finished = true;
                BackHistoryEntity be = (BackHistoryEntity) o;
                LogUtil.i(TAG, o.toString());
                adapter.putData(be.result);
            }
        }, data3);

    }

}