package com.bwf.aiyiqi.gui.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bwf.aiyiqi.R;
import com.bwf.aiyiqi.entity.ResponseArticle;
import com.bwf.aiyiqi.entity.ResponseArticleReply;
import com.bwf.aiyiqi.gui.adapter.baseadapters.MyBaseRecycleAdapter;
import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/12/6.
 */

public class ArticleAdapter extends MyBaseRecycleAdapter<String> {
    private ArticleRelateAdapter relateAdapter;
    private ArticleReplyAdapter replyAdapter;

    public ArticleAdapter(Context context) {
        super(context);
        relateAdapter = new ArticleRelateAdapter(context);
        replyAdapter = new ArticleReplyAdapter(context);
    }

    @Override
    protected int getFooterCount() {
        return 1;
    }

    @Override
    protected int getHeaderCount() {
        return 1;
    }

    private ResponseArticle article;

    public void setObjData(Object obj) {
        article = (ResponseArticle) obj;
        if (article==null)return;
        setDatas(article.getData().getCurrentNews().getContent());
        relateAdapter.setDatas(article.getData().getRelatedNews());
        notifyDataSetChanged();
    }


    public void setReply(ResponseArticleReply reply) {
        replyAdapter.setReply(reply);
        notifyItemChanged(getItemCount()-1);
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case HEADER:
                View headerview = inflater.inflate(R.layout.article_header, parent, false);
                return new HeaderHolder(headerview);
            case CONTENT:
                View contentview = inflater.inflate(R.layout.note_content, parent, false);
                return new ContentHolder(contentview);
            case FOOTER:
                View footerview = inflater.inflate(R.layout.note_footer, parent, false);
                return new FooterHolder(footerview);
        }
        return null;
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (article != null) {
            switch (getItemViewType(position)) {
                case HEADER:
                    HeaderHolder headerHolder = (HeaderHolder) holder;
                    headerHolder.articleHeaderLinear.removeAllViews();
                    headerHolder.articleHeaderTv.setGravity(Gravity.CENTER);
                    headerHolder.articleHeaderTv.setText(article.getData().getCurrentNews().getTitle());
                    for (ResponseArticle.DataBean.TagsBean tag : article.getData().getTags()) {
                        TextView tv = new TextView(getContext());
                        tv.setTextColor(0xff66ccff);
                        tv.setText(tag.getName() + "  ");
                        tv.setTextSize(14);
                        headerHolder.articleHeaderLinear.addView(tv);
                    }
                    break;
                case CONTENT:
                    String content = getItem(position);
                    ContentHolder contentHolder = (ContentHolder) holder;
//                    String pat="http";
//                    Pattern pattern=Pattern.compile(pat);
//                    Matcher matcher=pattern.matcher(content);
                    if (position % 2 == 0) {
                        contentHolder.articleTv.setVisibility(View.GONE);
                        contentHolder.articleDrawee.setVisibility(View.VISIBLE);
                        contentHolder.articleDrawee.setImageURI(content);
                    } else {
                        contentHolder.articleTv.setVisibility(View.VISIBLE);
                        contentHolder.articleDrawee.setVisibility(View.GONE);
                        contentHolder.articleTv.setText(content);
                    }
                    break;
                case FOOTER:
                    FooterHolder footerHolder = (FooterHolder) holder;
                    footerHolder.articleRecycler1.setLayoutManager(new LinearLayoutManager(getContext()));
                    footerHolder.articleRecycler1.setAdapter(relateAdapter);
                    footerHolder.articleRecycler2.setLayoutManager(new LinearLayoutManager(getContext()));
                    footerHolder.articleRecycler2.setAdapter(replyAdapter);
                    break;
            }
        }

    }

    class HeaderHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.article_header_tv)
        TextView articleHeaderTv;
        @BindView(R.id.article_header_linear)
        LinearLayout articleHeaderLinear;

        HeaderHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    class ContentHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.article_tv)
        TextView articleTv;
        @BindView(R.id.article_drawee)
        SimpleDraweeView articleDrawee;

        ContentHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    class FooterHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.article_recycler1)
        RecyclerView articleRecycler1;
        @BindView(R.id.article_recycler2)
        RecyclerView articleRecycler2;

        FooterHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

}
