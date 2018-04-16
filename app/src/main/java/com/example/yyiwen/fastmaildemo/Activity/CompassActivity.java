package com.example.yyiwen.fastmaildemo.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.yyiwen.fastmaildemo.R;
import com.example.yyiwen.fastmaildemo.View.CompassView;

public class CompassActivity extends AppCompatActivity {
    CompassView compassView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        compassView=new CompassView(this);
        setContentView(compassView);
        compassView.setBearing(45);
//        setContentView(R.layout.activity_compass);
//        compassView= (CompassView) findViewById(R.id.compassView);
//        compassView.setBearing(45);
    }
}
