package com.lsb.myapplicationl;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ControlActivity extends AppCompatActivity {

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
        String text = ((Button) view).getText().toString();
        intent.putExtra("login", text);

        setResult(RESULT_OK, intent);
        finish();
    }
}
