package com.example.yyiwen.fastmaildemo.Fragment;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.LocationListener;
import com.example.yyiwen.fastmaildemo.Activity.BrandScreenActivity;
import com.example.yyiwen.fastmaildemo.Activity.MainActivity;
import com.example.yyiwen.fastmaildemo.Activity.SearchActivity;
import com.example.yyiwen.fastmaildemo.Bean.LocationInfo;
import com.example.yyiwen.fastmaildemo.R;
import com.example.yyiwen.fastmaildemo.Utils.CommonUtil;
import com.example.yyiwen.fastmaildemo.Utils.UIUtils;
import com.example.yyiwen.fastmaildemo.Utils.VolleyUtil;
import com.example.yyiwen.fastmaildemo.View.BMapApiDemoApp;
import com.example.yyiwen.fastmaildemo.View.MyToast;

import java.util.List;


public class NearFragment extends Fragment implements View.OnClickListener {
    private com.example.yyiwen.fastmaildemo.View.CircleImageView mIv_head_iamge;
    private TextView mTv_title;
    private ImageView mIv_tag;
    private ImageView mIv_map;
    private LinearLayout ll_title;
    private TextView tv_location;
    PopupWindow popupWindow;
    private String provider;//位置提供器
    private LocationManager locationManager;//位置服务
    private String location_context;
    private Location location;
    private LinearLayout ll_location;
    private TextView tv_show;
    BMapApiDemoApp app;
    StringBuilder sb;
    List<String> providers;
    LocationListener mLocationListener = null;//create时注册此listener，Destroy时需要Remove
    LocationInfo locationInfo;
    List<LocationInfo> locationData;
    Intent intent;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_near, container, false);
        //初始化
        mIv_head_iamge = (com.example.yyiwen.fastmaildemo.View.CircleImageView) view.findViewById(R.id.iv_head_iamge);
        mTv_title = (TextView) view.findViewById(R.id.tv_title);
        mIv_tag = (ImageView) view.findViewById(R.id.iv_tag);
        mIv_map = (ImageView) view.findViewById(R.id.iv_map);
        tv_show = (TextView) view.findViewById(R.id.tv_location);
        ll_title = (LinearLayout) view.findViewById(R.id.ll_title);
        ll_location = (LinearLayout) view.findViewById(R.id.ll_location);
        tv_location = (TextView) view.findViewById(R.id.tv_location);
        //初始化数据
        initData();
        //初始化点击事件
        initListener();
        //获取地理位置
        getLocation();
        return view;
    }

    private void initData() {
        //改变标题
        mTv_title.setText("品牌筛选");
        //改变图标
        mIv_map.setImageResource(R.drawable.search_white);
        //POPWINDOW
        popupWindow = new PopupWindow();
        //获取
        location_context = Context.LOCATION_SERVICE;
        //获取位置服务
        locationManager = (LocationManager) getActivity().getSystemService(location_context);
//        app = (BMapApiDemoApp)getActivity().getApplication();
//        if (app.mBMapMan == null) {
//            app.mBMapMan = new BMapManager(getActivity().getApplication());
//            app.mBMapMan.init(app.mStrKey, new BMapApiDemoApp.MyGeneralListener());
//        }
//        app.mBMapMan.start();
        // 注册定位事件
//        mLocationListener = new LocationListener(){
//
//            @Override
//            public void onLocationChanged(Location location) {
//                if(location != null){
//                    String strLog = String.format("您当前的位置:\r\n" +
//                                    "纬度:%f\r\n" +
//                                    "经度:%f",
//                            location.getLongitude(), location.getLatitude());
//                    tv_location.setText(strLog);
//                }
//            }
//        };
    }

    private void initListener() {
        ll_title.setOnClickListener(this);
        ll_location.setOnClickListener(this);
        mIv_map.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ll_title:
                intent = new Intent(getActivity(), BrandScreenActivity.class);
                startActivity(intent);
                break;
            case R.id.ll_location:
                //开启定位功能
                getLocation();
                break;
            case R.id.iv_map:
                intent = new Intent(getActivity(), SearchActivity.class);
                startActivity(intent);
                break;
        }
    }

    private void getLocation() {
        sb = new StringBuilder("111111");
        provider = judgeProvider(locationManager);
        if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        location = locationManager.getLastKnownLocation(provider);
        String latLongString;
//        if(location!=null){
//            double lat=location.getLatitude();
//            double lng=location.getLongitude();
//            latLongString="Lat:"+lat+"\nLong"+lng;
//            getLocationData(location);//得到当前经纬度并开启线程去反向地理编码
//        }else {
//            latLongString="NO locaton found";
//        }
        String placename1 = "";
        String placename2 = "";
        if (location != null) {
            double lat = location.getLatitude();
            double lng = location.getLongitude();

            Geocoder geocoder=new Geocoder(getContext());
//                        Geocoder geocoder = new Geocoder(this, Locale.CHINA);
            List places = null;

            try {
//                                Thread.sleep(2000);
                places = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 5);
//                                Thread.sleep(2000);
//                Toast toast=Toast.makeText(getContext(), places.size()+"", Toast.LENGTH_LONG);
//                int offsetX=0;
//                int offsetY=0;
//                toast.setGravity(Gravity.TOP,offsetX,offsetY);
//
//                toast.show();
                Toast.makeText(getContext(), places.size()+"", Toast.LENGTH_LONG).show();
//                UIUtils.showToastSafe(places.size()+"");

                showToast("没有可用的位置提供器");
                System.out.println(places.size()+"");
            } catch (Exception e) {
                e.printStackTrace();
            }


            if (places != null && places.size() > 0) {
                // placename=((Address)places.get(0)).getLocality();
                //一下的信息将会具体到某条街
                //其中getAddressLine(0)表示国家，getAddressLine(1)表示精确到某个区，getAddressLine(2)表示精确到具体的街
                placename1 = ((Address) places.get(0)).getAddressLine(0) + ", " + System.getProperty("line.separator")
                        + ((Address) places.get(0)).getAddressLine(1) + ", "
                        + ((Address) places.get(0)).getAddressLine(2);
                placename2 =((Address) places.get(0)).getAddressLine(1) + ", "
                        + ((Address) places.get(0)).getAddressLine(2);

            }

            latLongString = "纬度:" + lat + "\n经度:" + lng;
//            Toast.makeText(getContext(), placename1, Toast.LENGTH_LONG).show();
        } else {
            latLongString = "无法获取地理信息";
        }
