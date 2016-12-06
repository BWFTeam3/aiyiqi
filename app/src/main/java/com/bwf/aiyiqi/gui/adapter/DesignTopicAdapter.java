package com.bwf.aiyiqi.gui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bwf.aiyiqi.R;
import com.bwf.aiyiqi.entity.ResponseDesignTopic;
import com.bwf.aiyiqi.gui.adapter.baseadapters.MyBaseRecycleAdapter;
import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Phyj on 2016/12/3.
 */

public class DesignTopicAdapter extends MyBaseRecycleAdapter<ResponseDesignTopic.DataBean.ListBean> {
    public DesignTopicAdapter(Context context) {
        super(context);
    }

    @Override
    protected int getFooterCount() {
        return 0;
    }

    @Override
    protected int getHeaderCount() {
        return 0;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.designtopic_recycleitem, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyViewHolder myViewHolder = (MyViewHolder) holder;
        ResponseDesignTopic.DataBean.ListBean listBean = getItem(position);
        myViewHolder.recycleTextLasttime.setText(listBean.getTitle());
        myViewHolder.recycleTextLasttime.setTextColor(0xffffffff);
        myViewHolder.recycleTextviewViewcount.setText("1");
        myViewHolder.recycleTextviewViewcount.setTextColor(0xffffffff);
        myViewHolder.designtopicItemtv.setText(listBean.getDesc());
        myViewHolder.recycleTextviewCommentcount.setText(listBean.getComment_count());
        myViewHolder.recycleTextviewCommentcount.setTextColor(0xffffffff);
        myViewHolder.designRecycledrawee.setImageURI(listBean.getUrl());
        myViewHolder.linearLayoutTopicitem.setBackgroundColor(0x88000000);
    }

    class MyViewHolder extends BaseHolder {
        @BindView(R.id.design_recycledrawee)
        SimpleDraweeView designRecycledrawee;
        @BindView(R.id.recycle_text_lasttime)
        TextView recycleTextLasttime;
        @BindView(R.id.recycle_imageview_view)
        ImageView recycleImageviewView;
        @BindView(R.id.recycle_textview_viewcount)
        TextView recycleTextviewViewcount;
        @BindView(R.id.recycle_imageview_comment)
        ImageView recycleImageviewComment;
        @BindView(R.id.recycle_textview_commentcount)
        TextView recycleTextviewCommentcount;
        @BindView(R.id.designtopic_itemtv)
        TextView designtopicItemtv;
        @BindView(R.id.linearLayout_topicitem)
        LinearLayout linearLayoutTopicitem;
        MyViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

}
