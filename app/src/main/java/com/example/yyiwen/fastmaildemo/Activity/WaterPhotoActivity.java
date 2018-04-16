package com.example.yyiwen.fastmaildemo.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.yyiwen.fastmaildemo.R;
import com.example.yyiwen.fastmaildemo.Utils.ToastUtil;
import com.example.yyiwen.fastmaildemo.View.ImageTools;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.PopupWindow.OnDismissListener;

@SuppressWarnings("deprecation")
public class WaterPhotoActivity extends Activity implements OnClickListener{
    private ImageView mImageView;
    private ViewPager mViewPager;
    private RelativeLayout mWaterPhoto;
    private TextView cancle,mSure;
    private int cameraPosition;
    private String path = "";
    private int waterType;
    private int scroll =90;
    private int w,h;
    private List<View> views=new ArrayList<View>();

    private TextView v1_tv_hour,v1_tv_day;
    @SuppressWarnings("unused")
    private ImageView v2_img_icon;
    private TextView v2_tv_location,v2_tv_time;
    private TextView v3_tv_address,v3_tv_time;
    private TextView v4_tv_time,v4_tv_info;
    private TextView v5_tv_time,v5_tv_name;

    private SimpleDateFormat simpleDateFormat1,simpleDateFormat2;
    private String day,hour;

    private PopupWindow popWindow;
    private LayoutInflater layoutInflater;
    private TextView tv_cancel,mood1,mood2,mood3,mood4,mood5;

