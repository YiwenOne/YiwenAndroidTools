package com.example.yyiwen.fastmaildemo.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.example.yyiwen.fastmaildemo.R;
import com.example.yyiwen.fastmaildemo.Utils.LocationUtils;

public class GaodeMapActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener,
        View.OnClickListener,
        CompoundButton.OnCheckedChangeListener{
    private Button btn_check;
    private TextView tv_result;
    private RadioGroup rgLocationMode;
    private EditText etInterval;
    private EditText etHttpTimeout;
    private CheckBox cbOnceLocation;
    private CheckBox cbAddress;
    private CheckBox cbGpsFirst;
    private CheckBox cbCacheAble;
    private CheckBox cbOnceLastest;
    private CheckBox cbSensorAble;
    private AMapLocationClient locationClient=null;
    private AMapLocationClientOption locationOption=new AMapLocationClientOption();
    @Override
    protected void initView() {
        setContentView(R.layout.activity_gaode_map);
        //初始化控件
        btn_check= (Button) findViewById(R.id.btn_check);
        tv_result= (TextView) findViewById(R.id.tv_result);
        rgLocationMode = (RadioGroup) findViewById(R.id.rg_locationMode);

        etInterval = (EditText) findViewById(R.id.et_interval);
        etHttpTimeout = (EditText) findViewById(R.id.et_httpTimeout);

        cbOnceLocation = (CheckBox)findViewById(R.id.cb_onceLocation);
        cbGpsFirst = (CheckBox) findViewById(R.id.cb_gpsFirst);
        cbAddress = (CheckBox) findViewById(R.id.cb_needAddress);
        cbCacheAble = (CheckBox) findViewById(R.id.cb_cacheAble);
        cbOnceLastest = (CheckBox) findViewById(R.id.cb_onceLastest);
        cbSensorAble = (CheckBox)findViewById(R.id.cb_sensorAble);
    }
    @Override
    protected void initData() {
        setTitle("定位");
        //初始化定位
        initLocation();
    }

    private void initLocation() {
        //初始化client
        locationClient=new AMapLocationClient(this.getApplication());
        //设置定位参数
        locationClient.setLocationOption(getDefaultOption());
        //设置定位监听
        locationClient.setLocationListener(locationListener);
    }

    /**
     * 定位参数
     * @return
     */
    private AMapLocationClientOption getDefaultOption(){
        AMapLocationClientOption option=new AMapLocationClientOption();
        //设置定位模式，可选的模式有高精度、仅设备、仅网络。默认为高精度模式
        option.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
        //设置是否gps优先，只在高精度模式下有效。默认关闭
        option.setGpsFirst(true);
        //可选，设置网络请求超时时间。默认为30秒。在仅设备模式下无效
        option.setHttpTimeOut(30000);
        //可选，设置定位间隔。默认为2秒
        option.setInterval(2000);
        //可选，设置是否返回逆地理地址信息。默认是true
        option.setNeedAddress(true);
        //可选，设置是否单次定位。默认是false
        option.setOnceLocation(false);
        //可选，设置是否等待wifi刷新，默认为false.如果设置为true,会自动变为单次定位，持续定位时不要使用
        option.setOnceLocationLatest(false);
        //可选， 设置网络请求的协议。可选HTTP或者HTTPS。默认为HTTP
        AMapLocationClientOption.setLocationProtocol(AMapLocationClientOption.AMapLocationProtocol.HTTP);
        //可选，设置是否使用传感器。默认是false
        option.setSensorEnable(false);
        //可选，设置是否开启wifi扫描。默认为true，如果设置为false会同时停止主动刷新，停止以后完全依赖于系统刷新，定位位置可能存在误差
        option.setWifiScan(true);
        return option;
    }
    AMapLocationListener locationListener=new AMapLocationListener() {
        @Override
        public void onLocationChanged(AMapLocation aMapLocation) {
            if(aMapLocation!=null){
                String result= LocationUtils.getLocationStr(aMapLocation);
                tv_result.setText(result);
            }else {
                tv_result.setText("定位失败");
            }
        }
    };
    @Override
    protected void initListener() {
        btn_check.setOnClickListener(this);
        rgLocationMode.setOnCheckedChangeListener(this);
        cbAddress.setOnCheckedChangeListener(this);
        cbCacheAble.setOnCheckedChangeListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_check:
                if(btn_check.getText().equals("开始定位")){
                    btn_check.setText("停止定位");
                    setViewEnable(false);
                    btn_check.setText(getResources().getString(
                            R.string.stopLocation));
                    tv_result.setText("正在定位...");
                    startLocation();
                }else {
                    setViewEnable(true);
                    btn_check.setText(getResources().getString(
                            R.string.startLocation));
                    stopLocation();
                    tv_result.setText("定位停止");
                }
                break;
        }
    }
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        if (null == locationOption) {
            locationOption = new AMapLocationClientOption();
        }
        switch (checkedId) {
            case R.id.rb_batterySaving :
                locationOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Battery_Saving);
                break;
            case R.id.rb_deviceSensors :
                locationOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Device_Sensors);
                break;
            case R.id.rb_hightAccuracy :
                locationOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
                break;
            default :
                break;
        }
    }
    /**
     * 设置控件的可用状态
     */
    private void setViewEnable(boolean isEnable) {
        for(int i=0; i<rgLocationMode.getChildCount(); i++){
            rgLocationMode.getChildAt(i).setEnabled(isEnable);
        }
        etInterval.setEnabled(isEnable);
        etHttpTimeout.setEnabled(isEnable);
        cbOnceLocation.setEnabled(isEnable);
        cbGpsFirst.setEnabled(isEnable);
        cbAddress.setEnabled(isEnable);
        cbCacheAble.setEnabled(isEnable);
        cbOnceLastest.setEnabled(isEnable);
        cbSensorAble.setEnabled(isEnable);
    }
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if(null == locationOption){
            locationOption = new AMapLocationClientOption();
        }
        switch (buttonView.getId()) {
            case R.id.cb_needAddress :
                if(null != locationOption){
                    locationOption.setNeedAddress(isChecked);
                }
                break;
            case R.id.cb_cacheAble :
                if(null != locationOption){
                    locationOption.setLocationCacheEnable(isChecked);
                }
                break;
            default :
                break;
        }
        if(null != locationClient){
            locationClient.setLocationOption(locationOption);
        }
    }

    /**
     * 重置定位参数
     */
    private void resetOption() {
        // 设置是否需要显示地址信息
        locationOption.setNeedAddress(cbAddress.isChecked());
        /**
         * 设置是否优先返回GPS定位结果，如果30秒内GPS没有返回定位结果则进行网络定位
         * 注意：只有在高精度模式下的单次定位有效，其他方式无效
         */
        locationOption.setGpsFirst(cbGpsFirst.isChecked());
        // 设置是否开启缓存
        locationOption.setLocationCacheEnable(cbCacheAble.isChecked());
        //设置是否等待设备wifi刷新，如果设置为true,会自动变为单次定位，持续定位时不要使用
        locationOption.setOnceLocationLatest(cbOnceLastest.isChecked());
        //设置是否使用传感器
        locationOption.setSensorEnable(cbSensorAble.isChecked());
        //设置是否开启wifi扫描，如果设置为false时同时会停止主动刷新，停止以后完全依赖于系统刷新，定位位置可能存在误差
        String strInterval = etInterval.getText().toString();
        if (!TextUtils.isEmpty(strInterval)) {
            try{
                // 设置发送定位请求的时间间隔,最小值为1000，如果小于1000，按照1000算
                locationOption.setInterval(Long.valueOf(strInterval));
            }catch(Throwable e){
                e.printStackTrace();
            }
        }

        String strTimeout = etHttpTimeout.getText().toString();
        if(!TextUtils.isEmpty(strTimeout)){
            try{
                // 设置网络请求超时时间
                locationOption.setHttpTimeOut(Long.valueOf(strTimeout));
            }catch(Throwable e){
                e.printStackTrace();
            }
        }
    }
    /**
     * 开始定位
     */
    private void startLocation(){
        //根据控件的选择，重新设置定位参数
        resetOption();
        // 设置定位参数
        locationClient.setLocationOption(locationOption);
        // 启动定位
        locationClient.startLocation();
    }
    /**
     * 停止定位
     */
    private void stopLocation(){
        locationClient.stopLocation();
    }
    /**
     * 毁灭定位
     */
    private void destroyLocation() {
        if (null != locationClient) {
            /**
             * 如果AMapLocationClient是在当前Activity实例化的，
             * 在Activity的onDestroy中一定要执行AMapLocationClient的onDestroy
             */
            locationClient.onDestroy();
            locationClient = null;
            locationOption = null;
        }
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        destroyLocation();
    }
}
