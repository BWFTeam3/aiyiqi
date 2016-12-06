package com.bwf.aiyiqi.gui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bwf.aiyiqi.R;
import com.bwf.aiyiqi.entity.ResponseDesignPs;
import com.bwf.aiyiqi.gui.adapter.baseadapters.MyBaseRecycleAdapter;
import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Phyj on 2016/12/4.
 */

public class DesignPsAdapter extends MyBaseRecycleAdapter<ResponseDesignPs.DataBean.ListBean> {


    public DesignPsAdapter(Context context) {
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
        View view = inflater.inflate(R.layout.designps_recycleitem, parent, false);
        return new PsItemHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        PsItemHolder itemHolder = (PsItemHolder) holder;
        ResponseDesignPs.DataBean.ListBean listBean = getItem(position);
        itemHolder.itemLinear.setGravity(Gravity.CENTER_VERTICAL);
        itemHolder.recycleTextLasttime.setVisibility(View.GONE);
        itemHolder.recycleTextviewCommentcount.setText(listBean.getLike_num());
        itemHolder.recycleTextviewViewcount.setText("100");
        itemHolder.recycleImageview.setImageURI(listBean.getUrl());
    }

    class PsItemHolder extends BaseHolder {
        @BindView(R.id.recycle_imageview)
        SimpleDraweeView recycleImageview;
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
        @BindView(R.id.item_linear)
        LinearLayout itemLinear;
        PsItemHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
