package com.bwf.aiyiqi.gui.activity;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.bwf.aiyiqi.R;
import com.bwf.aiyiqi.entity.ResponseArticle;
import com.bwf.aiyiqi.entity.ResponseArticleReply;
import com.bwf.aiyiqi.gui.activity.baseactivitys.BaseActivity;
import com.bwf.aiyiqi.gui.adapter.ArticleAdapter;
import com.bwf.aiyiqi.mvp.presenter.ArticlePresenter;
import com.bwf.aiyiqi.mvp.presenter.Impl.ArticlePresenterImpl;
import com.bwf.aiyiqi.mvp.view.ArticleView;
import com.bwf.aiyiqi.utils.StringHandler;
import com.cjj.MaterialRefreshLayout;
import com.cjj.MaterialRefreshListener;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/12/5.
 */

public class ArticleDetailsActicity extends BaseActivity implements ArticleView {
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
    private ArticlePresenter presenter;
    private ArticleAdapter adapter;

    @Override
    protected int getViewResId() {
        return R.layout.detailes_acticity;
    }

    String id;

    @Override
    protected void initViews() {
        ButterKnife.bind(this);
        title.setText("文章详情");
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        refreshLayout.setMaterialRefreshListener(new MaterialRefreshListener() {
            @Override
            public void onRefresh(MaterialRefreshLayout materialRefreshLayout) {
                loadDatas(id);
            }
        });
        scrollviewTag.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ArticleAdapter(this);
        scrollviewTag.setAdapter(adapter);
    }

    @Override
    protected void initDatas() {
        Intent intent = getIntent();
        id = intent.getStringExtra("id");
        presenter = new ArticlePresenterImpl(this);
        Log.d("ArticleDetailsActicity", id+"aaa");
        loadDatas(id);
    }

    private void loadDatas(String id) {
        presenter.loadDatas(id);
        presenter.loadReplys(id);
    }

    @Override
    public void showDatasSuccess(String response) {
        refreshLayout.finishRefresh();
        response = StringHandler.getString(response);
        ResponseArticle article = JSON.parseObject(response, ResponseArticle.class);
        adapter.setObjData(article);
    }

    @Override
    public void showDatasFaild(Exception e) {
        refreshLayout.finishRefresh();
        Toast.makeText(this,e.getMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showReplysSuccess(String response) {
        refreshLayout.finishRefresh();
        ResponseArticleReply articleReply = JSON.parseObject(response, ResponseArticleReply.class);
        adapter.setReply(articleReply);
    }

    @Override
    public void showReplysFaild(Exception e) {
        refreshLayout.finishRefresh();
        Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
    }

}
