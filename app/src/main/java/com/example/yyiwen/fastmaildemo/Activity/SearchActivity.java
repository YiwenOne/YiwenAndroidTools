package com.example.yyiwen.fastmaildemo.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.view.View;

import com.example.yyiwen.fastmaildemo.R;
import com.example.yyiwen.fastmaildemo.View.ClearEditText;

public class SearchActivity extends BaseActivity implements View.OnClickListener{
    SearchView searchView;
    ClearEditText clearEditText;
    View ll_left;


    @Override
    protected void initView() {
        setContentView(R.layout.activity_search);
        ll_left=findViewById(R.id.ll_left);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {
        ll_left.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ll_left:
                finish();
                break;
        }
    }
}
