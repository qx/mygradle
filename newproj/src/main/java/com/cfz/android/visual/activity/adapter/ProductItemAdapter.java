package com.cfz.android.visual.activity.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Environment;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cn.trinea.android.common.entity.FailedReason;
import cn.trinea.android.common.service.impl.ImageCache;
import cn.trinea.android.common.service.impl.ImageMemoryCache;
import cn.trinea.android.common.service.impl.RemoveTypeLastUsedTimeFirst;
import com.cfz.android.R;
import com.cfz.android.mode.object.network.BackNewProduct;
import com.cfz.android.visual.activity.listener.ImageLoadingListener;

import java.io.File;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2014/5/15.
 */
public class ProductItemAdapter extends BaseAdapter implements ImageLoadingListener {
    private ArrayList<BackNewProduct> products;
    private Context mContext;
    private LayoutInflater mInflater = null;
    private HashMap<String, SoftReference<Drawable>> mCachedIcons = null;
    private ArrayList<String> imageUrlList;
    public static final String TAG_CACHE = "image_cache";

    private ImageView[] curImgs;
    private String[] imageUrls;
    public ProductItemAdapter(Context mContext) {
        this.mContext = mContext;
        mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mCachedIcons = new HashMap<String, SoftReference<Drawable>>();
        products = new ArrayList<BackNewProduct>();


    }

