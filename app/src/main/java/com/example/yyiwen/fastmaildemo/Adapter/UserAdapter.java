package com.example.yyiwen.fastmaildemo.Adapter;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.yyiwen.fastmaildemo.Bean.User;
import com.example.yyiwen.fastmaildemo.R;
import com.example.yyiwen.fastmaildemo.viewholder.ViewHolder;

import java.util.List;


public class UserAdapter extends BaseCommAdapter<User>
{
    public UserAdapter(List<User> datas)
    {
        super(datas);
    }

    @Override
    protected void setUI(ViewHolder holder, int position, Context context)
    {
        User item = getItem(position);

        TextView tv_name = holder.getItemView(R.id.tv_name_use_item);
        tv_name.setText(item.name);

        TextView tv_sex = holder.getItemView(R.id.tv_sex_use_item);
        tv_sex.setText(item.sex);

        ImageView iv_head = holder.getItemView(R.id.iv_head_use_item);
        iv_head.setImageResource(item.headId);
    }

    @Override
    protected int getLayoutId()
    {
        return R.layout.item_user_list;
    }

}
