package com.lsb.myapplicationl.adapterview;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.lsb.myapplicationl.R;

import java.util.List;

/**
 * Created by L on 2017/07/26.
 */

public class PositionAdapter extends BaseAdapter {

    private final Context mContext;
    private final List<Place> mData;

    public PositionAdapter(Context context, List<Place> data) {
        mContext = context;
        mData = data;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            // 최초
            convertView = LayoutInflater.from(mContext)
                    .inflate(R.layout.item_exam, parent, false);
            holder = new ViewHolder();

            TextView PlaceView = (TextView) convertView.findViewById(R.id.place_text);

            holder.place = PlaceView;

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Place place = (Place) getItem(position);

        if (position == 0) {
            convertView.setBackgroundColor(Color.BLACK);
        } else if (position % 2 == 0) {
            convertView.setBackgroundColor(Color.BLUE);
        } else {
            convertView.setBackgroundColor(Color.RED);
        }

        holder.place.setText(place.getPlace());
//        convertView.setBackgroundColor(Color.GRAY);
        return convertView;
    }

    private static class ViewHolder {
        TextView place;
    }
}
