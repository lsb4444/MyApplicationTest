package com.lsb.myapplicationl;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class SbAdapterviewExamActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sb_adapterview_exam);


        ListView listView = (ListView)findViewById(R.id.list_view2);

        ArrayList<String> data = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            data.add("포지션 " + i);
        }

        ArrayAdapter<String> adapter_list = new ArrayAdapter<String>(SbAdapterviewExamActivity.this,
                android.R.layout.simple_list_item_1,data );

        listView.setAdapter(adapter_list);
    }
}