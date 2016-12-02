package com.bwf.aiyiqi.gui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bwf.aiyiqi.R;
import com.bwf.aiyiqi.entity.ResponseFitmentPorgress;
import com.bwf.aiyiqi.gui.view.MyGridView;
import com.facebook.drawee.view.SimpleDraweeView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/11/29.
 */

public class FitmentLiveRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private LayoutInflater inflater;
    private Context context;
    private List<ResponseFitmentPorgress.DataBean> datas;
    private final int FOOTER = 2;
    private final int CONTENT = 1;

    public FitmentLiveRecyclerViewAdapter(Context context) {
        this.context = context;
        datas = new ArrayList<>();
        inflater = LayoutInflater.from(context);
    }

    protected Context getContext() {
        return context;
    }

    public void clearData() {
        this.datas.clear();
    }

    public void setDatas(List<ResponseFitmentPorgress.DataBean> datas) {
        this.datas.clear();
        this.datas.addAll(datas);
        notifyDataSetChanged();
    }

    public void addDatas(List<ResponseFitmentPorgress.DataBean> datas) {
        this.datas.addAll(datas);
        notifyDataSetChanged();
    }

    public void clearDatas() {
        this.datas.clear();
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return datas.size() + 1;
    }

    @Override
    public int getItemViewType(int position) {
        if (position >= getItemCount() - 1)
            return FOOTER;
        return CONTENT;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == FOOTER) {
            View view = inflater.inflate(R.layout.footer_recycler_fitment_live, parent, false);
            return new FooterViewHolder(view);
        }
        return new ContentViewHolder(inflater.inflate(R.layout.item_recycler_fitment_live, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position) == FOOTER) {
            return;
        }
        ResponseFitmentPorgress.DataBean dataBean = datas.get(position);
        ContentViewHolder contentViewHolder = (ContentViewHolder) holder;
        contentViewHolder.simpleDrwaeeView.setImageURI(dataBean.getAvatar());
        contentViewHolder.textViewName.setText(getContext().getString(R.string.name_fragment_fitment_live, dataBean.getCreatorName(), dataBean.getCreatorRole()));
        contentViewHolder.textViewTitle.setText(dataBean.getMessage());
        String date = new SimpleDateFormat("yyyy/MM/dd HH:mm").format(new Date(dataBean.getCreateTime()));
        contentViewHolder.textViewTime.setText(date);
        FitmentLiveGridViewAdapter fitmentLiveGridViewAdapter = new FitmentLiveGridViewAdapter(getContext());
        if (!TextUtils.isEmpty(dataBean.getImgSrc())) {
            String data = dataBean.getImgSrc();
            String[] split = data.split(",");
            List<String> list = new ArrayList<>();
            for (int i = 0; i < split.length; i++) {
                list.add(split[i]);
            }
            fitmentLiveGridViewAdapter.addDatas(list);
            contentViewHolder.gridView.setAdapter(fitmentLiveGridViewAdapter);
            fitmentLiveGridViewAdapter.setClickListener(new FitmentLiveGridViewAdapter.ClickListener() {
                @Override
                public void onClick(List<String> urls, int position) {
                    clickListener.onClick(urls, position);
                }
            });
        }
        if (dataBean.getReplyList().size() != 0) {
            contentViewHolder.textViewComments.setText(getContext().getString(R.string.comments_fragment_fitment_live, dataBean.getReplyList().size() + ""));
            for (int i = 0; i < dataBean.getReplyList().size(); i++) {
                ResponseFitmentPorgress.DataBean.Reply reply = dataBean.getReplyList().get(i);
                TextView textView = new TextView(getContext());
                textView.setTextSize(14);
                textView.setText(reply.getName() + "(" + reply.getRoleName() + "):" + reply.getMessage());
                contentViewHolder.linearLayoutComments.addView(textView);
            }
        }
    }


    static class FooterViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.textView_footer_recycler_fitment_live)
        TextView textViewFooterRecyclerFitmentLive;

        FooterViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    static class ContentViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.simpleDrwaeeView_fragment_fitment_live)
        SimpleDraweeView simpleDrwaeeView;
        @BindView(R.id.textView_name_fragment_fitment_live)
        TextView textViewName;
        @BindView(R.id.textView_title_fragment_fitment_live)
        TextView textViewTitle;
        @BindView(R.id.gridView_fragment_fitment_live)
        MyGridView gridView;
        @BindView(R.id.textView_time_fragment_fitment_live)
        TextView textViewTime;
        @BindView(R.id.imagView_back_fragment_fitment_live)
        ImageView imagViewBack;
        @BindView(R.id.textView_comments_fragment_fitment_live)
        TextView textViewComments;
        @BindView(R.id.linearLayout_comments_fragment_fitment_live)
        LinearLayout linearLayoutComments;

        ContentViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    private ClickListener clickListener;

    public void setClickListener(ClickListener clickListener) {
        this.clickListener = clickListener;
    }

    public interface ClickListener {
        void onClick(List<String> urls, int position);
    }
}
