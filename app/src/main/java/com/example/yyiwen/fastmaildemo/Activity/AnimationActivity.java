package com.example.yyiwen.fastmaildemo.Activity;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;

import com.example.yyiwen.fastmaildemo.R;

public class AnimationActivity extends AppCompatActivity implements View.OnClickListener{
    private ImageView iv_text;
    private Button btn_1,btn_2,btn_3,btn_4,btn_5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);
        //初始化组件
        iv_text= (ImageView) findViewById(R.id.iv_text);
        btn_1= (Button) findViewById(R.id.btn_1);
        btn_2= (Button) findViewById(R.id.btn_2);
        btn_3= (Button) findViewById(R.id.btn_3);
        btn_4= (Button) findViewById(R.id.btn_4);
        btn_5= (Button) findViewById(R.id.btn_5);
        //设置点击事件
        ininListener();
    }

    private void ininListener() {
        btn_1.setOnClickListener(this);
        btn_2.setOnClickListener(this);
        btn_3.setOnClickListener(this);
        btn_4.setOnClickListener(this);
        btn_5.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_1:
                /**
                 float fromX 动画起始时 X坐标上的伸缩尺寸
                 float toX 动画结束时 X坐标上的伸缩尺寸
                 float fromY 动画起始时Y坐标上的伸缩尺寸
                 float toY 动画结束时Y坐标上的伸缩尺寸
                 int pivotXType 动画在X轴相对于物件位置类型
                 float pivotXValue 动画相对于物件的X坐标的开始位置
                 int pivotYType 动画在Y轴相对于物件位置类型
                 float pivotYValue 动画相对于物件的Y坐标的开始位置
                 */
                /**
                 * 方法一 代码设置动画
                 */
//                ScaleAnimation scaleAnimation =new ScaleAnimation(0.0f, 1.4f, 0.0f, 1.4f,
//                        Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
//                /** 常用方法 */
//                //animation.setRepeatCount(int repeatCount);//设置重复次数
//                //animation.setFillAfter(boolean);//动画执行完后是否停留在执行完的状态
//                //animation.setStartOffset(long startOffset);//执行前的等待时间
//                //设置动画持续时间
//                scaleAnimation.setDuration(2000);
//                //开始动画
//                iv_text.startAnimation(scaleAnimation);

                /**
                 * 方法二   xml文件设置动画
                 */
                Animation scaleAnimation=AnimationUtils.loadAnimation(AnimationActivity.this,R.anim.animation_scale);
                iv_text.startAnimation(scaleAnimation);
                break;
            case R.id.btn_2:
                Animation alaphAnimation=new AlphaAnimation(1f,0.1f);
                //设置动画持续时间
                alaphAnimation.setDuration(2000);
                //开始动画
                iv_text.startAnimation(alaphAnimation);
                break;
            case R.id.btn_3:
                /**
                 参数说明：
                 float fromXDelta 动画开始的点离当前View X坐标上的差值
                 float toXDelta 动画结束的点离当前View X坐标上的差值
                 float fromYDelta 动画开始的点离当前View Y坐标上的差值
                 float toYDelta 动画开始的点离当前View Y坐标上的差值
                 */
                TranslateAnimation translateAnimation=new TranslateAnimation(10,100,10,100);
                //设置动画持续时间
                translateAnimation.setDuration(2000);
                /** 常用方法 */
                //animation.setRepeatCount(int repeatCount);//设置重复次数
                //animation.setFillAfter(boolean);//动画执行完后是否停留在执行完的状态
                //animation.setStartOffset(long startOffset);//执行前的等待时间
                //开始动画
                iv_text.startAnimation(translateAnimation);
                break;
            case R.id.btn_4:
                /**
                 参数说明：
                 float fromDegrees：旋转的开始角度。
                 float toDegrees：旋转的结束角度。
                 int pivotXType：X轴的伸缩模式，可以取值为ABSOLUTE、RELATIVE_TO_SELF、RELATIVE_TO_PARENT。
                 float pivotXValue：X坐标的伸缩值。
                 int pivotYType：Y轴的伸缩模式，可以取值为ABSOLUTE、RELATIVE_TO_SELF、RELATIVE_TO_PARENT。
                 float pivotYValue：Y坐标的伸缩值。
                 */
                RotateAnimation rotateAnimation=new RotateAnimation(0f,360f,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
                //设置动画持续时间
                rotateAnimation.setDuration(2000);
                /** 常用方法 */
                //animation.setRepeatCount(int repeatCount);//设置重复次数
                //animation.setFillAfter(boolean);//动画执行完后是否停留在执行完的状态
                //animation.setStartOffset(long startOffset);//执行前的等待时间
                rotateAnimation.setRepeatCount(10);
                /** 常用方法 */
                //animation.setRepeatCount(int repeatCount);//设置重复次数
                //animation.setFillAfter(boolean);//动画执行完后是否停留在执行完的状态
                //animation.setStartOffset(long startOffset);//执行前的等待时间
                //开始动画
                iv_text.startAnimation(rotateAnimation);
                break;
            case R.id.btn_5:

                break;
        }
    }
}
