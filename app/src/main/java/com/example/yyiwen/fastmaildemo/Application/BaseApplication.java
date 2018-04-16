package com.example.yyiwen.fastmaildemo.Application;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;

import com.android.volley.RequestQueue;
import com.example.yyiwen.fastmaildemo.Utils.VolleyUtil;

public class BaseApplication extends Application {
    /**
     * 获取到主线程的上下文
     */
    private static BaseApplication mContext;
    /**
     * 获取到主线程的handler
     */
    private static Handler mMainThreadHandler;
    /**
     * 获取到主线程
     */
    private static Thread mMainThread;

    /**
     * 获取到主线程的轮询器
     */
    private static Looper mMainThreadLooper;

    /**
     * 获取到主线程id
     */
    private static int mMainTheadId;
    public RequestQueue mQueue;

    public static BaseApplication getApplication() {
        return mContext;
    }

    public static Handler getMainThreadHandler() {
        return mMainThreadHandler;
    }
    public static Thread getMainThread() {
        return mMainThread;
    }

    public static Looper getMainThreadLooper() {
        return mMainThreadLooper;
    }

    public static int getMainThreadId() {
        return mMainTheadId;
    }

    @Override
    public void onCreate() {
        // TODO Auto-generated method stub
        super.onCreate();

        //Jpush初始化
//      JPushInterface.stopPush(this);

        this.mContext = this;
        this.mMainThreadHandler = new Handler();
        this.mMainThread = Thread.currentThread();
        this.mMainThreadLooper = getMainLooper();
        this.mMainTheadId = android.os.Process.myTid();
        initRequestQueue();
        this.mContext = this;
        this.mMainThreadHandler = new Handler();
        this.mMainThread = Thread.currentThread();
        this.mMainThreadLooper = getMainLooper();
    }

    //初始化请求队列
    private void initRequestQueue() {
        //初始化 volley
        VolleyUtil.initialize(mContext);
    }
}
