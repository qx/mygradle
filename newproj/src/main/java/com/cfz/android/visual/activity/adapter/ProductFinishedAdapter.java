package com.cfz.android.visual.activity.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.cfz.android.R;
import com.cfz.android.constant.URLConstant;
import com.cfz.android.entity.network.urlentity.BaseFinishedProductResult;
import com.cfz.android.visual.activity.listener.GlobalConstant;
import com.cfz.android.visual.imageutils.ImageLoader;

import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by ok on 7/23/14.
 */
public class ProductFinishedAdapter extends BaseAdapter implements URLConstant, GlobalConstant {
    private final ImageLoader imageLoader;
    private ArrayList<BaseFinishedProductResult> products;
    private Context mContext;
    private LayoutInflater mInflater = null;
    private HashMap<String, SoftReference<Drawable>> mCachedIcons = null;

    public ProductFinishedAdapter(Context mContext) {
        this.mContext = mContext;
        mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mCachedIcons = new HashMap<String, SoftReference<Drawable>>();
        products = new ArrayList<BaseFinishedProductResult>();
        imageLoader = new ImageLoader(mContext.getApplicationContext());
    }

    /**
     * add data
     *
     * @param list
     */
    public void putData(final ArrayList<? extends BaseFinishedProductResult> list) {

        if (products == null) {
            return;
        }
        if (list == null) {
            return;
        }
        products.addAll(list);
        if (list.size() > 0) {
            notifyDataSetChanged();
        }
    }

    @Override
    public int getCount() {
        return products.size();
    }

    @Override
    public Object getItem(int position) {
        return products.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int i, View view, ViewGroup parent) {
        ProductViewHolder productViewHolder;
        if (view == null) {
            productViewHolder = new ProductViewHolder();
            view = mInflater.inflate(R.layout.item_list_product_finished, null);
            productViewHolder.productImg = (ImageView) view.findViewById(R.id.productImg);
            productViewHolder.userHeadImg = (ImageView) view.findViewById(R.id.userHeadImg);

            productViewHolder.nickName = (TextView) view.findViewById(R.id.nickName);
            productViewHolder.detail = (TextView) view.findViewById(R.id.detail);
            productViewHolder.luckyCode = (TextView) view.findViewById(R.id.luckyCode);
            productViewHolder.publishTime = (TextView) view.findViewById(R.id.publishTime);

            productViewHolder.listener = new AdapterClickListener();
            view.setTag(productViewHolder);
        } else {
            productViewHolder = (ProductViewHolder) view.getTag();
        }

        productViewHolder.nickName.setText(products.get(i).nickName);
//        products.get(i).bettingCnt, products.get(i).price

        String sAgeFormat1 = mContext.getResources().getString(R.string.itme_product_detail);
        String sFinal1 = String.format(sAgeFormat1, products.get(i).bettingCnt, products.get(i).price);
        productViewHolder.detail.setText(sFinal1);//bettingCnt, price

        productViewHolder.luckyCode.setText(String.format(mContext.getResources().getString(R.string.itme_product_luckycode), products.get(i).luckyCode));
        productViewHolder.publishTime.setText(String.format(mContext.getResources().getString(R.string.itme_product_finished_time), products.get(i).publishTime));

        productViewHolder.listener.setPosition(new BundleInfo(
                        products.get(i).productId,
                        products.get(i).infoId,
                        products.get(i).productType)
        );
        view.setOnClickListener(productViewHolder.listener);
        imageLoader.DisplayImage(products.get(i).userHeadImg, productViewHolder.userHeadImg);
        imageLoader.DisplayImage(products.get(i).productImg, productViewHolder.productImg);
        return view;
    }

    private final class AdapterClickListener implements View.OnClickListener {
        private BundleInfo binfo;

        public void setPosition(BundleInfo info) {
            binfo = info;
        }

        @Override
        public void onClick(View v) {
            gotoDetailActivity(binfo);
        }

    }

    private static final class ProductViewHolder {

        ImageView productImg;
        ImageView userHeadImg;
        TextView nickName;
        TextView detail;
        TextView luckyCode;
        TextView publishTime;
        //        TextView totalCnt;
//        TextView currentCnt;
        AdapterClickListener listener;

    }

    private void gotoDetailActivity(BundleInfo binfo) {

    }


    private class BundleInfo {
        private BundleInfo(String productId, String infoId, int typeid) {
            this.productId = productId;
            this.infoId = infoId;
            this.typeid = typeid;
        }

        String productId;
        String infoId;
        int typeid;
    }

}
