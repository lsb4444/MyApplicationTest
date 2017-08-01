package com.lsb.myapplicationl.fagment;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.lsb.myapplicationl.R;

public class ColorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color);
    }

    public void onCreateFragmentButtonClicked(View view) {
        // 새로운 프래그먼트 생성

        switch (view.getId()){
            case R.id.red_fragment_button:
                ColorFragment fragment = ColorFragment.newInstance(Color.RED, "1번 프래그먼트 생성 완료");
                getSupportFragmentManager().beginTransaction().replace(R.id.container_fragment_1,fragment).commit();
                break;
            case R.id.green_fragment_button:
                ColorFragment fragment2 = ColorFragment.newInstance(Color.GREEN, "2번 프래그먼트 생성 완료");
                getSupportFragmentManager().beginTransaction().replace(R.id.container_fragment_2,fragment2).commit();
                break;
            case R.id.blue_fragment_button:
                ColorFragment fragment3 = ColorFragment.newInstance(Color.BLUE, "3번 프래그먼트 생성 완료");
                getSupportFragmentManager().beginTransaction().replace(R.id.container_fragment_3,fragment3).commit();
                break;
        }

    }
}
