
package com.tencent.sample.activitys;

import com.tencent.connect.share.QQShare;
import com.tencent.sample.R;
import com.tencent.sample.Util;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class QQShareActivity extends BaseActivity implements OnClickListener, OnCheckedChangeListener {

    private View mContainer_title = null;
    private View mContainer_summary = null;
    private View mContainer_audioUrl = null;
    private View mContainer_targetUrl = null;
    private View mContainer_imgUrl = null;
    private View mContainer_appName = null;
    
    private TextView title = null;
    private TextView imageUrl = null;
    private TextView targetUrl = null;
    private TextView summary = null;
    private TextView appName = null;// app名称，用于手Q显示返回

    // zivon add
    private RadioButton mRadioBtn_localImage = null;
    private RadioButton mRadioBtn_netImage = null;
    private CheckBox mCheckBox_qzoneAutoOpen = null;
    private CheckBox mCheckBox_qzoneItemHide = null;

    private RadioButton mRadioBtnShareTypeDefault;
    private RadioButton mRadioBtnShareTypeAudio;
    private RadioButton mRadioBtnShareTypeImg;
    private int shareType = QQShare.SHARE_TO_QQ_TYPE_DEFAULT;
    private EditText mEditTextAudioUrl;
    
    private int mExtarFlag = 0x00;
    
    private QQShare mQQShare = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setBarTitle("QQ分享");
        setLeftButtonEnable();
        setContentView(R.layout.qq_share_activity);

        title = (TextView) findViewById(R.id.shareqq_title);
        imageUrl = (TextView) findViewById(R.id.shareqq_image_url);
        targetUrl = (TextView) findViewById(R.id.shareqq_target_url);
        summary = (TextView) findViewById(R.id.shareqq_summary);
        appName = (TextView) findViewById(R.id.shareqq_app_name);

        findViewById(R.id.shareqq_commit).setOnClickListener(this);

        mEditTextAudioUrl = (EditText) findViewById(R.id.et_shareqq_audioUrl);

        // mContainer_qzone_special = findViewById(R.id.qzone_specail_radio_container);
        mContainer_title = findViewById(R.id.qqshare_title_container);
        mContainer_summary = findViewById(R.id.qqshare_summary_container);
        mContainer_audioUrl = findViewById(R.id.qqshare_audioUrl_container);
        mContainer_targetUrl = findViewById(R.id.qqshare_targetUrl_container);
        mContainer_imgUrl = findViewById(R.id.qqshare_imageUrl_container);
        mContainer_appName = findViewById(R.id.qqshare_appName_container);
        
        mRadioBtn_netImage = (RadioButton) findViewById(R.id.radioBtn_net_image);
        mRadioBtn_netImage.setOnClickListener(this);
        mRadioBtn_localImage = (RadioButton) findViewById(R.id.radioBtn_local_image);
        mRadioBtn_localImage.setOnClickListener(this);
        mRadioBtnShareTypeDefault = (RadioButton) findViewById(R.id.radioBtn_share_type_default);
        mRadioBtnShareTypeDefault.setOnClickListener(this);
        mRadioBtnShareTypeAudio = (RadioButton) findViewById(R.id.radioBtn_share_type_audio);
        mRadioBtnShareTypeAudio.setOnClickListener(this);
        mRadioBtnShareTypeImg = (RadioButton)findViewById(R.id.radioBtn_share_type_image);
        mRadioBtnShareTypeImg.setOnClickListener(this);
        
        mCheckBox_qzoneItemHide = (CheckBox) findViewById(R.id.checkBox_qzone_item_hide);
        mCheckBox_qzoneItemHide.setOnCheckedChangeListener(this);
        mCheckBox_qzoneAutoOpen = (CheckBox) findViewById(R.id.checkBox_qzone_auto_open);
        mCheckBox_qzoneAutoOpen.setOnCheckedChangeListener(this);
        
        initShareUI(shareType);
        
        mQQShare = new QQShare(this, MainActivity.mQQAuth.getQQToken());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.shareqq_commit: // 提交
                final Bundle params = new Bundle();
                if (shareType != QQShare.SHARE_TO_QQ_TYPE_IMAGE) {
                	params.putString(QQShare.SHARE_TO_QQ_TITLE, title.getText().toString());
                    params.putString(QQShare.SHARE_TO_QQ_TARGET_URL, targetUrl.getText().toString());
                    params.putString(QQShare.SHARE_TO_QQ_SUMMARY, summary.getText().toString());
                }
                if (shareType == QQShare.SHARE_TO_QQ_TYPE_IMAGE) {
                    params.putString(QQShare.SHARE_TO_QQ_IMAGE_LOCAL_URL, imageUrl.getText().toString());
                } else {
                    params.putString(QQShare.SHARE_TO_QQ_IMAGE_URL, imageUrl.getText().toString());
                }
                params.putString(shareType == QQShare.SHARE_TO_QQ_TYPE_IMAGE ? QQShare.SHARE_TO_QQ_IMAGE_LOCAL_URL 
                		: QQShare.SHARE_TO_QQ_IMAGE_URL, imageUrl.getText().toString());
                params.putString(QQShare.SHARE_TO_QQ_APP_NAME, appName.getText().toString());
                params.putInt(QQShare.SHARE_TO_QQ_KEY_TYPE, shareType);
                params.putInt(QQShare.SHARE_TO_QQ_EXT_INT, mExtarFlag);
                if (shareType == QQShare.SHARE_TO_QQ_TYPE_AUDIO) {
                    params.putString(QQShare.SHARE_TO_QQ_AUDIO_URL, mEditTextAudioUrl.getText().toString());
                }
                if ((mExtarFlag & QQShare.SHARE_TO_QQ_FLAG_QZONE_AUTO_OPEN) != 0) {
                    showToast("在好友选择列表会自动打开分享到qzone的弹窗~~~");
                } else if ((mExtarFlag & QQShare.SHARE_TO_QQ_FLAG_QZONE_ITEM_HIDE) != 0) {
                    showToast("在好友选择列表隐藏了qzone分享选项~~~");
                }
                doShareToQQ(params);
                return;
            case R.id.radioBtn_net_image: // 定向分享网络图片
                if (shareType == QQShare.SHARE_TO_QQ_TYPE_IMAGE) {
                    // 纯图分享只能支持本地图片
                    mRadioBtn_localImage.setChecked(true);
                    startPickLocaleImage(this);
                    showToast("纯图分享只支持本地图片");
                } else {
                    imageUrl.setText(R.string.qqshare_imageUrl_content);
                }
                return;
            case R.id.radioBtn_local_image: // 定向分享本地图片
                startPickLocaleImage(this);
                return;
            case R.id.radioBtn_share_type_audio:
                shareType = QQShare.SHARE_TO_QQ_TYPE_AUDIO;
                break;
            case R.id.radioBtn_share_type_default:
                shareType = QQShare.SHARE_TO_QQ_TYPE_DEFAULT;
                break;
            case R.id.radioBtn_share_type_image:
                shareType = QQShare.SHARE_TO_QQ_TYPE_IMAGE;
                break;
        }
        initShareUI(shareType);
    }

    /**
     * 初始化UI
     * @param shareType
     */
    private void initShareUI(int shareType) {
        switch (shareType) {
            case QQShare.SHARE_TO_QQ_TYPE_IMAGE:
                mContainer_title.setVisibility(View.GONE);
                mContainer_summary.setVisibility(View.GONE);
                mContainer_audioUrl.setVisibility(View.GONE);
                mContainer_targetUrl.setVisibility(View.GONE);
                mContainer_imgUrl.setVisibility(View.VISIBLE);
                mContainer_appName.setVisibility(View.GONE);
                mRadioBtn_localImage.setChecked(true);
                imageUrl.setText(null);
                startPickLocaleImage(this);
                return;
            case QQShare.SHARE_TO_QQ_TYPE_AUDIO:
                mContainer_audioUrl.setVisibility(View.VISIBLE);
                title.setText("不要说话");
                imageUrl.setText("http://imgcache.qq.com/music/photo/mid_album_300/V/E/000J1pJ50cDCVE.jpg");
                mEditTextAudioUrl
                        .setText("http://stream14.qqmusic.qq.com/30432451.mp3?key=ABD30A88B30BA76C1435598BC67F69EA741DE4082BF8E089&qqmusic_fromtag=15");
                targetUrl
                        .setText("http://y.qq.com/i/song.html?songid=XXX&source=mobileQQ#wechat_redirect");
                summary.setText("专辑名：不想放手歌手名：陈奕迅");
                appName.setText("QQ音乐");
                break;
            case QQShare.SHARE_TO_QQ_TYPE_DEFAULT:
                mContainer_audioUrl.setVisibility(View.GONE);
                title.setText(R.string.qqshare_title_content);
                imageUrl.setText(R.string.qqshare_imageUrl_content);
                targetUrl.setText(R.string.qqshare_targetUrl_content);
                summary.setText(R.string.qqshare_summary_content);
                appName.setText(R.string.qqshare_appName_content);
                break;
        }
        mContainer_title.setVisibility(View.VISIBLE);
        mContainer_summary.setVisibility(View.VISIBLE);
        mContainer_targetUrl.setVisibility(View.VISIBLE);
        mContainer_imgUrl.setVisibility(View.VISIBLE);
        mContainer_appName.setVisibility(View.VISIBLE);
        mRadioBtn_netImage.setChecked(true);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        String path = null;
        if (resultCode == Activity.RESULT_OK && requestCode == 0) {
            if (data != null && data.getData() != null) {
                // 根据返回的URI获取对应的SQLite信息
                Uri uri = data.getData();
                final String[] proj = {
                        MediaStore.Images.Media.DATA
                };
                Cursor cursor = this.getContentResolver().query(uri, proj, null, null, null);
                int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
                cursor.moveToFirst();
                path = cursor.getString(column_index);
            }
        }
        if (path != null) {
            imageUrl.setText(path);
        } else {
        	if(shareType != QQShare.SHARE_TO_QQ_TYPE_IMAGE){
        		showToast("请重新选择图片");
        	}	
        }
    }

    private static final void startPickLocaleImage(Activity activity) {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        intent.setType("image/*");
        activity.startActivityForResult(
                Intent.createChooser(intent, activity.getString(R.string.str_image_local)), 0);
    }

    /**
     * 用异步方式启动分享
     * @param params
     */
    private void doShareToQQ(final Bundle params) {
        final Activity activity = QQShareActivity.this;
        new Thread(new Runnable() {
            
            @Override
            public void run() {
                // TODO Auto-generated method stub
                mQQShare.shareToQQ(activity, params, new IUiListener() {

                    @Override
                    public void onCancel() {
                    	if(shareType != QQShare.SHARE_TO_QQ_TYPE_IMAGE){
                    		Util.toastMessage(activity, "onCancel: ");
                    	}
                    }

                    @Override
                    public void onComplete(Object response) {
                        // TODO Auto-generated method stub
                        Util.toastMessage(activity, "onComplete: " + response.toString());
                    }

                    @Override
                    public void onError(UiError e) {
                        // TODO Auto-generated method stub
                        Util.toastMessage(activity, "onError: " + e.errorMessage, "e");
                    }

                });
            }
        }).start();
    }
    
    Toast mToast = null;
    private void showToast(String text) {
        if (mToast != null && !super.isFinishing()) {
            mToast.setText(text);
            mToast.show();
            return;
        }
        mToast = Toast.makeText(this, text, Toast.LENGTH_SHORT);
        mToast.show();
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        // TODO Auto-generated method stub
        switch (buttonView.getId()) {
            case R.id.checkBox_qzone_auto_open:
                if (mCheckBox_qzoneItemHide.isChecked()) {
                    mCheckBox_qzoneAutoOpen.setChecked(false);
                    showToast("Qzone隐藏选项打开时, 不能自动弹Qzone窗口");
                } else {
                    if (isChecked) {
                        // 最后一个二进制位置为1, 其他位不变
                        mExtarFlag |= QQShare.SHARE_TO_QQ_FLAG_QZONE_AUTO_OPEN;
                    } else {
                        // 最后一个二进制位置为0, 其他位不变
                        mExtarFlag &= (0xFFFFFFFF - QQShare.SHARE_TO_QQ_FLAG_QZONE_AUTO_OPEN);
                    }
                }
                return;
            case R.id.checkBox_qzone_item_hide:
                if (mCheckBox_qzoneAutoOpen.isChecked()) {
                    mCheckBox_qzoneItemHide.setChecked(false);
                    showToast("Qzone自动弹窗选项打开时, 不能隐藏Qzone Item.");
                } else {
                    if (isChecked) {
                        // 倒数第二位置为1, 其他位不变
                        mExtarFlag |= QQShare.SHARE_TO_QQ_FLAG_QZONE_ITEM_HIDE;
                    } else {
                        // 倒数第二位置为0, 其他位不变
                        mExtarFlag &= (0xFFFFFFFF - QQShare.SHARE_TO_QQ_FLAG_QZONE_ITEM_HIDE);
                    }
                }
                return;
        }
        
    }
}
