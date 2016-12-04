package com.bwf.aiyiqi.gui.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bwf.aiyiqi.R;
import com.bwf.aiyiqi.entity.ResponseFitmentNews;
import com.bwf.aiyiqi.gui.adapter.baseadapters.MyBaseRecycleAdapter;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/11/28.
 */

public class FitmentAdapter extends MyBaseRecycleAdapter<ResponseFitmentNews.DataBean.ListBean> {
    public static final int HEADER = 0;
    public static final int FOOTER = 2;
    public static final int CONTENT = 1;
    OnItemClickListener itenListener;
    public FitmentAdapter(Context context,OnItemClickListener listener) {
        super(context);
        this.itenListener=listener;
    }

    @Override
    protected int getFooterCount() {
        return 1;
    }

    @Override
    protected int getHeaderCount() {
        return 1;
    }

    @Override
    // TODO: 2016/12/1 抽到父类
    public int getItemViewType(int position) {
        if (position < getHeaderCount()) return HEADER;
        if (position >= getItemCount() - getFooterCount()) return FOOTER;
        else return CONTENT;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == HEADER) {
            View view = inflater.inflate(R.layout.fitment_header, parent, false);
            return new FitHeaderViewHolder(view);
        }
        if (viewType == CONTENT) {
            View view = inflater.inflate(R.layout.related_article_children, parent, false);
            return new FitViewHolder(view);
        } else {
            View view = inflater.inflate(R.layout.subview_recycle_footer, parent, false);
            return new FooterViewHolder(view);
        }
    }

    private HeaderAdapter headerAdapter;

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (getItemViewType(position)) {
            case HEADER:
                if (headerAdapter == null) {
                    FitHeaderViewHolder headerViewHolder = (FitHeaderViewHolder) holder;
                    LinearLayoutManager manager = new LinearLayoutManager(getContext());
                    manager.setOrientation(LinearLayoutManager.HORIZONTAL);
                    headerViewHolder.fitmentRecycleview.setLayoutManager(manager);
                    headerAdapter = new HeaderAdapter(getContext());
                    if (itenListener!=null){
                        headerAdapter.setOnItemClickListener(itenListener);
                    }
                    headerViewHolder.fitmentRecycleview.setAdapter(headerAdapter);
                }
                break;
            case CONTENT:
                ResponseFitmentNews.DataBean.ListBean listBean = getItem(position);
                FitViewHolder fitViewHolder = (FitViewHolder) holder;
                if (listBean == null) {
                    return;
                }
                fitViewHolder.relatedDetailsTitle.setText(listBean.getTitle());
                fitViewHolder.articleDetailsIamgeTag.setImageURI(listBean.getImage());
                fitViewHolder.mainArticleItemScan.setText(listBean.getViewCount() + "");
                fitViewHolder.mainArticleItemStar.setText((int) (Math.random() * 30) + "");
                fitViewHolder.mainArticleItemComments.setText(listBean.getReplies());
                break;

            case FOOTER:

                break;
        }

    }

    public void setHeaderDatas(List<String> list) {
        headerAdapter.setHeaderDatas(list);
    }

    class FitHeaderViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.fitment_header)
        RecyclerView fitmentRecycleview;

        FitHeaderViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    class FitViewHolder extends BaseHolder {
        @BindView(R.id.related_details_title)
        TextView relatedDetailsTitle;
        @BindView(R.id.zhegeidmeimaobing)
        TextView mainArticleItemScan;
        @BindView(R.id.main_article_item_star)
        TextView mainArticleItemStar;
        @BindView(R.id.main_article_item_comments)
        TextView mainArticleItemComments;
        @BindView(R.id.article_details_iamge_tag)
        SimpleDraweeView articleDetailsIamgeTag;
        @BindView(R.id.related_details_article_tag)
        LinearLayout relatedDetailsArticleTag;

        FitViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
