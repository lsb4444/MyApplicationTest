package com.lsb.myapplicationl;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class SignUpExam2Activity extends AppCompatActivity {

    private TextView mSuccesId;
    private TextView mPassword;
    private TextView mEmail;
    private TextView mGender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_exam2);

        mSuccesId = (TextView) findViewById(R.id.Succes_Id_Text);
        mPassword = (TextView) findViewById(R.id.Succes_Password_Text);
        mEmail = (TextView) findViewById(R.id.Succes_Email_Text);
        mGender = (TextView) findViewById(R.id.Succes_Gender_Text);

        Intent intent = getIntent();
        if (intent != null) {
            mSuccesId.setText(intent.getStringExtra("ID"));
            mPassword .setText(intent.getStringExtra("PASSWORD"));
            mEmail.setText(intent.getStringExtra("EMAIL"));
            mGender.setText(intent.getStringExtra("GENDER"));
        }
    }

    public void onButtonClicked(View view) {
        setResult(RESULT_OK);
        finish();
    }
}

