package com.example.yyiwen.fastmaildemo.Activity;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.example.yyiwen.fastmaildemo.R;

import java.util.ArrayList;

import butterknife.BindView;

public class DrawLayoutActivity extends AppCompatActivity {
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.navigation)
    NavigationView mAmNv;
    @BindView(R.id.drawer_layout)
    DrawerLayout mAmDl;
    @BindView(R.id.tabs)
    TabLayout mTabs;
    @BindView(R.id.vp_moudle)
    ViewPager mVpMoudle;
    @BindView(R.id.fab)
    FloatingActionButton mFab;

    private View mView_nav;
    private ImageView mIv_photo;
    private String[] mMoudleName = {"推荐", "新闻", "音乐", "美图", "附近", "视频", "发现"};
    private ArrayList<Fragment> mFragmentList = new ArrayList<Fragment>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draw_layout);
    }
}
