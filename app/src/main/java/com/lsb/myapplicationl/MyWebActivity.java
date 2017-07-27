package com.lsb.myapplicationl;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;

public class MyWebActivity extends AppCompatActivity {

    private EditText mUrlEdit;
    private WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_web);

        mUrlEdit = (EditText) findViewById(R.id.Url_Edit);
        mWebView = (WebView) findViewById(R.id.web_page_view);

        mWebView.setWebViewClient(new WebViewClient());
        mWebView.getSettings().setJavaScriptEnabled(true);
    }

    public void onButtonClicked(View view) {
        switch (view.getId()) {
            case R.id.Back_Button:
                mWebView.goBack();
                break;
            case R.id.Front_Button:
                mWebView.goForward();
                break;
            case R.id.go_Button:
                String url = mUrlEdit.getText().toString();
                String url_check = mUrlEdit.getText().toString();
                url_check = url_check.toLowerCase();
                if (!(url_check.startsWith("http://")||!(url_check.startsWith("https://")))) {
                    url = "http://" + url;
                }
                mWebView.loadUrl(url);

                break;
            case R.id.Refresh_Button:
                mWebView.reload();
                break;
        }
    }

    @Override
    public void onBackPressed() {
        if (mWebView.canGoBack()) {
            mWebView.goBack();
        } else {
            super.onBackPressed();
        }
    }
}
