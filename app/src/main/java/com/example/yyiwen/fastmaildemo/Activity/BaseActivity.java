package com.example.yyiwen.fastmaildemo.Activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.yyiwen.fastmaildemo.R;
import com.example.yyiwen.fastmaildemo.Utils.CommonUtil;
import com.example.yyiwen.fastmaildemo.Utils.UIUtils;
import com.example.yyiwen.fastmaildemo.Utils.VolleyUtil;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* 基类  -- wu   2016-1.11
 */
public abstract class BaseActivity extends FragmentActivity {
    /**
     * 记录所有活动的Activity
     */
    private static final List<BaseActivity> mActivities = new LinkedList<BaseActivity>();
    /**
     * 记录处于前台的Activity
     */
    private static BaseActivity mForegroundActivity = null;
    public Button mBtnBarLeft;
    public ImageView mBtnBarLeftArr;
    public Button mBtnBarRight;
    public TextView mTvBarTitle;
    public FrameLayout mFlLoading;
    public FrameLayout mFlLoadError;
    public Button mBtReClick;
    public RequestQueue mQueue;
    public View ll_left;
    public FrameLayout loading;

    /**
     * 关闭所有Activity
     */
    public static void finishAll() {
        List<BaseActivity> copy;
        synchronized (mActivities) {
            copy = new ArrayList<BaseActivity>(mActivities);
        }
        for (BaseActivity activity : copy) {
            activity.finish();
        }
    }

    /**
     * 关闭所有Activity，除了参数传递的Activity
     */
    public static void finishAll(BaseActivity except) {
        List<BaseActivity> copy;
        synchronized (mActivities) {
            copy = new ArrayList<BaseActivity>(mActivities);
        }
        for (BaseActivity activity : copy) {
            if (activity != except)
                activity.finish();
        }
    }

    /**
     * 是否有启动的Activity
     */
    public static boolean hasActivity() {
        return mActivities.size() > 0;
    }

    /**
     * 获取当前处于前台的activity
     */
    public static BaseActivity getForegroundActivity() {
        return mForegroundActivity;
    }

    /**
     * 获取当前处于栈顶的activity，无论其是否处于前台
     */
    public static BaseActivity getCurrentActivity() {
        List<BaseActivity> copy;
        synchronized (mActivities) {
            copy = new ArrayList<BaseActivity>(mActivities);
        }
        if (copy.size() > 0) {
            return copy.get(copy.size() - 1);
        }
        return null;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
//        initWindow();
        initTitleBar();
        initData();
        initListener();
        mQueue = Volley.newRequestQueue(this);
    }

    @Override
    protected void onResume() {
        mForegroundActivity = this;
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }
    /**
     * 初始化View
     */
    protected abstract void initView();
    /**
     * 初始化数据
     */
    protected abstract void initData();

    /**
     * 初始化监听
     */
    protected abstract void initListener();

    protected void initTitleBar() {

    }

    /**
     * 退出应用
     */
    public void exitApp() {
        finishAll();
        android.os.Process.killProcess(android.os.Process.myPid());
    }

    /**
     * 抽取 get 网络请求
     */
    public void volleyRequest(String url, Response.Listener<String> listener) {
        int networkAvailable = CommonUtil.isNetworkAvailable(BaseActivity.this);
        if (networkAvailable == 0) {
//            UIUtils.showToastSafe("请检查网络");
        } else {
            StringRequest request = new StringRequest(Request.Method.GET, url, listener, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError volleyError) {
                    UIUtils.showToastSafe("请检查网络");
                }
            });
            request.setRetryPolicy(new DefaultRetryPolicy(50000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
            VolleyUtil.getRequestQueue().add(request);
        }
    }

    /**
     * String String 类型
     * post 请求
     */
    public void postSimpleReq(String url, final Map<String, String> params, Response.Listener<String> listener) {
        int networkAvailable = CommonUtil.isNetworkAvailable(BaseActivity.this);
        if (networkAvailable == 0) {
            //无网络
            UIUtils.showToastSafe("请检查网络-----");
        } else {
            StringRequest stringRequest = new StringRequest(Request.Method.POST, url, listener, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError volleyError) {
                    UIUtils.showToastSafe("请检查网络-----" + volleyError);
                }
            }) {
                @Override
                protected Map<String, String> getParams() {
                    return params;
                }
            };
            stringRequest.setRetryPolicy(new DefaultRetryPolicy(50000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
            VolleyUtil.getRequestQueue().add(stringRequest);
        }
    }

    /**
     * post  Object 请求
     *
     * @param url
     * @param obj
     * @param listener
     */
    public void postRequest(String url, Map<String, String> obj, Response.Listener<JSONObject> listener) {
//        Map<String, String> obj = new HashMap<String, String>();
//        obj.put("SalesID", "F248611C-CB39-4806-919E-71DCD085D208");
        int networkAvailable = CommonUtil.isNetworkAvailable(UIUtils.getContext());
        if (networkAvailable == 0) {
            //无网络
            UIUtils.showToastSafe("请检查网络");
        } else {
            Map<Object, Object> params = new HashMap<Object, Object>();
            params.put("ApiParamObj", obj);
            params.put("ErrCode", "0");
            params.put("Message", "POST");
            params.put("Success", "1");
            JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.POST, url, new JSONObject(params), listener, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    UIUtils.showToastSafe("请检查网络");
                }
            });
            jsonObjReq.setRetryPolicy(new DefaultRetryPolicy(50000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
            VolleyUtil.getRequestQueue().add(jsonObjReq);
        }
    }

    private long exitTime = 0;

    public void postObjRequest(String url, Map<String, Object> obj, Response.Listener<JSONObject> listener) {
//        Map<String, String> obj = new HashMap<String, String>();
//        obj.put("SalesID", "F248611C-CB39-4806-919E-71DCD085D208");
        int networkAvailable = CommonUtil.isNetworkAvailable(UIUtils.getContext());
        if (networkAvailable == 0) {
            //无网络
//            UIUtils.showToastSafe("请检查网络");
        } else {
            Map<Object, Object> params = new HashMap<Object, Object>();
            params.put("ApiParamObj", obj);
            params.put("ErrCode", "0");
            params.put("Message", "POST");
            params.put("Success", "1");
            JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.POST, url, new JSONObject(params), listener, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    UIUtils.showToastSafe("请检查网络");
                }
            });
            jsonObjReq.setRetryPolicy(new DefaultRetryPolicy(50000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
            VolleyUtil.getRequestQueue().add(jsonObjReq);
        }
    }


    public void postPushReq(String url, Map<String, Object> obj, Response.Listener<JSONObject> listener) {
        int networkAvailable = CommonUtil.isNetworkAvailable(UIUtils.getContext());
        if (networkAvailable == 0) {
            //无网络
//            UIUtils.showToastSafe("请检查网络");
        } else {
            JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.POST, url, new JSONObject(obj), listener, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    UIUtils.showToastSafe("请检查网络");
                    System.out.println(error + "------------------错误原因");
                }
            });
            jsonObjReq.setRetryPolicy(new DefaultRetryPolicy(50000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
            VolleyUtil.getRequestQueue().add(jsonObjReq);
        }
    }
}
