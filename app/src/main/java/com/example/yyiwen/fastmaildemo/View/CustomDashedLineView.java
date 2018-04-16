package com.example.yyiwen.fastmaildemo.View;

import android.content.Context;
import android.view.View;
import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.util.AttributeSet;
import android.view.View;

import com.example.yyiwen.fastmaildemo.R;
import com.example.yyiwen.fastmaildemo.Utils.UIUtils;

/**
 * Created by y.yiwen on 1/17/2017.
 */
public class CustomDashedLineView extends View{

    public CustomDashedLineView(Context context) {
        super(context);
    }
    @SuppressLint("DrawAllocation")
    @Override
    protected void onDraw(Canvas canvas) {

        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(UIUtils.getColor(R.color.black));

        Path path = new Path();
        path.moveTo(0, 5);
        path.lineTo(this.getWidth(), 5);

        PathEffect effects = new DashPathEffect(new float[] { 5, 5, 5, 5 }, 1);
        paint.setPathEffect(effects);
        canvas.drawPath(path, paint);
    }
}
