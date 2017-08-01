package com.lsb.myapplicationl.fagment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lsb.myapplicationl.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ColorFragment extends Fragment {


    public ColorFragment() {
        // Required empty public constructor
    }


    public static ColorFragment newInstance (int color , String string) {
        Bundle args = new Bundle();
        args.putInt("color", color);
        args.putString("Hello", string);
        ColorFragment fragment = new ColorFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_color, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView text = (TextView) view.findViewById(R.id.fragment_text);

        int color = getArguments().getInt("color");
        String hello = getArguments().getString("Hello");

        text.setText(hello);
        view.setBackgroundColor(color);
    }

}
