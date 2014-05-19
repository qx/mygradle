package com.example.myapp5;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.connect.auth.QQAuth;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;
import com.tencent.tauth.UiError;
import org.json.JSONObject;

public class MyActivity extends Activity {
    private TextView return_text;
    private Button button;
    public static final String APPID = "101097138";
    public static final String APPKEY = "43f976aea06436196677fe2860789f1e";
    private Tencent mTencent;
    private QQAuth mQQAuth;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        return_text = (TextView) findViewById(R.id.return_text);
        button = (Button) findViewById(R.id.button);
        mTencent = Tencent.createInstance(APPID, this.getApplicationContext());
        mQQAuth = QQAuth.createInstance(APPID, this.getApplicationContext());
//        mTencent = Tencent.createInstance(APPID, MainActivity.this);
    }



    public void onLogin(View v) {
        onClickLogin();

    }

    private void onClickLogin() {
        if (!mQQAuth.isSessionValid()) {
            IUiListener listener = new BaseUiListener() {
                @Override
                protected void doComplete(JSONObject values) {
//                    updateUserInfo();
//                    updateLoginButton();

                    System.out.println("************complete"+values);
                }
            };
            //mQQAuth.login(this, "all", listener);
            mTencent.loginWithOEM(this, "all", listener,"10000144","10000144","xxxx");
        } else {
            mQQAuth.logout(this);
//            updateUserInfo();
//            updateLoginButton();
        }
    }



    private class BaseUiListener implements IUiListener {

//        @Override
//
//        public void onComplete(JSONObject response) {
//
////            mBaseMessageText.setText("onComplete:");
//
////            mMessageText.setText(response.toString());
//            return_text.setText(response.toString());
//
//            doComplete(response);
//
//        }

        protected void doComplete(JSONObject response) {
            return_text.setText(response.toString());

            doComplete(response);
        }

        @Override
        public void onComplete(Object o) {

        }

        @Override

        public void onError(UiError e) {

            showResult("onError:", "code:" + e.errorCode + ", msg:"

                    + e.errorMessage + ", detail:" + e.errorDetail);

        }

        @Override

        public void onCancel() {

            showResult("onCancel", "");

        }

    }

    private void showResult(String s, String s1) {
        Toast.makeText(this, s + "||" + s1, 0).show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        mTencent.onActivityResult(requestCode, resultCode, data);
    }
}
