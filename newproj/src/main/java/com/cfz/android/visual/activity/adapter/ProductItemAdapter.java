package com.cfz.android.visual.activity.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import cn.trinea.android.common.util.ToastUtils;
import com.cfz.android.R;
import com.cfz.android.constant.URLConstant;
import com.cfz.android.entity.network.resultbean.NewProductResult;
import com.cfz.android.visual.activity.ProductDetailActivity;
import com.cfz.android.visual.imageutils.ImageLoader;

import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2014/5/15.
 */
public class ProductItemAdapter extends BaseAdapter implements URLConstant {
    private final ImageLoader imageLoader;
    private ArrayList<NewProductResult> products;
    private Context mContext;
    private LayoutInflater mInflater = null;
    private HashMap<String, SoftReference<Drawable>> mCachedIcons = null;

    public ProductItemAdapter(Context mContext) {
        this.mContext = mContext;
        mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mCachedIcons = new HashMap<String, SoftReference<Drawable>>();
        products = new ArrayList<NewProductResult>();
        imageLoader = new ImageLoader(mContext.getApplicationContext());

    }

    /**
     * add data
     *
     * @param list
     */
    public void putData(final List<NewProductResult> list) {

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


    public void clear() {
        if (products != null) {
            products.clear();
        }
        if (mCachedIcons == null) {
            return;
        }
        Collection<SoftReference<Drawable>> list = mCachedIcons.values();
        for (SoftReference<Drawable> item : list) {
            Drawable icon = item.get();
            if (icon == null) {
                continue;
            }
            icon.setCallback(null);
        }
        mCachedIcons.clear();
    }

    @Override
    public int getCount() {
        return products.size();
    }

    @Override
    public Object getItem(int i) {
        return products.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ProductViewHolder productViewHolder;
        if (view == null) {
            productViewHolder = new ProductViewHolder();
            view = mInflater.inflate(R.layout.item_list_product, null);
            ImageView BackNewProduct;
            productViewHolder.BackNewProduct = (ImageView) view.findViewById(R.id.imageView);

            productViewHolder.productName = (TextView) view.findViewById(R.id.productName);
            productViewHolder.detail = (TextView) view.findViewById(R.id.detail);
            productViewHolder.price = (TextView) view.findViewById(R.id.price);
            productViewHolder.totalCnt = (TextView) view.findViewById(R.id.totalCnt);
            productViewHolder.currentCnt = (TextView) view.findViewById(R.id.currentCnt);
            productViewHolder.listener = new AdapterClickListener();
            view.setTag(productViewHolder);
        } else {
            productViewHolder = (ProductViewHolder) view.getTag();
        }
        productViewHolder.productName.setText(products.get(i).productName);
        productViewHolder.detail.setText(products.get(i).detail);
        productViewHolder.price.setText(products.get(i).price + "");
        productViewHolder.totalCnt.setText(products.get(i).currentCnt + "");
        productViewHolder.currentCnt.setText(products.get(i).totalCnt + "");
        productViewHolder.listener.setPosition(new BundleInfo(products.get(i).productId, products.get(i).infoId));
        view.setOnClickListener(productViewHolder.listener);
        imageLoader.DisplayImage(products.get(i).productImg, productViewHolder.BackNewProduct);
        return view;
    }


    private static final class ProductViewHolder {

        ImageView BackNewProduct;
        TextView productName;
        TextView detail;
        TextView price;
        TextView totalCnt;
        TextView currentCnt;
        AdapterClickListener listener;

    }

    private final class AdapterClickListener implements View.OnClickListener {
        private BundleInfo binfo;

        public void setPosition(BundleInfo info) {
            binfo = info;
        }

        @Override
        public void onClick(View v) {
//            ToastUtils.show(mContext, info + "", 0);
            gotoDetailActivity(binfo);
        }

    }

    private void gotoDetailActivity(BundleInfo info) {
        Intent mIntent = new Intent(mContext, ProductDetailActivity.class);
//        Bundle mBundle = new Bundle();
//        mBundle.putString(URL_PRODUCT_DETAIL_PID, info.productId);
//        mBundle.putString(URL_PRODUCT_DETAIL_IID, info.infoId);
        mIntent.putExtra(URL_PRODUCT_DETAIL_PID, info.productId);
        mIntent.putExtra(URL_PRODUCT_DETAIL_IID, info.infoId);
//        mContext.startActivity(mIntent, mBundle);
        mContext.startActivity(mIntent);
    }

    private class BundleInfo {
        private BundleInfo(String productId, String infoId) {
            this.productId = productId;
            this.infoId = infoId;
        }

        String productId;
        String infoId;
    }

}

