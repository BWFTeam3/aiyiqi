package com.bwf.aiyiqi.gui.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bwf.aiyiqi.R;
import com.bwf.aiyiqi.entity.ResponseMainArticles;
import com.bwf.aiyiqi.entity.ResponseMainPager;
import com.bwf.aiyiqi.gui.activity.BuildingActivity;
import com.bwf.aiyiqi.gui.activity.CityEvent.CityEventActivity;
import com.bwf.aiyiqi.gui.activity.DecorationBudgetActivity;
import com.bwf.aiyiqi.gui.activity.DecorationCompany.DecorationCompanyActivity;
import com.bwf.aiyiqi.gui.activity.DesignActivity;
import com.bwf.aiyiqi.gui.activity.FitmentActivity;
import com.bwf.aiyiqi.gui.activity.design_measureActivity;
import com.bwf.aiyiqi.gui.activity.OderselfActivity;
import com.bwf.aiyiqi.gui.adapter.baseadapters.MyBaseRecycleAdapter;
import com.bwf.aiyiqi.gui.view.AutoScrollViewPager;
import com.bwf.aiyiqi.widget.PagerDotIndicator;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/11/24.
 */

public class MainRecycleAdapter extends MyBaseRecycleAdapter implements View.OnClickListener {

    private ViewPager pager;

    public MainRecycleAdapter(Context context) {
        super(context);
    }

    @Override
    protected int getFooterCount() {
        return 1;
    }

    @Override
    protected int getHeaderCount() {
        return 1;
    }


    private MainPagerAdapter pagerAdapter;
    private List<View> views;
    private PagerDotIndicator dotIndicator;
    private LinearLayout container;

