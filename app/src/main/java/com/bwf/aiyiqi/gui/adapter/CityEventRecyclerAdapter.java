package com.bwf.aiyiqi.gui.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bwf.aiyiqi.R;
import com.bwf.aiyiqi.entity.ResponseCityEvent;
import com.bwf.aiyiqi.gui.activity.CityEvent.InvitationDetailActivity;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/11/30.
 */

public class CityEventRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private LayoutInflater inflater;
    private List<ResponseCityEvent.DataBean.ForumlistBean> datas;
    private Context context;
    private final int CONTENT = 1;
    private final int FOOTER = 2;

    public CityEventRecyclerAdapter(Context context) {
        this.inflater = LayoutInflater.from(context);
        this.context = context;
        datas = new ArrayList<>();
    }

    public void setDatas(List<ResponseCityEvent.DataBean.ForumlistBean> datas) {
        this.datas.clear();
        this.datas.addAll(datas);
        notifyDataSetChanged();
    }

    public void addDatas(List<ResponseCityEvent.DataBean.ForumlistBean> datas) {
        this.datas.addAll(datas);
        notifyDataSetChanged();
    }

    public void clearDatas() {
        this.datas.clear();
    }

    @Override
    public int getItemCount() {
        return datas.size() + 1;
    }

    public Context getContext() {
        return context;
    }

    @Override
    public int getItemViewType(int position) {
        return position == getItemCount() - 1 ? FOOTER : CONTENT;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == FOOTER)
            return new FooterViewHolder(inflater.inflate(R.layout.footer_city_event_recycler_view, parent, false));
        View view = inflater.inflate(R.layout.item_city_event_recycler_view, parent, false);
        return new ContentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position) == FOOTER)
            return;
        final ResponseCityEvent.DataBean.ForumlistBean bean = datas.get(position);
        ContentViewHolder contentViewHolder = (ContentViewHolder) holder;
        contentViewHolder.simpleDraweeViewCityEventRecyclerView.setImageURI(bean.getAttachments());
        if (bean.getActivityclose() == 1) {
            contentViewHolder.imageViewApplyCityEventRecyclerView.setImageResource(R.mipmap.activity_end_sign);
            contentViewHolder.textViewApplyCityEventRecyclerView.setText(getContext().getString(R.string.event_end));
        }
        if (!TextUtils.isEmpty(bean.getLastpost())) {
            String[] split = bean.getLastpost().split("-");
            String str = split[0] + "年" + split[1] + "月" + split[2] + "日";
            contentViewHolder.textViewEndTimeCityEventRecyclerView.setText("报名截止日期："+str);
        }
        contentViewHolder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), InvitationDetailActivity.class);
                String url = TextUtils.isEmpty(bean.getUrls()) ? bean.getGroupon_urls() : bean.getUrls();
                intent.putExtra("url", url);
                getContext().startActivity(intent);
            }
        });
    }


    static class FooterViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.textView_footer_city_event_recycler)
        TextView textViewFooterCityEventRecycler;

        FooterViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    static class ContentViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.simpleDraweeView_city_event_recyclerView)
        SimpleDraweeView simpleDraweeViewCityEventRecyclerView;
        @BindView(R.id.imageView_apply_city_event_recyclerView)
        ImageView imageViewApplyCityEventRecyclerView;
        @BindView(R.id.textView_apply_city_event_recyclerView)
        TextView textViewApplyCityEventRecyclerView;
        @BindView(R.id.imageView_endTime_city_event_recyclerView)
        ImageView imageViewEndTimeCityEventRecyclerView;
        @BindView(R.id.textView_endTime_city_event_recyclerView)
        TextView textViewEndTimeCityEventRecyclerView;
        @BindView(R.id.linearLayout_city_event_recyclerView)
        LinearLayout linearLayoutCityEventRecyclerView;
        private View view;

        ContentViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
            this.view = view;
        }
    }
}
