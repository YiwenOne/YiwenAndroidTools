package com.example.yyiwen.fastmaildemo.Application;

import android.app.Application;

/**
 *
 */
public class MyApplication extends BaseApplication {

    private static MyApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        this.instance = this;
    }



    public static MyApplication getInstance() {
        return instance;
    }


}

