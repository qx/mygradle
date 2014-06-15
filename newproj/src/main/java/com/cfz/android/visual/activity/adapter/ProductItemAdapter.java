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
import com.cfz.android.entity.network.resultbean.NewProductResult;
import com.cfz.android.visual.imageutils.ImageLoader;

import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2014/5/15.
 */
public class ProductItemAdapter extends BaseAdapter {
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

            view.setTag(productViewHolder);
        } else {
            productViewHolder = (ProductViewHolder) view.getTag();
        }

        productViewHolder.productName.setText(products.get(i).productName);
        productViewHolder.detail.setText(products.get(i).detail);
        productViewHolder.price.setText(products.get(i).price + "");
        productViewHolder.totalCnt.setText(products.get(i).currentCnt + "");
        productViewHolder.currentCnt.setText(products.get(i).totalCnt + "");
        imageLoader.DisplayImage(products.get(i).productImg, productViewHolder.BackNewProduct);
        return view;
    }


    final class ProductViewHolder {

        ImageView BackNewProduct;
        TextView productName;
        TextView detail;
        TextView price;
        TextView totalCnt;
        TextView currentCnt;

    }

}

