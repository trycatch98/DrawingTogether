package com.hansung.drawingtogether.view.main;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.net.Uri;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavDeepLinkBuilder;

import com.hansung.drawingtogether.R;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import static com.kakao.util.helper.Utility.getPackageInfo;


public class MainActivity extends AppCompatActivity {

    private String topicPassword="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Log.e("kkankkan", getKeyHash(this));

        Intent kakaoIntent = getIntent();
        if (kakaoIntent == null)
            return;

        Uri uri = kakaoIntent.getData();
        if (uri == null)
            return;

        String topic = uri.getQueryParameter("topic");
        String password = uri.getQueryParameter("password");

        if (!(topic == null) && !(password == null)) {
            topicPassword = topic;
            topicPassword += "/" + password;
        }

        /*if (kakaoIntent.getData() == null)
            return;

        String topic = kakaoIntent.getData().getQueryParameter("topic");
        String password = kakaoIntent.getData().getQueryParameter("password");*/

        Log.e("kkankkan", "카카오 링크로 접속 -> " + "topic : " + topic + " / password : " + password);
    }

    public String getTopicPassword() {
        return topicPassword;
    }

    public void setTopicPassword(String topicPassword) {
        this.topicPassword = topicPassword;
    }

  /*  public String getKeyHash(final Context context) {
        PackageInfo packageInfo = getPackageInfo(context, PackageManager.GET_SIGNATURES);
        if (packageInfo == null)
            return null;

        for (Signature signature : packageInfo.signatures) {
            try {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                return Base64.encodeToString(md.digest(), Base64.NO_WRAP);
            } catch (NoSuchAlgorithmException e) {
                Log.e("kkankkan", "Unable to get MessageDigest. signature=" + signature, e);
            }
        }
        return null;
    }*/

}
