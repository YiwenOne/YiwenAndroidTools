package com.example.yyiwen.fastmaildemo.Activity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.example.yyiwen.fastmaildemo.Fragment.HideOnScrollFragment;
import com.example.yyiwen.fastmaildemo.R;

import java.util.ArrayList;
import java.util.List;

public class HideOnScrollActivity extends BaseActivity {
    Toolbar toolbar;
    ;
    ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppThemeBlue);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hide_on_scroll);

        initToolbar();
        initViewPagerAndTabs();
    }

    @Override
    protected void initView() {

    }

    private void initToolbar() {
        toolbar= (Toolbar) findViewById(R.id.toolbar);

        setTitle("HIDE");
        toolbar.setTitleTextColor(getResources().getColor(android.R.color.white));
    }

    private void initViewPagerAndTabs() {
        ViewPager vp= (ViewPager) findViewById(R.id.viewPager);
        TabLayout tabLayout= (TabLayout) findViewById(R.id.tabLayout);
        PagerAdapter pagerAdapter = new PagerAdapter(getSupportFragmentManager());
        pagerAdapter.addFragment(HideOnScrollFragment.createInstance(20),"left");
        pagerAdapter.addFragment(HideOnScrollFragment.createInstance(4),"right");
        vp.setAdapter(pagerAdapter);
        tabLayout.setupWithViewPager(vp);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {

    }

    static class PagerAdapter extends FragmentPagerAdapter {

        private final List<Fragment> fragmentList = new ArrayList<>();
        private final List<String> fragmentTitleList = new ArrayList<>();

        public PagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        public void addFragment(Fragment fragment, String title) {
            fragmentList.add(fragment);
            fragmentTitleList.add(title);
        }

        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }
        @Override
        public CharSequence getPageTitle(int position) {
            return fragmentTitleList.get(position);
        }
    }
}