    @SuppressLint("SimpleDateFormat")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_water_photo);
        WindowManager windowManager = getWindowManager();
        Display display = windowManager.getDefaultDisplay();
        w=display.getWidth();
        h=display.getHeight();
        layoutInflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        simpleDateFormat1=new SimpleDateFormat("yyyy-MM-dd");
        simpleDateFormat2=new SimpleDateFormat("HH:mm");
        Date date=new Date();
        day=simpleDateFormat1.format(date);
        hour=simpleDateFormat2.format(date);
        findView();
        init();
    }

    private void findView() {
        mImageView = (ImageView) findViewById(R.id.water_photo);
        mViewPager=(ViewPager) findViewById(R.id.viewPager);
        cancle = (TextView) findViewById(R.id.cancle);
        mSure = (TextView) findViewById(R.id.sure);
        mWaterPhoto=(RelativeLayout) findViewById(R.id.rl_water);
    }

    private void init() {
        Intent intent=getIntent();
        cameraPosition= intent.getIntExtra("cameraPosition",1);
        path = intent.getStringExtra("path");
        waterType = intent.getIntExtra("waterType",0);

        Bitmap bitmap = ImageTools.getdecodeBitmap(path,w,h);
        scrollImageView(bitmap);

        cancle.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                finish();
            }
        });

        mSure.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Bitmap bitmap = getScreenShot(mWaterPhoto);
                int result = ImageTools.saveBitmap(path, bitmap);
                if (result == 1) {
                    Intent intent=new Intent();
                    intent.putExtra("path", path);
                    setResult(RESULT_OK, intent);
                    finish();
                }
            }
        });

        initViewPaper();

    }

    /**
     * 水印布局
     */
    void initViewPaper(){
        LayoutInflater inflater=LayoutInflater.from(this);
        View view1=inflater.inflate(R.layout.water_camera_page1, null);
        View view2=inflater.inflate(R.layout.water_camera_page2, null);
        View view3=inflater.inflate(R.layout.water_camera_page3, null);
        View view4=inflater.inflate(R.layout.water_camera_page4, null);
        View view5=inflater.inflate(R.layout.water_camera_page5, null);

        v1_tv_hour=(TextView) view1.findViewById(R.id.tv_hour);
        v1_tv_day=(TextView) view1.findViewById(R.id.tv_day);
        v1_tv_hour.setText(hour);
        v1_tv_day.setText(day);

        v2_img_icon=(ImageView) view2.findViewById(R.id.img_icon);
        v2_tv_location=(TextView) view2.findViewById(R.id.tv_location);
        v2_tv_location.setText("我在郑州市金水区");
        v2_tv_time=(TextView) view2.findViewById(R.id.tv_time);
        v2_tv_time.setText(day+" "+hour);
        v2_tv_location.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                ToastUtil.showShortToast(WaterPhotoActivity.this, "郑州市金水区");
            }
        });

        v3_tv_address=(TextView) view3.findViewById(R.id.tv_address);
        v3_tv_time=(TextView) view3.findViewById(R.id.tv_time);
        v3_tv_time.setText(day+" "+hour);

        v4_tv_time=(TextView) view4.findViewById(R.id.tv_time);
        v4_tv_info=(TextView) view4.findViewById(R.id.tv_info);//心情
        v4_tv_time.setText(day+" "+hour);
        v4_tv_info.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                showPopupWindow(v4_tv_info);
            }
        });

        v5_tv_time=(TextView) view5.findViewById(R.id.tv_time);
        v5_tv_name=(TextView) view5.findViewById(R.id.tv_name);
        v5_tv_time.setText(day+" "+hour);
        v5_tv_name.setText("白玉梁");

        views.add(view1);
        views.add(view2);
        views.add(view3);
        views.add(view4);
        views.add(view5);

        mViewPager.setAdapter(new MyViewPagerAdapter());
        mViewPager.setOnPageChangeListener(new MyOnPagerChangeListener());
        mViewPager.setCurrentItem(waterType);
    }

    private void scrollImageView(Bitmap bitmap) {
        if(cameraPosition==0){//前置摄像头
            scroll=-90;
        }else{//后置

        }
        Matrix matrix = new Matrix();
        matrix.preRotate(scroll);
        bitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(),bitmap.getHeight(), matrix, true);
        mImageView.setImageBitmap(bitmap);
    }


    // 获取指定Activity的截屏，保存到png文件
    private Bitmap getScreenShot(RelativeLayout waterPhoto) {
        View view = waterPhoto;
        view.setDrawingCacheEnabled(true);
        view.buildDrawingCache();
        Bitmap bitmap = view.getDrawingCache();
        int width=view.getWidth();
        int height=view.getHeight();
        Bitmap b = Bitmap.createBitmap(bitmap, 0, 0, width, height);
        view.destroyDrawingCache();
        return b;
    }

    //viewPager
    private class MyViewPagerAdapter extends PagerAdapter{
        @Override
        public int getCount() {
            return views.size();
        }
        @Override
        public boolean isViewFromObject(View arg0, Object arg1) {
            return arg0==arg1;
        }
        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(views.get(position));
        }
        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(views.get(position));
            return views.get(position);
        }

    }


    private class MyOnPagerChangeListener implements OnPageChangeListener{

        @Override
        public void onPageScrollStateChanged(int arg0) {
        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {
        }

        @Override
        public void onPageSelected(int arg0) {
            waterType=arg0;
            switch (arg0) {
                case 1:
                    v2_tv_location.setBackgroundResource(R.drawable.uncheck);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            v2_tv_location.setBackgroundDrawable(null);
                        }
                    }, 500);
                    break;
                case 2:
                    v3_tv_address.setBackgroundResource(R.drawable.uncheck);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            v3_tv_address.setBackgroundDrawable(null);
                        }
                    }, 500);
                    break;
                case 3:
                    v4_tv_info.setBackgroundResource(R.drawable.uncheck);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            v4_tv_info.setBackgroundDrawable(null);
                        }
                    }, 500);
                    break;
            }
        }

    }

    private void showPopupWindow(View parent){
        if (popWindow == null) {
            View view = layoutInflater.inflate(R.layout.mood_text,null);
            popWindow = new PopupWindow(view,LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT,true);
            initPop(view);
        }
        popWindow.setAnimationStyle(android.R.style.Animation_InputMethod);
        popWindow.setFocusable(true);
        popWindow.setOutsideTouchable(true);
        popWindow.setBackgroundDrawable(new BitmapDrawable());
        popWindow.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        popWindow.showAtLocation(parent, Gravity.CENTER, 0,0);
        popWindow.setOnDismissListener(new OnDismissListener() {
            @Override
            public void onDismiss() {

            }
        });
    }

    public void initPop(View view){
        mood1 = (TextView) view.findViewById(R.id.tv_1);
        mood2 = (TextView) view.findViewById(R.id.tv_2);
        mood3 = (TextView) view.findViewById(R.id.tv_3);
        mood4 = (TextView) view.findViewById(R.id.tv_4);
        mood5 = (TextView) view.findViewById(R.id.tv_5);
        tv_cancel= (TextView) view.findViewById(R.id.tv_cancel);
        mood1.setOnClickListener(this);
        mood2.setOnClickListener(this);
        mood3.setOnClickListener(this);
        mood4.setOnClickListener(this);
        mood5.setOnClickListener(this);
        tv_cancel.setOnClickListener(this);
    }

    @Override
    public void onClick(View arg0) {
        switch (arg0.getId()) {
            case R.id.tv_1:
                v4_tv_info.setText(getResources().getString(R.string.mood1));
                break;
            case R.id.tv_2:
                v4_tv_info.setText(getResources().getString(R.string.mood2));
                break;
            case R.id.tv_3:
                v4_tv_info.setText(getResources().getString(R.string.mood3));
                break;
            case R.id.tv_4:
                v4_tv_info.setText(getResources().getString(R.string.mood4));
                break;
            case R.id.tv_5:
                v4_tv_info.setText(getResources().getString(R.string.mood5));
                break;
        }
        if(popWindow!=null&&popWindow.isShowing()){
            popWindow.dismiss();
        }
    }


}

