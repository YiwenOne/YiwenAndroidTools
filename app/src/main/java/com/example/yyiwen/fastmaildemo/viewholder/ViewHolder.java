package com.example.yyiwen.fastmaildemo.viewholder;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;

public class ViewHolder
{
    /**
     * 保存所有itemview的集合
     */
    private SparseArray<View> mViews;

    private View mConvertView;

    private ViewHolder(Context context, int layoutId)
    {
        mConvertView = View.inflate(context, layoutId, null);
        mConvertView.setTag(this);

        mViews = new SparseArray<>();
    }

    public static ViewHolder newsInstance(View convertView, Context context, int layoutId)
    {
        if (convertView == null)
        {
            return new ViewHolder(context, layoutId);

        } else
        {
            return (ViewHolder) convertView.getTag();
        }
    }

    /**
     * 获取根目录的view
     * @return
     */
    public View getConverView()
    {
        return mConvertView;
    }

    /**
     * 获取itemView
     * @param id
     * @return
     */
    @SuppressWarnings("unchecked")
    public <T extends View> T getItemView(int id)
    {
        View view =  mViews.get(id);
        if (view == null)
        {
            view = mConvertView.findViewById(id);
            mViews.append(id, view);
        }
        
        return (T) view;
    }
}