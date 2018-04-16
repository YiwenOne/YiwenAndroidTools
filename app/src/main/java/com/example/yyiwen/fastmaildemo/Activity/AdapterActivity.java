package com.example.yyiwen.fastmaildemo.Activity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.Adapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.MediaController;
import android.widget.Toast;

import com.example.yyiwen.fastmaildemo.Adapter.CommonAdapter;
import com.example.yyiwen.fastmaildemo.Adapter.UserAdapter;
import com.example.yyiwen.fastmaildemo.Adapter.ViewHolder;
import com.example.yyiwen.fastmaildemo.Bean.User;
import com.example.yyiwen.fastmaildemo.R;
import com.example.yyiwen.fastmaildemo.View.SwipeLayout;
import com.example.yyiwen.fastmaildemo.View.SwipeLayoutManager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import pl.droidsonroids.gif.GifDrawable;
import pl.droidsonroids.gif.GifImageView;


public class AdapterActivity extends BaseActivity {
    private ListView mListView;
    private List<User> mUsers;
    SwipeLayout swipelayout_button;
    ListView listview;
    private Adapter adapter;

    private ArrayList<String> datas = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adapter);

        initDa();

//        mListView = (ListView) findViewById(R.id.lv_main);

        // NomarlAdapter mAdapter = new NomarlAdapter(mUsers);
//        UserAdapter mAdapter = new UserAdapter(mUsers);

//        mListView.setAdapter(mAdapter);
        listview = (ListView) findViewById(R.id.listview);
        swipelayout_button = (SwipeLayout) findViewById(R.id.swipelayout_button);
        // 初始化SwipeLayout
        SwipeLayoutManager.getInstance().closeOpenInstance();

        //-------------------Button-----------------------
        swipelayout_button.setOnSwipeLayoutClickListener(new SwipeLayout.OnSwipeLayoutClickListener() {
            @Override
            public void onClick() {
                Toast.makeText(AdapterActivity.this, "BUTTON", Toast.LENGTH_SHORT).show();
            }
        });

        swipelayout_button.getContentView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AdapterActivity.this, "BUTTON", Toast.LENGTH_SHORT).show();
            }
        });

        ((LinearLayout)swipelayout_button.getDeleteView()).getChildAt(1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AdapterActivity.this, "DELETE", Toast.LENGTH_SHORT).show();
            }
        });



        //-------------------ListView----------------------
        initData();
        adapter = new Adapter(this,datas,R.layout.item_listview);
        listview.setAdapter(adapter);


        // 侧滑打来的时候滑动没有想到什么好的办法解决，只能这样了。
        listview.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                if(scrollState == AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL) {
                    // 如果listView跟随手机拖动，关闭已经打开的SwipeLayout
                    SwipeLayoutManager.getInstance().closeOpenInstance();
                }
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
            }
        });



    }


    @Override
    protected void initView() {

    }
    @Override
    protected void initData() {

    }

    private void initDa()
    {
        for (int i=0;i<20;i++) {
            datas.add(i + "壶浊酒喜相逢");
        }
//        mUsers = new ArrayList<User>();
//        mUsers.add(new User("小红", R.drawable.head_1, "女"));
//        mUsers.add(new User("剑圣", R.drawable.head_2, "男"));
//        mUsers.add(new User("刀锋战士", R.drawable.head_3, "男"));
//        mUsers.add(new User("张飞", R.drawable.head_3, "男"));
//        mUsers.add(new User("雅典娜", R.drawable.head_4, "女"));
//        mUsers.add(new User("稻草人", R.drawable.head_5, "未知"));
    }

    @Override
    protected void initListener() {

    }
    class Adapter extends CommonAdapter<String> {

        public Adapter(Context context, List<String> datas, int layoutId) {
            super(context, datas, layoutId);
        }

        @Override
        public void convert(ViewHolder holder, final String s) {
            holder.setText(R.id.tv_name,s);

            final SwipeLayout swipeLayout = holder.getView(R.id.swipelayout);

            swipeLayout.setOnSwipeLayoutClickListener(new SwipeLayout.OnSwipeLayoutClickListener() {
                @Override
                public void onClick() {
                    Toast.makeText(AdapterActivity.this, s, Toast.LENGTH_SHORT).show();
                }
            });

            ((LinearLayout)swipeLayout.getDeleteView()).getChildAt(0).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(AdapterActivity.this, "call", Toast.LENGTH_SHORT).show();
                }
            });



            ((LinearLayout)swipeLayout.getDeleteView()).getChildAt(1).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    SwipeLayoutManager.getInstance().closeOpenInstance();
                    datas.remove(s);
                    adapter.notifyDataSetChanged();
                    Toast.makeText(mContext, "datas.size():" + datas.size(), Toast.LENGTH_SHORT).show();
                }
            });

        }
    }
}
