package com.example.yyiwen.fastmaildemo.Activity;

import android.content.Context;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

import com.example.yyiwen.fastmaildemo.Listener.OnDismissListener;
import com.example.yyiwen.fastmaildemo.Listener.OnItemClickListener;
import com.example.yyiwen.fastmaildemo.R;
import com.example.yyiwen.fastmaildemo.Utils.UIUtils;
import com.example.yyiwen.fastmaildemo.View.AlertView;
import com.example.yyiwen.fastmaildemo.View.CustomDashedLineView;

/**
 * 多种类型弹出框
 */
public class MoreDialogActivity extends BaseActivity implements OnItemClickListener,OnDismissListener{
    //避免重复创建View，先创建View,然后需要的时候show出来
    private AlertView alertView;
    //窗口拓展例子
    private AlertView alertViewExt;
    //拓展View内容
    private EditText etName;

    private InputMethodManager imm;
    //虚线
    CustomDashedLineView customDashedLineView;
    @Override
    protected void initView() {
        setContentView(R.layout.activity_more_dialog);
        //初始化组件
        imm= (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);

        alertView=new AlertView("标题","内容","取消",new String[]{"确定"},null,this,AlertView.Style.Alert,this).setCancelable(true)
                .setOnDismissListener(this);
        //拓展窗口
        alertViewExt=new AlertView("提示","请完善你的个人资料","取消",null,new String[]{"完成"},this,AlertView.Style.Alert,this);

        ViewGroup extView= (ViewGroup) LayoutInflater.from(this).inflate(R.layout.alertext_form,null);
        etName= (EditText) extView.findViewById(R.id.etName);
        etName.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                //输入框出来则往上移动
                boolean isOpen=imm.isActive();
                alertViewExt.setMarginBottom(isOpen&&hasFocus?120:0);
                System.out.print(isOpen);
            }
        });
        alertViewExt.addExtView(extView);
    }

    public void alertShow1(View view){

        alertView.show();
    }

    public void alertShow2(View view) {
        new AlertView("标题", "内容", null, new String[]{"确定"}, null, this, AlertView.Style.Alert, this).show();
    }

    public void alertShow3(View view) {
        new AlertView(null, null, null, new String[]{"高亮按钮1", "高亮按钮2", "高亮按钮3"},
                new String[]{"其他按钮1", "其他按钮2", "其他按钮3", "其他按钮4", "其他按钮5", "其他按钮6",
                        "其他按钮7", "其他按钮8", "其他按钮9", "其他按钮10", "其他按钮11", "其他按钮12"},
                this, AlertView.Style.Alert, this).show();
    }

    public void alertShow4(View view) {
        new AlertView("标题", null, "取消", new String[]{"高亮按钮1"}, new String[]{"其他按钮1", "其他按钮2", "其他按钮3"}, this, AlertView.Style.ActionSheet, this).show();
    }

    public void alertShow5(View view) {
        new AlertView("标题", "内容", "取消", null, null, this, AlertView.Style.ActionSheet, this).setCancelable(true).show();
    }

    public void alertShow6(View view) {
        new AlertView("上传头像", null, "取消", null,
                new String[]{"拍照", "从相册中选择"},
                this, AlertView.Style.ActionSheet, this).show();
    }

    public void alertShowExt(View view) {
        alertViewExt.show();
    }

    private void closeKeyBoard(){
        //关闭软键盘
        imm.hideSoftInputFromWindow(etName.getWindowToken(),0);
        //恢复位置
        alertViewExt.setMarginBottom(0);
    }


    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {

    }

    @Override
    public void onDismiss(Object o) {
        closeKeyBoard();
        Toast.makeText(this, "消失了", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemClick(Object o, int position) {
        closeKeyBoard();
        //判断是否是拓展窗口View,而且点击的是非取消按钮
        if(o==alertViewExt&&position!=AlertView.CANCELPOSITION){
            String name=etName.getText().toString();
            if(name.isEmpty()){
                Toast.makeText(this, "啥都没填呢", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this, "hello,"+name, Toast.LENGTH_SHORT).show();
            }
            return;
        }
        Toast.makeText(this, "点击了第" + position + "个", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode==event.KEYCODE_BACK&&event.getRepeatCount()==0){
            if(alertView!=null&&alertView.isShowing()){
                alertView.dismiss();
                return false;
            }
        }
        return super.onKeyDown(keyCode, event);
    }
}
