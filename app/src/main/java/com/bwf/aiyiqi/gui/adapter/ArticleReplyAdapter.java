package com.bwf.aiyiqi.gui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bwf.aiyiqi.R;
import com.bwf.aiyiqi.entity.ResponseArticleReply;
import com.bwf.aiyiqi.gui.adapter.baseadapters.MyBaseRecycleAdapter;
import com.facebook.drawee.view.SimpleDraweeView;

import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/12/6.
 */

public class ArticleReplyAdapter extends MyBaseRecycleAdapter<ResponseArticleReply.DataBean.DataBean1> {
    public ArticleReplyAdapter(Context context) {
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

    private ResponseArticleReply reply;

    public void setReply(ResponseArticleReply reply) {
        this.reply = reply;
        setDatas(reply.getData().getData1());
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case HEADER:
                View headerview = inflater.inflate(R.layout.note_like, parent, false);
                return new HeaderHolder(headerview);
            case CONTENT:
                View contentview = inflater.inflate(R.layout.note_reply, parent, false);
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
                headerHolder.noteLikeTv.setText(getContext().getString(R.string.note_like, reply.getData().getData1().size()));
                break;
            case CONTENT:
                if (reply == null) return;
                ContentHolder contentHolder = (ContentHolder) holder;
                contentHolder.noteReplyContent.removeAllViews();
                ResponseArticleReply.DataBean.DataBean1 dataBean1 = getItem(position);
                contentHolder.noteReplyImg.setImageURI(dataBean1.getUserheadimage());
                contentHolder.noteReplyUsername.setText(dataBean1.getComment_user_name());
                SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm");
                long time=(long)(Integer.parseInt(dataBean1.getComment_time()));
                String date=dateFormat.format(new Date(time));
                contentHolder.noteReplyLasttime.setText(date);
                View view = new TextView(getContext());
                ((TextView) view).setText(dataBean1.getComment_content());
                contentHolder.noteReplyContent.addView(view);
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
        @BindView(R.id.note_reply_img)
        SimpleDraweeView noteReplyImg;
        @BindView(R.id.note_reply_username)
        TextView noteReplyUsername;
        @BindView(R.id.note_reply_content)
        LinearLayout noteReplyContent;
        @BindView(R.id.note_reply_lasttime)
        TextView noteReplyLasttime;
        @BindView(R.id.note_reply_imgbuttom)
        ImageButton noteReplyImgbuttom;

        ContentHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

}