    public void setHeaderDatas(List<ResponseMainPager.DataBean> headerDatas) {
        if (views == null) {
            views = new ArrayList<>();
            for (int i = 0; i < headerDatas.size(); i++) {
                if (headerDatas.size() < 3) {
                    views.add(inflater.inflate(R.layout.main_autopager, null));
                }
                views.add(inflater.inflate(R.layout.main_autopager, null));
            }
        }
        pagerAdapter = new MainPagerAdapter(getContext(), views);
        pagerAdapter.setDatas(headerDatas);
        dotIndicator = new PagerDotIndicator(getContext(), container, pager);
        dotIndicator.setDotNums(headerDatas.size());
        pager.setAdapter(pagerAdapter);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == HEADER) {
            View view = inflater.inflate(R.layout.subview_recycle_header, parent, false);
            return new HeaderViewHolder(view);
        }
        if (viewType == CONTENT) {
            View view = inflater.inflate(R.layout.subview_recycle_article, parent, false);
            return new MyViewHolder(view);
        } else {
            View view = inflater.inflate(R.layout.subview_recycle_footer, parent, false);
            return new FooterViewHolder(view);
        }
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        switch (getItemViewType(position)) {
            case HEADER:
                HeaderViewHolder headerViewHolder = (HeaderViewHolder) holder;
                pager = headerViewHolder.mainAutoviewpager;
                container = headerViewHolder.mainAutoviewpagerLinear;
                pager.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });
                headerViewHolder.mainRecycleviewCtv1.setOnClickListener(this);
                headerViewHolder.mainRecycleviewCtv2.setOnClickListener(this);
                headerViewHolder.mainRecycleviewCtv3.setOnClickListener(this);
                headerViewHolder.mainRecycleviewCtv4.setOnClickListener(this);
                headerViewHolder.mainRecycleviewCtv5.setOnClickListener(this);
                headerViewHolder.mainRecycleviewCtv6.setOnClickListener(this);
                headerViewHolder.mainRecycleviewCtv7.setOnClickListener(this);
                headerViewHolder.mainRecycleviewCtv8.setOnClickListener(this);
                break;
            case CONTENT:
                ResponseMainArticles.DataBean data = (ResponseMainArticles.DataBean) getItem(position);
                MyViewHolder myViewHolder = (MyViewHolder) holder;
                myViewHolder.recycleImageview.setImageURI(data.getPath());
                myViewHolder.recycleImageview.setMinimumHeight(350);
                myViewHolder.recycleImageview.setVisibility(View.VISIBLE);
                myViewHolder.recycleTextviewViewcount.setText(data.getViews());
                myViewHolder.recycleTextviewCommentcount.setText(data.getReplies());
                if (data.getType() == 1) {
                    myViewHolder.subviewNoteLinear.setVisibility(View.GONE);
                    myViewHolder.subviewArticleLinear.setVisibility(View.VISIBLE);
                    myViewHolder.recycleArticleTextview.setText(data.getTitle());
                    myViewHolder.recycleTextLasttime.setText(data.getDateline());
                } else if (data.getType() == 3) {
                    if (data.getPath()==null||data.getPath()==""){
                        myViewHolder.recycleImageview.setVisibility(View.GONE);
                    }
                    myViewHolder.subviewNoteLinear.setVisibility(View.VISIBLE);
                    myViewHolder.subviewArticleLinear.setVisibility(View.GONE);
                    myViewHolder.recycleTextLasttime.setText("精选自北京*****");
                    myViewHolder.recycleUserImv.setImageURI(data.getAvtUrl());
                    myViewHolder.recycleTitle.setText(data.getTitle());
                    myViewHolder.recycleUserLasttime.setText(data.getDateline());
                    myViewHolder.recycleUserName.setText(data.getAuthor());
                }
                break;
            case FOOTER:
                break;
        }
    }

    public void onClick(View view) {
        Intent intent = null;
        switch (view.getId()) {
            case R.id.main_recycleview_ctv1:
                intent = new Intent(getContext(), DecorationCompanyActivity.class);
                break;
            case R.id.main_recycleview_ctv2:
                intent = new Intent(getContext(), CityEventActivity.class);
                break;
            case R.id.main_recycleview_ctv3:
                intent=new Intent(getContext(), FitmentActivity.class);
                break;
            case R.id.main_recycleview_ctv4:
                intent = new Intent(getContext(), DecorationBudgetActivity.class);
                break;
            case R.id.main_recycleview_ctv5:
                intent = new Intent(getContext(), BuildingActivity.class);
                break;
            case R.id.main_recycleview_ctv6:
                intent=new Intent(getContext(),DesignActivity.class);
                break;
            case R.id.main_recycleview_ctv7:
                intent = new Intent(getContext(),OderselfActivity.class);
                break;
            case R.id.main_recycleview_ctv8:
                intent = new Intent(getContext(), design_measureActivity.class);
                break;
        }
        if (intent != null)
            getContext().startActivity(intent);
    }

    class HeaderViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.main_autoviewpager)
        AutoScrollViewPager mainAutoviewpager;
        @BindView(R.id.main_autoviewpager_linear)
        LinearLayout mainAutoviewpagerLinear;
        @BindView(R.id.main_recycleview_ctv1)
        CheckedTextView mainRecycleviewCtv1;
        @BindView(R.id.main_recycleview_ctv2)
        CheckedTextView mainRecycleviewCtv2;
        @BindView(R.id.main_recycleview_ctv3)
        CheckedTextView mainRecycleviewCtv3;
        @BindView(R.id.main_recycleview_ctv4)
        CheckedTextView mainRecycleviewCtv4;
        @BindView(R.id.main_recycleview_ctv5)
        CheckedTextView mainRecycleviewCtv5;
        @BindView(R.id.main_recycleview_ctv6)
        CheckedTextView mainRecycleviewCtv6;
        @BindView(R.id.main_recycleview_ctv7)
        CheckedTextView mainRecycleviewCtv7;
        @BindView(R.id.main_recycleview_ctv8)
        CheckedTextView mainRecycleviewCtv8;

        HeaderViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
            dotIndicator = new PagerDotIndicator(getContext(), mainAutoviewpagerLinear, mainAutoviewpager);

        }
    }

    class MyViewHolder extends BaseHolder {
        @BindView(R.id.recycle_article_ctv)
        CheckedTextView recycleArticleCtv;
        @BindView(R.id.recycle_article_textview)
        TextView recycleArticleTextview;
        @BindView(R.id.subview_article_linear)
        LinearLayout subviewArticleLinear;
        @BindView(R.id.recycle_user_imv)
        SimpleDraweeView recycleUserImv;
        @BindView(R.id.recycle_user_name)
        TextView recycleUserName;
        @BindView(R.id.recycle_user_lasttime)
        TextView recycleUserLasttime;
        @BindView(R.id.recycle_user_follow)
        CheckedTextView recycleUserFollow;
        @BindView(R.id.recycle_title)
        TextView recycleTitle;
        @BindView(R.id.subview_note_linear)
        LinearLayout subviewNoteLinear;
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

        MyViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}