//        tv_show.setText("当前位置"+placename1);
        tv_show.setText("当前位置:"+placename2);
    }

//    @Override
//    public void onPause() {
//        BMapApiDemoApp app = (BMapApiDemoApp)getActivity().getApplication();
//        // 移除listener
//        app.mBMapMan.getLocationManager().removeUpdates(mLocationListener);
//        app.mBMapMan.stop();
//        super.onPause();
//    }
//    @Override
//    public void onResume() {
//        BMapApiDemoApp app = (BMapApiDemoApp)getActivity().getApplication();
//        // 注册Listener
//        app.mBMapMan.getLocationManager().requestLocationUpdates(mLocationListener);
//        app.mBMapMan.start();
//        super.onResume();
//    }
    /**
     * 判断是否有可用的内容提供器
     * @return 不存在返回null
     */
    private String judgeProvider(LocationManager locationManager) {
        List<String> prodiverlist = locationManager.getProviders(true);
        if(prodiverlist.contains(LocationManager.NETWORK_PROVIDER)){
            return LocationManager.NETWORK_PROVIDER;
        }else if(prodiverlist.contains(LocationManager.GPS_PROVIDER)) {
            return LocationManager.GPS_PROVIDER;
        }else{
            Toast.makeText(getContext(),"没有可用的位置提供器",Toast.LENGTH_SHORT).show();
        }
        return null;
    }
    private void showToast(String str){
        MyToast.makeshow(getActivity(), str + "", Toast.LENGTH_LONG);
    }
}
