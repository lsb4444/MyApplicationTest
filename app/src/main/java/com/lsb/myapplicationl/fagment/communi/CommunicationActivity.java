package com.lsb.myapplicationl.fagment.communi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.lsb.myapplicationl.R;

import static com.lsb.myapplicationl.R.id.container1;

public class CommunicationActivity extends AppCompatActivity implements CommuniFragment.OnChatListener {

    private CommuniFragment mFragmentUp;

    private EditText mEditText;
    private TextView mTextView;
    private String mID = "액티비티 : ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_communication);

        mFragmentUp = (CommuniFragment) getSupportFragmentManager().findFragmentById(container1);

        mEditText = (EditText) findViewById(R.id.activity_edit_text);
        mTextView = (TextView) findViewById(R.id.activity_chat);

    }

    @Override
    public void onChat(String chat) {
        mTextView.setText(mTextView.getText()  + chat);

    }

    public void onButtonClicked(View view) {
        mTextView.setText((String) mTextView.getText() + mID + mEditText.getText() + "\n");
        mFragmentUp.chatchat(mID + mEditText.getText() + "\n");
    }
}
