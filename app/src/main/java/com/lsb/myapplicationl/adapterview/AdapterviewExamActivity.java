package com.lsb.myapplicationl.adapterview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.lsb.myapplicationl.R;

import java.util.ArrayList;

public class AdapterviewExamActivity extends AppCompatActivity {

    private ArrayList<Place> mData;
    private PositionAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adapterview_exam);

        ListView listView = (ListView) findViewById(R.id.list_view);

        mData = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Place position = new Place("포지션" + i );
            mData.add(position);
        }


        mAdapter = new PositionAdapter(AdapterviewExamActivity.this, mData);

        listView.setAdapter(mAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Place place = (Place) parent.getAdapter().getItem(position);

                Intent intent = new Intent(AdapterviewExamActivity.this, AddPlaceActivity.class);
                intent.putExtra("lalal",place.getPlace());
                startActivity(intent);
            }
        });
        registerForContextMenu(listView);

        listView.setOnLongClickListener(new View.OnLongClickListener() {

            @Override
            public boolean onLongClick(View v) {

                return false;
            }

        });
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_place, menu);
    }
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch (item.getItemId()) {
            case R.id.action_add2:
                //삭제
                mData.remove(info.position);
                // 업데이트
                mAdapter.notifyDataSetInvalidated();

                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }

}
