package com.bwf.aiyiqi.gui.fragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.bwf.aiyiqi.R;
import com.bwf.aiyiqi.entity.ResponseMainArticles;
import com.bwf.aiyiqi.entity.ResponseMainPager;
import com.bwf.aiyiqi.gui.activity.SearchActivity;
import com.bwf.aiyiqi.gui.adapter.MainRecycleAdapter;
import com.bwf.aiyiqi.gui.adapter.baseadapters.MyBaseRecycleAdapter;
import com.bwf.aiyiqi.gui.fragment.basefragments.BaseFragment;
import com.bwf.aiyiqi.mvp.presenter.Impl.MainRecyclePresenterImpl;
import com.bwf.aiyiqi.mvp.view.MainRecycleView;
import com.cjj.MaterialRefreshLayout;
import com.cjj.MaterialRefreshListener;
import com.uuzuche.lib_zxing.activity.CaptureActivity;
import com.uuzuche.lib_zxing.activity.CodeUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/11/23.
 */

public class MainFragment extends BaseFragment implements View.OnClickListener, MainRecycleView, MyBaseRecycleAdapter.OnItemClickListener {
    private static final int REQUEST_CODE = 1984;
    @BindView(R.id.main_recycleview)
    RecyclerView mainRecycleview;
    @BindView(R.id.main_refresh)
    MaterialRefreshLayout mainRefresh;
    @BindView(R.id.erweima)
    ImageButton erweima;
    @BindView(R.id.main_searchlinearlayout)
    LinearLayout mainSearchlinearlayout;
    @BindView(R.id.main_title)
    LinearLayout mainTitle;
    @BindView(R.id.search_city)
    TextView searchCity;
    private MainRecycleAdapter recycleAdapter;
    private MainRecyclePresenterImpl presenter;

    @Override
    protected int getViewResId() {
        return R.layout.main_fragment;
    }

    @Override
    protected void initViews() {

        recycleAdapter = new MainRecycleAdapter(getActivity());
        recycleAdapter.setOnItemClickListener(this);
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        mainRecycleview.setLayoutManager(manager);
        mainRecycleview.setAdapter(recycleAdapter);
        mainRefresh.setMaterialRefreshListener(new MaterialRefreshListener() {
            @Override
            public void onRefresh(MaterialRefreshLayout materialRefreshLayout) {
                recycleAdapter.clearDatas();
                presenter.loadDatas();
            }
        });
        mainRecycleview.addOnScrollListener(new RecyclerView.OnScrollListener() {
            int totalY = 0;

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                totalY += dy;
                Log.d("MainFragment", "dy:" + totalY);
                if (totalY > 200) {
                    mainTitle.setBackgroundColor(0xff00A051);
                }else{
                    mainTitle.setBackgroundColor(Color.TRANSPARENT);
                }
            }
        });
        erweima.setOnClickListener(this);
        mainSearchlinearlayout.setOnClickListener(this);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE) {
            if (data != null) {
                Bundle extras = data.getExtras();
                if (extras == null) return;
                if (extras.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_SUCCESS) {
                    String result = extras.getString(CodeUtils.RESULT_STRING);
                    Toast.makeText(getContext(), result, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getContext(), "解析失败", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    @Override
    protected void initDatas() {
        presenter = new MainRecyclePresenterImpl(this);
        presenter.loadDatas();
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
        if (data == null) {
            presenter.loadDatas();
            return;
        }
        if ((int) view.getTag() == MainRecycleAdapter.FOOTER) {
            ResponseMainArticles.DataBean dataBean = (ResponseMainArticles.DataBean) data;
            int type = dataBean.getType();
            String id = dataBean.getId();
            presenter.loadNextPage(type, id);
        } else {
            ResponseMainArticles.DataBean dataBean = (ResponseMainArticles.DataBean) data;
            int type = dataBean.getType();
            if (type == 1) {
                // TODO: 2016/11/24 跳转文章详情
                Toast.makeText(getActivity(), "跳转文章", Toast.LENGTH_SHORT).show();
                Log.d("MainFragment", dataBean.getId());

            } else if (type == 3) {
                // TODO: 2016/11/24 跳转帖子
                Toast.makeText(getActivity(), "跳转帖子", Toast.LENGTH_SHORT).show();
                Log.d("MainFragment", dataBean.getId());

            }
        }

    }

    @Override
    public void showMainSuccess(String response) {
        mainRefresh.finishRefresh();
        ResponseMainArticles articles = JSON.parseObject(response, ResponseMainArticles.class);
        recycleAdapter.addDatas(articles.getData());
    }

    @Override
    public void showMainFaild(Exception e) {
        mainRefresh.finishRefresh();
        // TODO: 2016/11/24 团聚异常捕获
        Toast.makeText(getActivity(), "数据加载失败", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showMainPagersSuccess(String response) {
        mainRefresh.finishRefresh();
        ResponseMainPager responseMainPager = JSON.parseObject(response, ResponseMainPager.class);
        recycleAdapter.setHeaderDatas(responseMainPager.getData());

    }

    @Override
    public void showMainPagersFaild(Exception e) {
        mainRefresh.finishRefresh();
        Toast.makeText(getActivity(), "图片加载失败", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        if (v == erweima) {
            Intent intent = new Intent(getActivity(), CaptureActivity.class);
            startActivityForResult(intent, REQUEST_CODE);
            startActivity(intent);
        } else if (v == mainSearchlinearlayout) {
            Intent intent = new Intent(getActivity(), SearchActivity.class);
            startActivity(intent);
        }
    }
}
