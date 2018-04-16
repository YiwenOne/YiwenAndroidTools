package com.example.yyiwen.fastmaildemo.View;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

/**
 * Created by y.yiwen on 9/6/2016.
 */
public class MyView extends View implements Runnable {
    int x=20;
    int y=20;
    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        //获取焦点
        setFocusable(true);
        //开启线程
        new Thread(this).start();
    }

    @Override
    public void run() {
        Looper.prepare();
        RefreshHandler refreshHandler=new RefreshHandler();
        while(!Thread.currentThread().isInterrupted()){
            //通过发送消息通知更新界面
            Message m=new Message();
            m.what=0x101;
            refreshHandler.sendMessage(m);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //实例化画笔
        Paint paint=new Paint();
        //设置画笔颜色
        paint.setColor(Color.BLUE);
        //画圆
        canvas.drawCircle(x,y,10,paint);
    }
    //设置画面处理器
    class RefreshHandler extends Handler{
        @Override
        public void handleMessage(Message msg) {
            if(msg.what==0x101){
                MyView.this.update();
                MyView.this.invalidate();
            }
            super.handleMessage(msg);
        }
    };
    //更新坐标
    private void update(){
        int h=getHeight();
        y+=5;
        if(y>=h){
            y=20;
        }
    }
}
