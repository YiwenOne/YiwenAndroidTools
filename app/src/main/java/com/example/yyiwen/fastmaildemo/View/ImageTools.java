package com.example.yyiwen.fastmaildemo.View;

/**
 * Created by y.yiwen on 12/22/2016.
 */
import java.io.File;
import java.io.FileOutputStream;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
public class ImageTools {
    /**
     * save
     * @param path
     * @param buffer
     * @return
     */
    public static boolean saveBitmap(String path,byte[] buffer){
        boolean result=false;
        try {
            FileOutputStream out=new FileOutputStream(new File(path));
            out.write(buffer);
            out.flush();
            out.close();
            result=true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;

    }

    public static int saveBitmap(String path,Bitmap bitmap){
        int result=-1;
        try {
            FileOutputStream fos=new FileOutputStream(new File(path));
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos);
            fos.flush();
            fos.close();
            result=1;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;

    }

    /**
     *
     * @param filePath
     * @return
     */
    public static Bitmap getdecodeBitmap(String filePath,int ww,int hh){
        if(filePath==null){
            return null;
        }
        BitmapFactory.Options options=new Options();
        options.inJustDecodeBounds=true;
        Bitmap bitmap=BitmapFactory.decodeFile(filePath, options);

        int width=options.outWidth;
        int height=options.outHeight;
        float scale=1f;
        if(width>ww&&width>height){
            scale=width/ww;
        }else if(height>hh&&height>width){
            scale=height/hh;
        }else{
            scale=1;
        }

        options.inSampleSize=(int) scale;
        options.inJustDecodeBounds=false;
        bitmap=BitmapFactory.decodeFile(filePath, options);
        return bitmap;
    }
}
