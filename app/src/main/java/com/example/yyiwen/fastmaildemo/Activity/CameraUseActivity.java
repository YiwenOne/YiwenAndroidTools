package com.example.yyiwen.fastmaildemo.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.yyiwen.fastmaildemo.R;
import com.example.yyiwen.fastmaildemo.Utils.Const;
import com.example.yyiwen.fastmaildemo.Utils.UIUtils;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;
public class CameraUseActivity extends AppCompatActivity {
    private ImageView img;
    private Button btn;
    private final int REQUESTCODE=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera_use);
        File file=new File(Const.FILE_IMG_CACHE);
        if(!file.exists()){
            file.mkdirs();
        }
        initView();
    }
    private void initView() {
        img=(ImageView) findViewById(R.id.img);
        btn= (Button) findViewById(R.id.btn);
        btn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent=new Intent(CameraUseActivity.this,WaterCameraActivity.class);
                startActivityForResult(intent, REQUESTCODE);
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode ==RESULT_OK){
            if (requestCode == REQUESTCODE) {//拍照成功
                String path=data.getStringExtra("path");
                try{
                    //这里获取路径后转换为bitmap进行显示，我未做特殊处理，有可能会出现内存溢出，需注意
                    Bitmap bitmap=BitmapFactory.decodeFile(path);
                    img.setImageBitmap(bitmap);
                }catch(Exception e){
                    UIUtils.showToastSafe("错误："+e.getMessage());
                }
            }
        }
    }
}
