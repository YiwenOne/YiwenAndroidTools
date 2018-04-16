package com.example.yyiwen.fastmaildemo.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.Gallery;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;

import com.example.yyiwen.fastmaildemo.Adapter.ImageAdapter;
import com.example.yyiwen.fastmaildemo.R;

public class ImageSwicherActivity extends BaseActivity implements AdapterView.OnItemSelectedListener,ViewSwitcher.ViewFactory{
    private Gallery gallery;
    private ImageSwitcher imageSwitcher;
    private ImageAdapter imageAdapter;
    private int[] resIds = new int[]
            {
                    R.drawable.head_1, R.drawable.head_2, R.drawable.head_3, R.drawable.head_4, R.drawable.head_5,
                    R.drawable.head_6, R.drawable.img_alexey, R.drawable.img_besim, R.drawable.img_darren, R.drawable.img_face,
                    R.drawable.img_mark, R.drawable.img_pizza, R.drawable.img_prasad, R.drawable.img_william
            };


    @Override
    protected void initView() {
        setContentView(R.layout.activity_image_swicher);
        gallery = (Gallery) findViewById(R.id.gallery);
        imageAdapter = new ImageAdapter(this,resIds);
        gallery.setAdapter(imageAdapter);

        imageSwitcher = (ImageSwitcher) findViewById(R.id.imageswitcher);
        imageSwitcher.setFactory(this);
        //设置淡入淡出效果
        imageSwitcher.setInAnimation(AnimationUtils.loadAnimation(this, android.R.anim.fade_in));
        imageSwitcher.setOutAnimation(AnimationUtils.loadAnimation(this, android.R.anim.fade_out));
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {
        gallery.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        //点击 gallery 里面的某一张图片时，对 ImageSwitcher 里面的图片迕行设置
        imageSwitcher.setImageResource(resIds[position % resIds.length]);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
    @Override
    public View makeView()
    {
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundColor(0xFF000000);
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageView.setLayoutParams(new ImageSwitcher.LayoutParams(Gallery.LayoutParams.FILL_PARENT, Gallery.LayoutParams.FILL_PARENT));
        return imageView;
    }
}
