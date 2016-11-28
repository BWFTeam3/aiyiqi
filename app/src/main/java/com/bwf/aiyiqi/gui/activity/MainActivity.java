package com.bwf.aiyiqi.gui.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.bwf.aiyiqi.R;
import com.bwf.aiyiqi.gui.activity.baseactivitys.BaseActivity;
import com.bwf.aiyiqi.gui.fragment.MainFragment;
import com.bwf.aiyiqi.gui.fragment.MineFragment;
import com.bwf.aiyiqi.gui.fragment.MsgFragment;
import com.bwf.aiyiqi.gui.fragment.OwnerFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    @BindView(R.id.main_framelaout)
    FrameLayout mainFramelaout;
    @BindView(R.id.main_ctv_home)
    CheckedTextView mainCtvHome;
    @BindView(R.id.main_ctv_owner)
    CheckedTextView mainCtvOwner;
    @BindView(R.id.main_ctv_msg)
    CheckedTextView mainCtvMsg;
    @BindView(R.id.main_ctv_mine)
    CheckedTextView mainCtvMine;
    @BindView(R.id.activity_main)
    LinearLayout activityMain;

    private List<Fragment>list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        switchFragment(0,mainCtvHome);
    }

    @Override
    protected int getViewResId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initViews() {
        ButterKnife.bind(this);
        list=new ArrayList<>();
        list.add(new MainFragment());
        list.add(new OwnerFragment());
        list.add(new MsgFragment());
        list.add(new MineFragment());
        mainCtvHome.setOnClickListener(this);
        mainCtvOwner.setOnClickListener(this);
        mainCtvMsg.setOnClickListener(this);
        mainCtvMine.setOnClickListener(this);
    }

   @Override
    protected void initDatas() {

    }
    private Fragment currentFragment;
    private void switchFragment(int index,View v){
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction transaction=fragmentManager.beginTransaction();
        if (currentFragment!=null)transaction.hide(currentFragment);
        Fragment fragment=list.get(index);
        if (fragment.isAdded()){
            transaction.show(fragment);
        }else{
            transaction.add(R.id.main_framelaout,fragment);
        }
        transaction.commit();
        currentFragment=fragment;

        if (checkedTextView==v)return;
        if (checkedTextView!=null)checkedTextView.setChecked(false);
        checkedTextView = (CheckedTextView) v;
        ((CheckedTextView) v).setChecked(true);
    }

    private CheckedTextView checkedTextView;
    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.main_ctv_home:
                switchFragment(0,v);
                break;
            case R.id.main_ctv_owner:
                switchFragment(1,v);
                break;
            case R.id.main_ctv_msg:
                switchFragment(2,v);
                break;
            case R.id.main_ctv_mine:
                switchFragment(3,v);
                break;
        }
    }

}
