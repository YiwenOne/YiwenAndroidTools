package com.example.yyiwen.fastmaildemo.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.yyiwen.fastmaildemo.Activity.AnimationActivity;
import com.example.yyiwen.fastmaildemo.Activity.CompassActivity;
import com.example.yyiwen.fastmaildemo.Activity.DrawActivity;
import com.example.yyiwen.fastmaildemo.Activity.DrawableActivity;
import com.example.yyiwen.fastmaildemo.Activity.FileActivity;
import com.example.yyiwen.fastmaildemo.Activity.GesturePasswordActivity;
import com.example.yyiwen.fastmaildemo.Activity.IntentActivity;
import com.example.yyiwen.fastmaildemo.Activity.JSAndroidActivity;
import com.example.yyiwen.fastmaildemo.Activity.LoadMoreActivity;
import com.example.yyiwen.fastmaildemo.Activity.MoreTextShowAndHideActivity;
import com.example.yyiwen.fastmaildemo.Activity.RecyclerViewActivity;
import com.example.yyiwen.fastmaildemo.Activity.TabLayoutBottomActivity;
import com.example.yyiwen.fastmaildemo.Activity.TabLayoutTopActivity;
import com.example.yyiwen.fastmaildemo.Activity.WebActivity;
import com.example.yyiwen.fastmaildemo.Activity.WebViewActivity;
import com.example.yyiwen.fastmaildemo.Activity.WebViewDemo;
import com.example.yyiwen.fastmaildemo.R;
import com.example.yyiwen.fastmaildemo.View.CompassView;
import com.example.yyiwen.fastmaildemo.View.GlideImageLoader;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;

import java.util.ArrayList;
import java.util.List;

public class SearchFragment extends Fragment implements View.OnClickListener{

    private com.example.yyiwen.fastmaildemo.View.CircleImageView mIv_head_iamge;
    private TextView mTv_title;
    private ImageView mIv_tag;
    private ImageView mIv_map;
    Button btn_paint,btn_tabLayout_top,btn_tabLayout_bottom,btn_gesture_password,
            btn_intent,btn_write_read,btn_animation,btn_draw,btn_js_android,btn_webview,btn_loadmore,btn_RecyclerView,btn_compassView,btn_more_tv_showAndHide;
    SlidingMenu sMenu;
    Intent intent;
    private LinearLayout ll_title;
    private LinearLayout ll_content;
    boolean isTrue=false;
    private Banner banner;
    private List<String> imageUrl;
    private List<String> bannerTitle;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View view=inflater.inflate(R.layout.fragment_search, container, false);
        //初始化
        mIv_head_iamge = (com.example.yyiwen.fastmaildemo.View.CircleImageView) view.findViewById(R.id.iv_head_iamge);
        mTv_title = (TextView) view.findViewById(R.id.tv_title);
        mIv_tag = (ImageView) view.findViewById(R.id.iv_tag);
        mIv_map = (ImageView) view.findViewById(R.id.iv_map);
        btn_paint= (Button) view.findViewById(R.id.btn_paint);
        btn_tabLayout_top= (Button) view.findViewById(R.id.btn_tabLayout_top);
        btn_tabLayout_bottom= (Button) view.findViewById(R.id.btn_tabLayout_bottom);
        btn_gesture_password= (Button) view.findViewById(R.id.btn_gesture_password);
        btn_intent= (Button) view.findViewById(R.id.btn_intent);
        btn_write_read= (Button) view.findViewById(R.id.btn_write_read);
        btn_animation= (Button) view.findViewById(R.id.btn_animation);
        btn_draw= (Button) view.findViewById(R.id.btn_draw);
        btn_js_android= (Button) view.findViewById(R.id.btn_js_android);
        btn_webview= (Button) view.findViewById(R.id.btn_webview);
        btn_loadmore= (Button) view.findViewById(R.id.btn_loadmore);
        btn_RecyclerView= (Button) view.findViewById(R.id.btn_RecyclerView);
        btn_compassView= (Button) view.findViewById(R.id.btn_compassView);
        btn_more_tv_showAndHide= (Button) view.findViewById(R.id.btn_more_tv_showAndHide);
        ll_title= (LinearLayout) view.findViewById(R.id.ll_title);
        ll_content= (LinearLayout) view.findViewById(R.id.ll_content);
        banner = (Banner) view.findViewById(R.id.banner);
        initData();
        initBanner();

        //设置点击
        initListener();

        //1)创建SlidingMenu
        sMenu = new SlidingMenu(getActivity());
        //2)设置属性：mode,menu,阴影图片及宽度，touch,菜单的宽度,透明度
        sMenu.setMode(SlidingMenu.LEFT);

