package com.example.yyiwen.fastmaildemo.Activity;




import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.PixelFormat;
import android.hardware.Camera;
import android.hardware.Camera.AutoFocusCallback;
import android.hardware.Camera.CameraInfo;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PictureCallback;
import android.hardware.Camera.Size;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.yyiwen.fastmaildemo.R;
import com.example.yyiwen.fastmaildemo.Utils.Const;
import com.example.yyiwen.fastmaildemo.Utils.ToastUtil;
import com.example.yyiwen.fastmaildemo.View.ImageTools;
import com.example.yyiwen.fastmaildemo.View.SupportedSizesReflect;

@SuppressWarnings("deprecation")
public class WaterCameraActivity extends Activity implements SurfaceHolder.Callback{

    private Context mContext;
    private SurfaceView mSurfaceView;
    //	private ImageView mCamera_sd;
    private ImageView change_camera,mTackPic;
    private ViewPager mViewPager;

    private Camera camera;
    private SurfaceHolder mHolder;
    List<Size> supportedPictureSizes,supportedPreviewSizes;
    // 0表示后置，1表示前置
    private int cameraCount,cameraPosition = 1;

    private List<View> views=new ArrayList<View>();
    private int waterType=0;

    private TextView v1_tv_hour,v1_tv_day;
    @SuppressWarnings("unused")
    private ImageView v2_img_icon;
    private TextView v2_tv_location,v2_tv_time;
    private TextView v3_tv_address,v3_tv_time;
    private TextView v4_tv_time,v4_tv_info;
    private TextView v5_tv_time,v5_tv_name;

    private SimpleDateFormat simpleDateFormat1,simpleDateFormat2;
    private String day,hour;

