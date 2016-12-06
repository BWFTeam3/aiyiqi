package com.bwf.aiyiqi.gui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bwf.aiyiqi.R;
import com.bwf.aiyiqi.gui.activity.LoginAndRegistActivity;
import com.bwf.aiyiqi.gui.fragment.basefragments.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2016/11/23.
 */

public class MineFragment extends BaseFragment {


    @BindView(R.id.imageView_mineFragment_head_portrait)
    ImageView imageViewMineFragmentHeadPortrait;
    @BindView(R.id.textView_mineFragment_head_portrait)
    TextView textViewMineFragmentHeadPortrait;
    @BindView(R.id.integration_rule)
    LinearLayout integrationRule;
    @BindView(R.id.invitation)
    LinearLayout invitation;
    @BindView(R.id.attention)
    LinearLayout attention;
    @BindView(R.id.fans)
    LinearLayout fans;
    @BindView(R.id.tv_mine_list)
    RelativeLayout tvMineList;
    @BindView(R.id.mine_collect)
    RelativeLayout mineCollect;
    @BindView(R.id.mine_love)
    RelativeLayout mineLove;
    @BindView(R.id.mine_setting)
    RelativeLayout mineSetting;
    @BindView(R.id.mine_idea)
    RelativeLayout mineIdea;

    @Override
    protected int getViewResId() {
        return R.layout.mine_fragment;
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

    @OnClick({R.id.imageView_mineFragment_head_portrait, R.id.textView_mineFragment_head_portrait, R.id.integration_rule, R.id.invitation, R.id.attention, R.id.fans, R.id.tv_mine_list, R.id.mine_collect, R.id.mine_love, R.id.mine_setting, R.id.mine_idea})
    public void onClick(View view) {
        Intent intent = new Intent();
        switch (view.getId()) {
            case R.id.imageView_mineFragment_head_portrait:
                intent = new Intent(getContext(), LoginAndRegistActivity.class);
                startActivity(intent);
                break;
            case R.id.textView_mineFragment_head_portrait:
                intent = new Intent(getContext(), LoginAndRegistActivity.class);
                startActivity(intent);
                break;
            case R.id.integration_rule:
                break;
            case R.id.invitation:
                intent = new Intent(getContext(), LoginAndRegistActivity.class);
                startActivity(intent);
                break;
            case R.id.attention:
                intent = new Intent(getContext(), LoginAndRegistActivity.class);
                startActivity(intent);
                break;
            case R.id.fans:
                intent = new Intent(getContext(), LoginAndRegistActivity.class);
                startActivity(intent);
                break;
            case R.id.tv_mine_list:
                intent = new Intent(getContext(), LoginAndRegistActivity.class);
                startActivity(intent);
                break;
            case R.id.mine_collect:
                intent = new Intent(getContext(), LoginAndRegistActivity.class);
                startActivity(intent);
                break;
            case R.id.mine_love:
                intent = new Intent(getContext(), LoginAndRegistActivity.class);
                startActivity(intent);
                break;
            case R.id.mine_setting:
                break;
            case R.id.mine_idea:
                intent = new Intent(getContext(), LoginAndRegistActivity.class);
                startActivity(intent);
                break;
        }
    }
}
