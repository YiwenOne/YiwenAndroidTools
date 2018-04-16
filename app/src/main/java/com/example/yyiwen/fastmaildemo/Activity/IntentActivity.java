package com.example.yyiwen.fastmaildemo.Activity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.yyiwen.fastmaildemo.R;

public class IntentActivity extends AppCompatActivity {
    ListView lv_intent;
    String names[]={"查看电话信息","编辑电话信息","显示拨打电话界面","直接打电话","访问浏览器界面","访问地图"};
    CustomAdapter customAdapter;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent);
        //初始化
        lv_intent= (ListView) findViewById(R.id.lv_intent);
        //初始化适配器
        customAdapter=new CustomAdapter();
        //填充适配器
        lv_intent.setAdapter(customAdapter);
        //设置点击事件
        lv_intent.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                intent=new Intent();
                //声明Uri
                Uri uri;
                //声明数据字符串
                String data;
                switch (position){
                    case 0:
//                        data="chakan";
//                        //通过Uri字符串获取Uri实例
//                        uri=Uri.parse(data);
//                        //设置Intent的Action属性
//                        intent.setAction(Intent.ACTION_VIEW);
//                        //设置Intent的DATA属性
//                        intent.setData(uri);
//                        //启动Activity
//                        startActivity(intent);
                        break;
                    case 1:
//                        data="chakan";
//                        //通过Uri字符串获取Uri实例
//                        uri=Uri.parse(data);
//                        //设置Intent的Action属性
//                        intent.setAction(Intent.ACTION_EDIT);
//                        //设置Intent的DATA属性
//                        intent.setData(uri);
//                        //启动Activity
//                        startActivity(intent);
                        break;
                    case 2:
                        data="tel:10086";
                        //通过Uri字符串获取Uri实例
                        uri=Uri.parse(data);
                        //设置Intent的Action属性
                        intent.setAction(Intent.ACTION_DIAL);
                        //设置Intent的DATA属性
                        intent.setData(uri);
                        //启动Activity
                        startActivity(intent);
                        break;
                    case 3:
                        data="tel:10086";
                        //通过Uri字符串获取Uri实例
                        uri=Uri.parse(data);
                        //设置Intent的Action属性
                        intent.setAction(Intent.ACTION_CALL);
                        //设置Intent的DATA属性
                        intent.setData(uri);
                        //启动Activity
                        startActivity(intent);
                        break;
                    case 4:
                        data="http://www.baidu.com";
                        //通过Uri字符串获取Uri实例
                        uri=Uri.parse(data);
                        //设置Intent的Action属性
                        intent.setAction(Intent.ACTION_VIEW);
                        //设置Intent的DATA属性
                        intent.setData(uri);
                        //启动Activity
                        startActivity(intent);
                        break;
                    case 5:
//                        data="geo:39.92.116.46";
//                        //通过Uri字符串获取Uri实例
//                        uri=Uri.parse(data);
//                        //实例化Intent
//                        intent=new Intent(Intent.ACTION_VIEW,uri);
////                        //设置Intent的Action属性
////                        intent.setAction(Intent.ACTION_VIEW);
////                        //设置Intent的DATA属性
////                        intent.setData(uri);
//                        //启动Activity
//                        startActivity(intent);
                        break;
                }
            }
        });
    }
    class CustomAdapter extends BaseAdapter{

        Context context;
        @Override
        public int getCount() {
            return names.length;
        }

        @Override
        public Object getItem(int position) {
            return names[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView=View.inflate(IntentActivity.this,R.layout.listview_intent,null);
            TextView tv_intent= (TextView) convertView.findViewById(R.id.tv_intent);
            tv_intent.setText(names[position]);
            return convertView;
        }
    }

}
