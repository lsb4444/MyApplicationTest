package com.lsb.myapplicationl.fagment.communi;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.lsb.myapplicationl.R;

import static com.lsb.myapplicationl.R.id.fragment_button;

/**
 * A simple {@link Fragment} subclass.
 */
public class CommuniFragment extends Fragment implements View.OnClickListener {

    private OnChatListener mListener;

    public interface OnChatListener {
        void onChat(String chat);
    }

    private EditText mEditText;
    private TextView mTextColor;
    private TextView mChatText;
    private String mID =  "프라그멘트 : ";


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mListener = (OnChatListener) context;
    }

    public CommuniFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_communi, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mEditText = (EditText) view.findViewById(R.id.fragment_edit_text);
        mTextColor = (TextView) view.findViewById(R.id.fragment_color_text);
        mChatText = (TextView) view.findViewById(R.id.chat_text);
        view.findViewById(R.id.fragment_button).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case fragment_button:
                mChatText.setText((String) mChatText.getText() + mID + mEditText.getText() + "\n");
                mListener.onChat(mID + mEditText.getText() + "\n");
        }
    }

    public void chatchat(String c) {
        mChatText.setText(mChatText.getText() + c);
    }
}
