package com.example.yyiwen.fastmaildemo.Activity;

import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.yyiwen.fastmaildemo.R;
import com.example.yyiwen.fastmaildemo.View.RippleView;
import com.example.yyiwen.fastmaildemo.View.RoundImageView;

public class RippleEffectActivity extends BaseActivity implements View.OnClickListener{
    private RippleView rippleView;
    private RoundImageView roundImageView;
    private static final int Nou=1;
    //声明一个SoundPoll
    private SoundPool sp;
    //定义一个整形用load():设置SoundPool
    private int music;

    private Handler handler=new Handler(){
        public void handleMessage(Message message){
            if(message.what==Nou){
                //每隔10S响应一次
                handler.sendEmptyMessageDelayed(Nou,5000);
                sp.play(music,1,1,0,0,1);
            }
        }
    };
    @Override
    protected void initView() {
        setContentView(R.layout.activity_ripple_effect);
        //初始化组件
        rippleView= (RippleView) findViewById(R.id.rippleView);
        roundImageView= (RoundImageView) findViewById(R.id.roundImageView);
    }

    @Override
    protected void initData() {
        //第一个参数为同时播放数据流的最大个数，第二数据流类型，第三为声音质量
        sp=new SoundPool(10, AudioManager.STREAM_SYSTEM,5);
        //把你的声音素材放到res/raw里面，第二个参数是资源文件，第三个为音乐的优先级
        music=sp.load(this,R.raw.hongbao_gq,1);

    }


    @Override
    protected void initListener() {
        roundImageView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.roundImageView:
                if(rippleView.isStarting()){//如果正在运行就停止，否则就继续执行
                    rippleView.stop();
                    //结束进程
                    handler.removeMessages(Nou);
                }else {
                    rippleView.start();
                    //开启进程
                    handler.sendEmptyMessage(Nou);
                }
                break;
        }
    }
    //程序毁灭时也要结束进程
    @Override
    protected void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();
        handler.removeMessages(Nou);
    }
}
