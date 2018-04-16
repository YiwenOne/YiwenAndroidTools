package com.example.yyiwen.fastmaildemo.View;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;

import com.example.yyiwen.fastmaildemo.R;

/**
 * Created by y.yiwen on 11/8/2016.
 */
public class CompassView extends View{
    private float bearing;
    private Paint markerPaint;
    private Paint textPaint;
    private Paint circlePaint;
    private String northString;
    private String eastString;
    private String southString;
    private String westString;
    private int textHeight;
    public float getBearing() {
        return bearing;
    }

    public void setBearing(float bearing) {
        this.bearing = bearing;
    }

    public CompassView(Context context) {
        super(context);
        initCompassView();
    }
    public CompassView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initCompassView();
    }
    public CompassView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initCompassView();
    }



    private void initCompassView(){
        setFocusable(true);
        Resources r=this.getResources();
        circlePaint=new Paint(Paint.ANTI_ALIAS_FLAG);
        circlePaint.setColor(r.getColor(R.color.backgroud_color));
        circlePaint.setStrokeWidth(1);
        circlePaint.setStyle(Paint.Style.FILL_AND_STROKE);

        northString=r.getString(R.string.cardinal_north);
        eastString=r.getString(R.string.cardinal_east);
        southString=r.getString(R.string.cardinal_south);
        westString=r.getString(R.string.cardinal_west);

        textPaint=new Paint(Paint.ANTI_ALIAS_FLAG);
        textPaint.setColor(r.getColor(R.color.text_color));
        textHeight= (int) textPaint.measureText("yY");

        markerPaint=new Paint(Paint.ANTI_ALIAS_FLAG);
        markerPaint.setColor(r.getColor(R.color.marker_color));
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int measuredWidth=measure(widthMeasureSpec);
        int measuredHeight=measure(heightMeasureSpec);
        int d=Math.min(measuredWidth,measuredHeight);
        setMeasuredDimension(d,d);
    }

    private int measure(int measureSpec) {
        int result=0;
        //对测量说明进行解码
        int specMode=MeasureSpec.getMode(measureSpec);
        int specSize=MeasureSpec.getSize(measureSpec);
        if(specMode==MeasureSpec.UNSPECIFIED){
            //如果没有指定界限，就返回默认大小200
            result=200;
        }else {
            result=specSize;
        }
    return result;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        //找到控件的中心，并将最小边的长度作为指南针的半径存储起来
        int px=getMeasuredWidth()/2;
        int py=getMeasuredHeight()/2;
        int radius=Math.min(px,py);
        //使用drawCircle方法画出指南针字盘的边界、颜色和背景
        canvas.drawCircle(px,py,radius,circlePaint);
        //当前方向总是指向设备顶部
        //旋转视图
        canvas.save();
        canvas.rotate(-bearing,px,py);
        //绘制标记，把画布旋转一圈，并且每15度画一个标记，每45度表示一个方向的缩写
        int textWidth= (int) textPaint.measureText("W");
        int cardinalX=px-textWidth/2;
        int cardinalY=py-radius+textHeight;
        //每15度画一个标记
        for(int i=0;i<24;i++){
            //绘制标记
            canvas.drawLine(px,py-radius,px,py-radius+10,markerPaint);
            canvas.save();
            canvas.translate(0,textHeight);
            //绘制基本方位
            if(i%6==0){
                String dirString="";
                switch (i){
                    case 0:
                        dirString=northString;
                        int arrowY=2*textHeight;
                        canvas.drawLine(px,arrowY,px-5,3*textHeight,markerPaint);
                        canvas.drawLine(px,arrowY,px+5,3*textHeight,markerPaint);
                        break;
                    case 6:
                        dirString=eastString;
                        break;
                    case 12:
                        dirString=southString;
                        break;
                    case 18:
                        dirString=westString;
                        break;
                }
                canvas.drawText(dirString,cardinalX,cardinalY,textPaint);
            }else if(i % 3==0){
                //每45度绘制文本
                String angle=String.valueOf(i*15);
                float angleTextWidth=textPaint.measureText(angle);
                int angleTextX= (int) (px-angleTextWidth/2);
                int angleTextY=py-radius+textHeight;
                canvas.drawText(angle,angleTextX,angleTextY,textPaint);
            }
            canvas.restore();
            canvas.rotate(15,px,py);
        }
        canvas.restore();
//        super.onDraw(canvas);
    }
}
