package com.example.yyiwen.fastmaildemo.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.yyiwen.fastmaildemo.R;

public class SetActivity extends BaseActivity implements View.OnClickListener{

    private ImageView mIv_back;
    private TextView mTitle;
    private LinearLayout ll_back;

    @Override
    protected void initView() {
        setContentView(R.layout.activity_set);
        mIv_back = (ImageView) findViewById(R.id.iv_back);
        mTitle = (TextView) findViewById(R.id.title);
        ll_back= (LinearLayout) findViewById(R.id.ll_back);
    }

    @Override
    protected void initData() {
        mTitle.setText("设置");
    }

    @Override
    protected void initListener() {
        mIv_back.setOnClickListener(this);
        ll_back.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_back:
                finish();
                break;
            case R.id.ll_back:
                finish();
                break;
        }
    }
}
