package com.lsb.myapplicationl;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class CoffeeActivity extends AppCompatActivity {
    private TextView mQuantityTextView;
    private int mQuantity = 1;
    private TextView mPriceTextView;
    private int mPrice =0;


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

        mQuantityTextView.setText(String.valueOf(mQuantity));
//        mQuantityTextView.setText("" + mQuantity);  이 방법을 많이 쓰긴함 간단하여
    }

    public void minusButtonClicked(View view) {
//        Toast.makeText(this, "잘 눌림", Toast.LENGTH_SHORT).show();
        if (mQuantity > 1) {
            mQuantity--;
            mPrice = mPrice - 3000;
        } else {
            mQuantity = 1;
            mPrice = 3000;
        }
        mQuantityTextView.setText("" + mQuantity );
        mPriceTextView.setText("" + mPrice+ "원");
    }



    public void plusBottonCliced(View view) {
        mQuantity++;
        mPrice = mPrice + 3000;
        mPriceTextView.setText("" + mPrice+ "원");
        mQuantityTextView.setText("" + mQuantity );
    }


}
