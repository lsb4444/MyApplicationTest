package com.lsb.myapplicationl;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class ControlActivity extends AppCompatActivity {
    private String mMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control);

        Intent intent = getIntent();
        if (intent != null) {
            String message = intent.getStringExtra("login");
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        }
    }

    public void onButtonClicked(View view) {
        Intent intent = new Intent();
        switch (view.getId()) {
            case R.id.guest_button:
                mMessage = "고객관리";
                intent.putExtra("login", mMessage);
                setResult(RESULT_OK, intent);
                break;
            case R.id.sales_button:
                mMessage = "매출관리";
                intent.putExtra("login", mMessage);
                setResult(RESULT_OK, intent);
                break;
            case R.id.product_button:
                mMessage = "상품관리";
                intent.putExtra("login", mMessage);
                setResult(RESULT_OK, intent);
                break;
        }
        finish();
    }
}
