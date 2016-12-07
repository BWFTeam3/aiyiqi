package com.bwf.aiyiqi.gui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.bwf.aiyiqi.R;
import com.bwf.aiyiqi.gui.fragment.basefragments.BaseFragment;

/**
 * Created by Administrator on 2016/11/30.
 */

public class design extends BaseFragment {
    WebView webView2;
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        webView2 = (WebView)getView().findViewById(R.id.we2);
        WebSettings mWebSettings = webView2.getSettings();
//        mWebSettings.setCacheMode(WebSettings.LOAD_DEFAULT);//开启缓存
        mWebSettings.setJavaScriptEnabled(true);//开启javascript支持
//        mWebSettings.setUseWideViewPort(true);//任意比例缩放
//        mWebSettings.setLoadWithOverviewMode(true);// 缩放至屏幕的大小
        //打开网页时不调用系统浏览器， 而是在本WebView中显示
        webView2.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
        webView2.loadUrl("http://hui.17house.com/svc/payment-facade/h5/measureDesignFree/designFree.html?model=android");
    }
    @Override
    protected int getViewResId() {
        return R.layout.design;
    }

    @Override
    protected void initViews() {

    }

    @Override
    protected void initDatas() {

    }
}
