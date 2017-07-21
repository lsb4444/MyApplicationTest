package com.lsb.myapplicationl;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class ActivityMoveActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move);
        View.OnClickListener listener = new MyClickListner();
        View.OnClickListener listener2 = new MyClickListner2();


        Button button =  (Button) findViewById(R.id.button);
        button.setOnClickListener(listener);

        Button button2 =  (Button) findViewById(R.id.button2);
        button2.setOnClickListener(listener2);

    }
    class MyClickListner implements View.OnClickListener {

        @Override
        public void onClick(View view) {

        }
    }
    class MyClickListner2 implements View.OnClickListener {

        @Override
        public void onClick(View view) {

        }
    }
}
