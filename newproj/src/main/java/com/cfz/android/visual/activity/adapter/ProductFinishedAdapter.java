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

//        productViewHolder.productName.setText(products.get(i).productName);
//        productViewHolder.detail.setText(products.get(i).detail);
//        productViewHolder.price.setText(products.get(i).price + "");
//        productViewHolder.totalCnt.setText(products.get(i).currentCnt + "");
//        productViewHolder.currentCnt.setText(products.get(i).totalCnt + "");
        productViewHolder.listener.setPosition(new BundleInfo(
                        products.get(i).productId,
                        products.get(i).infoId,
                        products.get(i).productType)
                );
        view.setOnClickListener(productViewHolder.listener);
        imageLoader.DisplayImage(products.get(i).productImg, productViewHolder.BackNewProduct);
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

        ImageView BackNewProduct;
        TextView productName;
        TextView detail;
        TextView price;
        TextView totalCnt;
        TextView currentCnt;
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
