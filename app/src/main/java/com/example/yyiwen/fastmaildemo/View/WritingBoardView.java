package com.example.yyiwen.fastmaildemo.View;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;

import com.example.yyiwen.fastmaildemo.R;

/**
 * Created by y.yiwen on 8/10/2016.
 */
public class WritingBoardView extends View{
    private int mBoardBackground;//画板颜色
    private int mPaintColor;//画笔颜色
    private int mPaintWidth;//画笔宽度
    private Path mPath;
    private Paint mPaint;//画笔
    public WritingBoardView(Context context) {
        this(context,null);
    }

    public WritingBoardView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public WritingBoardView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context,attrs);
    }



    private void init(Context context,AttributeSet attrs) {
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.WritingBoardView);
        mBoardBackground =   a.getColor(R.styleable.WritingBoardView_boardBackground, Color.WHITE);
        mPaintColor =   a.getColor(R.styleable.WritingBoardView_paintColor,Color.BLUE);
        mPaintWidth = a.getDimensionPixelSize(R.styleable.WritingBoardView_paintWidth,
                (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,5,getResources().getDisplayMetrics()));
        a.recycle();
        mPaint = new Paint();
        mPath = new Path();
        setBackgroundColor(mBoardBackground);
        mPaint.setColor(mPaintColor);
        mPaint.setStrokeWidth(mPaintWidth);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setAntiAlias(true);
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float touchX = event.getX();
        float touchY = event.getY();
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                mPath.moveTo(touchX,touchY);//重新设置即将出现的线的起点
                break;
            case MotionEvent.ACTION_MOVE:
                mPath.lineTo(touchX,touchY);//连线
                break;
            case MotionEvent.ACTION_UP:
                break;
        }
        invalidate();//通知系统重绘
        return true;//要处理当前事件
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(mPath,mPaint);
    }
}
