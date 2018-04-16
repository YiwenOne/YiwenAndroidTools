package com.example.yyiwen.fastmaildemo.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.yyiwen.fastmaildemo.R;
import com.zaaach.citypicker.CityPickerActivity;

public class ChooseCityActivity extends BaseActivity implements View.OnClickListener {
    private Button btn_choose;
    private TextView tv_city;
    private static final int REQUEST_CODE_PICK_CITY = 233;

    @Override
    protected void initView() {
        setContentView(R.layout.activity_choose_city);
        //初始化控件
        btn_choose= (Button) findViewById(R.id.btn_choose);
        tv_city= (TextView) findViewById(R.id.tv_city);
    }

    @Override
    protected void initData() {

    }


    @Override
    protected void initListener() {
        btn_choose.setOnClickListener(this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==REQUEST_CODE_PICK_CITY&&resultCode==RESULT_OK) {
            if (data != null) {
                String city = data.getStringExtra(CityPickerActivity.KEY_PICKED_CITY);
                tv_city.setText("当前选择的是："+city);
            }
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_choose:
                startActivityForResult(new Intent(ChooseCityActivity.this, CityPickerActivity.class),REQUEST_CODE_PICK_CITY);
                break;
        }
    }
}
