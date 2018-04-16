package com.example.yyiwen.fastmaildemo.Activity;

import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.HashMap;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.example.yyiwen.fastmaildemo.R;

public class LoadMoreActivity extends AppCompatActivity implements OnScrollListener{
    // ListView的Adapter
    private SimpleAdapter mSimpleAdapter;
    private ListView lv;
    private Button bt;
    private ProgressBar pg;
    private ArrayList<HashMap<String,String>> list;
    // ListView底部View
    private View moreView;
    private Handler handler;
    // 设置一个最大的数据条数，超过即不再加载
    private int MaxDateNum;
    // 最后可见条目的索引
    private int lastVisibleIndex;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_more);
        MaxDateNum = 22; // 设置最大数据条数

        lv = (ListView) findViewById(R.id.lv);

        // 实例化底部布局
        moreView = getLayoutInflater().inflate(R.layout.moredata, null);

        bt = (Button) moreView.findViewById(R.id.bt_load);
        pg = (ProgressBar) moreView.findViewById(R.id.pg);
        handler = new Handler();

        // 用map来装载数据，初始化10条数据
        list = new ArrayList<HashMap<String,String>>();
        for (int i = 0; i < 10; i++) {
            HashMap<String, String> map = new HashMap<String, String>();
            map.put("ItemTitle", "第" + i + "行标题");
            map.put("ItemText", "第" + i + "行内容");
            list.add(map);
        }
        // 实例化SimpleAdapter
        mSimpleAdapter = new SimpleAdapter(this, list, R.layout.listview_loadmore,
                new String[] { "ItemTitle", "ItemText" },
                new int[] { R.id.tv_title, R.id.tv_content });
        // 加上底部View，注意要放在setAdapter方法前
        lv.addFooterView(moreView);
        lv.setAdapter(mSimpleAdapter);
        // 绑定监听器
        lv.setOnScrollListener(this);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(LoadMoreActivity.this,DrawActivity.class);
                startActivity(intent);
            }
        });
        bt.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                pg.setVisibility(View.VISIBLE);// 将进度条可见
                bt.setVisibility(View.GONE);// 按钮不可见

                handler.postDelayed(new Runnable() {

                    @Override
                    public void run() {
                        loadMoreDate();// 加载更多数据
                        bt.setVisibility(View.VISIBLE);
                        pg.setVisibility(View.GONE);
                        mSimpleAdapter.notifyDataSetChanged();// 通知listView刷新数据
                    }
                }, 2000);
            }
        });
    }
    //沉浸式状态栏
    private void initState() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //透明状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //透明导航栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
    }
    private void loadMoreDate() {
        int count = mSimpleAdapter.getCount();
        if (count + 5 < MaxDateNum) {
            // 每次加载5条
            for (int i = count; i < count + 5; i++) {
                HashMap<String, String> map = new HashMap<String, String>();
                map.put("ItemTitle", "新增第" + i + "行标题");
                map.put("ItemText", "新增第" + i + "行内容");
                list.add(map);
            }
        } else {
            // 数据已经不足5条
            for (int i = count; i < MaxDateNum; i++) {
                HashMap<String, String> map = new HashMap<String, String>();
                map.put("ItemTitle", "新增第" + i + "行标题");
                map.put("ItemText", "新增第" + i + "行内容");
                list.add(map);
            }
        }

    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem,
                         int visibleItemCount, int totalItemCount) {
        // 计算最后可见条目的索引
        lastVisibleIndex = firstVisibleItem + visibleItemCount - 1;

        // 所有的条目已经和最大条数相等，则移除底部的View
        if (totalItemCount == MaxDateNum + 1) {
            lv.removeFooterView(moreView);
            Toast.makeText(this, "数据全部加载完成，没有更多数据！", Toast.LENGTH_LONG).show();
        }

    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
        // 滑到底部后自动加载，判断listview已经停止滚动并且最后可视的条目等于adapter的条目
        if (scrollState == OnScrollListener.SCROLL_STATE_IDLE
                && lastVisibleIndex == mSimpleAdapter.getCount()) {
            // 当滑到底部时自动加载
            // pg.setVisibility(View.VISIBLE);
            // bt.setVisibility(View.GONE);
            // handler.postDelayed(new Runnable() {
            //
            // @Override
            // public void run() {
            // loadMoreDate();
            // bt.setVisibility(View.VISIBLE);
            // pg.setVisibility(View.GONE);
            // mSimpleAdapter.notifyDataSetChanged();
            // }
            //
            // }, 2000);

        }

    }

}
