package com.lsb.myapplicationl;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class IdPasswordActivity extends AppCompatActivity {

    public static final int REQUEST_CODE_MESSEGE = 1000;
    private EditText mIdEditText;
    private EditText mPasswordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_idpassword);

        mIdEditText = (EditText) findViewById(R.id.Id_edit);
        mPasswordEditText = (EditText) findViewById(R.id.password_edit);

        findViewById(R.id.login_button).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(IdPasswordActivity.this,
                        ControlActivity.class);
                String message = ("ID" + String.valueOf(mIdEditText.getText()) + "\n" + "Pw" + String.valueOf(mPasswordEditText.getText()));
                intent.putExtra("login", message);
                startActivityForResult(intent, REQUEST_CODE_MESSEGE);
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE_MESSEGE &&
                resultCode == RESULT_OK &&
                data != null) {
            String a = data.getStringExtra("login");
            Toast.makeText(this, a, Toast.LENGTH_SHORT).show();
        }
    }
}
