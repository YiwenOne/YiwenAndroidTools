package com.example.yyiwen.fastmaildemo.Assist;

import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;

import com.example.yyiwen.fastmaildemo.R;

public class ButtonListener implements OnClickListener{

	private WebView webView;
	
	public ButtonListener(WebView webView) {
		super();
		this.webView = webView;
	}

	@Override
	public void onClick(View v) {

		switch (v.getId()) {
			case R.id.javaCallJs_web_button:
				webView.loadUrl("javascript:javacalljs()"); // 无参数调用
				break;
			case R.id.javaCallJsParam_web_button:
				webView.loadUrl("javascript:javacalljsparam(" + "'含参数'"+ ")"); // 无参数调用
				break;
			default:
				break;
		}
	}
}
