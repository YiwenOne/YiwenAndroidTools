package com.example.yyiwen.fastmaildemo.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.yyiwen.fastmaildemo.Activity.RecyclerViewActivity;
import com.example.yyiwen.fastmaildemo.R;
import com.example.yyiwen.fastmaildemo.viewholder.RecyclerItemViewHolder;

import java.util.List;

/**
 * Created by y.yiwen on 1/12/2017.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements View.OnClickListener{
    private List<String> mItemList;
    Context context;
    private OnRecyclerViewItemClickListener mOnItemClickListener = null;
    public RecyclerAdapter(List<String> itemList){
        mItemList=itemList;
    }
    //define interface
    public static interface OnRecyclerViewItemClickListener {
        void onItemClick(View view , String data);
    }
    @Override
    public void onClick(View v) {
        if (mOnItemClickListener != null) {
            //注意这里使用getTag方法获取数据
            mOnItemClickListener.onItemClick(v,(String)v.getTag());
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context=parent.getContext();
        View view= LayoutInflater.from(context).inflate(R.layout.recycler_item,parent,false);
        //将创建的View注册点击事件
        view.setOnClickListener(this);
        return RecyclerItemViewHolder.newInstance(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        RecyclerItemViewHolder holder= (RecyclerItemViewHolder) viewHolder;
        //将数据保存在itemView的Tag中，以便点击时进行获取
        viewHolder.itemView.setTag(mItemList.get(position));
        String itemText=mItemList.get(position);
        holder.setItemText(itemText);

    }

    @Override
    public int getItemCount() {
        return mItemList==null ? 0:mItemList.size();
    }

    public void setOnItemClickListener(OnRecyclerViewItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }
}