    /**
     * add data
     *
     * @param list
     */
    public void putData(final List<BackNewProduct> list) {

        if (products == null) {
            return;
        }
        products.addAll(list);
        if (list != null && list.size() > 0) {
              curImgs=new ImageView[products.size()];
             imageUrls=new String[products.size()];
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
            imageUrlList = new ArrayList<String>();
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
//        IMAGE_CACHE.initData(mContext, TAG_CACHE);
//        IMAGE_CACHE.setContext(mContext);
//        IMAGE_CACHE.setCacheFolder(DEFAULT_CACHE_FOLDER);
//        IMAGE_CACHE.get(products.get(i).productImg, productViewHolder.BackNewProduct);
        curImgs[i] = productViewHolder.BackNewProduct;
        imageUrls[i] = products.get(i).productImg;

        productViewHolder.productName.setText(products.get(i).productName);
        productViewHolder.detail.setText(products.get(i).detail);
        productViewHolder.price.setText(products.get(i).price + "");
        productViewHolder.totalCnt.setText(products.get(i).currentCnt + "");
        productViewHolder.currentCnt.setText(products.get(i).totalCnt + "");
//        updateImageView(imageUrls,curImgs);
        return view;
    }

    public static final ImageCache IMAGE_CACHE = new ImageCache(128, 512);
    public static final String DEFAULT_CACHE_FOLDER = new StringBuilder().append(Environment.getExternalStorageDirectory()
            .getAbsolutePath())
            .append(File.separator).append(".cfz")
            .append(File.separator)
            .append("newproduct")
            .append(File.separator)
            .append("ImageCache").toString();

    public void updateImageView(String[] imageUrls,ImageView[] curImgs) {

        if (imageUrls == null || imageUrls.length == 0) {
            return;

        }

        IMAGE_CACHE.initData(mContext, TAG_CACHE);
        IMAGE_CACHE.setContext(mContext);
        IMAGE_CACHE.setCacheFolder(DEFAULT_CACHE_FOLDER);

        // intelligent compress image
        // IMAGE_CACHE.setCompressListener(new CompressListener() {
        //
        // @Override
        // public int getCompressSize(String imagePath) {
        // if (FileUtils.isFileExist(imagePath)) {
        // long fileSize = FileUtils.getFileSize(imagePath) / 1000;
        // /**
        // * if image bigger than 100k, compress to 1/(n + 1) width and 1/(n + 1) height, n is fileSize / 100k
        // **/
        // if (fileSize > 100) {
        // return (int)(fileSize / 100) + 1;
        // }
        // }
        // return 1;
        // }
        // });

        int count = 0, viewId = 0x7F24FFF0;
        int verticalSpacing, horizontalSpacing;
        verticalSpacing = horizontalSpacing = mContext.getResources().getDimensionPixelSize(R.dimen.dp_4);
//        Display display = mContext.getWindowManager().getDefaultDisplay();
//        int imageWidth = (display.getWidth() - (COLUMNS + 1) * horizontalSpacing) / COLUMNS;


        for (int i = 0; i < imageUrls.length; i++) {
            curImgs[i].setScaleType(ImageView.ScaleType.CENTER);
//            imageView.setBackgroundResource(R.drawable.image_border);
            IMAGE_CACHE.get(imageUrls[i], curImgs[i]);


        }


//
//        for (String imageUrl : imageUrlList) {
//            ImageView imageView = new ImageView(context);
//            imageView.setId(++viewId);
//            imageView.setScaleType(ImageView.ScaleType.CENTER);
//            imageView.setBackgroundResource(R.drawable.image_border);
////            parentLayout.addView(imageView);
//
//            // set imageView layout params
//            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) imageView.getLayoutParams();
//            layoutParams.width = imageWidth;
//            layoutParams.topMargin = verticalSpacing;
//            layoutParams.rightMargin = horizontalSpacing;
//            int column = count % COLUMNS;
//            int row = count / COLUMNS;
//            if (row > 0) {
//                layoutParams.addRule(RelativeLayout.BELOW, viewId - COLUMNS);
//            }
//            if (column > 0) {
//                layoutParams.addRule(RelativeLayout.RIGHT_OF, viewId - 1);
//            }
//            layoutParams.height = IMAGEVIEW_DEFAULT_HEIGHT;

        // get image
//            IMAGE_CACHE.get(imageUrl, imageView);
//            count++;
    }


    public static AlphaAnimation getInAlphaAnimation(long durationMillis) {
        AlphaAnimation inAlphaAnimation = new AlphaAnimation(0, 1);
        inAlphaAnimation.setDuration(durationMillis);
        return inAlphaAnimation;
    }

    {
        /** init icon cache **/
        ImageMemoryCache.OnImageCallbackListener imageCallBack = new ImageMemoryCache.OnImageCallbackListener() {

            /**
             * callback function after get image successfully, run on ui thread
             *
             * @param imageUrl    imageUrl
             * @param loadedImage bitmap
             * @param view        view need the image
             * @param isInCache   whether already in cache or got realtime
             */
            @Override
            public void onGetSuccess(String imageUrl, Bitmap loadedImage, View view, boolean isInCache) {
                if (view != null && loadedImage != null) {
                    ImageView imageView = (ImageView) view;
                    imageView.setImageBitmap(loadedImage);
                    // first time show with animation
                    if (!isInCache) {
                        imageView.startAnimation(getInAlphaAnimation(2000));
                    }

                    // auto set height accroding to rate between height and weight
                    RelativeLayout.LayoutParams imageParams = (RelativeLayout.LayoutParams) imageView.getLayoutParams();
                    imageParams.height = imageParams.width * loadedImage.getHeight() / loadedImage.getWidth();
                    imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                    ProductItemAdapter.this.notifyDataSetChanged();

                }
            }

            /**
             * callback function before get image, run on ui thread
             *
             * @param imageUrl imageUrl
             * @param view     view need the image
             */
            @Override
            public void onPreGet(String imageUrl, View view) {
                // Log.e(TAG_CACHE, "pre get image");
            }

            /**
             * callback function after get image failed, run on ui thread
             *
             * @param imageUrl     imageUrl
             * @param loadedImage  bitmap
             * @param view         view need the image
             * @param failedReason failed reason for get image
             */
            @Override
            public void onGetFailed(String imageUrl, Bitmap loadedImage, View view, FailedReason failedReason) {
                Log.e(TAG_CACHE,
                        new StringBuilder(128).append("get image ").append(imageUrl).append(" error, failed type is: ")
                                .append(failedReason.getFailedType()).append(", failed reason is: ")
                                .append(failedReason.getCause().getMessage()).toString()
                );
            }

            @Override
            public void onGetNotInCache(String imageUrl, View view) {
                if (view != null && view instanceof ImageView) {
                    ((ImageView) view).setImageResource(R.drawable.product);
                }
            }
        };
        IMAGE_CACHE.setOnImageCallbackListener(imageCallBack);
        IMAGE_CACHE.setCacheFullRemoveType(new RemoveTypeLastUsedTimeFirst<Bitmap>());

        IMAGE_CACHE.setHttpReadTimeOut(10000);
        IMAGE_CACHE.setOpenWaitingQueue(true);
        IMAGE_CACHE.setValidTime(-1);
        /**
         * close connection, default is connect keep-alive to reuse connection. if image is from different server, you
         * can set this
         */
        // IMAGE_CACHE.setRequestProperty("Connection", "false");
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

