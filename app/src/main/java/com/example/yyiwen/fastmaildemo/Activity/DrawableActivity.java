package com.example.yyiwen.fastmaildemo.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.yyiwen.fastmaildemo.R;
import com.example.yyiwen.fastmaildemo.View.WritingBoardView;

public class DrawableActivity extends AppCompatActivity {
    protected static final int STATUS_SMOOTING=0;
    protected static final int STATUS_STOP=1;
    protected int mWidth,mHeight;
    protected int mSoothMarginTop;
    protected int mStatus=STATUS_STOP;
    protected int mDuration=500;
    protected int mRepeatimes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawable);
    }

}
