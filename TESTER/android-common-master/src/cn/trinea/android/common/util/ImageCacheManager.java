package cn.trinea.android.common.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import cn.trinea.android.common.entity.FailedReason;
import cn.trinea.android.common.service.impl.FileNameRuleImageUrl;
import cn.trinea.android.common.service.impl.ImageCache;
import cn.trinea.android.common.service.impl.ImageMemoryCache.OnImageCallbackListener;
import cn.trinea.android.common.service.impl.ImageSDCardCache;
import cn.trinea.android.common.service.impl.ImageSDCardCache.OnImageSDCallbackListener;
import cn.trinea.android.common.service.impl.RemoveTypeLastUsedTimeFirst;

/**
 * ImageCacheManager
 *
 * @author maxiaohui hackooo@sina.cn 2014-2-14
 */
public class ImageCacheManager {

    private static ImageCache imageCache = null;
    private static ImageSDCardCache imageSDCardCache = null;

    /**
     * get the singleton instance of ImageCache
     *
     * @return
     */
    public static ImageCache getImageCache() {
        if (imageCache == null) {
            synchronized (CacheManager.class) {
                if (imageCache == null) {
                    imageCache = new ImageCache(128, 512);
                    setImageCache();
                }
            }
        }
        return imageCache;
    }

    /**
     * get the singleton instance of ImageSDCardCache
     *
     * @return
     */
    public static ImageSDCardCache getImageSDCardCache() {
        if (imageSDCardCache == null) {
            synchronized (CacheManager.class) {
                if (imageSDCardCache == null) {
                    imageSDCardCache = new ImageSDCardCache();
                    setImageSDCardCache();
                }
            }
        }
        return imageSDCardCache;
    }

    /**
     * set ImageCache properties
     */
    private static void setImageCache() {
        if (imageCache == null) {
            return;
        }

        OnImageCallbackListener imageCallBack = new OnImageCallbackListener() {

            @Override
            public void onGetSuccess(String imageUrl, Bitmap loadedImage, View view, boolean isInCache) {
                if (view != null && loadedImage != null) {
                    ImageView imageView = (ImageView) view;
                    imageView.setImageBitmap(loadedImage);
                    // first time show with animation
                    if (!isInCache) {
                        imageView.startAnimation(getInAlphaAnimation(2000));
                    }
                }
            }

            @Override
            public void onPreGet(String imageUrl, View view) {
            }

            @Override
            public void onGetFailed(String imageUrl, Bitmap loadedImage, View view, FailedReason failedReason) {
            }

            @Override
            public void onGetNotInCache(String imageUrl, View view) {
            }
        };
        imageCache.setOnImageCallbackListener(imageCallBack);
        imageCache.setCacheFullRemoveType(new RemoveTypeLastUsedTimeFirst<Bitmap>());

        imageCache.setHttpReadTimeOut(10000);
        imageCache.setValidTime(-1);
    }

    /**
     * set ImageSDCardCache properties
     */
    private static void setImageSDCardCache() {
        if (imageSDCardCache == null) {
            return;
        }

        OnImageSDCallbackListener imageCallBack = new OnImageSDCallbackListener() {

            private static final long serialVersionUID = 1L;

            @Override
            public void onGetSuccess(String imageUrl, String imagePath, View view, boolean isInCache) {
                ImageView imageView = (ImageView) view;

                // if oom please use BitmapFactory.decodeFile(imagePath, option)
                Bitmap bm = BitmapFactory.decodeFile(imagePath);
                if (bm != null) {
                    imageView.setImageBitmap(bm);

                    // first time show with animation
                    if (!isInCache) {
                        imageView.startAnimation(getInAlphaAnimation(2000));
                    }
                }
            }

            @Override
            public void onPreGet(String imageUrl, View view) {
            }

            @Override
            public void onGetNotInCache(String imageUrl, View view) {
            }

            @Override
            public void onGetFailed(String imageUrl, String imagePath, View view, FailedReason failedReason) {
            }
        };
        imageSDCardCache.setOnImageSDCallbackListener(imageCallBack);
        imageSDCardCache.setCacheFullRemoveType(new RemoveTypeLastUsedTimeFirst<String>());
        imageSDCardCache.setFileNameRule(new FileNameRuleImageUrl());

        imageSDCardCache.setHttpReadTimeOut(10000);
        imageSDCardCache.setValidTime(-1);
    }

    public static AlphaAnimation getInAlphaAnimation(long durationMillis) {
        AlphaAnimation inAlphaAnimation = new AlphaAnimation(0, 1);
        inAlphaAnimation.setDuration(durationMillis);
        return inAlphaAnimation;
    }

    private ImageCacheManager() {

    }
}
