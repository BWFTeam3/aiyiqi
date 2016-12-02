package com.bwf.aiyiqi.gui.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.bwf.aiyiqi.R;
import com.bwf.aiyiqi.gui.adapter.baseadapters.MyBaseAdapter;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by Administrator on 2016/11/29.
 */

public class FitmentLiveGridViewAdapter extends MyBaseAdapter<String> {

    public FitmentLiveGridViewAdapter(Context context) {
        super(context);
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View view = inflater.inflate(R.layout.item_recycler_fitment_live_gridview, parent, false);
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(R.id.simpleDraweeView_item_fragment_fitment_live_gridview);
        simpleDraweeView.setImageURI(datas.get(position));
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (clickListener != null)
                 clickListener.onClick(datas,position);
            }
        });
        return view;
    }
    private ClickListener clickListener;
    public void setClickListener(ClickListener clickListener){
        this.clickListener = clickListener;
    }
    public interface ClickListener{
        void onClick(List<String> urls,int position);
    }
}
