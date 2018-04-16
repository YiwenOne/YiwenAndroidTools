package com.example.yyiwen.fastmaildemo.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.yyiwen.fastmaildemo.R;
import com.example.yyiwen.fastmaildemo.View.CollapsibleTextView;


public class MoreTextShowAndHideActivity extends BaseActivity implements View.OnClickListener{

    private String shortText="我是一个短文本";

    private String longText="在进行Android应用开发的过程中都会涉及到注册登录功能模块的实现， " +
            "而许多的注册或者登录或者修改密码功能常常是需要用户去输入短信验证码，通常，" +
            "用户收到短信验证码需要最小化应用去查看短信再次回到应用输入相对于的验证码，" +
            "这个过程处理有点麻烦，因此有必要应该能够自动获得下发成功的短信验证码，" +
            "方便用户操作，用户体验效果也会好一点。";
    //显示文本
    private CollapsibleTextView collapsibleTextView;

    private Button showShort,showLong,collapsed,redSuffix,blueSuffix,expanded,collapsed1line,collapsed2lines,suffixTrigger,fullTextTrigger,
            collapsedTextShowText,collapsedTextShowAll,expandedTextHide,expandedTextHideText;
    @Override
    protected void initView() {
        setContentView(R.layout.activity_more_text_show_and_hide);
        //初始化组件
        collapsibleTextView= (CollapsibleTextView) findViewById(R.id.collapsibleTextView);
        showShort= (Button) findViewById(R.id.showShort);
        showLong= (Button) findViewById(R.id.showLong);
        collapsed= (Button) findViewById(R.id.collapsed);
        redSuffix= (Button) findViewById(R.id.redSuffix);
        blueSuffix= (Button) findViewById(R.id.blueSuffix);
        expanded= (Button) findViewById(R.id.expanded);
        collapsed1line= (Button) findViewById(R.id.collapsed1line);
        collapsed2lines= (Button) findViewById(R.id.collapsed2lines);
        suffixTrigger= (Button) findViewById(R.id.suffixTrigger);
        fullTextTrigger= (Button) findViewById(R.id.fullTextTrigger);
        collapsedTextShowText= (Button) findViewById(R.id.collapsedTextShowText);
        collapsedTextShowAll= (Button) findViewById(R.id.collapsedTextShowAll);
        expandedTextHide= (Button) findViewById(R.id.expandedTextHide);
        expandedTextHideText= (Button) findViewById(R.id.expandedTextHideText);

    }

    @Override
    protected void initData() {
        collapsibleTextView.setFullString(longText);
    }

    @Override
    protected void initListener() {
        collapsibleTextView.setOnClickListener(this);
        showShort.setOnClickListener(this);
        showLong.setOnClickListener(this);
        collapsed.setOnClickListener(this);
        redSuffix.setOnClickListener(this);
        blueSuffix.setOnClickListener(this);
        expanded.setOnClickListener(this);
        collapsed1line.setOnClickListener(this);
        collapsed2lines.setOnClickListener(this);
        suffixTrigger.setOnClickListener(this);
        fullTextTrigger.setOnClickListener(this);
        collapsedTextShowText.setOnClickListener(this);
        collapsedTextShowAll.setOnClickListener(this);
        expandedTextHide.setOnClickListener(this);
        expandedTextHideText.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.showShort:
                collapsibleTextView.setFullString(shortText);
                break;
            case R.id.showLong:
                collapsibleTextView.setFullString(longText);
                break;
            case R.id.expanded:
                collapsibleTextView.setExpanded(true);
                break;
            case R.id.collapsed:
                collapsibleTextView.setExpanded(false);
                break;
            case R.id.redSuffix:
                collapsibleTextView.setSuffixColor(R.color.red);
                break;
            case R.id.blueSuffix:
                collapsibleTextView.setSuffixColor(R.color.blue);
                break;
            case R.id.collapsed1line:
                collapsibleTextView.setCollapsedLines(1);
                break;
            case R.id.collapsed2lines:
                collapsibleTextView.setCollapsedLines(2);
                break;
            case R.id.suffixTrigger:
                collapsibleTextView.setSuffixTrigger(true);
                break;
            case R.id.fullTextTrigger:
                collapsibleTextView.setSuffixTrigger(false);
                break;
            case R.id.collapsedTextShowText:
                collapsibleTextView.setCollapsedText("显示全部");
                break;
            case R.id.collapsedTextShowAll:
                collapsibleTextView.setCollapsedText("显示");
                break;
            case R.id.expandedTextHide:
                collapsibleTextView.setExpandedText("隐藏文本");
                break;
            case R.id.expandedTextHideText:
                collapsibleTextView.setExpandedText("隐藏");
                break;

        }
    }
}
