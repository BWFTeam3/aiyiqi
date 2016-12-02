package com.bwf.aiyiqi.gui.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bwf.aiyiqi.R;
import com.bwf.aiyiqi.entity.ResponseYiqiGroup;
import com.bwf.aiyiqi.gui.adapter.baseadapters.MyBaseAdapter;
import com.facebook.drawee.view.SimpleDraweeView;

/**
 * Created by Administrator on 2016/11/25.
 */

public class YiqiGroupGridViewAdapter extends MyBaseAdapter<ResponseYiqiGroup.DataBean> {

    public YiqiGroupGridViewAdapter(Context context) {
        super(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = inflater.inflate(R.layout.item_gridview_yiqigroup,parent,false);
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(R.id.simpleDraweeView_gridView_yiqigroup);
        TextView textViewTop = (TextView) view.findViewById(R.id.textView_top_gridView_yiqigroup);
        TextView textViewBottom = (TextView) view.findViewById(R.id.textView_bottom_gridView_yiqigroup);
        RatingBar ratingBar = (RatingBar) view.findViewById(R.id.ratingbar_yiqigroup);
        simpleDraweeView.setImageURI(datas.get(position).getAvatar());
        textViewTop.setText(datas.get(position).getVendorName());
        textViewBottom.setText(getContext().getString(R.string.case_number,datas.get(position).getCaseNumber()));
        ratingBar.setRating(datas.get(position).getRating());
        return view;
    }
}
