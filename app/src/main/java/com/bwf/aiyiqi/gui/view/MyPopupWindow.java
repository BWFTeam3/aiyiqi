package com.bwf.aiyiqi.gui.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.PopupWindow;

import com.bwf.aiyiqi.R;
import com.bwf.aiyiqi.gui.adapter.MyPopAdapter;
import com.bwf.aiyiqi.gui.fragment.DesignPsFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Phyj on 2016/12/4.
 */

public class MyPopupWindow extends PopupWindow implements AdapterView.OnItemClickListener {
    private List<String> list;
    private View conentView;
    private GridView gridView;
    private MyPopAdapter adapter;

    public static final int ROOM = 0;
    public static final int STYLE = 1;
    public static final int LAYOUT = 2;
    public static final int COLOR = 3;
    private int state;

    public void setChoise(String str[], int state) {
        this.state = state;
        list.clear();
        for (String choise : str) {
            list.add(choise);
        }
        adapter.setDatas(list);
    }

    private DesignPsFragment fragment;

    public MyPopupWindow(Context context, Fragment fragment) {
        this.fragment = (DesignPsFragment) fragment;
        list = new ArrayList<>();
        LayoutInflater inflater = LayoutInflater.from(context);
        conentView = inflater.inflate(R.layout.mypopupwindow, null);
        gridView = (GridView) conentView.findViewById(R.id.popupwindow_gridview);
        adapter = new MyPopAdapter(context);
        gridView.setOnItemClickListener(this);
        gridView.setAdapter(adapter);
        this.setContentView(conentView);
        this.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        this.setHeight(ViewGroup.LayoutParams.MATCH_PARENT);
        this.setFocusable(true);
        this.setOutsideTouchable(true);
        ColorDrawable dw = new ColorDrawable(Color.argb(128, 000, 000, 000));
        this.setBackgroundDrawable(dw);
        this.update();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (state) {
            case ROOM:
                fragment.setRoomInt(position);
                break;
            case STYLE:
                fragment.setStyleInt(position);
                break;
            case LAYOUT:
                fragment.setLayoutInt(position);
                break;
            case COLOR:
                fragment.setColorInt(position);
                break;
        }
        this.dismiss();
    }
    @Override
    public void dismiss() {
        super.dismiss();
        fragment.onPopupWindowdismiss(state);
    }

    public void show(View view, int position) {
        adapter.setItemColor(position);
        this.showAsDropDown(view);
    }
}
