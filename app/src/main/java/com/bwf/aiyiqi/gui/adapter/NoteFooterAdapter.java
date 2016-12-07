package com.bwf.aiyiqi.gui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bwf.aiyiqi.R;
import com.bwf.aiyiqi.entity.ResponseNoteLike;
import com.bwf.aiyiqi.entity.ResponseNoteReply;
import com.bwf.aiyiqi.gui.adapter.baseadapters.MyBaseRecycleAdapter;
import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/12/6.
 */

public class NoteFooterAdapter extends MyBaseRecycleAdapter<ResponseNoteReply.DataBean> {
    public NoteFooterAdapter(Context context) {
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

    private ResponseNoteReply reply;
    private ResponseNoteLike like;

    public void setReply(ResponseNoteReply reply) {
        this.reply = reply;
        setDatas(reply.getData());
    }

    public void setLike(ResponseNoteLike like) {
        this.like = like;
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
                if (like == null) return;
                HeaderHolder headerHolder = (HeaderHolder) holder;
                headerHolder.noteLikelinear.removeViews(1,headerHolder.noteLikelinear.getChildCount()-1);
                int likecount = like.getData().size();
                headerHolder.noteLikeTv.setText(getContext().getString(R.string.note_like, likecount));
                for (int i = 0; i < likecount; i++) {
                    View view = inflater.inflate(R.layout.subview_simpledrawee,headerHolder.noteLikelinear,false);
                    SimpleDraweeView draweeView= (SimpleDraweeView) view.findViewById(R.id.drawee);
                   draweeView.setImageURI(like.getData().get(i).getAvtUrl());
                    headerHolder.noteLikelinear.addView(draweeView);
                }

                break;
            case CONTENT:
                if (reply == null) return;
                ContentHolder contentHolder = (ContentHolder) holder;
                contentHolder.noteReplyContent.removeAllViews();
                ResponseNoteReply.DataBean dataBean = getItem(position);
                contentHolder.noteReplyImg.setImageURI(dataBean.getAvtUrl());
                contentHolder.noteReplyUsername.setText(dataBean.getAuthor());
                contentHolder.noteReplyLasttime.setText(dataBean.getDateline());
                for (ResponseNoteReply.DataBean.MessageBean message : dataBean.getMessage()) {
                    if (message.getMsgType() == 0) {
                        View view = new TextView(getContext());
                        ((TextView) view).setText(message.getMsg());
                        contentHolder.noteReplyContent.addView(view);
                    } else if (message.getMsgType() == 1) {
                        View view = inflater.inflate(R.layout.subview_simpledrawee,contentHolder.noteReplyContent,false);
                        SimpleDraweeView draweeView= (SimpleDraweeView) view.findViewById(R.id.drawee);
                        draweeView.setImageURI(message.getMsg());
                        contentHolder.noteReplyContent.addView(draweeView);
                    }
                }
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
