package com.example.yyiwen.fastmaildemo.View;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.example.yyiwen.fastmaildemo.R;
import com.example.yyiwen.fastmaildemo.Utils.UIUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 模仿咻一咻
 * Created by y.yiwen on 12/30/2016.
 */
public class RippleView extends View{
    private Paint paint;
    private int maxWidth=255;
    //是否运行
    public boolean isStarting=false;
    private List<String> alphaList=new ArrayList<String>();
    private List<String> startWidthList=new ArrayList<String>();
    public RippleView(Context context) {
        super(context);
        init();
    }

    public RippleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public RippleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }
    private void init(){
        paint=new Paint();
        //设置颜色
        paint.setColor(0x0059ccf5);
        alphaList.add("255");//圆心的不透明度
        startWidthList.add("0");
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //设置背景全透明
        setBackgroundColor(Color.TRANSPARENT);
        //依次绘制同心圆
        for(int i=0;i<alphaList.size();i++){
            int alpha=Integer.parseInt(alphaList.get(i));
            //圆半径
            int startWidth=Integer.parseInt(startWidthList.get(i));
            paint.setAlpha(alpha);
            //这个半径决定扩散面积
            canvas.drawCircle(getWidth()/2,getHeight()/2,startWidth+50,paint);
            //同心圆扩散
            if(isStarting && alpha>0 &&startWidth<maxWidth){
                alphaList.set(i,(alpha-1)+"");
                startWidthList.set(i,(startWidth+1)+"");
            }
        }
        if (isStarting
                && Integer
                .parseInt(startWidthList.get(startWidthList.size() - 1)) == maxWidth / 5) {
            alphaList.add("255");
            startWidthList.add("0");
        }
        //同心圆达到10个，删除最外层圆
        if(isStarting && startWidthList.size()==10){
            startWidthList.remove(0);
            alphaList.remove(0);
        }
        //刷新界面
        invalidate();
    }
    // 执行动画
    public void start() {
        isStarting = true;
    }

    // 停止动画
    public void stop() {
        isStarting = false;
    }

    // 判断是都在不在执行
    public boolean isStarting() {
        return isStarting;
    }
}
