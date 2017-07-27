package com.lsb.myapplicationl;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class CoffeeActivity extends AppCompatActivity {
    public static final int DEFAULT_QUANTITY = 1;
    public static final int PRICE = 3000;

    private int mQuantity = DEFAULT_QUANTITY;

    private TextView mQuantityTextView;
    private TextView mPriceTextView;
    private CheckBox mWippedCreamCheckBox;
    private EditText mNameEditText;
    private DecimalFormat mFormat = new DecimalFormat("#,##0");


    // AppCompatActivity 구글이 제공하는 액티비티가 들어 있는 곳

    // 메인
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 레이아웃 설정   R은 리소스를 의미
        setContentView(R.layout.activity_coffee);

        // XML에 있는 View의 레퍼런스를 가져오는 방법
        mQuantityTextView = (TextView) findViewById(R.id.volume);
        mPriceTextView = (TextView) findViewById(R.id.price);

        mQuantityTextView.setText(String.valueOf(DEFAULT_QUANTITY));
//        mQuantityTextView.setText("" + mQuantity);  이 방법을 많이 쓰긴함 간단하여
        mWippedCreamCheckBox = (CheckBox) findViewById(R.id.whipped_cream_check);
        mNameEditText = (EditText) findViewById(R.id.name_edit);

        display();
    }

    public void minusButtonClicked(View view) {
//        Toast.makeText(this, "잘 눌림", Toast.LENGTH_SHORT).show();
        mQuantity--;
        if (mQuantity < 1) {
            mQuantity = DEFAULT_QUANTITY;
        }
        display();
    }
    public void plusBottonCliced(View view) {
        mQuantity++;
        display();
    }
    public void onCheckBoxClicked(View view) {
        display();
    }

    private void display() {
        mQuantityTextView.setText("" + mQuantity);
        String message = "주문자 : " + mNameEditText.getText().toString();
        message += "\n====================";
        message += "\n휘핑 크림 추가 여부 : " + mWippedCreamCheckBox.isChecked();
        message += "\n갯수 : " + mQuantity;
        message += "\n가격 : " + mFormat.format(mQuantity * PRICE) + "원";

        mPriceTextView.setText(message);
    }

    public void onOderButtonClicked(View view) {

        MmsMessage(mPriceTextView.getText().toString());
    }
    public void MmsMessage(String message) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, message);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}
