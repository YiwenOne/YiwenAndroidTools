package com.example.yyiwen.fastmaildemo.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.yyiwen.fastmaildemo.R;

public class BrandScreenActivity extends AppCompatActivity implements View.OnClickListener{
    private ImageView mIv_back;
    private TextView mTitle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_brand_screen);
        mIv_back = (ImageView) findViewById(R.id.iv_back);
        mTitle = (TextView) findViewById(R.id.title);
        //初始化数据
        initData();
        //初始化点击事件
        initListener();
    }

    private void initData() {
        //设置标题
        mTitle.setText("选择品牌");
    }
    private void initListener() {
        mIv_back.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_back:
                 finish();
                break;
        }
    }
}
