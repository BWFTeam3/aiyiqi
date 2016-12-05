package com.bwf.aiyiqi.gui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.bwf.aiyiqi.R;
import com.bwf.aiyiqi.gui.fragment.basefragments.BaseFragment;
import com.bwf.aiyiqi.utils.Apis;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/11/30.
 */

public class DecorationBudgetFragment extends BaseFragment {
    @BindView(R.id.decoratebudget_fragment_webview)
    WebView decoratebudgetFragmentWebview;

    @Override
    protected int getViewResId() {
        return R.layout.decoration_budget_fragment;
    }

    public static DecorationBudgetFragment newInstance() {
        DecorationBudgetFragment budgetFragment = new DecorationBudgetFragment();
        return budgetFragment;
    }

    @Override
    protected void initViews() {

    }


    @Override
    protected void initDatas() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        decoratebudgetFragmentWebview.getSettings().setJavaScriptEnabled(true);
        decoratebudgetFragmentWebview.loadUrl(Apis.DECORATIONBUDGET);
        decoratebudgetFragmentWebview.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                Log.d("ArticleDetailActivity", url);
                return true;
            }
        });
    }
}
