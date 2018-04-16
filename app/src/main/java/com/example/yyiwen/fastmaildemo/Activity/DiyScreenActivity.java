package com.example.yyiwen.fastmaildemo.Activity;

import android.content.Context;
import android.graphics.Color;
import android.provider.SyncStateContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.yyiwen.fastmaildemo.R;

public class DiyScreenActivity extends AppCompatActivity {
    LinearLayout ll_main;
    Context context;
    ImageView imageView;
    TextView tVote;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_diy_screen);
//        ll_main= (LinearLayout) findViewById(R.id.ll_main);
//        //控件需要新创建  new 出来
//        imageView=new ImageView(context);
//        tVote= new TextView(DiyScreenActivity.this);
//        tVote.setText("123456");
//        tVote.setTextColor(Color.parseColor("#444444"));
//        imageView.setImageResource(R.drawable.back);
//        // setTextSize() 里面的单位是sp
//        tVote.setTextSize(14);
//
//        // 父控件是LinearLayout 若是相对布局用RelativeLayout.LayoutParams
//        RelativeLayout.LayoutParams linearParams = new RelativeLayout.LayoutParams(
//                LinearLayout.LayoutParams.MATCH_PARENT,
//                LinearLayout.LayoutParams.WRAP_CONTENT
//        );
//        // 需要 dp 转成像素单位
//
////        linearParams.bottomMargin = Constants.dip2px(DiyScreenActivity.this,8);
//        imageView.setLayoutParams(linearParams);
//        tVote.setLayoutParams(linearParams);
//        tVote.setGravity(Gravity.CENTER);
//
//        ll_main.addView(tVote);
        //定义一个界面管理器
        LinearLayout layout=new LinearLayout(this);
        //添加到主界面
        setContentView(layout);
        //设置显示样式（左右还是上下）
        layout.setOrientation(LinearLayout.VERTICAL);
        //定义一个布局
        RelativeLayout rl1=new RelativeLayout(this);
        LinearLayout ll1=new LinearLayout(this);
        LinearLayout ll2=new LinearLayout(this);
        //创建一个TextView
        final TextView tv=new TextView(this);
        //创建一个按钮
        Button button=new Button(this);
        //设置按钮显示文字
        button.setText("change");
        //制定长度和高度的布局方式
        button.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        RelativeLayout.LayoutParams params=new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        LinearLayout.LayoutParams params1=new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        LinearLayout.LayoutParams params2=new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        //设置Rl1的布局方式
        rl1.setLayoutParams(params);
        ll1.setLayoutParams(params1);
        ll2.setLayoutParams(params2);
        ll1.setOrientation(LinearLayout.HORIZONTAL);
        ImageView imageView=new ImageView(this);
        imageView.setImageResource(R.drawable.back);
        imageView.setLayoutParams(new ViewGroup.LayoutParams(30, 30));

        TextView tv2=new TextView(this);
        tv2.setText("我是第二季");
        tv2.setGravity(Gravity.LEFT);
        TextView tv3=new TextView(this);
        tv3.setText("我是第三季");
        tv3.setGravity(Gravity.CENTER);
        TextView tv4=new TextView(this);
        tv4.setText("我是第四季");
        tv4.setGravity(Gravity.RIGHT);
        //添加
        ll1.addView(imageView);
        ll1.addView(tv2);
        ll1.addView(tv3);
        ll1.addView(tv4);
        TextView tv5=new TextView(this);
        tv5.setText("我是第5季");
//        tv2.setGravity(Gravity.LEFT);
        TextView tv6=new TextView(this);
        tv6.setText("我是第6季");
//        tv3.setGravity(Gravity.CENTER);
        TextView tv7=new TextView(this);
        tv7.setText("我是第7季");

        rl1.addView(tv5);
        rl1.addView(tv6);
        rl1.addView(tv7);

        TextView tv8=new TextView(this);
        tv8.setText("我是第八个");
        tv8.setGravity(Gravity.CENTER);
        tv8.setTextSize(18);

        ll2.addView(tv8);
        //向layout容器中添加TextView
        layout.addView(tv);
        //向容器中添加按钮
        layout.addView(button);
        //向容器中添加RL1
        layout.addView(ll1);


        layout.addView(rl1);

        layout.addView(ll2);
        //给按钮设置点击事件
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text=tv.getText().toString();
                if(text.equals("自定义")){
                    tv.setText("我爱你");
                }else {
                    tv.setText("自定义");
                }
            }
        });
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        //设置
    }

}
