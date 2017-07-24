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
                char first = mUrlEdit.getText().charAt(1);
                String url = mUrlEdit.getText().toString();
                if (first == 'w') {
                    url = "http://" + url;
                }
                mWebView.loadUrl(url);

                mWebView.setWebViewClient(new WebViewClient());
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
