package com.example.yyiwen.fastmaildemo.Activity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.yyiwen.fastmaildemo.R;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class FileOutputAndInputActivity extends AppCompatActivity {
    String FILE_NAME="tempfile.tmp";
    FileOutputStream fos;
    FileInputStream fis;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_output_and_input);
        try {
            //创建一个文件输出流
            fos=openFileOutput(FILE_NAME, Context.MODE_PRIVATE);
            //创建一个文件输入流
            fis=openFileInput(FILE_NAME);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
