package com.example.yyiwen.fastmaildemo.View;

import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;

/**
 * Created by y.yiwen on 1/9/2017.
 */
public class ZoomPageTransformer implements ViewPager.PageTransformer{
    private static final float MIN_SCALE = 0.85f;
    @Override
    public void transformPage(View view, float position) {
        Log.d("test", view.getId() + ":" + position);
        if (position <= 1) {
            float scaleFactor = Math.max(MIN_SCALE, 1 - Math.abs(position));
            view.setScaleX(scaleFactor);
            view.setScaleY(scaleFactor);
        }
    }
}
