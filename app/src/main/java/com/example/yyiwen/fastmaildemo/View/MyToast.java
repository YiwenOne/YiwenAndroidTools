package com.example.yyiwen.fastmaildemo.View;

import android.app.Activity;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yyiwen.fastmaildemo.R;
import com.example.yyiwen.fastmaildemo.Utils.UIUtils;

/**
 *  自定义Toast的工具类
 * Created by y.yiwen on 11/16/2016.
 */
public class MyToast {
    /**
     * 自定义Toast
     * @param context  类所在的context对象
     * @param massage   要显示的信息
     * @param show_length  显示时间的长短, 常用Toast.LENGTH_LONG ,  Toast.LENGTH_SHORT
     */
    public static  void makeshow(Context context, String massage, int show_length){
        //使用布局加载器，将编写的toast_layout布局加载进来
        View view = LayoutInflater.from(context).inflate(R.layout.layout_toast, null);
        //获取ImageView
//        ImageView image = (ImageView) view.findViewById(R.id.toast_iv);
        //设置图片
//        image.setImageResource(R.drawable.cofe);
        //获取TextView
        TextView title = (TextView) view.findViewById(R.id.text);
        //设置显示的内容
        title.setText(massage);
        title.setTextColor(UIUtils.getColor(R.color.biaotilan));
        Toast toast = new Toast(context);
        //设置Toast要显示的位置，水平居中并在底部，X轴偏移0个单位，Y轴偏移70个单位，
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 300);
        //设置显示时间
        toast.setDuration(show_length);

        toast.setView(view);
        toast.show();
    }
}
