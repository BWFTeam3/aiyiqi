package com.bwf.aiyiqi.gui.activity.DecorationCompany;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import com.bwf.aiyiqi.R;
import com.bwf.aiyiqi.gui.activity.baseactivitys.BaseActivity;
import com.bwf.aiyiqi.utils.Apis;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2016/11/25.
 */

public class OldHouseActivity extends BaseActivity {
    @BindView(R.id.imageView_title)
    ImageView imageViewTitle;
    @BindView(R.id.textView_title)
    TextView textViewTitle;
    @BindView(R.id.webView_old_house)
    WebView webViewOldHouse;

    @Override
    protected int getViewResId() {
        return R.layout.subview_old_house;
    }

    @Override
    protected void initViews() {
        ButterKnife.bind(this);
    }

    @Override
    protected void initDatas() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        textViewTitle.setText("老房整装");
        WebSettings settings = webViewOldHouse.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(true);
        settings.setCacheMode(WebSettings.LOAD_DEFAULT);
        webViewOldHouse.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
        webViewOldHouse.requestFocusFromTouch();
        webViewOldHouse.loadUrl(Apis.URL_OLD_HOUSE_OVERALL_DECORATION);
    }

    @OnClick(R.id.imageView_title)
    public void onClick() {
        finish();
    }
}