    private int w,h;
    private Size pictureSize,previewSize;
    @SuppressLint("SimpleDateFormat")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);//去掉标题栏
        setContentView(R.layout.activity_camera);
        mContext=this;
        WindowManager windowManager = getWindowManager();
        Display display = windowManager.getDefaultDisplay();
        w=display.getWidth();
        h=display.getHeight();
        cameraCount = Camera.getNumberOfCameras();// 得到摄像头的个数
        simpleDateFormat1=new SimpleDateFormat("yyyy-MM-dd");
        simpleDateFormat2=new SimpleDateFormat("HH:mm");
        Date date=new Date();
        day=simpleDateFormat1.format(date);
        hour=simpleDateFormat2.format(date);
        findView();
        initViewPaper();
        initData();
    }

    private void findView(){
        mSurfaceView=(SurfaceView) findViewById(R.id.surfaceView);
        change_camera=(ImageView) findViewById(R.id.change_camera);
        if(cameraCount<=1){
            change_camera.setVisibility(View.GONE);
        }else{
            change_camera.setVisibility(View.VISIBLE);
        }
        mTackPic=(ImageView) findViewById(R.id.tack_pic);
        mViewPager=(ViewPager) findViewById(R.id.viewPager);

    }

    private void initViewPaper(){
        //viewPager
        LayoutInflater inflater=LayoutInflater.from(mContext);
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
        v2_tv_time=(TextView) view2.findViewById(R.id.tv_time);
        v2_tv_time.setText(day+" "+hour);
        v2_tv_location=(TextView) view2.findViewById(R.id.tv_location);
        v2_tv_location.setText("我在郑州市");

        v3_tv_address=(TextView) view3.findViewById(R.id.tv_address);
        v3_tv_time=(TextView) view3.findViewById(R.id.tv_time);
        v3_tv_time.setText(day+" "+hour);

        v4_tv_time=(TextView) view4.findViewById(R.id.tv_time);
        v4_tv_info=(TextView) view4.findViewById(R.id.tv_info);
        v4_tv_time.setText(day+" "+hour);

        v5_tv_time=(TextView) view5.findViewById(R.id.tv_time);
        v5_tv_name=(TextView) view5.findViewById(R.id.tv_name);
        v5_tv_time.setText(day+" "+hour);
        v5_tv_name.setText("WaterMark");

        views.add(view1);
        views.add(view2);
        views.add(view3);
        views.add(view4);
        views.add(view5);

        mViewPager.setAdapter(new MyViewPagerAdapter());
        mViewPager.setOnPageChangeListener(new MyOnPagerChangeListener());

    }

    /**
     * 初始化相关data
     */
    private void initData() {
        // 获得句柄
        mHolder = mSurfaceView.getHolder();
        mHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
        mHolder.setKeepScreenOn(true);
        // 添加回调
        mHolder.addCallback(this);
        //切换前后置摄像头
        change_camera.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                try{
                    changeCamera();
                }catch(Exception e){
                    ToastUtil.showShortToast(WaterCameraActivity.this, "请检查您的手机是否支持前置摄像头");
                }
            }
        });
        //拍照
        mTackPic.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                takePic();
            }
        });
        //对焦
        mSurfaceView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                camera.autoFocus(null);
            }
        });

    }

    // 切换前后摄像头
    void changeCamera(){
        CameraInfo cameraInfo = new CameraInfo();
        for (int i = 0; i < cameraCount; i++) {
            Camera.getCameraInfo(i, cameraInfo);// 得到每一个摄像头的信息
            if (cameraPosition == 1) {
                // 现在是后置，变更为前置
                if (cameraInfo.facing == Camera.CameraInfo.CAMERA_FACING_FRONT) {
                    releaseCamera();//释放camera
                    camera = Camera.open(i);// 打开当前选中的摄像头
                    setStartPreview(camera,mHolder);// 通过surfaceview显示取景画面
                    cameraPosition = 0;
                    break;
                }
            } else {
                // 现在是前置， 变更为后置
                if (cameraInfo.facing == Camera.CameraInfo.CAMERA_FACING_BACK) {
                    releaseCamera();//释放camera
                    camera = Camera.open(i);
                    setStartPreview(camera,mHolder);
                    cameraPosition = 1;
                    break;
                }
            }

        }
    }

    // 保持前后摄像头状态
    void keepCamera(){
        CameraInfo cameraInfo = new CameraInfo();
        for (int i = 0; i < cameraCount; i++) {
            Camera.getCameraInfo(i, cameraInfo);// 得到每一个摄像头的信息
            if (cameraPosition == 1) {
                // 现在是前置， 变更为后置
                if (cameraInfo.facing == Camera.CameraInfo.CAMERA_FACING_BACK) {
                    camera = Camera.open(i);
                }
            } else {
                // 现在是后置，变更为前置
                if (cameraInfo.facing == Camera.CameraInfo.CAMERA_FACING_FRONT) {
                    camera = Camera.open(i);// 打开当前选中的摄像头
                }
            }
        }
    }

    //拍照
    void takePic(){
        if(camera!=null){
            if(cameraPosition==0){//前置
                try{
                    camera.takePicture(null, null, new MyPictureCallback());
                }catch(Exception e1){
                    ToastUtil.showShortToast(WaterCameraActivity.this, "拍照失败，请尝试重新拍摄");
                }
            }else{//后置
                camera.autoFocus(new AutoFocusCallback() {
                    @Override
                    public void onAutoFocus(boolean success, Camera arg1) {
                        if(success){
                            try{
                                camera.takePicture(null, null, new MyPictureCallback());
                            }catch(Exception e){
                                ToastUtil.showShortToast(WaterCameraActivity.this, "拍照失败，请尝试重新拍摄");
                            }
                        }
                    }
                });
            }
        }
    }

    @Override
    public void onStart() {
        try{
            if (this.checkCameraHardware(this) && (camera == null)) {
                // 打开camera
                keepCamera();
                if (mHolder != null) {
                    setStartPreview(camera,mHolder);
                }
            }
        }catch(Exception e){
            ToastUtil.showShortToast(WaterCameraActivity.this, "启动相机失败");
        }
        super.onStart();
    }


    @Override
    public void onPause() {
        super.onPause();
        /**
         * 记得释放camera，方便其他应用调用
         */
        releaseCamera();
    }

    /**
     * 释放mCamera
     */
    private void releaseCamera() {
        if (camera != null) {
            camera.setPreviewCallback(null);
            camera.stopPreview();// 停掉原来摄像头的预览
            camera.release();
            camera = null;
        }
    }



    private class MyPictureCallback implements PictureCallback{
        @Override
        public void onPictureTaken(byte[] data, Camera camera) {
            String photoName=System.currentTimeMillis()+".png";
            String path= Const.FILE_IMG_CACHE+photoName;
            if(ImageTools.saveBitmap(path, data)){
                Intent intent=new Intent(mContext,WaterPhotoActivity.class);
                intent.putExtra("cameraPosition", cameraPosition);
                intent.putExtra("path", path);
                intent.putExtra("waterType", waterType);
                startActivityForResult(intent, 1);
            }else{
                camera.startPreview();
            }
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode ==RESULT_OK){
            if(requestCode==1){
                String path=data.getStringExtra("path");
                Intent intent=new Intent();
                intent.putExtra("path", path);
                setResult(RESULT_OK, intent);
                finish();
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(camera!=null){
            camera.release();
            camera=null;
        }
    }

    public static int getPreviewDegree(Activity activity) {
        // 获得手机的方向
        int rotation = activity.getWindowManager().getDefaultDisplay().getRotation();
        int degree = 0;
        // 根据手机的方向计算相机预览画面应该选择的角度
        switch (rotation) {
            case Surface.ROTATION_0:
                degree = 90;
                break;
            case Surface.ROTATION_90:
                degree = 0;
                break;
            case Surface.ROTATION_180:
                degree = 270;
                break;
            case Surface.ROTATION_270:
                degree = 180;
                break;
        }
        return degree;
    }


    /**
     * 水印
     * @author Administrator
     */
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
    /**
     * 水印滑动监听
     * @author Administrator
     *
     */
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

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        setStartPreview(camera,mHolder);
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width,int height) {
        if (mHolder.getSurface() == null) {
            return;
        }
        try {
            camera.stopPreview();
        } catch (Exception e) {

        }
        setStartPreview(camera,mHolder);
    }
    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        /**
         * 记得释放camera，方便其他应用调用
         */
        releaseCamera();
        holder = null;
        mSurfaceView = null;
    }

    /** Check if this device has a camera */
    private boolean checkCameraHardware(Context context) {
        if (context.getPackageManager().hasSystemFeature(
                PackageManager.FEATURE_CAMERA)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 设置camera显示取景画面,并预览
     * @param camera
     */
    private void setStartPreview(Camera camera,SurfaceHolder holder){
        try {
            // 拍照,设置相关参数
            Camera.Parameters params = camera.getParameters();
            params.setPreviewFormat(PixelFormat.JPEG); // 图片预览格式
            params.setPictureFormat(PixelFormat.JPEG); // 图片格式
            params.setJpegQuality(100); // 图片质量
            supportedPictureSizes= SupportedSizesReflect.getSupportedPictureSizes(params);
            supportedPreviewSizes=SupportedSizesReflect.getSupportedPreviewSizes(params);
            if ( supportedPictureSizes != null &&
                    supportedPreviewSizes != null &&
                    supportedPictureSizes.size() > 0 &&
                    supportedPreviewSizes.size() > 0) {
                //2.x
                pictureSize = supportedPictureSizes.get(supportedPictureSizes.size()-1);
                int maxSize = 5616;
                for(Size size : supportedPictureSizes){
                    if(maxSize <= Math.max(size.width,size.height)){
                        pictureSize = size;
                        break;
                    }
                }
                previewSize = getOptimalPreviewSize(supportedPreviewSizes, w,h);
                params.setPreviewSize(previewSize.width,previewSize.height);
                params.setPictureSize(pictureSize.width,pictureSize.height);
            }

            params.setFocusMode(Parameters.FOCUS_MODE_AUTO);// 自动对焦
            camera.setParameters(params);
            camera.setPreviewDisplay(holder);
            int degree=getPreviewDegree(WaterCameraActivity.this);
            camera.setDisplayOrientation(degree);
            camera.startPreview();
        } catch (Exception e) {
            ToastUtil.showShortToast(WaterCameraActivity.this, "请检查您的手机是否支持拍照功能");
        }
    }

    private Size getOptimalPreviewSize(List<Size> sizes, int w, int h) {
        final double ASPECT_TOLERANCE = 0.1;
        double targetRatio = (double) w / h;
        if (sizes == null) return null;

        Size optimalSize = null;
        double minDiff = Double.MAX_VALUE;

        int targetHeight = h;

        // Try to find an size match aspect ratio and size
        for (Size size : sizes) {
            double ratio = (double) size.width / size.height;
            if (Math.abs(ratio - targetRatio)> ASPECT_TOLERANCE) continue;
            if (Math.abs(size.height - targetHeight)< minDiff) {
                optimalSize = size;
                minDiff = Math.abs(size.height - targetHeight);
            }
        }
        // Cannot find the one match the aspect ratio, ignore the requirement
        if (optimalSize == null) {
            minDiff = Double.MAX_VALUE;
            for (Size size : sizes) {
                if (Math.abs(size.height - targetHeight) < minDiff) {
                    optimalSize = size;
                    minDiff = Math.abs(size.height - targetHeight);
                }
            }
        }
        return optimalSize;
    }


}

