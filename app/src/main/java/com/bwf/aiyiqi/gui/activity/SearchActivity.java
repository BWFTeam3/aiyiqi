package com.bwf.aiyiqi.gui.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.bwf.aiyiqi.R;
import com.bwf.aiyiqi.entity.ResponseSearch;
import com.bwf.aiyiqi.gui.activity.baseactivitys.BaseActivity;
import com.bwf.aiyiqi.gui.adapter.SearchRecycleAdapter;
import com.bwf.aiyiqi.mvp.presenter.Impl.SearchPresenterImpl;
import com.bwf.aiyiqi.mvp.presenter.SearchPresenter;
import com.bwf.aiyiqi.mvp.view.SearchView;
import com.cjj.MaterialRefreshLayout;
import com.cjj.MaterialRefreshListener;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/11/29.
 */
public class SearchActivity extends BaseActivity implements SearchView,View.OnClickListener{
    @BindView(R.id.search_textview)
    EditText searchTextview;
    @BindView(R.id.search_cancle_image)
    ImageButton searchCancleImage;//x
    @BindView(R.id.search_cancle)
    TextView searchCancle;//取消
    @BindView(R.id.search_linearlayout_view)//空白页的容器
            LinearLayout searchLinearlayoutView;
    @BindView(R.id.search_recycleview)
    RecyclerView searchRecycleview;
    @BindView(R.id.refreshLayout_search)
    MaterialRefreshLayout refreshLayoutSearch;
    @BindView(R.id.search_null)//暂无收缩内容
            TextView searchNull;

    @Override
    protected int getViewResId() {
        return R.layout.search_activity;
    }
    private String content;
    private SearchPresenter presenter;
    private SearchRecycleAdapter adapter;
    private boolean isloading;
    private int totalCount=-1;
    @Override
    protected void initViews() {
        ButterKnife.bind(this);
        final LinearLayoutManager manager=new LinearLayoutManager(this);
        adapter=new SearchRecycleAdapter(this);
        searchRecycleview.setAdapter(adapter);
        searchRecycleview.setLayoutManager(manager);
        searchCancleImage.setOnClickListener(this);
        searchCancle.setOnClickListener(this);
        searchRecycleview.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (totalCount==manager.findLastVisibleItemPosition()){
                    Toast.makeText(SearchActivity.this, "没有更多数据了", Toast.LENGTH_SHORT).show();
                    isloading=true;
                    return;
                }
                if (!isloading&&manager.findLastVisibleItemPosition()==adapter.getItemCount()-1){
                    presenter.loadNextPage(content);

                }
            }
        });
        searchTextview.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (TextUtils.isEmpty(s)){
                    searchCancleImage.setVisibility(View.GONE);
                    refreshLayoutSearch.setVisibility(View.GONE);
                    searchLinearlayoutView.setVisibility(View.VISIBLE);
                }else{
                    searchCancleImage.setVisibility(View.VISIBLE);
                    content=searchTextview.getText().toString();
                    adapter.clearDatas();
                    presenter.loadDatas(content);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        refreshLayoutSearch.setMaterialRefreshListener(new MaterialRefreshListener() {
            @Override
            public void onRefresh(MaterialRefreshLayout materialRefreshLayout) {
                adapter.clearDatas();
                presenter.loadDatas(content);
            }
        });
    }

    @Override
    protected void initDatas() {
        presenter=new SearchPresenterImpl(this);

    }

    @Override
    public void showSeachSuccess(String response) {
        searchLinearlayoutView.setVisibility(View.GONE);
        ResponseSearch responseSearch=JSON.parseObject(response,ResponseSearch.class);
        if (responseSearch.getData()==null){
            searchNull.setVisibility(View.VISIBLE);
            refreshLayoutSearch.setVisibility(View.GONE);
            return;
        }
        totalCount=responseSearch.getTotalCount();
        isloading=false;
        searchNull.setVisibility(View.GONE);
        refreshLayoutSearch.setVisibility(View.VISIBLE);
        refreshLayoutSearch.finishRefresh();
        adapter.addDatas(responseSearch.getData());
    }

    @Override
    public void showSeachFaild(Exception e) {
        isloading=false;
        refreshLayoutSearch.finishRefresh();
        searchNull.setVisibility(View.VISIBLE);
    }

    @Override
    public void onClick(View v) {
        if (v==searchCancle){
            finish();
        }else if(v== searchCancleImage){
            searchTextview.setText("");
        }

    }
}
