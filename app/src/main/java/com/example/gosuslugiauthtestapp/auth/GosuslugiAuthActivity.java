package com.example.gosuslugiauthtestapp.auth;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.CookieManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.gosuslugiauthtestapp.BuildConfig;
import com.example.gosuslugiauthtestapp.R;
import com.example.gosuslugiauthtestapp.auth.model.AuthDataDTO;

import java.util.HashMap;

public class GosuslugiAuthActivity extends AppCompatActivity {

    private static final String BASE_URL = "https://ecp-test.miacugra.ru/esia";
    public static final String EXTRA_AUTH_RESULT = "https://ecp-test.miacugra.ru/esia";
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gosuslugi_auth);
        webView = findViewById(R.id.webView);
        AuthenticatingWebView authenticatingWebView = new AuthenticatingWebView(webView, new AuthenticatingWebViewCallbackMethods() {
            @Override
            public void startProgressDialog() {

            }

            @Override
            public void stopProgressDialog() {

            }

            @Override
            public void displayResults(AuthDataDTO authDataDTO) {
                Intent intent = new Intent();
                intent.putExtra(EXTRA_AUTH_RESULT, authDataDTO);
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        authenticatingWebView.makeRequest(BASE_URL);

    }

}
