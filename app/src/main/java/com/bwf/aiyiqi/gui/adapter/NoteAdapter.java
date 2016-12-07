package com.bwf.aiyiqi.gui.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bwf.aiyiqi.R;
import com.bwf.aiyiqi.entity.ResponseNote;
import com.bwf.aiyiqi.entity.ResponseNoteLike;
import com.bwf.aiyiqi.entity.ResponseNoteReply;
import com.bwf.aiyiqi.gui.adapter.baseadapters.MyBaseRecycleAdapter;
import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/12/6.
 */

public class NoteAdapter extends MyBaseRecycleAdapter<ResponseNote.DataBean.MessageBean> {
    private NoteFooterAdapter footerAdapter;

    public NoteAdapter(Context context) {
        super(context);
        footerAdapter = new NoteFooterAdapter(context);
    }

    @Override
    protected int getFooterCount() {
        return 1;
    }

    @Override
    protected int getHeaderCount() {
        return 1;
    }

    private ResponseNote note;

    public void setObjData(Object obj) {
        note = (ResponseNote) obj;
        setDatas(note.getData().getMessage());
        notifyDataSetChanged();
    }


    public void setReply(ResponseNoteReply reply) {
        footerAdapter.setReply(reply);
    }

    public void setLike(ResponseNoteLike like) {
        footerAdapter.setLike(like);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case HEADER:
                View headerview = inflater.inflate(R.layout.note_header, parent, false);
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
        if (note != null) {
            switch (getItemViewType(position)) {
                case HEADER:
                    HeaderHolder headerHolder = (HeaderHolder) holder;
                    headerHolder.recycleUserImv.setImageURI(note.getData().getAvtUrl());
                    headerHolder.recycleUserName.setText(note.getData().getAuthor());
                    headerHolder.recycleTitle.setText(note.getData().getTitle());
                    headerHolder.recycleUserFrom.setText(note.getData().getDateline());
                    headerHolder.recycleUserLasttime.setText("精选自北京装修论坛>");
                    break;
                case CONTENT:
                    ContentHolder contentHolder = (ContentHolder) holder;
                    ResponseNote.DataBean.MessageBean messageBean = getItem(position);
                    if (messageBean.getMsgType() == 0) {
                        contentHolder.articleTv.setVisibility(View.VISIBLE);
                        contentHolder.articleTv.setText(messageBean.getMsg());
                        contentHolder.articleDrawee.setVisibility(View.GONE);
                    } else if (messageBean.getMsgType() == 1) {
                        contentHolder.articleTv.setVisibility(View.GONE);
                        contentHolder.articleDrawee.setVisibility(View.VISIBLE);
                        contentHolder.articleDrawee.setMinimumHeight(Integer.parseInt(messageBean.getHeight()));
                        contentHolder.articleDrawee.setMinimumWidth(Integer.parseInt(messageBean.getWidth()));
                        contentHolder.articleDrawee.setImageURI(messageBean.getMsg());
                    }
                    break;
                case FOOTER:
                    FooterHolder footerHolder = (FooterHolder) holder;
                    LinearLayoutManager manager = new LinearLayoutManager(getContext());
                    footerHolder.articleRecycler1.setLayoutManager(manager);
                    footerHolder.articleRecycler1.setAdapter(footerAdapter);
                    footerHolder.articleRecycler2.setVisibility(View.GONE);
                    break;
            }
        }

    }

    class HeaderHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.recycle_user_imv)
        SimpleDraweeView recycleUserImv;
        @BindView(R.id.recycle_user_name)
        TextView recycleUserName;
        @BindView(R.id.recycle_user_follow)
        CheckedTextView recycleUserFollow;
        @BindView(R.id.recycle_title)
        TextView recycleTitle;
        @BindView(R.id.subview_note_linear)
        LinearLayout subviewNoteLinear;
        @BindView(R.id.recycle_user_lasttime)
        TextView recycleUserLasttime;
        @BindView(R.id.recycle_user_from)
        TextView recycleUserFrom;

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
