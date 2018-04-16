package com.example.yyiwen.fastmaildemo.Fragment;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.baidu.mapapi.MapView;
import com.example.yyiwen.fastmaildemo.Activity.AMapActivity;
import com.example.yyiwen.fastmaildemo.Activity.AdapterActivity;
import com.example.yyiwen.fastmaildemo.Activity.BannerActivity;
import com.example.yyiwen.fastmaildemo.Activity.BrandScreenActivity;
import com.example.yyiwen.fastmaildemo.Activity.CameraUseActivity;
import com.example.yyiwen.fastmaildemo.Activity.ChooseCityActivity;
import com.example.yyiwen.fastmaildemo.Activity.ControlActivity;
import com.example.yyiwen.fastmaildemo.Activity.DiyScreenActivity;
import com.example.yyiwen.fastmaildemo.Activity.GaodeMapActivity;
import com.example.yyiwen.fastmaildemo.Activity.HideOnScrollActivity;
import com.example.yyiwen.fastmaildemo.Activity.LaunchAppActivity;
import com.example.yyiwen.fastmaildemo.Activity.LoadingActivity;
import com.example.yyiwen.fastmaildemo.Activity.MainActivity;
import com.example.yyiwen.fastmaildemo.Activity.MapViewActivity;
import com.example.yyiwen.fastmaildemo.Activity.MoreDialogActivity;
import com.example.yyiwen.fastmaildemo.Activity.NavigationActivity;
import com.example.yyiwen.fastmaildemo.Activity.RippleEffectActivity;
import com.example.yyiwen.fastmaildemo.Activity.RxjavaHelloActivity;
import com.example.yyiwen.fastmaildemo.R;
import com.example.yyiwen.fastmaildemo.Utils.UIUtils;

import java.util.ArrayList;
import java.util.List;

