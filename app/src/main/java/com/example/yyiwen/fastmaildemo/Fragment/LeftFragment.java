package com.example.yyiwen.fastmaildemo.Fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yyiwen.fastmaildemo.Activity.SetActivity;
import com.example.yyiwen.fastmaildemo.R;

public class LeftFragment extends Fragment implements View.OnClickListener{
	private com.example.yyiwen.fastmaildemo.View.CircleImageView mIv_head_iamge;
	private TextView mTv_name;
	private RelativeLayout mRL_red;
	private RelativeLayout mRL_collect;
	private RelativeLayout mRL_check;
	private RelativeLayout mRL_mine_order;
	private RelativeLayout mRL_stay;
	private RelativeLayout mRL_information;
	private RelativeLayout mRLSet;
	private RelativeLayout mRL_feedback;
	String[] colors = { "red", "blue", "black" ,"green","pink"};



	//1)声明回调接口
	public interface CallBack{
		public void callback(String str);
	}
  //2)声明回调变量
	CallBack callBack;
  //3)onAttach  给变量赋值
//	@Override
//	public void onAttach(Activity activity) {
//		super.onAttach(activity);
//		callBack =(CallBack)activity;
//	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_menu, null);

		mIv_head_iamge = (com.example.yyiwen.fastmaildemo.View.CircleImageView) view.findViewById(R.id.iv_head_iamge);
		mTv_name = (TextView) view.findViewById(R.id.tv_name);
		mRL_red = (RelativeLayout) view.findViewById(R.id.RL_red);
		mRL_collect = (RelativeLayout) view.findViewById(R.id.RL_collect);
		mRL_check = (RelativeLayout) view.findViewById(R.id.RL_check);
		mRL_mine_order = (RelativeLayout) view.findViewById(R.id.RL_mine_order);
		mRL_stay = (RelativeLayout) view.findViewById(R.id.RL_stay);
		mRL_information = (RelativeLayout) view.findViewById(R.id.RL_information);
		mRLSet = (RelativeLayout) view.findViewById(R.id.RLSet);
		mRL_feedback = (RelativeLayout) view.findViewById(R.id.RL_feedback);
//		//创建适配器
//		ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, colors);
//		//填充适配器
//		setListAdapter(adapter);
		initListener();
		return view;
	}

	private void initListener() {
		mIv_head_iamge.setOnClickListener(this);
		mRL_red.setOnClickListener(this);
		mRL_collect.setOnClickListener(this);
		mRL_check.setOnClickListener(this);
		mRL_mine_order.setOnClickListener(this);
		mRL_stay.setOnClickListener(this);
		mRL_information.setOnClickListener(this);
		mRLSet.setOnClickListener(this);
		mRL_feedback.setOnClickListener(this);
	}

//	@Override
//	public void onListItemClick(ListView l, View v, int position, long id) {
//		super.onListItemClick(l, v, position, id);
//		//Toast.makeText(getActivity(),colors[position],1).show();
//		//4)发送回调
//		callBack.callback(colors[position]);
//	}
	@Override
	public void onClick(View v) {
		switch (v.getId()){
			case R.id.iv_head_iamge:
				break;
			case R.id.RL_red:
				break;
			case R.id.RL_collect:
				break;
			case R.id.RL_check:
				break;
			case R.id.RL_mine_order:
				break;
			case R.id.RL_stay:
				break;
			case R.id.RL_information:
				break;
			case R.id.RLSet:
				Intent intent=new Intent(getActivity(), SetActivity.class);
				startActivity(intent);
				break;
			case R.id.RL_feedback:
				break;

		}
	}
}












