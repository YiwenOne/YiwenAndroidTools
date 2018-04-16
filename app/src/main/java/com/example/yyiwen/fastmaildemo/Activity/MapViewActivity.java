package com.example.yyiwen.fastmaildemo.Activity;

import android.location.LocationManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

import com.baidu.mapapi.MapController;
import com.baidu.mapapi.MapView;
import com.example.yyiwen.fastmaildemo.R;

public class MapViewActivity extends BaseActivity implements View.OnClickListener{
    MapView mapView;
    TextView tv_location;
    MapController mapController;
    Button btn_1,btn_2;
    LocationManager locationManager;
    @Override
    protected void initData() {
        //获得地图的控制器
        mapController=mapView.getController();
        //配置地图显示选项
        mapView.setSatellite(true);
        mapView.setStreetView(true);
        mapView.displayZoomControls(false);
        //放大地图
        mapController.setZoom(10);


    }

    @Override
    protected void initView() {
        setContentView(R.layout.activity_map_view);
        mapView= (MapView) findViewById(R.id.mapView);
        tv_location= (TextView) findViewById(R.id.tv_location);
        btn_1= (Button) findViewById(R.id.btn_1);
        btn_2= (Button) findViewById(R.id.btn_2);

    }

    @Override
    protected void initListener() {
        btn_1.setOnClickListener(this);
        btn_2.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btn_1:
                mapController.setZoom(15);
                break;
            case R.id.btn_2:
                mapController.setZoom(5);
                break;
        }
    }
}
