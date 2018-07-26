package com.example.gosuslugiauthtestapp.auth;

import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Message;
import android.view.KeyEvent;
import android.webkit.ClientCertRequest;
import android.webkit.CookieManager;
import android.webkit.HttpAuthHandler;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SafeBrowsingResponse;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Юленька on 24.07.2018.
 */

public class CustomWebClient extends WebViewClient {

    @Override
    public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
        super.onReceivedError(view, request, error);
    }

    @Override
    public void onPageFinished(WebView view, String url) {
        CookieManager  cookieManager = CookieManager.getInstance();
        try {
            URL url1 = new URL(url);
            String cookie = cookieManager.getCookie(url1.getHost());
            String[] pairs = cookie.split(";");
            for (int i = 0; i < pairs.length; ++i) {
                String[] parts = pairs[i].split("=", 2);
                String[] parts1 = pairs[i].split("=", 2);
                // If token is found, return it to the calling activity.
//                if (parts.length == 2 &&
//                        parts[0].equalsIgnoreCase("oauth_token")) {
//                    Intent result = new Intent();
//                    result.putExtra("token", parts[1]);
//                    setResult(RESULT_OK, result);
//                    finish();
//                }
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        super.onPageFinished(view, url);
    }

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
        return super.shouldOverrideUrlLoading(view, request);
    }

    @Override
    public void onReceivedHttpError(WebView view, WebResourceRequest request, WebResourceResponse errorResponse) {
        super.onReceivedHttpError(view, request, errorResponse);
    }



    @Override
    public WebResourceResponse shouldInterceptRequest(WebView view, WebResourceRequest request) {
        return super.shouldInterceptRequest(view, request);
    }

    @Override
    public void onPageStarted(WebView view, String url, Bitmap favicon) {
        super.onPageStarted(view, url, favicon);
    }

    @Override
    public void onLoadResource(WebView view, String url) {
        super.onLoadResource(view, url);
    }

    @Override
    public void onPageCommitVisible(WebView view, String url) {
        super.onPageCommitVisible(view, url);
    }

    @Override
    public WebResourceResponse shouldInterceptRequest(WebView view, String url) {
        return super.shouldInterceptRequest(view, url);
    }

    @Override
    public void onTooManyRedirects(WebView view, Message cancelMsg, Message continueMsg) {
        super.onTooManyRedirects(view, cancelMsg, continueMsg);
//        https://ecp-test.miacugra.ru/esia/Home/EsiaPage?data=yuwD709Ehh0HPhfWod21ttoGWTuSGt5uV2BDu0sczP8qNPu4-qoOi20EmuiKkUfN8lz-pplCLhKuA7pFwtvZSTsLzJIu6fZpNDgMS-cM-AivwE2DdVPCg_0TO5ouqUFs6IzwgFVrVe2AsaGyxjo62N531ObsXWXSihdYKxczT57pDk-Jpw_tkVoKrjBSgaIchsrQ54fL0TFjLFLaeRZ-smHn6rM7BenqDVS_FPH6w0g&code=eyJ2ZXIiOjEsInR5cCI6IkpXVCIsInNidCI6ImF1dGhvcml6YXRpb25fY29kZSIsImFsZyI6IlJTMjU2In0.eyJuYmYiOjE1MzI0NDM4NDIsInNjb3BlIjoibW9iaWxlP29pZD0xMDAwMjk5NjU1IGtpZF9iaXJ0aF9jZXJ0X2RvYz9vaWQ9MTAwMDI5OTY1NSBnZW5kZXI_b2lkPTEwMDAyOTk2NTUgYmlydGhwbGFjZT9vaWQ9MTAwMDI5OTY1NSBraWRfZnVsbG5hbWU_b2lkPTEwMDAyOTk2NTUgYmlydGhkYXRlP29pZD0xMDAwMjk5NjU1IHNuaWxzP29pZD0xMDAwMjk5NjU1IGtpZF9zbmlscz9vaWQ9MTAwMDI5OTY1NSBmdWxsbmFtZT9vaWQ9MTAwMDI5OTY1NSBraWRfYmlydGhkYXRlP29pZD0xMDAwMjk5NjU1IGVtYWlsP29pZD0xMDAwMjk5NjU1IGlkX2RvYz9vaWQ9MTAwMDI5OTY1NSBraWRfZ2VuZGVyP29pZD0xMDAwMjk5NjU1IiwiYXV0aF90aW1lIjoxNTMyNDQzNTU3LCJpc3MiOiJodHRwOlwvXC9lc2lhLmdvc3VzbHVnaS5ydVwvIiwidXJuOmVzaWE6c2lkIjoiODM0M2I4OTVlODkzMWQwMGQ1YWQ1OGExMDY5ODkwYTM1MjEzZGYxOTdmYjBiNGRhNDlkODRhMzEzNGYyMzIwMiIsInVybjplc2lhOmNsaWVudDpzdGF0ZSI6IjQ1OTYzNzcyLWU4OGQtNGZiZi05OGFiLTFjZWVkODY4YzI3YyIsImF1dGhfbXRoZCI6IlBXRCIsInVybjplc2lhOnNiaiI6eyJ1cm46ZXNpYTpzYmo6dHlwIjoiUCIsInVybjplc2lhOnNiajppc190cnUiOnRydWUsInVybjplc2lhOnNiajpvaWQiOjEwMDAyOTk2NTUsInVybjplc2lhOnNiajpuYW0iOiJPSUQuMTAwMDI5OTY1NSIsInVybjplc2lhOnNiajplaWQiOjc0MTQ1NjN9LCJleHAiOjE1MzI0NDQwODIsInBhcmFtcyI6e30sImlhdCI6MTUzMjQ0Mzg0MiwiY2xpZW50X2lkIjoiMDA0MzA2ODYxIn0.XkFI94cG8s8psAfIar4TsrWpqgKriBQRevebh7T6tz_J45rak0JMmN7cNxHu-ja0kajGMeBzBPpbxlthWAMhqR3GlbItQXWjmi8ZWxtWeHemxPyemJ0QkvqeDA1lugEOHO3z5J7id1oCrnGP2YgSfLw8Sd3VFgU7WJMpxAoIFBiDOgYa-HQMpeSYGkkX59hDktmSn5iiLoEWRg5liPB51JqbCkceDEkKgk8CNFhD-0oQ7b-DV-qVmYnMZ6U0O-LEm9V0b1aD3ICxxg5CILPRPKLFCaXo4DDlfVBCugpWDO0Kmgu7LzWwJ4nogZxJGnF8LwkKuVaIf5Qes6aiU5Adgg&state=45963772-e88d-4fbf-98ab-1ceed868c27chttps://ecp-test.miacugra.ru/esia/Home/EsiaPage?data=yuwD709Ehh0HPhfWod21ttoGWTuSGt5uV2BDu0sczP8qNPu4-qoOi20EmuiKkUfN8lz-pplCLhKuA7pFwtvZSTsLzJIu6fZpNDgMS-cM-AivwE2DdVPCg_0TO5ouqUFs6IzwgFVrVe2AsaGyxjo62N531ObsXWXSihdYKxczT57pDk-Jpw_tkVoKrjBSgaIchsrQ54fL0TFjLFLaeRZ-smHn6rM7BenqDVS_FPH6w0g&code=eyJ2ZXIiOjEsInR5cCI6IkpXVCIsInNidCI6ImF1dGhvcml6YXRpb25fY29kZSIsImFsZyI6IlJTMjU2In0.eyJuYmYiOjE1MzI0NDM4NDIsInNjb3BlIjoibW9iaWxlP29pZD0xMDAwMjk5NjU1IGtpZF9iaXJ0aF9jZXJ0X2RvYz9vaWQ9MTAwMDI5OTY1NSBnZW5kZXI_b2lkPTEwMDAyOTk2NTUgYmlydGhwbGFjZT9vaWQ9MTAwMDI5OTY1NSBraWRfZnVsbG5hbWU_b2lkPTEwMDAyOTk2NTUgYmlydGhkYXRlP29pZD0xMDAwMjk5NjU1IHNuaWxzP29pZD0xMDAwMjk5NjU1IGtpZF9zbmlscz9vaWQ9MTAwMDI5OTY1NSBmdWxsbmFtZT9vaWQ9MTAwMDI5OTY1NSBraWRfYmlydGhkYXRlP29pZD0xMDAwMjk5NjU1IGVtYWlsP29pZD0xMDAwMjk5NjU1IGlkX2RvYz9vaWQ9MTAwMDI5OTY1NSBraWRfZ2VuZGVyP29pZD0xMDAwMjk5NjU1IiwiYXV0aF90aW1lIjoxNTMyNDQzNTU3LCJpc3MiOiJodHRwOlwvXC9lc2lhLmdvc3VzbHVnaS5ydVwvIiwidXJuOmVzaWE6c2lkIjoiODM0M2I4OTVlODkzMWQwMGQ1YWQ1OGExMDY5ODkwYTM1MjEzZGYxOTdmYjBiNGRhNDlkODRhMzEzNGYyMzIwMiIsInVybjplc2lhOmNsaWVudDpzdGF0ZSI6IjQ1OTYzNzcyLWU4OGQtNGZiZi05OGFiLTFjZWVkODY4YzI3YyIsImF1dGhfbXRoZCI6IlBXRCIsInVybjplc2lhOnNiaiI6eyJ1cm46ZXNpYTpzYmo6dHlwIjoiUCIsInVybjplc2lhOnNiajppc190cnUiOnRydWUsInVybjplc2lhOnNiajpvaWQiOjEwMDAyOTk2NTUsInVybjplc2lhOnNiajpuYW0iOiJPSUQuMTAwMDI5OTY1NSIsInVybjplc2lhOnNiajplaWQiOjc0MTQ1NjN9LCJleHAiOjE1MzI0NDQwODIsInBhcmFtcyI6e30sImlhdCI6MTUzMjQ0Mzg0MiwiY2xpZW50X2lkIjoiMDA0MzA2ODYxIn0.XkFI94cG8s8psAfIar4TsrWpqgKriBQRevebh7T6tz_J45rak0JMmN7cNxHu-ja0kajGMeBzBPpbxlthWAMhqR3GlbItQXWjmi8ZWxtWeHemxPyemJ0QkvqeDA1lugEOHO3z5J7id1oCrnGP2YgSfLw8Sd3VFgU7WJMpxAoIFBiDOgYa-HQMpeSYGkkX59hDktmSn5iiLoEWRg5liPB51JqbCkceDEkKgk8CNFhD-0oQ7b-DV-qVmYnMZ6U0O-LEm9V0b1aD3ICxxg5CILPRPKLFCaXo4DDlfVBCugpWDO0Kmgu7LzWwJ4nogZxJGnF8LwkKuVaIf5Qes6aiU5Adgg&state=45963772-e88d-4fbf-98ab-1ceed868c27c
    }

    @Override
    public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
        super.onReceivedError(view, errorCode, description, failingUrl);
    }

    @Override
    public void onFormResubmission(WebView view, Message dontResend, Message resend) {
        super.onFormResubmission(view, dontResend, resend);
    }

    @Override
    public void doUpdateVisitedHistory(WebView view, String url, boolean isReload) {
        super.doUpdateVisitedHistory(view, url, isReload);
    }

    @Override
    public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
        super.onReceivedSslError(view, handler, error);
    }

    @Override
    public void onReceivedClientCertRequest(WebView view, ClientCertRequest request) {
        super.onReceivedClientCertRequest(view, request);
    }

    @Override
    public void onReceivedHttpAuthRequest(WebView view, HttpAuthHandler handler, String host, String realm) {
        super.onReceivedHttpAuthRequest(view, handler, host, realm);
    }

    @Override
    public boolean shouldOverrideKeyEvent(WebView view, KeyEvent event) {
        return super.shouldOverrideKeyEvent(view, event);
    }

    @Override
    public void onUnhandledKeyEvent(WebView view, KeyEvent event) {
        super.onUnhandledKeyEvent(view, event);
    }

    @Override
    public void onScaleChanged(WebView view, float oldScale, float newScale) {
        super.onScaleChanged(view, oldScale, newScale);
    }

    @Override
    public void onReceivedLoginRequest(WebView view, String realm, String account, String args) {
        super.onReceivedLoginRequest(view, realm, account, args);
    }

    @Override
    public boolean onRenderProcessGone(WebView view, RenderProcessGoneDetail detail) {
        return super.onRenderProcessGone(view, detail);
    }

    @Override
    public void onSafeBrowsingHit(WebView view, WebResourceRequest request, int threatType, SafeBrowsingResponse callback) {
        super.onSafeBrowsingHit(view, request, threatType, callback);
    }
}
