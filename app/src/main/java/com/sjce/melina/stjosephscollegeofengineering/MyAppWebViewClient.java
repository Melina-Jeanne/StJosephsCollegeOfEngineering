package com.sjce.melina.stjosephscollegeofengineering;

import android.webkit.WebViewClient;

import android.content.Intent;
import android.net.Uri;
import android.webkit.WebView;

public class MyAppWebViewClient extends WebViewClient {
    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        if (Uri.parse(url).getHost().equals("http://stjosephs.ac.in/index.html")) {
            return false;

        }

        return false;
    }
}
