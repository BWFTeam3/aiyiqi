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

public class NewHouseActivity extends BaseActivity {
    @BindView(R.id.imageView_title)
    ImageView imageViewTitle;
    @BindView(R.id.textView_title)
    TextView textViewTitle;
    @BindView(R.id.webView_new_house)
    WebView webViewNewHouse;

    @Override
    protected int getViewResId() {
        return R.layout.subview_new_house;
    }

    @Override
    protected void initViews() {
        ButterKnife.bind(this);
        textViewTitle.setText("新房整装");
    }

    @Override
    protected void initDatas() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WebSettings settings = webViewNewHouse.getSettings();
        settings.setCacheMode(WebSettings.LOAD_DEFAULT);
        settings.setJavaScriptEnabled(true);
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        webViewNewHouse.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
        webViewNewHouse.requestFocusFromTouch();
        webViewNewHouse.loadUrl(Apis.URL_NEW_HOUSE_OVERALL_DECORATION);

    }

    @OnClick(R.id.imageView_title)
    public void onClick() {
        finish();
    }
}
