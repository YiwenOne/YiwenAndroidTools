package com.example.yyiwen.fastmaildemo.Assist;

import android.content.Context;
import android.widget.Toast;

public class MJavascriptInterface {

	private Context context;

	public MJavascriptInterface(Context context) {
		super();
		this.context = context;
	}

	/**
	 * JS调用Android(Java)无参数的方法
	 */
	public void jsCallWebView() {
		Toast.makeText(context, "无参数的方法",
				Toast.LENGTH_SHORT).show();
	}

	/**
	 * JS调用Android(Java)含参数的方法
	 * @param param
	 */
	public void jsCallWebView(String param) {
		Toast.makeText(context, "含参数的方法" + param,
				Toast.LENGTH_SHORT).show();
	}
}
