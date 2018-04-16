package com.example.yyiwen.fastmaildemo.Activity;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.yyiwen.fastmaildemo.R;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileActivity extends Activity implements View.OnClickListener{
    private static final String FILE_NAME="temp.txt";
    Button btn_write,btn_read;
    EditText edit1,edit2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file);
        btn_write= (Button) findViewById(R.id.btn_wtite);
        btn_read= (Button) findViewById(R.id.btn_read);
        edit1= (EditText) findViewById(R.id.edit1);
        edit2= (EditText) findViewById(R.id.edit2);
        //点击监听
        initListener();
    }

    private void initListener() {
        btn_write.setOnClickListener(this);
        btn_read.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_wtite:
                write(edit1.getText().toString());
                break;
            case R.id.btn_read:
                String TEXT=read();
                edit2.setText(TEXT);
                break;
        }
    }
    //读的方法
    private String read(){
        try {
            //初始化输入流
            FileInputStream fis=new FileInputStream(FILE_NAME);
            //定义缓存数组
            byte[] buffer=new byte[fis.available()];
            //读到缓冲区
            fis.read(buffer);
            return new String(buffer);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    //写的方法
    private void write(String content){
        try {
            //初始化输出流
            FileOutputStream fos=openFileOutput(FILE_NAME,MODE_APPEND);
            //写内容
            fos.write(content.getBytes());
            //关闭文件流
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
