package com.example.yyiwen.fastmaildemo.Activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.PersistableBundle;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.amap.api.maps.AMap;
import com.amap.api.maps.MapView;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.route.BusRouteResult;
import com.amap.api.services.route.DrivePath;
import com.amap.api.services.route.DriveRouteResult;
import com.amap.api.services.route.RidePath;
import com.amap.api.services.route.RideRouteResult;
import com.amap.api.services.route.RouteSearch;
import com.amap.api.services.route.WalkPath;
import com.amap.api.services.route.WalkRouteResult;
import com.example.yyiwen.fastmaildemo.Adapter.BusResultListAdapter;
import com.example.yyiwen.fastmaildemo.R;
import com.example.yyiwen.fastmaildemo.Utils.AMapUtil;
import com.example.yyiwen.fastmaildemo.Utils.ToastUtil;
import com.example.yyiwen.fastmaildemo.Utils.UIUtils;
import com.example.yyiwen.fastmaildemo.Overlay.DrivingRouteOverlay;
import com.example.yyiwen.fastmaildemo.Overlay.RideRouteOverlay;
import com.example.yyiwen.fastmaildemo.Overlay.WalkRouteOverlay;

public class NavigationActivity extends BaseActivity implements AMap.OnMapClickListener,
        AMap.OnMarkerClickListener, AMap.OnInfoWindowClickListener, AMap.InfoWindowAdapter, RouteSearch.OnRouteSearchListener,View.OnClickListener {
    private AMap aMap;
    private MapView mapView;
    private Context mContext;
    private RouteSearch mRouteSearch;
    private BusRouteResult mBusRouteResult;
    private DriveRouteResult mDriveRouteResult;
    private RideRouteResult mRideRouteResult;
    private WalkRouteResult mWalkRouteResult;
    private LatLonPoint mStartPoint = new LatLonPoint(39.942295,116.335891);//起点，39.942295,116.335891
    private LatLonPoint mEndPoint = new LatLonPoint(39.995576,116.481288);//终点，39.995576,116.481288
    private final int ROUTE_TYPE_BUS = 1;
    private final int ROUTE_TYPE_DRIVE = 2;
    private final int ROUTE_TYPE_WALK = 3;
    private final int ROUTE_TYPE_RIDE = 4;
    private String mCurrentCityName = "北京";
    private RelativeLayout mBottomLayout, mHeadLayout,rl_drive,rl_bus,rl_walk,rl_crosstownBus;
    private LinearLayout mBusResultLayout;
    private ListView mBusResultList;
    private TextView mRotueTimeDes, mRouteDetailDes;
    private ProgressDialog progDialog = null;// 搜索时进度条
    private ImageView mBus;
    private ImageView mDrive;
    private ImageView mWalk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        //初始化组件
        mContext = this.getApplicationContext();
        mapView = (MapView) findViewById(R.id.route_map);
        mapView.onCreate(savedInstanceState);// 此方法必须重写
        init();
        rl_drive = (RelativeLayout) findViewById(R.id.rl_drive);
        rl_bus = (RelativeLayout) findViewById(R.id.rl_bus);
        rl_walk = (RelativeLayout) findViewById(R.id.rl_walk);
        rl_crosstownBus = (RelativeLayout) findViewById(R.id.rl_crosstownBus);
        rl_drive.setOnClickListener(this);
        rl_bus.setOnClickListener(this);
        rl_walk.setOnClickListener(this);
        rl_crosstownBus.setOnClickListener(this);
        setfromandtoMarker();
        searchRouteResult(ROUTE_TYPE_RIDE, RouteSearch.RidingDefault);
    }

    private void setfromandtoMarker() {
        aMap.addMarker(new MarkerOptions()
                .position(AMapUtil.convertToLatLng(mStartPoint))
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.start)));
        aMap.addMarker(new MarkerOptions()
                .position(AMapUtil.convertToLatLng(mEndPoint))
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.end)));
    }
    /**
     * 初始化AMap对象
     */
    private void init() {
        if (aMap == null) {
            aMap = mapView.getMap();
        }
        registerListener();
        mRouteSearch = new RouteSearch(this);
        mRouteSearch.setRouteSearchListener(this);
        mBottomLayout = (RelativeLayout) findViewById(R.id.bottom_layout);
        mHeadLayout = (RelativeLayout) findViewById(R.id.routemap_header);
//        mHeadLayout.setVisibility(View.GONE);
        mRotueTimeDes = (TextView) findViewById(R.id.firstline);
        mRouteDetailDes = (TextView) findViewById(R.id.secondline);
        mDrive = (ImageView)findViewById(R.id.route_drive);
        mBus = (ImageView)findViewById(R.id.route_bus);
        mWalk = (ImageView)findViewById(R.id.route_walk);
    }
    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {

    }
    /**
     * 注册监听
     */
    private void registerListener() {
        aMap.setOnMapClickListener(NavigationActivity.this);
        aMap.setOnMarkerClickListener(NavigationActivity.this);
        aMap.setOnInfoWindowClickListener(NavigationActivity.this);
        aMap.setInfoWindowAdapter(NavigationActivity.this);

    }
    @Override
    protected void initListener() {

    }


    @Override
    public View getInfoWindow(Marker marker) {
        return null;
    }

    @Override
    public View getInfoContents(Marker marker) {
        return null;
    }

    @Override
    public void onInfoWindowClick(Marker marker) {

    }

    @Override
    public void onMapClick(LatLng latLng) {

    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        return false;

    }

    /**
     * 开始搜索路径规划方案
     */
    public  void  searchRouteResult(int routeType,int mode){
        if(mStartPoint==null){
            UIUtils.showToastSafe("定位中，稍后再试...");
            return;
        }
        if(mEndPoint==null){
            UIUtils.showToastSafe("终点未设置");
        }
        showProgressDialog();
        final  RouteSearch.FromAndTo fromAndTo=new RouteSearch.FromAndTo(mStartPoint,mEndPoint);
        if(routeType==ROUTE_TYPE_WALK){// 步行路径规划
            RouteSearch.WalkRouteQuery query=new RouteSearch.WalkRouteQuery(fromAndTo,mode);
            mRouteSearch.calculateWalkRouteAsyn(query);
        }else if(routeType==ROUTE_TYPE_BUS){// 公交路径规划
            RouteSearch.BusRouteQuery query=new RouteSearch.BusRouteQuery(fromAndTo,mode,mCurrentCityName,0);
            mRouteSearch.calculateBusRouteAsyn(query);
        }else if(routeType==ROUTE_TYPE_DRIVE){// 驾车路径规划
            RouteSearch.DriveRouteQuery query = new RouteSearch.DriveRouteQuery(fromAndTo, mode, null,
                    null, "");// 第一个参数表示路径规划的起点和终点，第二个参数表示驾车模式，第三个参数表示途经点，第四个参数表示避让区域，第五个参数表示避让道路
            mRouteSearch.calculateDriveRouteAsyn(query);// 异步路径规划驾车模式查询
        }else if(routeType==ROUTE_TYPE_RIDE){// 骑行路径规划
            RouteSearch.RideRouteQuery query = new RouteSearch.RideRouteQuery(fromAndTo, mode);
            mRouteSearch.calculateRideRouteAsyn(query);// 异步路径规划骑行模式查询
        }

    }
    /**
     * 显示进度框
     */
    private void showProgressDialog() {
        if (progDialog == null)
            progDialog = new ProgressDialog(this);
        progDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progDialog.setIndeterminate(false);
        progDialog.setCancelable(true);
        progDialog.setMessage("正在搜索");
        progDialog.show();
    }

    /**
     * 隐藏进度框
     */
    private void dissmissProgressDialog() {
        if (progDialog != null) {
            progDialog.dismiss();
        }
    }
    @Override
    public void onBusRouteSearched(BusRouteResult result, int errorCode) {
        dissmissProgressDialog();
        aMap.clear();// 清理地图上的所有覆盖物
        if (errorCode == AMapException.CODE_AMAP_SUCCESS) {
            if (result != null && result.getPaths() != null) {
                if (result.getPaths().size() > 0) {
                    mBusRouteResult = result;
                    BusResultListAdapter mBusResultListAdapter = new BusResultListAdapter(mContext, mBusRouteResult);
                    mBusResultList.setAdapter(mBusResultListAdapter);
                } else if (result != null && result.getPaths() == null) {
                    UIUtils.showToastSafe("对不起，没有搜索到相关数据！");
                }
            } else {
                UIUtils.showToastSafe("对不起，没有搜索到相关数据！");
            }
        } else {
            ToastUtil.showerror(this.getApplicationContext(), errorCode);
        }
    }

    @Override
    public void onDriveRouteSearched(DriveRouteResult result, int errorCode) {
        dissmissProgressDialog();
        aMap.clear();// 清理地图上的所有覆盖物
        if (errorCode == AMapException.CODE_AMAP_SUCCESS) {
            if (result != null && result.getPaths() != null) {
                if (result.getPaths().size() > 0) {
                    mDriveRouteResult = result;
                    final DrivePath drivePath = mDriveRouteResult.getPaths()
                            .get(0);
                    DrivingRouteOverlay drivingRouteOverlay = new DrivingRouteOverlay(
                            mContext, aMap, drivePath,
                            mDriveRouteResult.getStartPos(),
                            mDriveRouteResult.getTargetPos(), null);
                    drivingRouteOverlay.setNodeIconVisibility(false);//设置节点marker是否显示
                    drivingRouteOverlay.setIsColorfulline(true);//是否用颜色展示交通拥堵情况，默认true
                    drivingRouteOverlay.removeFromMap();
                    drivingRouteOverlay.addToMap();
                    drivingRouteOverlay.zoomToSpan();
                    mBottomLayout.setVisibility(View.VISIBLE);
                    int dis = (int) drivePath.getDistance();
                    int dur = (int) drivePath.getDuration();
                    String des = AMapUtil.getFriendlyTime(dur)+"("+AMapUtil.getFriendlyLength(dis)+")";
                    mRotueTimeDes.setText(des);
                    mRouteDetailDes.setVisibility(View.VISIBLE);
                    int taxiCost = (int) mDriveRouteResult.getTaxiCost();
                    mRouteDetailDes.setText("打车约"+taxiCost+"元");
                    mBottomLayout.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
//                            Intent intent = new Intent(mContext,
//                                    DriveRouteDetailActivity.class);
//                            intent.putExtra("drive_path", drivePath);
//                            intent.putExtra("drive_result",
//                                    mDriveRouteResult);
//                            startActivity(intent);
                        }
                    });

                } else if (result != null && result.getPaths() == null) {
                    UIUtils.showToastSafe("对不起，没有搜索到相关数据！");
                }

            } else {
                UIUtils.showToastSafe("对不起，没有搜索到相关数据！");
            }
        } else {
            ToastUtil.showerror(this.getApplicationContext(), errorCode);
        }

    }

    @Override
    public void onWalkRouteSearched(WalkRouteResult result, int errorCode) {
        dissmissProgressDialog();
        aMap.clear();// 清理地图上的所有覆盖物
        if (errorCode == AMapException.CODE_AMAP_SUCCESS) {
            if (result != null && result.getPaths() != null) {
                if (result.getPaths().size() > 0) {
                    mWalkRouteResult = result;
                    final WalkPath walkPath = mWalkRouteResult.getPaths()
                            .get(0);
                    WalkRouteOverlay walkRouteOverlay = new WalkRouteOverlay(
                            this, aMap, walkPath,
                            mWalkRouteResult.getStartPos(),
                            mWalkRouteResult.getTargetPos());
                    walkRouteOverlay.removeFromMap();
                    walkRouteOverlay.addToMap();
                    walkRouteOverlay.zoomToSpan();
                    mBottomLayout.setVisibility(View.VISIBLE);
                    int dis = (int) walkPath.getDistance();
                    int dur = (int) walkPath.getDuration();
                    String des = AMapUtil.getFriendlyTime(dur)+"("+AMapUtil.getFriendlyLength(dis)+")";
                    mRotueTimeDes.setText(des);
                    mRouteDetailDes.setVisibility(View.GONE);
                    mBottomLayout.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
//                            Intent intent = new Intent(mContext,
//                                    WalkRouteDetailActivity.class);
//                            intent.putExtra("walk_path", walkPath);
//                            intent.putExtra("walk_result",
//                                    mWalkRouteResult);
//                            startActivity(intent);
                        }
                    });
                } else if (result != null && result.getPaths() == null) {
                    UIUtils.showToastSafe("对不起，没有搜索到相关数据！");
                }
            } else {
                UIUtils.showToastSafe("对不起，没有搜索到相关数据！");
            }
        } else {
            ToastUtil.showerror(this.getApplicationContext(), errorCode);
        }
    }

    @Override
    public void onRideRouteSearched(RideRouteResult result, int errorCode) {
        dissmissProgressDialog();
        aMap.clear();//清理地图上的所有覆盖物
        if(errorCode== AMapException.CODE_AMAP_SUCCESS){
            if(result!=null&&result.getPaths()!=null){
                if(result.getPaths().size()>0){
                    mRideRouteResult=result;
                    final RidePath ridePath=mRideRouteResult.getPaths().get(0);
                    RideRouteOverlay rideRouteOverlay=new RideRouteOverlay(this,aMap,ridePath,mRideRouteResult.getStartPos(),mRideRouteResult.getTargetPos());
                    rideRouteOverlay.removeFromMap();
                    rideRouteOverlay.addToMap();
                    rideRouteOverlay.zoomToSpan();
                    mBottomLayout.setVisibility(View.VISIBLE);
                    int dis = (int) ridePath.getDistance();
                    int dur = (int) ridePath.getDuration();
                    String des = AMapUtil.getFriendlyTime(dur)+"("+AMapUtil.getFriendlyLength(dis)+")";
                    mRotueTimeDes.setText(des);
                    mRouteDetailDes.setVisibility(View.GONE);
                    mBottomLayout.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
//                            Intent intent = new Intent(mContext,
//                                    RideRouteDetailActivity.class);
//                            intent.putExtra("ride_path", ridePath);
//                            intent.putExtra("ride_result",
//                                    mRideRouteResult);
//                            startActivity(intent);
                        }
                    });
                }else if(result!=null&&result.getPaths()==null){
                    UIUtils.showToastSafe("对不起，没有搜索到相关数据！");
                }
            }else {
                UIUtils.showToastSafe("对不起，没有搜索到相关数据！");
            }
        }else {
            ToastUtil.showerror(this.getApplicationContext(), errorCode);
        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.rl_crosstownBus:
                setfromandtoMarker();
                searchRouteResult(ROUTE_TYPE_RIDE, RouteSearch.RidingDefault);
                mDrive.setImageResource(R.drawable.route_drive_normal);
                mBus.setImageResource(R.drawable.route_bus_normal);
                mWalk.setImageResource(R.drawable.route_walk_normal);
//                mBusResultLayout.setVisibility(View.VISIBLE);
                break;
            case R.id.rl_bus:
                setfromandtoMarker();
                searchRouteResult(ROUTE_TYPE_BUS, RouteSearch.BusDefault);
                mDrive.setImageResource(R.drawable.route_drive_normal);
                mBus.setImageResource(R.drawable.route_bus_select);
                mWalk.setImageResource(R.drawable.route_walk_normal);
//                mapView.setVisibility(View.GONE);
//                mBusResultLayout.setVisibility(View.VISIBLE);
                break;
            case R.id.rl_drive:
                setfromandtoMarker();
                searchRouteResult(ROUTE_TYPE_DRIVE, RouteSearch.DrivingDefault);
                mDrive.setImageResource(R.drawable.route_drive_select);
                mBus.setImageResource(R.drawable.route_bus_normal);
                mWalk.setImageResource(R.drawable.route_walk_normal);
                mapView.setVisibility(View.VISIBLE);
//                mBusResultLayout.setVisibility(View.GONE);
                break;
            case R.id.rl_walk:
                setfromandtoMarker();
                searchRouteResult(ROUTE_TYPE_WALK, RouteSearch.WalkDefault);
                mDrive.setImageResource(R.drawable.route_drive_normal);
                mBus.setImageResource(R.drawable.route_bus_normal);
                mWalk.setImageResource(R.drawable.route_walk_select);
                mapView.setVisibility(View.VISIBLE);
//                mBusResultLayout.setVisibility(View.GONE);
                break;
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        mapView.onSaveInstanceState(outState);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }
}
