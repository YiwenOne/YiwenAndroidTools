package com.example.yyiwen.fastmaildemo.Activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.yyiwen.fastmaildemo.Bean.LoginInfo;
import com.example.yyiwen.fastmaildemo.NetRequest.NetWorkUtils;
import com.example.yyiwen.fastmaildemo.R;
import com.example.yyiwen.fastmaildemo.Utils.DialogUtil;
import com.example.yyiwen.fastmaildemo.Utils.SPUtils;
import com.example.yyiwen.fastmaildemo.Utils.UIUtils;
import com.example.yyiwen.fastmaildemo.Utils.UrlUtils;
import com.example.yyiwen.fastmaildemo.View.ClearEditText;

import java.util.HashSet;
import java.util.Set;

import rx.Observer;

public class LoginActivity extends BaseActivity {
    /*账号*/
    private ClearEditText et_accounts;
    /*密码*/
    private ClearEditText et_password;
    /*登录*/
    private Button btn_login;

    LinearLayout LinearLayout1;

    private ProgressDialog progressDialog;

    private Context context = LoginActivity.this;


    @Override
    protected void initView() {
        setContentView(R.layout.activity_login);
        //初始化组件
        et_accounts = (ClearEditText) findViewById(R.id.et_accounts);
        et_password = (ClearEditText) findViewById(R.id.et_password);
        btn_login = (Button) findViewById(R.id.btn_login);
        LinearLayout1 = (LinearLayout) findViewById(R.id.LinearLayout1);
        LinearLayout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //收起软键盘
                InputMethodManager imm = (InputMethodManager)
                        getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
            }
        });
        et_password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(et_accounts.getText())) {
                    //设置晃动
                    et_accounts.setShakeAnimation();
                    //设置提示
                    UIUtils.showToastSafe("用户名不能为空");
                    return;
                }
                if (TextUtils.isEmpty(et_password.getText())) {
                    et_password.setShakeAnimation();
                    et_password.setFocusable(true);
                    et_password.setFocusableInTouchMode(true);
                    UIUtils.showToastSafe("密码不能为空");
                    return;
                }
                //得到用户输入的账号
                final String accounts = et_accounts.getText().toString();
                //得到用户输入的密码
                final String password = et_password.getText().toString();
                loginInProcess(accounts, password);
            }
        });
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {

    }

    private void loginInProcess(final String accounts, final String password) {
        //dialog = ProgressDialog.show(context, null, "加载中,请稍等...", false);
        progressDialog = new ProgressDialog(context, R.style.theme_customer_progress_dialog);
        //progressDialog = new ProgressDialog(context);
        progressDialog.setMessage("加载中,请稍等...");
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.show();
        //初始化Volley
        String strURL = String.format(UrlUtils.Login + "User=%s&Pwd=%s&frm=", accounts, password);
        NetWorkUtils.verfacationCodeGet(accounts,password, new Observer<LoginInfo>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

                Log.e("MAIN2",e.getLocalizedMessage()+"--"+e.getMessage());
            }

            @Override
            public void onNext(LoginInfo loginInfo) {
                if (loginInfo.getRole() == null) {
                    DialogUtil.show(context, "此账号没有关联角色！");
                    progressDialog.hide();
                    return;
                }
                if (loginInfo.getRole().get(0).getRoleName().equals("销售顾问")) {
                    DialogUtil.show(context, "此账号销售顾问！");
                } else if (loginInfo.getRole().get(0).getRoleName().equals("经理") || loginInfo.getRole().get(0).getRoleName().equals("内训师")) {
                    DialogUtil.show(context, "此账号经理！");
                } else if (loginInfo.getRole().get(0).getRoleName().equals("总经理")) {
                    DialogUtil.show(context, "此账号总经理！");
                } else {
                    DialogUtil.show(context, "此账号不能登录系统！");
                    progressDialog.hide();
                    return;
                }
            }
        });
    }


}
