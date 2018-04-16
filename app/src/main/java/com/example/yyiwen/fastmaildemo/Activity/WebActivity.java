package com.example.yyiwen.fastmaildemo.Activity;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.view.KeyEvent;
import android.view.Menu;
import android.webkit.WebView;
import android.widget.Button;

import com.example.yyiwen.fastmaildemo.R;
import com.example.yyiwen.fastmaildemo.Assist.ButtonListener;
import com.example.yyiwen.fastmaildemo.Assist.MJavascriptInterface;
import com.example.yyiwen.fastmaildemo.Assist.MWebViewClient;

public class WebActivity extends Activity {
	private WebView webView;
	private Button paramButton;
	private Button noParamButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_web);
		initViews();
	}

	private void initViews() {
		webView = (WebView) findViewById(R.id.webView_web);
		// 设置WebView对JavaScript的支持
		webView.getSettings().setJavaScriptEnabled(true);
		// 从assets目录下面的加载html
		webView.loadUrl("file:///android_asset/web.html");
		//自定义WebView的背景颜色
		webView.setBackgroundColor(Color.TRANSPARENT);//先设置背景色为transparent
//		webView.setBackgroundResource(R.drawable.webbg);//然后设置背景图片
		webView.setBackgroundResource(R.drawable.bgcolorblue);
////		webView.loadUrl("http://www.baidu.com");
		MWebViewClient mWebViewClient = new MWebViewClient(webView,getApplicationContext());
		webView.setWebViewClient(mWebViewClient);
//		MWebChromeClient mWebChromeClient = new MWebChromeClient(getApplicationContext());
//		webView.setWebChromeClient(mWebChromeClient);
		//添加JS调用Android(Java)的方法接口
		MJavascriptInterface mJavascriptInterface = new MJavascriptInterface(getApplicationContext());
		webView.addJavascriptInterface(mJavascriptInterface, "WebViewFunc");

		//初始化按钮，并绑定监听事件，事件的作用是调用JS的功能方法
		noParamButton = (Button) findViewById(R.id.javaCallJs_web_button);
		paramButton = (Button) findViewById(R.id.javaCallJsParam_web_button);
		ButtonListener buttonListener = new ButtonListener(webView);
		noParamButton.setOnClickListener(buttonListener);
		paramButton.setOnClickListener(buttonListener);
	}

	/**
	 * 退出监听
	 */
	@Override
	public boolean dispatchKeyEvent(KeyEvent event) {
		if (event.getKeyCode() == KeyEvent.KEYCODE_BACK
				&& event.getAction() == KeyEvent.ACTION_DOWN
				&& event.getRepeatCount() == 0
				) {
			if(webView.canGoBack()){
				webView.goBack();
				return false;
			}else {
				WebActivity.this.finish();
				return true;
			}
		}
		return false;
//		return super.dispatchKeyEvent(event);
	}

	//*******************华丽的分割线***********************
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
//		getMenuInflater().inflate(R.menu.web, menu);
		return true;
	}
}
