package com.example.yyiwen.fastmaildemo.Utils;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;

import com.example.yyiwen.fastmaildemo.R;
import com.example.yyiwen.fastmaildemo.View.CustomDialog;


/**
 * Created by Administrator on 2016/2/25.
 */
public class DialogUtil {
    public static void show(Context context, String message) {
        final Dialog dialog = new CustomDialog(context, R.style.custom_dialog, message);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialog.show();

        new Handler().postDelayed(new Runnable() {
            public void run() {
                dialog.dismiss();
            }
        }, 2000);
    }

    public static void show(Context context, String message, int sec) {
        final Dialog dialog = new CustomDialog(context, R.style.custom_dialog, message);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialog.show();

        new Handler().postDelayed(new Runnable() {
            public void run() {
                dialog.dismiss();
            }
        }, sec);
    }
}
