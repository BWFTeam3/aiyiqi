package com.bwf.aiyiqi.gui.activity;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.bwf.aiyiqi.R;
import com.bwf.aiyiqi.entity.ResponseNote;
import com.bwf.aiyiqi.entity.ResponseNoteLike;
import com.bwf.aiyiqi.entity.ResponseNoteReply;
import com.bwf.aiyiqi.gui.activity.baseactivitys.BaseActivity;
import com.bwf.aiyiqi.gui.adapter.NoteAdapter;
import com.bwf.aiyiqi.mvp.presenter.Impl.NotePresenterImpl;
import com.bwf.aiyiqi.mvp.presenter.NotePresenter;
import com.bwf.aiyiqi.mvp.view.NoteView;
import com.cjj.MaterialRefreshLayout;
import com.cjj.MaterialRefreshListener;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/12/5.
 */

public class NoteDetailsActicity extends BaseActivity implements NoteView, View.OnClickListener {
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.layout_title)
    RelativeLayout layoutTitle;
    @BindView(R.id.scrollview_tag)
    RecyclerView scrollviewTag;
    @BindView(R.id.refreshLayout)
    MaterialRefreshLayout refreshLayout;
    @BindView(R.id.image_button_tag02)
    ImageButton imageButtonTag02;
    @BindView(R.id.image_button_tag03)
    ImageButton imageButtonTag03;
    private NotePresenter presenter;
    private NoteAdapter adapter;

    @Override
    protected int getViewResId() {
        return R.layout.detailes_acticity;
    }

    @Override
    protected void initViews() {
        ButterKnife.bind(this);
        title.setText("帖子详情");
        back.setOnClickListener(this);
        refreshLayout.setMaterialRefreshListener(new MaterialRefreshListener() {
            @Override
            public void onRefresh(MaterialRefreshLayout materialRefreshLayout) {
                loadDatas(id);
            }
        });
        adapter=new NoteAdapter(this);
        scrollviewTag.setLayoutManager(new LinearLayoutManager(this));
        scrollviewTag.setAdapter(adapter);
    }

    private String id;

    @Override
    protected void initDatas() {
        Intent intent = getIntent();
        id = intent.getStringExtra("id");
        presenter = new NotePresenterImpl(this);
//        id = "1216903";
        loadDatas(id);

    }

    private void loadDatas(String id) {
        presenter.loadDatas(id);
        presenter.loadReplys(id);
        presenter.loadLikes(id);
    }

    @Override
    public void showDatasSuccess(String response) {
        refreshLayout.finishRefresh();
        ResponseNote note= JSON.parseObject(response,ResponseNote.class);
        adapter.setObjData(note);
    }

    @Override
    public void showDatasFaild(Exception e) {
        refreshLayout.finishRefresh();
        Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showReplysSuccess(String response) {
        refreshLayout.finishRefresh();
        ResponseNoteReply reply=JSON.parseObject(response,ResponseNoteReply.class);
        adapter.setReply(reply);
    }

    @Override
    public void showReplysFaild(Exception e) {
        refreshLayout.finishRefresh();
        Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLikesSuccess(String response) {
        refreshLayout.finishRefresh();
        ResponseNoteLike like=JSON.parseObject(response,ResponseNoteLike.class);
        adapter.setLike(like);
    }

    @Override
    public void showLikesFaild(Exception e) {
        refreshLayout.finishRefresh();
        Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        finish();
    }
}
