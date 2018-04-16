package com.example.yyiwen.fastmaildemo.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

import com.example.yyiwen.fastmaildemo.R;

/**
 * Created by y.yiwen on 1/23/2017.
 */
public class ImageAdapter extends BaseAdapter {
    private Context mContext;
    private int[] resIds;
    public ImageAdapter(Context context,int[] resIds) {
        this.mContext = context;
        this.resIds=resIds;
    }

    public int getCount() {
        return Integer.MAX_VALUE;
    }

    public Object getItem(int position) {
        return position;
    }

    public long getItemId(int position) {
        return position;
    }

    //设置 ImageView 控件的显示风格呾图像资源
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView = new ImageView(mContext);
        imageView.setImageResource(resIds[position % resIds.length]);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setLayoutParams(new Gallery.LayoutParams(80, 60));
//imageView.setLayoutParams(new Gallery.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
//        imageView.setBackgroundResource(R.drawable.picture_frame);
        return imageView;
    }
}
