package com.example.yyiwen.fastmaildemo.Fragment;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.example.yyiwen.fastmaildemo.R;

/**
 *  DialogFragment
 */
public class AdDialogFragment extends DialogFragment implements View.OnClickListener{

    private TextView tv1,tv2,tv3,tv4;
    public interface OnDialogListener{
        void onDialogClick(String person);
    }
    @Override
    public void onStart() {
        super.onStart();
        Window window = getDialog().getWindow();
        WindowManager.LayoutParams params = window.getAttributes();
        params.gravity = Gravity.BOTTOM;
        params.width = WindowManager.LayoutParams.MATCH_PARENT;
        window.setAttributes(params);
        //设置背景透明
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //加这句话去掉自带的标题栏
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
        View view = inflater.inflate(R.layout.fragment_blank, null);
        tv1= (TextView) view.findViewById(R.id.tv1);
        tv2= (TextView) view.findViewById(R.id.tv2);
        tv3= (TextView) view.findViewById(R.id.tv3);
        tv4= (TextView) view.findViewById(R.id.tv4);


        //init(view);
        initListener();
        return view;
    }

    private void initListener() {
        tv1.setOnClickListener(this);
        tv2.setOnClickListener(this);
        tv3.setOnClickListener(this);
        tv4.setOnClickListener(this);
    }



    public OnDialogListener mlistener;
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv1:
//                mlistener.onDialogClick("1");
                dismiss();
                break;
            case R.id.tv2:
//                mlistener.onDialogClick("2");
                dismiss();
                break;
            case R.id.tv3:
//                mlistener.onDialogClick("3");
                dismiss();
                break;
            case R.id.tv4:
//                mlistener.onDialogClick("4");
                dismiss();
                break;
            default:
                break;


        }
    }
    public void setOnDialogListener(OnDialogListener dialogListener){
        this.mlistener=dialogListener;
    }
}
