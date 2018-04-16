package com.example.yyiwen.fastmaildemo.Utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * sharePerfrence工具类
 * Created by y.yiwen on 1/4/2017.
 */
public class SPUtils {
    //SP的名字
    public final static String SP_NAME="config";
    //SP
    private static SharedPreferences sp;

    //保存boolean类型的值
    public static void saveBoolean(Context context,String key,boolean value){
        if(sp==null){
            sp=context.getSharedPreferences(SP_NAME,0);
            sp.edit().putBoolean(key,value).commit();
        }
    }

    //保存String类型的值
    public static void saveString(Context context,String key,String value){
        if(sp==null){
            sp=context.getSharedPreferences(SP_NAME,0);
            sp.edit().putString(key,value).commit();
        }
    }

    //保存int类型的值
    public static void saveInt(Context context,String key,int value){
        if(sp==null){
            sp=context.getSharedPreferences(SP_NAME,0);
            sp.edit().putInt(key,value).commit();
        }
    }

    //获取boolean的值
    public static boolean getBoolean(Context context,String key,boolean value){
        if(sp==null){
            sp=context.getSharedPreferences(SP_NAME,0);
        }
        return sp.getBoolean(key,value);
    }
    //获取String的值
    public static String getString(Context context,String key,String value){
        if(sp==null){
            sp=context.getSharedPreferences(SP_NAME,0);
        }
        return sp.getString(key,value);
    }
    //获取int的值
    public static int getint(Context context,String key,int value){
        if(sp==null){
            sp=context.getSharedPreferences(SP_NAME,0);
        }
        return sp.getInt(key,value);
    }
}
