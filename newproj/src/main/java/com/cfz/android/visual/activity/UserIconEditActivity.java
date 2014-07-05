package com.cfz.android.visual.activity;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import cn.trinea.android.common.util.ToastUtils;
import com.cfz.android.R;
import com.cfz.android.Spokers;
import com.cfz.android.UserData;
import com.cfz.android.entity.network.urlentity.BaseEntity;
import com.cfz.android.impl.HttpRequestListener;
import com.cfz.android.visual.imageutils.ImageLoader;
import com.google.api.client.http.HttpContent;
import com.google.api.client.http.InputStreamContent;

import java.io.*;

/**
 * Created by Administrator on 2014/4/27.
 */
public class UserIconEditActivity extends BaseUrlActivity implements View.OnClickListener {
    private static final int MAX_HEIGHT = 600;
    private static final int MAX_WIDTH = 600;
    private EditText v_value;
    private LinearLayout title_right_click;
    private ImageView user_img;
    private Button get_from_photo;
    private Button choose_from_gallery;
    private static final int SELECT_PICTURE = 1;
    private static final int CAPTURE_IMAGE = 2;
    private String selectedImagePath;
    private String filePath;

    private File tempfile;
    private InputStream inputstream;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_usericon);
        v_value = (EditText) findViewById(R.id.v_value);
        user_img = (ImageView) findViewById(R.id.user_img);
        title_right_click = (LinearLayout) findViewById(R.id.title_right_click);
        title_right_click.setOnClickListener(this);
        get_from_photo = (Button) findViewById(R.id.get_from_photo);
        choose_from_gallery = (Button) findViewById(R.id.choose_from_gallery);
        get_from_photo.setOnClickListener(this);
        choose_from_gallery.setOnClickListener(this);

        initView();
    }

    private void initView() {
        v_value.setText(UserData.getInstance().getUserNickName());
        ImageLoader imageLoader = new ImageLoader(this.getApplicationContext());
        imageLoader.DisplayImage(UserData.getInstance().getUserImage(), user_img);
    }


    @Override
    protected int getActivityTitle() {
        return R.string.title_edit_userpic;
    }

    @Override
    protected int getActivityMoreImg() {
        return R.drawable.save;
    }

    @Override
    protected int getActivityMoreTitle() {
        return R.string.null_string;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.title_right_click:
                saveToServer();
                break;
            case R.id.get_from_photo:
                getFromCarema();
                break;
            case R.id.choose_from_gallery:
                getFromGallery();
                break;
            default:
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            if (requestCode == SELECT_PICTURE) {
                Uri selectedImageUri = data.getData();
                selectedImagePath = getPath(selectedImageUri);

                tempfile = getFileFromDrawable(selectedImagePath);
                Drawable dw = Drawable.createFromPath(selectedImagePath);

                user_img.setImageDrawable(dw);

            } else if (requestCode == CAPTURE_IMAGE) {

//                BitmapFactory.Options options = new BitmapFactory.Options();
//                options.inPreferredConfig = Bitmap.Config.ARGB_8888;
//                Bitmap photo = BitmapFactory.decodeFile(filePath, options);
                Bitmap photo = decodeSampledBitmapFromFile(filePath, MAX_WIDTH, MAX_HEIGHT);
                tempfile = getFileFromBitmap(photo);
                user_img.setImageBitmap(photo);
            }
        }
    }

    private File getFileFromDrawable(String selectedImagePath) {
        Bitmap bmp = BitmapFactory.decodeFile(selectedImagePath);
        return getFileFromBitmap(bmp);
    }

    private File getFileFromBitmap(Bitmap bitmap) {
        File f = new File(this.getCacheDir(), "tempfile.jpeg");
        try {
            //create a file to write bitmap data
            f.createNewFile();

//Convert bitmap to byte array
//        Bitmap bitmap = your bitmap;
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 0 /*ignored for PNG*/, bos);
            byte[] bitmapdata = bos.toByteArray();

//write the bytes in file
            FileOutputStream fos = new FileOutputStream(f);
            fos.write(bitmapdata);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return f;
    }

    private void getFromCarema() {
        filePath = Environment.getExternalStorageDirectory() + "/Full_"
                + System.currentTimeMillis() + ".jpeg";
        File file = new File(filePath);
        Uri output = Uri.fromFile(file);
        Intent i = new Intent(
                android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        i.putExtra(MediaStore.EXTRA_OUTPUT, output);
        startActivityForResult(i, CAPTURE_IMAGE);
    }

    public static Bitmap decodeSampledBitmapFromFile(String path, int reqWidth, int reqHeight) { // BEST QUALITY MATCH

//First decode with inJustDecodeBounds=true to check dimensions
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(path, options);

// Calculate inSampleSize, Raw height and width of image
        final int height = options.outHeight;
        final int width = options.outWidth;
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        int inSampleSize = 1;

        if (height > reqHeight) {
            inSampleSize = Math.round((float) height / (float) reqHeight);
        }
        int expectedWidth = width / inSampleSize;

        if (expectedWidth > reqWidth) {
            //if(Math.round((float)width / (float)reqWidth) > inSampleSize) // If bigger SampSize..
            inSampleSize = Math.round((float) width / (float) reqWidth);
        }

        options.inSampleSize = inSampleSize;

// Decode bitmap with inSampleSize set
        options.inJustDecodeBounds = false;

        return BitmapFactory.decodeFile(path, options);
    }

    /**
     * helper to retrieve the path of an image URI
     */
    public String getPath(Uri uri) {
        // just some safety built in
        if (uri == null) {
            // TODO perform some logging or show user feedback
            return null;
        }
        // try to retrieve the image from the media store first
        // this will only work for images selected from gallery
        String[] projection = {MediaStore.Images.Media.DATA};
        Cursor cursor = managedQuery(uri, projection, null, null, null);
        if (cursor != null) {
            int column_index = cursor
                    .getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
            cursor.moveToFirst();
            return cursor.getString(column_index);
        }
        // this is our fallback here
        return uri.getPath();
    }

    private void getFromGallery() {
        // in onCreate or any event where your want the user to
        // select a file
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent,
                "Select Picture"), SELECT_PICTURE);
    }

    private void saveToServer() {
        saveIcon();
//        saveNickName();
    }

    private void saveIcon() {
//        HashMap<String, Object> hashMap = new HashMap<String, Object>();
//        hashMap.put(SETHEAD_PARAMS_IMAGE, tempfile);
//        Spokers.getInstance().getHttpDataUseAsync(hashMap,new HttpRequestListener() {
//            @Override
//            public void onDoing() {
//                super.onDoing();
//            }
//
//            @Override
//            public void onSuccess(Object o) {
//                ToastUtils.show(UserIconEditActivity.this, "success");
//                super.onSuccess(o);
//            }
//
//            @Override
//            public void onFail() {
//                ToastUtils.show(UserIconEditActivity.this, "fail");
//                super.onFail();
//            }
//        }, SETHEAD_URL, BaseEntity.class);

        try {
            inputstream = new FileInputStream(tempfile);
            HttpContent imc = new InputStreamContent("image/jpeg", inputstream);
//            HttpContent imc = new I
//            HttpContent imb=

            Spokers.getInstance().postHttpDataUseAsync(imc, new HttpRequestListener() {
                @Override
                public void onDoing() {
                    super.onDoing();
                }

                @Override
                public void onSuccess(Object o) {
                    ToastUtils.show(UserIconEditActivity.this, "success");
                    super.onSuccess(o);
                }

                @Override
                public void onFail() {
                    ToastUtils.show(UserIconEditActivity.this, "fail");
                    super.onFail();
                }
            }, SETHEAD_URL, BaseEntity.class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }


}