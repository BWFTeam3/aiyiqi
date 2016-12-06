package com.bwf.aiyiqi.gui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bwf.aiyiqi.R;
import com.bwf.aiyiqi.entity.ResponseNewest;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/12/4.
 */

public class NewestFragmentRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<ResponseNewest.DataBean> dataBeen;
    private LayoutInflater inflater;
    private Context context;

    public NewestFragmentRecyclerAdapter(Context context) {
        this.dataBeen = new ArrayList<>();
        this.context = context;
        this.inflater = LayoutInflater.from(context);
    }

    protected Context getContext() {
        return context;
    }

    public void clearData() {
        this.dataBeen.clear();
    }

    public void setDatas(List<ResponseNewest.DataBean> datas) {
        this.dataBeen.clear();
        this.dataBeen.addAll(datas);
        notifyDataSetChanged();
    }

    public void addDatas(List<ResponseNewest.DataBean> datas) {
        this.dataBeen.addAll(datas);
        notifyDataSetChanged();
    }

    public void clearDatas() {
        this.dataBeen.clear();
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_newest_fragment_recycler, parent, false);
        return new ContentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ResponseNewest.DataBean data = dataBeen.get(position);
        ContentViewHolder contentViewHolder = (ContentViewHolder) holder;
        contentViewHolder.simpleDraweeViewBasicInformation.setImageURI(data.getAvtUrl());
        contentViewHolder.textViewTitle.setText(data.getSubject());
        contentViewHolder.textViewTime.setText(data.getAuthor() + " " + data.getDateline());
        contentViewHolder.checkedTextViewViews.setText(data.getViews());
        contentViewHolder.checkedTextViewComment.setText(data.getReplies());
        if (data.getAttachments() == null)
            contentViewHolder.imageViewTitle.setVisibility(View.GONE);
    }

    @Override
    public int getItemCount() {
        return dataBeen.size();
    }


    static class ContentViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.simpleDraweeView_basicInformation)
        SimpleDraweeView simpleDraweeViewBasicInformation;
        @BindView(R.id.textView_title)
        TextView textViewTitle;
        @BindView(R.id.imageView_title)
        ImageView imageViewTitle;
        @BindView(R.id.textView_time)
        TextView textViewTime;
        @BindView(R.id.checkedTextView_comment)
        CheckedTextView checkedTextViewComment;
        @BindView(R.id.checkedTextView_views)
        CheckedTextView checkedTextViewViews;

        ContentViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
