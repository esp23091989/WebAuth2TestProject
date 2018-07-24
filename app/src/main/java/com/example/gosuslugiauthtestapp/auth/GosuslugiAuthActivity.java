package com.example.gosuslugiauthtestapp.auth;

import android.annotation.SuppressLint;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.CookieManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.gosuslugiauthtestapp.BuildConfig;
import com.example.gosuslugiauthtestapp.R;

public class GosuslugiAuthActivity extends AppCompatActivity {

    private WebView webView;
    private static final String BASE_URL = "https://ecp-test.miacugra.ru/esia";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gosuslugi_auth);
        webView = findViewById(R.id.webView);

        initWebViewSettings();

    }

    @SuppressLint("SetJavaScriptEnabled")
    private void initWebViewSettings() {
        CookieManager cookieManager = CookieManager.getInstance();
        WebSettings webSettings = webView.getSettings();
        webView.setWebViewClient(new CustomWebClient());

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
            cookieManager.removeAllCookies(null);
        else
            cookieManager.removeAllCookie();

        webSettings.setSaveFormData(false);
        webSettings.setSavePassword(false);
        webSettings.setJavaScriptEnabled(true);
        webView.loadUrl(BASE_URL);
    }
}
