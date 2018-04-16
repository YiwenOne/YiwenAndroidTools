package com.example.yyiwen.fastmaildemo.View;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;

import com.example.yyiwen.fastmaildemo.R;


/**
 * Created by Administrator on 2016/2/25.
 */
public class CustomDialog extends Dialog {
    Context context;
    private String message;

    public CustomDialog(Context context) {
        super(context);
        // TODO Auto-generated constructor stub
        this.context = context;
    }

    public CustomDialog(Context context, int theme) {
        super(context, theme);
        this.context = context;
    }

    public CustomDialog(Context context, int theme, String message) {
        super(context, theme);
        this.message = message;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.custom_dialog);

        TextView textView = (TextView) findViewById(R.id.content);
        textView.setText(message);
    }
}
