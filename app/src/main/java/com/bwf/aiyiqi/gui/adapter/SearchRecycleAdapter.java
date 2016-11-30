package com.bwf.aiyiqi.gui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bwf.aiyiqi.R;
import com.bwf.aiyiqi.entity.ResponseSearch;
import com.bwf.aiyiqi.gui.adapter.baseadapters.MyBaseRecycleAdapter;
import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/11/29.
 */

public class SearchRecycleAdapter extends MyBaseRecycleAdapter<ResponseSearch.DataBean> {
    public SearchRecycleAdapter(Context context) {
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
        View view = inflater.inflate(R.layout.search_recycle_content, parent, false);
        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        myViewHolder myholder= (myViewHolder) holder;
        ResponseSearch.DataBean dataBean = getItem(position);
        Log.d("test", dataBean.getAuthor());
        myholder.searchRecycleItemImageHeader.setImageURI(dataBean.getAvtUrl());
        myholder.searchRecycleUserName.setText(dataBean.getAuthor());
        myholder.searchRecycleTitle.setText(dataBean.getSubject());
        if (dataBean.getAttachments() == null) {
            myholder.searchRecycleImageContent.setVisibility(View.GONE);
        } else {
            myholder.searchRecycleImageContent.setImageURI(dataBean.getAttachments().get(0));
        }
        myholder.searchTime.setText(dataBean.getDateline());
        myholder.searchRecycleItemZan.setText(dataBean.getZan() + "");
        myholder.searchRecycleItemComment.setText(dataBean.getAttachment() + "");
        myholder.searchRecycleItemShare.setText(dataBean.getSharetimes() + "");
    }

    static class myViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.search_recycle_item_image_header)
        SimpleDraweeView searchRecycleItemImageHeader;
        @BindView(R.id.search_recycle_user_name)
        TextView searchRecycleUserName;
        @BindView(R.id.search_recycle_title)
        TextView searchRecycleTitle;
        @BindView(R.id.search_recycle_image_content)
        SimpleDraweeView searchRecycleImageContent;
        @BindView(R.id.search_recycle_beizhu)
        TextView searchRecycleBeizhu;
        @BindView(R.id.search_time)
        TextView searchTime;
        @BindView(R.id.search_recycle_item_zan)
        TextView searchRecycleItemZan;
        @BindView(R.id.search_recycle_tag_01)
        LinearLayout searchRecycleTag01;
        @BindView(R.id.search_recycle_item_comment)
        TextView searchRecycleItemComment;
        @BindView(R.id.search_recycle_tag_02)
        LinearLayout searchRecycleTag02;
        @BindView(R.id.search_recycle_item_share)
        TextView searchRecycleItemShare;
        @BindView(R.id.search_recycle_tag_03)
        LinearLayout searchRecycleTag03;
        @BindView(R.id.search_recycle_item)
        LinearLayout searchRecycleItem;

        myViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
