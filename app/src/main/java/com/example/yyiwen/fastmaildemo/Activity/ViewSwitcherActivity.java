package com.example.yyiwen.fastmaildemo.Activity;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.yyiwen.fastmaildemo.R;
import com.youth.banner.transformer.DepthPageTransformer;

public class ViewSwitcherActivity extends BaseActivity {
    ViewPager vp;


    @Override
    protected void initView() {
        setContentView(R.layout.activity_view_switcher);
        //初始化控件
        vp= (ViewPager) findViewById(R.id.viewPager);
    }

    @Override
    protected void initData() {
        vp.setPageTransformer(true, new DepthPageTransformer());
    }

    @Override
    protected void initListener() {

    }
}
