package com.bwf.aiyiqi.gui.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.bwf.aiyiqi.R;
import com.bwf.aiyiqi.entity.ResponseFitmentNews;
import com.bwf.aiyiqi.gui.adapter.FitmentAdapter;
import com.bwf.aiyiqi.gui.adapter.baseadapters.MyBaseRecycleAdapter;
import com.bwf.aiyiqi.gui.fragment.basefragments.BaseFragment;
import com.bwf.aiyiqi.mvp.presenter.FitmentPresenter;
import com.bwf.aiyiqi.mvp.presenter.Impl.FitmentPresenterImpl;
import com.bwf.aiyiqi.mvp.view.FitmentView;
import com.bwf.aiyiqi.utils.StringHandler;
import com.cjj.MaterialRefreshLayout;
import com.cjj.MaterialRefreshListener;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/11/28.
 */

public class FitmentFragment extends BaseFragment implements FitmentView,MyBaseRecycleAdapter.OnItemClickListener {
    @BindView(R.id.fitment_header)
    RecyclerView fitmentRecycleview;
    @BindView(R.id.fitment_refresh)
    MaterialRefreshLayout fitmentRefresh;

    @Override
    protected int getViewResId() {
        return R.layout.fitment_fragment;
    }
    private FitmentAdapter adapter;
    @Override
    protected void initViews() {
        LinearLayoutManager manager=new LinearLayoutManager(getContext());
        adapter=new FitmentAdapter(getContext(),this);
        adapter.setOnItemClickListener(this);
        fitmentRecycleview.setLayoutManager(manager);
        fitmentRecycleview.setAdapter(adapter);
        fitmentRefresh.setMaterialRefreshListener(new MaterialRefreshListener() {
            @Override
            public void onRefresh(MaterialRefreshLayout materialRefreshLayout) {
                presenter.loadTags(stage);
                presenter.loadNews(stage,"把我换成Tag的id");
            }
        });
    }

    private int stage;
    private FitmentPresenter presenter;

    @Override
    protected void initDatas() {
        Bundle bundle = getArguments();
        stage = bundle.getInt("stage");
        presenter = new FitmentPresenterImpl(this);
        presenter.loadTags(stage);
        presenter.loadNews(stage,"把我换成Tag的id");
    }

    @Override
    public void showTagsSuccess(String response) {
        fitmentRefresh.finishRefresh();
        List<String> list= StringHandler.getList(response,2);
        adapter.setHeaderDatas(list);
    }

    @Override
    public void showTagsFaild(Exception e) {
        fitmentRefresh.finishRefresh();
        Toast.makeText(getContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showNewsSuccess(String response) {
        fitmentRefresh.finishRefresh();
        ResponseFitmentNews responseFitmentNews= JSON.parseObject(response,ResponseFitmentNews.class);
        if (responseFitmentNews.getData().getList().get(0)==null)return;
        adapter.setDatas(responseFitmentNews.getData().getList());
    }

    @Override
    public void showNewsFaild(Exception e) {
        fitmentRefresh.finishRefresh();
        Toast.makeText(getContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showNextSuccess(String response) {
        fitmentRefresh.finishRefresh();
        ResponseFitmentNews responseFitmentNews= JSON.parseObject(response,ResponseFitmentNews.class);
        if (responseFitmentNews.getData().getList().get(0)==null)return;
        adapter.addDatas(responseFitmentNews.getData().getList());
    }

    @Override
    public void showNextFaild(Exception e) {
        fitmentRefresh.finishRefresh();
        Toast.makeText(getContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onItemClick(View view, int pesition, Object data) {
        if ((int)view.getTag()==FitmentAdapter.FOOTER){
            presenter.loadNextNews(stage,"把我换成Tag的id");
        }else if((int)view.getTag()==FitmentAdapter.HEADER){
           String s= ((TextView)view).getText().toString();
            Toast.makeText(getContext(),s, Toast.LENGTH_SHORT).show();
            // TODO: 2016/12/1 获得tag的id，调用presenter
        }else{
            Toast.makeText(getContext(), "帖转帖子", Toast.LENGTH_SHORT).show();
        }
    }

}