        sMenu.setMenu(R.layout.left_menu);
        sMenu.setShadowDrawable(R.drawable.left_shadow);
        sMenu.setShadowWidth(10);

        sMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_MARGIN);
        sMenu.setBehindOffset(160);

        sMenu.setFadeEnabled(true);
        sMenu.setFadeDegree(0.5f);
        //将碎片挂到左侧菜单
        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.llMenu, new LeftFragment()).commit();
        //3)将menu 挂到Activity
        sMenu.attachToActivity(getActivity(), SlidingMenu.SLIDING_CONTENT);

        return view;
    }
    private void initData() {
        //图片地址
        imageUrl = new ArrayList<>();
        imageUrl.add("http://img05.tooopen.com/images/20140604/sy_62331342149.jpg");
        imageUrl.add("http://pic33.nipic.com/20130916/3420027_192919547000_2.jpg");
        imageUrl.add("http://img.taopic.com/uploads/allimg/121017/234940-12101FR22825.jpg");


        //Title名称
        bannerTitle = new ArrayList<>();
        bannerTitle.add("一");
        bannerTitle.add("二");
        bannerTitle.add("三");
    }
    private void initBanner() {

        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
        //靠左显示指示器
//        banner.setIndicatorGravity(BannerConfig.LEFT);
        banner.setIndicatorGravity(BannerConfig.RIGHT);
        //设置图片加载器
        banner.setImageLoader(new GlideImageLoader());
        //设置图片集合
        banner.setImages(imageUrl);
        //设置banner动画效果
        banner.setBannerAnimation(Transformer.ScaleInOut);
        //设置标题集合（当banner样式有显示title时）
        banner.setBannerTitles(bannerTitle);
        //设置自动轮播，默认为true
        banner.isAutoPlay(true);
        //设置轮播时间
        banner.setDelayTime(1500);
        //设置指示器位置（当banner模式中有指示器时）
        banner.setIndicatorGravity(BannerConfig.CENTER);
        //banner设置方法全部调用完毕时最后调用
        banner.start();
    }
    private void initListener() {
        mIv_head_iamge.setOnClickListener(this);
        btn_paint.setOnClickListener(this);
        btn_tabLayout_top.setOnClickListener(this);
        btn_tabLayout_bottom.setOnClickListener(this);
        btn_gesture_password.setOnClickListener(this);
        btn_intent.setOnClickListener(this);
        btn_write_read.setOnClickListener(this);
        btn_animation.setOnClickListener(this);
        btn_draw.setOnClickListener(this);
        btn_js_android.setOnClickListener(this);
        btn_webview.setOnClickListener(this);
        btn_loadmore.setOnClickListener(this);
        btn_RecyclerView.setOnClickListener(this);
        btn_compassView.setOnClickListener(this);
        btn_more_tv_showAndHide.setOnClickListener(this);
        ll_title.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_head_iamge:
                sMenu.toggle();
                break;
            case R.id.iv_tag:

                break;
            case R.id.iv_map:

                break;
            case R.id.btn_paint:
                intent=new Intent(getActivity(),DrawableActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_tabLayout_top:
                intent=new Intent(getActivity(),TabLayoutTopActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_tabLayout_bottom:
                intent=new Intent(getActivity(),TabLayoutBottomActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_gesture_password:
                intent=new Intent(getActivity(),GesturePasswordActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_intent:
                intent=new Intent(getActivity(),IntentActivity.class);
                startActivity(intent);

                break;
            case R.id.btn_write_read:
                intent=new Intent(getActivity(),FileActivity.class);

                startActivity(intent);
                break;
            case R.id.btn_animation:
                intent=new Intent(getActivity(),AnimationActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_draw:
                intent=new Intent(getActivity(),DrawActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_js_android:
                intent=new Intent(getActivity(),WebActivity.class);
                startActivity(intent);
            case R.id.btn_webview:
                intent=new Intent(getActivity(),WebViewActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_loadmore:
                intent=new Intent(getActivity(),LoadMoreActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_RecyclerView:
                intent=new Intent(getActivity(),RecyclerViewActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_compassView:
                intent=new Intent(getActivity(),CompassActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_more_tv_showAndHide:
                intent=new Intent(getActivity(),MoreTextShowAndHideActivity.class);
                startActivity(intent);
                break;
        }
    }
    /**
     * 设置添加屏幕的背景透明度
     * @param bgAlpha
     */
    public void backgroundAlpha(float bgAlpha)
    {
        WindowManager.LayoutParams lp = getActivity().getWindow().getAttributes();
        lp.alpha = bgAlpha; //0.0-1.0
        getActivity().getWindow().setAttributes(lp);
    }
}
