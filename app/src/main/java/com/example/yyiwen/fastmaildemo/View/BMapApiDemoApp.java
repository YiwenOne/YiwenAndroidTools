package com.example.yyiwen.fastmaildemo.View;

import android.app.Application;
import android.util.Log;
import android.widget.Toast;

import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.MKEvent;
import com.baidu.mapapi.MKGeneralListener;

public class BMapApiDemoApp extends Application {

//	static BMapApiDemoApp mDemoApp;
//
//	//百度MapAPI的管理类
//	public BMapManager mBMapMan = null;
//
//	// 授权Key
//	// TODO: 请输入您的Key,
//	// 申请地址：http://dev.baidu.com/wiki/static/imap/key/
//	public String mStrKey = "B15E234FB751CDAB14DAAF62909FE8EA3BE06C5A";
//	boolean m_bKeyRight = true;	// 授权Key正确，验证通过
//
//	// 常用事件监听，用来处理通常的网络错误，授权验证错误等
//	public static class MyGeneralListener implements MKGeneralListener {
//		@Override
//		public void onGetNetworkState(int iError) {
//			Log.d("MyGeneralListener", "onGetNetworkState error is "+ iError);
//			Toast.makeText(BMapApiDemoApp.mDemoApp.getApplicationContext(), "您的网络出错啦！",
//					Toast.LENGTH_LONG).show();
//		}
//
//		@Override
//		public void onGetPermissionState(int iError) {
//			Log.d("MyGeneralListener", "onGetPermissionState error is "+ iError);
//			if (iError ==  MKEvent.ERROR_PERMISSION_DENIED) {
//				// 授权Key错误：
//				Toast.makeText(BMapApiDemoApp.mDemoApp.getApplicationContext(),
//						"请在BMapApiDemoApp.java文件输入正确的授权Key！",
//						Toast.LENGTH_LONG).show();
//				BMapApiDemoApp.mDemoApp.m_bKeyRight = false;
//			}
//		}
//
//	}
//
//	@Override
//	public void onCreate() {
//		this.mDemoApp = this;
//		this.mBMapMan = new BMapManager(this);
//		this.mBMapMan.init(this.mStrKey, new MyGeneralListener());
//		super.onCreate();
//	}
//	@Override
//	//建议在您app的退出之前调用mapadpi的destroy()函数，避免重复初始化带来的时间消耗
//	public void onTerminate() {
//		// TODO Auto-generated method stub
//		if (this.mBMapMan != null) {
//			this.mBMapMan.destroy();
//			this.mBMapMan = null;
//		}
//		super.onTerminate();
//	}

}
