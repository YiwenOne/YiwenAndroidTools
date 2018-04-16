package com.example.yyiwen.fastmaildemo.Activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Toast;

import com.example.yyiwen.fastmaildemo.R;

import java.util.StringTokenizer;

public class JSAndroidActivity extends AppCompatActivity {
    private Activity mActivity = null;
    private WebView mWebView = null;
    private String message;
    private JsInterface jsInterface;
    private String[] params = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_jsandroid);
        params = new String[2];
        jsInterface = new JsInterface();
        showWebView();
    }
    @SuppressLint("SetJavaScriptEnabled")
    private void showWebView() {
        try {
            mWebView = (WebView) findViewById(R.id.mWebView);

            mWebView.requestFocus();

            mWebView.setWebChromeClient(new WebChromeClient() {
                @Override
                public void onProgressChanged(WebView view, int progress) {
                    JSAndroidActivity.this.setTitle("Loading...");
                    JSAndroidActivity.this.setProgress(progress);
                    if (progress >= 80) {
                        JSAndroidActivity.this.setTitle("JsAndroid Test");
                    }
                }
            });

            mWebView.setOnKeyListener(new View.OnKeyListener() {
                @Override
                public boolean onKey(View v, int keyCode, KeyEvent event) {
                    if (keyCode == KeyEvent.KEYCODE_BACK
                            && mWebView.canGoBack()) {
                        mWebView.goBack();
                        return true;
                    }
                    return false;
                }
            });
            // WebView的管理设置状态
            WebSettings webSettings = mWebView.getSettings();
            // 设置android下容许执行js的脚本
            webSettings.setJavaScriptEnabled(true);
            // 编码方式
            webSettings.setDefaultTextEncodingName("utf-8");
            /*
             * 使用这个函数将一个对象绑定到Javascript,因此可以从Javascript访问的方法,
             * Android（Java）与js（HTML）交互的接口函数, jsObj 为桥连对象可随意设值
             */
            mWebView.addJavascriptInterface(jsInterface, "jsObj");
            /*
             * Android（Java）访问js（HTML）端代码是通过loadUrl函数实现的，访问格式如：
             * mWebView.loadUrl("javascript: showFromHtml()");
             */
            mWebView.loadUrl("file:///android_asset/index.html");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private class JsInterface {
        /**
         * js中通过window.jsObj.HtmlcallJava2("参数") 可以调用此方法并且把js中input中的值作为参数传入，
         * 但这是在点击js中的按钮得到的，若实现点击java中的按钮得到，需要方法 clickView(View v)
         *
         * @param param
         */
        public void HtmlcallJava2(final String param) {
            message = param;
            String str = message;
            StringTokenizer st = new StringTokenizer(str, ",;");
            while (st.hasMoreTokens()) {
                for (int i = 0; i < params.length; i++) {
                    params[i] = st.nextToken();
                    System.out.println(params[i]);
                }
            }
            Toast.makeText(JSAndroidActivity.this, param, Toast.LENGTH_SHORT)
                    .show();
        }
    }

    /**
     * button的点击事件
     *
     * @param v
     */
    public void clickView(View v) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                /**
                 * 调用js中的方法实现点击java中的按钮得到js中input的值
                 */
                mWebView.loadUrl("javascript: showHtmlcallJava2()");
            }
        });
    }
}
