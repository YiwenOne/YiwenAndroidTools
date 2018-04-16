package com.example.yyiwen.fastmaildemo.View;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * ============================================================

 * 描 述 ：
 * 
 *      屏蔽viewpager的滑动事件
 * 修订历史 ：
 * 
 * ============================================================
 **/
public class CustomViewPage extends ViewPager{

	public CustomViewPage(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}

	public CustomViewPage(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}
	/**
	 * 是否拦截
	 */
	@Override
	public boolean onInterceptTouchEvent(MotionEvent arg0) {
		// TODO Auto-generated method stub
		return false;
	}
    /**
     * 事件处理
     */
	@Override
	public boolean onTouchEvent(MotionEvent arg0) {
		// TODO Auto-generated method stub
		return false;
	}
}
