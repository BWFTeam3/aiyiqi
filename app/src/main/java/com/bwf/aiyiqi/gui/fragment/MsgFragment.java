package com.bwf.aiyiqi.gui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.bwf.aiyiqi.R;
import com.bwf.aiyiqi.gui.activity.LoginAndRegistActivity;
import com.bwf.aiyiqi.gui.fragment.basefragments.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2016/11/23.
 */

public class MsgFragment extends BaseFragment {

    @BindView(R.id.msg_comment_layout)
    LinearLayout msgCommentLayout;
    @BindView(R.id.msg_zan_layout)
    LinearLayout msgZanLayout;
    @BindView(R.id.msg_call_me_layout)
    LinearLayout msgCallMeLayout;
    @BindView(R.id.msg_system_layout)
    LinearLayout msgSystemLayout;

    @Override
    protected int getViewResId() {
        return R.layout.fragment_msg_layout;
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

    @OnClick({R.id.msg_comment_layout, R.id.msg_zan_layout, R.id.msg_call_me_layout, R.id.msg_system_layout})
    public void onClick(View view) {
             Intent intent;
        switch (view.getId()) {
            case R.id.msg_comment_layout:
                intent = new Intent(getContext(), LoginAndRegistActivity.class);
                startActivity(intent);
                break;
            case R.id.msg_zan_layout:
                intent = new Intent(getContext(), LoginAndRegistActivity.class);
                startActivity(intent);
                break;
            case R.id.msg_call_me_layout:
                intent = new Intent(getContext(), LoginAndRegistActivity.class);
                startActivity(intent);
                break;
            case R.id.msg_system_layout:
                intent = new Intent(getContext(), LoginAndRegistActivity.class);
                startActivity(intent);
                break;
        }
    }
}
