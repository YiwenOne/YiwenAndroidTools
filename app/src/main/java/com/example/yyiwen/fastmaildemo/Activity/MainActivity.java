package com.example.yyiwen.fastmaildemo.Activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.yyiwen.fastmaildemo.Fragment.DiscloseFragment;
import com.example.yyiwen.fastmaildemo.Fragment.LeftFragment;
import com.example.yyiwen.fastmaildemo.Fragment.NearFragment;
import com.example.yyiwen.fastmaildemo.Fragment.SearchFragment;
import com.example.yyiwen.fastmaildemo.R;
import com.example.yyiwen.fastmaildemo.View.CircleImageView;
import com.example.yyiwen.fastmaildemo.View.CustomViewPage;
import com.example.yyiwen.fastmaildemo.View.GlideImageLoader;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;


import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements LeftFragment.CallBack{
    CircleImageView iv_head_iamge;
    private CustomViewPage mLayout_content;
    private RadioGroup mMain_radio;
    private RadioButton mRb_search;
    private RadioButton mRb_near;
    private RadioButton mRb_disclose;
    /*碎片集合*/
    private List<Fragment> fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mLayout_content = (com.example.yyiwen.fastmaildemo.View.CustomViewPage) findViewById(R.id.layout_content);
        mMain_radio = (RadioGroup) findViewById(R.id.main_radio);
        mRb_search = (RadioButton) findViewById(R.id.rb_search);
        mRb_near = (RadioButton) findViewById(R.id.rb_near);
        mRb_disclose = (RadioButton) findViewById(R.id.rb_disclose);

        init();
    }

    private void init() {
        fragments=new ArrayList<Fragment>();
        fragments.add(new SearchFragment());
        fragments.add(new NearFragment());
        fragments.add(new DiscloseFragment());
        MainAdapter mainAdapter=new MainAdapter(getSupportFragmentManager());
        mLayout_content.setAdapter(mainAdapter);
        mRb_search.setTextColor(getResources().getColor(R.color.blue));
        mMain_radio.check(R.id.rb_search);
        mLayout_content.setCurrentItem(0, false);

        mMain_radio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_search:
                        mRb_search.setTextColor(getResources().getColor(R.color.blue));
                        mRb_near.setTextColor(getResources().getColor(R.color.font1));
                        mRb_disclose.setTextColor(getResources().getColor(R.color.font1));
                        mLayout_content.setCurrentItem(0, false);
                        //设置滑动菜单不运行滑动
                        break;
                    case R.id.rb_near:
                        mRb_search.setTextColor(getResources().getColor(R.color.font1));
                        mRb_near.setTextColor(getResources().getColor(R.color.blue));
                        mRb_disclose.setTextColor(getResources().getColor(R.color.font1));
                        mLayout_content.setCurrentItem(1, false);
                        break;
                    case R.id.rb_disclose:
                        mRb_search.setTextColor(getResources().getColor(R.color.font1));
                        mRb_near.setTextColor(getResources().getColor(R.color.font1));
                        mRb_disclose.setTextColor(getResources().getColor(R.color.blue));
                        mLayout_content.setCurrentItem(2, false);
                        break;
                }
            }
        });
    }

    @Override
    public void callback(String str) {
        Bundle bundle1 = new Bundle();
        bundle1.putString("str",str);
        new SearchFragment().setArguments(bundle1);
    }

    private class MainAdapter extends FragmentPagerAdapter{

        public MainAdapter(FragmentManager fm) {
            super(fm);
        }

























































































































        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return 3;
        }
    }
}
