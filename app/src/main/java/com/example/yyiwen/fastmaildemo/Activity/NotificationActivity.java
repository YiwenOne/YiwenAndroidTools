package com.example.yyiwen.fastmaildemo.Activity;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.yyiwen.fastmaildemo.R;

public class NotificationActivity extends BaseActivity implements View.OnClickListener {
    private NotificationManager notificationManager;
    Button btnSmile, btnWhy, btnWrath, btnClear, btnRing, btnVibrate, btnLight, btnRingAndVibrate;
    private Context mContext;
    @Override
    protected void initView() {
        setContentView(R.layout.activity_notification);
        notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        btnSmile = (Button) findViewById(R.id.btnSmile);
        btnWhy = (Button) findViewById(R.id.btnWhy);
        btnWrath = (Button) findViewById(R.id.btnWrath);
        btnClear = (Button) findViewById(R.id.btnClear);
        btnRing = (Button) findViewById(R.id.btnRing);
        btnVibrate = (Button) findViewById(R.id.btnVibrate);
        btnLight = (Button) findViewById(R.id.btnLight);
        btnRingAndVibrate = (Button) findViewById(R.id.btnRingAndVibrate);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {
        btnSmile.setOnClickListener(this);
        btnWhy.setOnClickListener(this);
        btnWrath.setOnClickListener(this);
        btnClear.setOnClickListener(this);
        btnRing.setOnClickListener(this);
        btnVibrate.setOnClickListener(this);
        btnLight.setOnClickListener(this);
        btnRingAndVibrate.setOnClickListener(this);
    }

    private void setDefaults(String tickerText, String contentTitle, String contentText, int id, int resId, int defaults) {
//        Notification notification = new Notification(resId, tickerText, System.currentTimeMillis());
//        PendingIntent contentIntent = PendingIntent.getActivity(this, 0, new Intent(this, NotificationActivity.class), 0);
//        notification.defaults = defaults;
//        notificationManager.notify(id, notification);
        Notification.Builder builder = new Notification.Builder(this);//新建Notification.Builder对象
        Intent notificationIntent = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, notificationIntent, 0);
        builder.setContentTitle(contentTitle);//设置标题
        builder.setContentText(contentText);//设置内容
        builder.setSmallIcon(R.mipmap.ic_launcher);//设置图片
        builder.setContentIntent(pendingIntent);//执行intent
        Notification notification = builder.getNotification();//将builder对象转换为普通的notification
//        startForeground(1,notification);//让 MyService 变成一个前台服务，并在系统状态栏中显示出来。
        notificationManager.notify(1, notification);
    }

    private void showNotification(String tickerText, String contentTitle, String contentText, int id, int resId) {
        Notification.Builder builder = new Notification.Builder(this);//新建Notification.Builder对象
        Intent notificationIntent = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, notificationIntent, 0);
        builder.setContentTitle(contentTitle);//设置标题
        builder.setContentText(contentText);//设置内容
        builder.setSmallIcon(R.mipmap.ic_launcher);//设置图片
        builder.setContentIntent(pendingIntent);//执行intent
        Notification notification = builder.getNotification();//将builder对象转换为普通的notification
//        startForeground(1,notification);//让 MyService 变成一个前台服务，并在系统状态栏中显示出来。
        notificationManager.notify(1, notification);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnSmile:
                showNotification("今天非常高兴", //显示在状态栉上的提示文字
                        "今天考试得了全年级第一", //详细通知的标题
                        "数学 100 分、诧文 99 分、英诧 100 分，yeah！", //详细通知的具体内容
                        R.drawable.kehu,  //Notification 对应的唯一 ID 值
                        R.drawable.kehu); //资源图片的 ID
                break;
            case R.id.btnWhy:
                showNotification("返是为什么呢？",
                        "返道题为什么会出错呢？",
                        "谁有正确答案啊.",
                        R.drawable.kehu,
                        R.drawable.kehu);
                break;
            case R.id.btnWrath:
                showNotification("今天心情丌好",
                        "也丌知道为什么，返几天一直徆郁闷.",
                        "也许应该去公园散心了",
                        R.drawable.kehu,
                        R.drawable.kehu);
                break;
            case R.id.btnClear:
                notificationManager.cancelAll();
                break;
            case R.id.btnRing:
                setDefaults("使用默认的声音",
                        "使用默认的声音",
                        "使用默认的声音",
                        R.id.btnRing,
                        R.drawable.kehu,
                        Notification.DEFAULT_SOUND);
            case R.id.btnVibrate:
                setDefaults("使用默认的震劢",
                        "使用默认的震劢",
                        "使用默认的震劢",
                        R.id.btnVibrate,
                        R.drawable.kehu,
                        Notification.DEFAULT_VIBRATE);
            case R.id.btnLight:
                setDefaults("使用默认的 Light",
                        "使用默认的 Light",
                        "使用默认的 Light",
                        R.id.btnLight,
                        R.drawable.kehu,
                        Notification.DEFAULT_LIGHTS);
            case R.id.btnRingAndVibrate:
                setDefaults("所有的都使用默认值",
                        "所有的都使用默认值",
                        "所有的都使用默认值",
                        R.id.btnRingAndVibrate,
                        R.drawable.kehu,
                        Notification.DEFAULT_ALL);
                break;
        }
    }
}
