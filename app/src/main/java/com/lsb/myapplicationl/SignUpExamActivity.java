package com.lsb.myapplicationl;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import static com.lsb.myapplicationl.IdPasswordActivity.REQUEST_CODE_MESSEGE;

public class SignUpExamActivity extends AppCompatActivity {

    public static final int REQUEST_CODE_SIGNUP = 1000;
    private EditText mIdEditText;
    private EditText mPasswordEditText;
    private EditText mPassword2EditText;
    private EditText mEmailEditText;
    private RadioGroup mGender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_exam);

        mIdEditText = (EditText) findViewById(R.id.id_Edit_Text);
        mPasswordEditText = (EditText) findViewById(R.id.password_edit_Text);
        mPassword2EditText = (EditText) findViewById(R.id.password_edit_Text2);
        mEmailEditText = (EditText) findViewById(R.id.Email_Edit_Text);
        mGender = (RadioGroup) findViewById(R.id.gender_radio);


    }


    public void onButtonClicked(View view) {
        int id = mGender.getCheckedRadioButtonId();
        RadioButton Gender_Radio = (RadioButton) findViewById(id);

        switch (view.getId()) {
            case R.id.Reset_Button:
                Reset();
                break;
            case R.id.Signup_Button:
                if (!isaInputCheck() && isPasswordCheck()) {
                    Intent intent = new Intent(SignUpExamActivity.this, SignUpExam2Activity.class);
                    intent.putExtra("ID", mIdEditText.getText().toString());
                    intent.putExtra("PASSWORD", mPasswordEditText.getText().toString());
                    intent.putExtra("EMAIL", mEmailEditText.getText().toString());
                    intent.putExtra("ID", mIdEditText.getText().toString());
                    intent.putExtra("GENDER", Gender_Radio.getText().toString());
                    startActivityForResult(intent, REQUEST_CODE_SIGNUP);
                } else if (isaInputCheck()) {
                    Toast.makeText(this, "모두 입력 해 주셔야 합니다.", Toast.LENGTH_SHORT).show();
                } else if (!isPasswordCheck()) {
                    Toast.makeText(this, "비밀번호가 다릅니다.", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    private boolean isPasswordCheck() {
        return mPasswordEditText.getText().toString().equals(mPassword2EditText.getText().toString());
    }

    private boolean isaInputCheck() {
        return mIdEditText.getText().toString().equals("") && mPasswordEditText.getText().toString().equals("") &&
                mPassword2EditText.getText().toString().equals("") && mEmailEditText.getText().toString().equals("");
    }

    private void Reset() {
        mIdEditText.setText("");
        mPasswordEditText.setText("");
        mPassword2EditText.setText("");
        mEmailEditText.setText("");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_MESSEGE &&
                resultCode == RESULT_OK) {
            String text = data.getStringExtra("확인 버튼을 실행 하셨습니다.");
            Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
        }
    }
}
