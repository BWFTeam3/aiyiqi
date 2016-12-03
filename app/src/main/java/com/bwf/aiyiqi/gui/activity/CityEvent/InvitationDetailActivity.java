package com.bwf.aiyiqi.gui.activity.CityEvent;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import com.bwf.aiyiqi.R;
import com.bwf.aiyiqi.gui.activity.baseactivitys.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2016/11/30.
 */
public class InvitationDetailActivity extends BaseActivity {
    @BindView(R.id.webView_invitation_detail)
    WebView webViewInvitationDetail;
    @BindView(R.id.textView_title)
    TextView textViewTitle;

    @Override
    protected int getViewResId() {
        return R.layout.subview_invitation_detail;
    }

    @Override
    protected void initViews() {
        ButterKnife.bind(this);
        textViewTitle.setText("活动详情");
        Intent intent = getIntent();
        String url = intent.getStringExtra("url");
        webViewInvitationDetail.getSettings().setJavaScriptEnabled(true);
        webViewInvitationDetail.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
        webViewInvitationDetail.loadUrl(url);
    }

    @Override
    protected void initDatas() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
    }

    @OnClick(R.id.imageView_title)
    public void onClick() {
        finish();
    }
}
