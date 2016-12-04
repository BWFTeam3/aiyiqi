package com.bwf.aiyiqi.gui.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bwf.aiyiqi.R;
import com.bwf.aiyiqi.gui.adapter.baseadapters.MyBaseAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Phyj on 2016/12/4.
 */

public class MyPopAdapter extends MyBaseAdapter {
    public MyPopAdapter(Context context) {
        super(context);
    }

    private int colorposition;

    public void setItemColor(int position) {
        colorposition=position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        String str = (String) getItem(position);
        ItemHolder holder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.mypopupwindow_item, parent, false);
            holder = new ItemHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ItemHolder) convertView.getTag();
        }
        holder.popitemTv.setText(str);
        if (position==colorposition){
            holder.popitemTv.setBackgroundResource(R.drawable.ps_text_checked);
        }else{
            holder.popitemTv.setBackgroundResource(R.drawable.ps_text_normal);
        }
        return convertView;
    }

    class ItemHolder {
        @BindView(R.id.popitem_tv)
        TextView popitemTv;

        ItemHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
