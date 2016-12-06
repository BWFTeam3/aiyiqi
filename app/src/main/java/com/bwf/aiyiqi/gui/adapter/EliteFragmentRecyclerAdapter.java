package com.bwf.aiyiqi.gui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.TextView;

import com.bwf.aiyiqi.R;
import com.bwf.aiyiqi.entity.ResponseElite;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.lankton.flowlayout.FlowLayout;

/**
 * Created by Administrator on 2016/12/4.
 */

public class EliteFragmentRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<ResponseElite.DataBean> dataBeen;
    private LayoutInflater inflater;
    private Context context;
    private String[] info = {"一", "二", "三", "四", "五", "六", "七", "八", "九", "十"};
    private String layout;
    private String style;
    private String str;

    public EliteFragmentRecyclerAdapter(Context context) {
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

    public void setDatas(List<ResponseElite.DataBean> datas) {
        this.dataBeen.clear();
        this.dataBeen.addAll(datas);
        notifyDataSetChanged();
    }

    public void addDatas(List<ResponseElite.DataBean> datas) {
        this.dataBeen.addAll(datas);
        notifyDataSetChanged();
    }

    public void clearDatas() {
        this.dataBeen.clear();
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_elite_fragment_recycler, parent, false);
        return new ContentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ResponseElite.DataBean data = dataBeen.get(position);
        ContentViewHolder contentViewHolder = (ContentViewHolder) holder;
        contentViewHolder.simpleDraweeViewItemEliteFragmentRecycler.setImageURI(data.getAvtUrl());
        contentViewHolder.textViewUserName.setText(data.getAuthor());
        if (data.getHouseInfo() == null)
            contentViewHolder.textViewHomeInfo.setVisibility(View.GONE);
        else {
            for (int i = 0; i < info.length; i++) {
                if (i == data.getHouseInfo().getLayout())
                    layout = info[i - 1];
                if (i == data.getHouseInfo().getStyle())
                    style = info[i - 1];
            }
            if (TextUtils.isEmpty(data.getHouseInfo().getCommunity()))
                str = "简约、软装配饰";
            else
                str = data.getHouseInfo().getCommunity();
            contentViewHolder.textViewHomeInfo.setVisibility(View.VISIBLE);
            contentViewHolder.textViewHomeInfo.setText(layout + "室" + style + "厅、" + data.getHouseInfo().getArea() + "平、" + data.getHouseInfo().getBudget() + "万、" + str);
        }
        contentViewHolder.textViewTitle.setText(data.getSubject());
        if (data.getTags().size() == 0)
            contentViewHolder.flowLayoutFlag.setVisibility(View.GONE);
        else {
            contentViewHolder.flowLayoutFlag.removeAllViews();
            contentViewHolder.flowLayoutFlag.setVisibility(View.VISIBLE);
            for (int i = 0; i < data.getTags().size(); i++) {
                View view = inflater.inflate(R.layout.text, null);
                TextView textView = (TextView) view.findViewById(R.id.tv);
                textView.setText(data.getTags().get(i).getTagname());
                contentViewHolder.flowLayoutFlag.addView(view);
            }
        }
        if (data.getAttachments() == null)
            contentViewHolder.simpleDraweeViewContent.setVisibility(View.GONE);
        else {
            contentViewHolder.simpleDraweeViewContent.setImageURI(data.getAttachments().get(0));
            contentViewHolder.simpleDraweeViewContent.setVisibility(View.VISIBLE);
        }
        contentViewHolder.textViewElite.setText("精选自" + data.getFname() + ">");
        contentViewHolder.textViewTime.setText(data.getDateline());
        contentViewHolder.checkedTextViewComment.setText(data.getReplies());
    }

    @Override
    public int getItemCount() {
        return dataBeen.size();
    }

    static class ContentViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.simpleDraweeView_item_elite_fragment_recycler)
        SimpleDraweeView simpleDraweeViewItemEliteFragmentRecycler;
        @BindView(R.id.textView_user_name)
        TextView textViewUserName;
        @BindView(R.id.textView_home_info)
        TextView textViewHomeInfo;
        @BindView(R.id.textView_title)
        TextView textViewTitle;
        @BindView(R.id.flowLayout_flag)
        FlowLayout flowLayoutFlag;
        @BindView(R.id.simpleDraweeView_content)
        SimpleDraweeView simpleDraweeViewContent;
        @BindView(R.id.textView_elite)
        TextView textViewElite;
        @BindView(R.id.textView_time)
        TextView textViewTime;
        @BindView(R.id.checkedTextView_zan)
        CheckedTextView checkedTextViewZan;
        @BindView(R.id.checkedTextView_comment)
        CheckedTextView checkedTextViewComment;

        ContentViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
