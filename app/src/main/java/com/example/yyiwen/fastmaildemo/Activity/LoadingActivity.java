package com.example.yyiwen.fastmaildemo.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.yyiwen.fastmaildemo.R;

import pl.droidsonroids.gif.GifImageView;

public class LoadingActivity extends BaseActivity {
    GifImageView mGifImageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);
        //        mGifImageView = (GifImageView) findViewById(R.id.activity_gif_giv);
//        try {
//            GifDrawable gifDrawable = new GifDrawable(getAssets(), "loading.gif");
//            mGifImageView.setImageDrawable(gifDrawable);
//            final MediaController mediaController = new MediaController(this);
//            mediaController.setMediaPlayer((GifDrawable) mGifImageView.getDrawable());
//            /**
//             * 也许你会像我一样，当看到上面一行代码时会纳闷，为什么setMediaPalyer传入的参数会是一个
//             * GifDrawable对象呢，它需要的参数类型是MediaPlayerControl。。。
//             * 还永德我们前面提到GifDrawable实现了MediaPlayerControl接口吗？
//             * 嗯。。。哦，，，恍然大明白了
//             */
//            mediaController.setAnchorView(mGifImageView);
//            mGifImageView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    mediaController.show();
//                }
//            });
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {

    }
}
