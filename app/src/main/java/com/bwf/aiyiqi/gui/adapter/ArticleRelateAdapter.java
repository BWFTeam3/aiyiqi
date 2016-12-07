package com.bwf.aiyiqi.gui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bwf.aiyiqi.R;
import com.bwf.aiyiqi.entity.ResponseArticle;
import com.bwf.aiyiqi.gui.adapter.baseadapters.MyBaseRecycleAdapter;
import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/12/6.
 */

public class ArticleRelateAdapter extends MyBaseRecycleAdapter<ResponseArticle.DataBean.RelatedNewsBean> {
    public ArticleRelateAdapter(Context context) {
        super(context);
    }

    @Override
    protected int getFooterCount() {
        return 0;
    }

    @Override
    protected int getHeaderCount() {
        return 1;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case HEADER:
                View headerview = inflater.inflate(R.layout.note_like, parent, false);
                return new HeaderHolder(headerview);
            case CONTENT:
                View contentview = inflater.inflate(R.layout.related_article_children, parent, false);
                return new ContentHolder(contentview);
            case FOOTER:
        }
        return null;
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (getItemViewType(position)) {
            case HEADER:
                HeaderHolder headerHolder = (HeaderHolder) holder;
                headerHolder.noteLikeTv.setText("相关文章推荐");
                break;
            case CONTENT:
                ResponseArticle.DataBean.RelatedNewsBean newsBean = getItem(position);
                ContentHolder contentHolder= (ContentHolder) holder;
                if (newsBean == null) {
                    return;
                }
                contentHolder.relatedDetailsTitle.setText(newsBean.getTitle());
                if (newsBean.getThumb()==null||newsBean.getThumb()==""){
                    contentHolder.articleDetailsIamgeTag.setVisibility(View.GONE);
                }else{
                    contentHolder.articleDetailsIamgeTag.setImageURI(newsBean.getThumb());
                }
                contentHolder.zhegeidmeimaobing.setText(newsBean.getClick() + "");
                contentHolder.mainArticleItemStar.setText((int) (Math.random() * 30) + "");
                contentHolder.mainArticleItemComments.setText(newsBean.getComment_count()+"");
                break;
            case FOOTER:

                break;
        }

    }

    class HeaderHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.note_like_tv)
        TextView noteLikeTv;
        @BindView(R.id.note_likelinear)
        LinearLayout noteLikelinear;

        HeaderHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    class ContentHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.related_details_title)
        TextView relatedDetailsTitle;
        @BindView(R.id.zhegeidmeimaobing)
        TextView zhegeidmeimaobing;
        @BindView(R.id.main_article_item_star)
        TextView mainArticleItemStar;
        @BindView(R.id.main_article_item_comments)
        TextView mainArticleItemComments;
        @BindView(R.id.article_details_iamge_tag)
        SimpleDraweeView articleDetailsIamgeTag;
        @BindView(R.id.related_details_article_tag)
        LinearLayout relatedDetailsArticleTag;

        ContentHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

}
