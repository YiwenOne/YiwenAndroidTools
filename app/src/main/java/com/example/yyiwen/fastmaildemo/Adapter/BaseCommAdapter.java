package com.example.yyiwen.fastmaildemo.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.yyiwen.fastmaildemo.viewholder.ViewHolder;

import java.util.List;

/**
 *  万能适配器
 * @param <T>
 */
public abstract class BaseCommAdapter<T> extends BaseAdapter
{

    private List<T> mDatas;

    public BaseCommAdapter(List<T> datas)
    {
        mDatas = datas;
    }

    @Override
    public int getCount()
    {
        return mDatas == null ? 0 : mDatas.size();
    }

    @Override
    public T getItem(int position)
    {
        return mDatas.get(position);
    }

    @Override
    public long getItemId(int position)
    {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        ViewHolder holder = ViewHolder
                .newsInstance(convertView, parent.getContext(), getLayoutId());
        
        setUI(holder,position,parent.getContext());
        
        return holder.getConverView();
    }

    /**
     * 设置UI
     * @param holder
     * @param position
     * @param context
     */
    protected abstract void setUI(ViewHolder holder, int position, Context context);

    /**
     * 获取适配器的布局id
     * @return
     */
    protected abstract int getLayoutId();
}
