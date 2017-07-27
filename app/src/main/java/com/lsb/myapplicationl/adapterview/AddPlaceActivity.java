package com.lsb.myapplicationl.adapterview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.lsb.myapplicationl.R;

public class AddPlaceActivity extends AppCompatActivity {

    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_place);

        mTextView = (TextView) findViewById(R.id.lalala_text);

    Intent intent = getIntent();
    if (intent !=null) {
        String place = intent.getStringExtra("lalal");

        mTextView.setText(place);
    }


    }

}
