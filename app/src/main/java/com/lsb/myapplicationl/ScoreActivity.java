package com.lsb.myapplicationl;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ScoreActivity extends AppCompatActivity {
    public static final int THREEPOINT = 3;
    public static final int TWOPOINT = 2;
    public static final int POINT = 1;
    public static final int STARTSCORE = 0;
    public int mStartScoreA = 0;
    public int mStartScoreB = 0;
    private TextView mTeamA_View;
    private TextView mTeamB_View;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        mTeamA_View = (TextView) findViewById(R.id.TeamA_Score_View);
        mTeamB_View = (TextView) findViewById(R.id.TeamB_Score_View);
    }

    public void TeamA3PointsButtonClicked(View view) {
        mStartScoreA = mStartScoreA + THREEPOINT;
        mTeamA_View.setText("" + mStartScoreA);
    }

    public void TeamA2PointsButtonClicked(View view) {
        mStartScoreA = mStartScoreA + TWOPOINT;
        mTeamA_View.setText("" + mStartScoreA);
    }

    public void TeamA1PointsButtonClicked(View view) {
        mStartScoreA = mStartScoreA + POINT;
        mTeamA_View.setText("" + mStartScoreA);
    }

    public void TeamB3PointsButtonClicked(View view) {
        mStartScoreB = mStartScoreB + THREEPOINT;
        mTeamB_View.setText("" + mStartScoreB);
    }

    public void TeamB2PointsButtonClicked(View view) {
        mStartScoreB = mStartScoreB + TWOPOINT;
        mTeamB_View.setText("" + mStartScoreB);
    }

    public void TeamB1PointsButtonClicked(View view) {
        mStartScoreB = mStartScoreB + POINT;
        mTeamB_View.setText("" + mStartScoreB);
    }

    public void ResetClicked(View view) {
        mStartScoreA = STARTSCORE;
        mStartScoreB = STARTSCORE;
        mTeamA_View.setText("" + mStartScoreA);
        mTeamB_View.setText("" + mStartScoreB);
    }
}
