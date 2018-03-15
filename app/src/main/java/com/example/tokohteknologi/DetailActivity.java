package com.example.tokohteknologi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        WebView webView = findViewById(R.id.web_detail);
        webView.loadUrl(getIntent().getStringExtra("LINK"));
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                getSupportActionBar().setTitle(view.getTitle());
                getSupportActionBar().setSubtitle(view.getUrl());
            }
        });
    }
}
