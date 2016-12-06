package com.bwf.aiyiqi.gui.adapter.baseadapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

/**
 * Created by 11645 on 2016/12/4.
 */

public class MyBuildingViewHolder {
    private SparseArray<View> mViews;
    private View convertView;
    private int mPositon;

    public View getConvertView() {
        return convertView;
    }



    public MyBuildingViewHolder(Context context, ViewGroup parent, int layoutId, int position) {
        this.convertView = LayoutInflater.from(context).inflate(layoutId,parent,false);
        mViews = new SparseArray();
        this.mPositon = position;
        convertView.setTag(this);
    }

    public static MyBuildingViewHolder getHolder(Context context, View convertView, int layoutId, ViewGroup parent, int position){
        if(convertView == null){
            return new MyBuildingViewHolder(context,parent,layoutId,position);
        }else {
            MyBuildingViewHolder holder = (MyBuildingViewHolder) convertView.getTag();
            holder.mPositon = position;
            return holder;
        }
    }

    public < T extends View> T getView(int viewId){
        View view = mViews.get(viewId);
        if(view == null){
            view = convertView.findViewById(viewId);
            mViews.put(viewId,view);
        }
        return (T) view;
    }


    public MyBuildingViewHolder setTextView(int textViewId, String textValue){
        TextView textView = getView(textViewId);
        textView.setText(textValue);
        return this;
    }

    public MyBuildingViewHolder setImageResource(int viewId, int resId)
    {
        ImageView view=getView(viewId);
        view.setImageResource(resId);
        return this;
    }


    public MyBuildingViewHolder setSimpleDraweeView(int viewId, String url)
    {
        SimpleDraweeView view=getView(viewId);
        view.setImageURI(Uri.parse(url));
        return this;
    }

    public MyBuildingViewHolder setImageBitmap(int viewId, Bitmap bitmap)
    {
        ImageView view=getView(viewId);
        view.setImageBitmap(bitmap);
        return this;
    }
}