public class DiscloseFragment extends Fragment implements View.OnClickListener,AdDialogFragment.OnDialogListener{
    private com.example.yyiwen.fastmaildemo.View.CircleImageView mIv_head_iamge;
    private TextView mTv_title;
    private ImageView mIv_tag;
    private ImageView mIv_map;
    private LinearLayout ll_title;
    PopupWindow popupWindow;
    private List<String> groups;
    CustomAdapter customAdapter;
    private LinearLayout ll_menu;
    private Button btn_Rxjava1,btn_map,btn_diy,btn_water_photo,btn_choose_city,btn_location,btn_amap,btn_navigation,btn_ripple
            ,btn_launch_app,btn_hide_on_scroll,btn_adapter,btn_dialog,btn_banner,btn_circle;
    Intent intent;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_disclose, container, false);
        //初始化
        mIv_head_iamge = (com.example.yyiwen.fastmaildemo.View.CircleImageView) view.findViewById(R.id.iv_head_iamge);
        mTv_title = (TextView) view.findViewById(R.id.tv_title);
        mIv_tag = (ImageView) view.findViewById(R.id.iv_tag);
        mIv_map = (ImageView) view.findViewById(R.id.iv_map);
        ll_title= (LinearLayout) view.findViewById(R.id.ll_title);
        ll_menu= (LinearLayout) view.findViewById(R.id.ll_menu);
        btn_Rxjava1= (Button) view.findViewById(R.id.btn_Rxjava1);
        btn_map= (Button) view.findViewById(R.id.btn_map);
        btn_diy= (Button) view.findViewById(R.id.btn_diy);
        btn_water_photo= (Button) view.findViewById(R.id.btn_water_photo);
        btn_choose_city= (Button) view.findViewById(R.id.btn_choose_city);
        btn_location= (Button) view.findViewById(R.id.btn_location);
        btn_amap= (Button) view.findViewById(R.id.btn_amap);
        btn_navigation= (Button) view.findViewById(R.id.btn_navigation);
        btn_ripple= (Button) view.findViewById(R.id.btn_ripple);
        btn_launch_app= (Button) view.findViewById(R.id.btn_launch_app);
        btn_hide_on_scroll= (Button) view.findViewById(R.id.btn_hide_on_scroll);
        btn_adapter= (Button) view.findViewById(R.id.btn_adapter);
        btn_dialog= (Button) view.findViewById(R.id.btn_loading);
        btn_banner= (Button) view.findViewById(R.id.btn_banner);
        btn_circle= (Button) view.findViewById(R.id.btn_circle);
        //初始化数据
        initData();
        //初始化点击事件
        initListener();
        return view;
    }

    private void initData() {
        //改变标题
        mTv_title.setText("全部");
        //改变图标
        mIv_map.setImageResource(R.drawable.add);

        btn_map.setVisibility(View.GONE);
    }
    private void initListener() {
        ll_title.setOnClickListener(this);
        btn_Rxjava1.setOnClickListener(this);
        btn_map.setOnClickListener(this);
        btn_diy.setOnClickListener(this);
        mIv_map.setOnClickListener(this);
        btn_water_photo.setOnClickListener(this);
        btn_choose_city.setOnClickListener(this);
        btn_location.setOnClickListener(this);
        btn_amap.setOnClickListener(this);
        btn_navigation.setOnClickListener(this);
        btn_ripple.setOnClickListener(this);
        btn_launch_app.setOnClickListener(this);
        btn_hide_on_scroll.setOnClickListener(this);
        btn_adapter.setOnClickListener(this);
        btn_dialog.setOnClickListener(this);
        btn_banner.setOnClickListener(this);
        btn_circle.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ll_title:
                showWindow();
                break;
            case R.id.iv_map:
                showDialogFragment();
                break;
            case R.id.btn_Rxjava1:
                intent=new Intent(getActivity(), RxjavaHelloActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_map:
//                intent=new Intent(getActivity(), MapViewActivity.class);
//                startActivity(intent);
                break;
            case R.id.btn_diy:
                intent=new Intent(getActivity(), DiyScreenActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_water_photo:
                intent=new Intent(getActivity(), CameraUseActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_choose_city:
                intent=new Intent(getActivity(), ChooseCityActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_location:
                intent=new Intent(getActivity(), GaodeMapActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_amap:
                intent=new Intent(getActivity(), AMapActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_navigation:
                intent=new Intent(getActivity(), NavigationActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_ripple:
                intent=new Intent(getActivity(), RippleEffectActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_launch_app:
                intent=new Intent(getActivity(), LaunchAppActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_hide_on_scroll:
                intent=new Intent(getActivity(),  HideOnScrollActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_adapter:
                intent=new Intent(getActivity(), AdapterActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_loading:
                intent=new Intent(getActivity(), LoadingActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_banner:
                intent=new Intent(getActivity(), BannerActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_circle:
                intent=new Intent(getActivity(), ControlActivity.class);
                startActivity(intent);
                break;
        }
    }

    private void showDialogFragment() {
        AdDialogFragment dialogFragment = new AdDialogFragment();
        dialogFragment.show(getFragmentManager(),"android");

    }

    private void showWindow() {
            LayoutInflater mLayoutInflater = (LayoutInflater)getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View view = mLayoutInflater.inflate(R.layout.layout_disclose_title, null);
            ListView lv_title= (ListView) view.findViewById(R.id.lv_title);
            // 加载数据
            groups = new ArrayList<String>();
            groups.add("全部");
            groups.add("附近");
            groups.add("热门");
            groups.add("我的");
            String  text=mTv_title.getText().toString();
            for(int i=0;i<groups.size();i++){
                if(groups.get(i).equals(text)){
                    groups.remove(i);
                }
            }
            customAdapter=new CustomAdapter(getActivity(),groups);
            lv_title.setAdapter(customAdapter);
            // 创建一个PopuWidow对象
            popupWindow = new PopupWindow(view, 300,
                    WindowManager.LayoutParams.WRAP_CONTENT);
            //
            popupWindow.setFocusable(true);
            //点击外围扩散
            popupWindow.setOutsideTouchable(true);
            // 这个是为了点击“返回Back”也能使其消失，并且并不会影响你的背景
            popupWindow.setBackgroundDrawable(new BitmapDrawable());
            WindowManager windowManager = (WindowManager) getActivity().getSystemService(Context.WINDOW_SERVICE);
            // 显示的位置为:屏幕的宽度的一半-PopupWindow的高度的一半
            int xPos = windowManager.getDefaultDisplay().getWidth() / 2
                    - popupWindow.getWidth() / 2;
            popupWindow.showAsDropDown(ll_menu, xPos, 0);
            backgroundAlpha(0.5f);
             //添加pop窗口关闭事件
            popupWindow.setOnDismissListener(new poponDismissListener());
            //设置listview点击事件
            lv_title.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    mTv_title.setText(groups.get(position));
                    popupWindow.dismiss();
                }
            });
    }

    @Override
    public void onDialogClick(String person) {
        UIUtils.showToastSafe(person);
    }

    class CustomAdapter extends BaseAdapter{
        Context context;
        private List<String> groups= new ArrayList<String>();
        public CustomAdapter(Context context,List<String> groups){
            this.context=context;
            this.groups=groups;
        }
        @Override
        public int getCount() {
            return groups.size();
        }

        @Override
        public Object getItem(int position) {
            return groups.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView=View.inflate(context,R.layout.listview_disclose_title,null);
            TextView tv_content= (TextView) convertView.findViewById(R.id.tv_content);
            tv_content.setText(groups.get(position));
            return convertView;
        }
    }
    /**
     * 添加新笔记时弹出的popWin关闭的事件，主要是为了将背景透明度改回来
     * @author cg
     *
     */
    class poponDismissListener implements PopupWindow.OnDismissListener{
        @Override
        public void onDismiss() {
            // TODO Auto-generated method stub
            //Log.v("List_noteTypeActivity:", "我是关闭事件");
            backgroundAlpha(1f);
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
