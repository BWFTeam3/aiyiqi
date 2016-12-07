package com.bwf.aiyiqi.gui.fragment;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.bwf.aiyiqi.R;
import com.bwf.aiyiqi.entity.ResponseDesignPs;
import com.bwf.aiyiqi.gui.adapter.DesignPsAdapter;
import com.bwf.aiyiqi.gui.fragment.basefragments.BaseFragment;
import com.bwf.aiyiqi.gui.view.GridSpacingItemDecoration;
import com.bwf.aiyiqi.gui.view.MyPopupWindow;
import com.bwf.aiyiqi.mvp.presenter.DesignPsPresenter;
import com.bwf.aiyiqi.mvp.presenter.Impl.DesignPsPresenterImpl;
import com.bwf.aiyiqi.mvp.view.DesignView;
import com.cjj.MaterialRefreshLayout;
import com.cjj.MaterialRefreshListener;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Phyj on 2016/12/3.
 */

public class DesignPsFragment extends BaseFragment implements View.OnClickListener, DesignView {
    @BindView(R.id.designps_room)
    CheckedTextView designpsRoom;
    @BindView(R.id.designps_style)
    CheckedTextView designpsStyle;
    @BindView(R.id.designps_layout)
    CheckedTextView designpsLayout;
    @BindView(R.id.designps_color)
    CheckedTextView designpsColor;
    @BindView(R.id.ps_recyclerview)
    RecyclerView psRecyclerview;
    @BindView(R.id.ps_refresh)
    MaterialRefreshLayout psRefresh;
    private DesignPsPresenter presenter;
    private DesignPsAdapter adapter;
    private GridLayoutManager manager;
    private int totalCount;
    private MyPopupWindow popupWindow;

    @Override
    protected int getViewResId() {
        return R.layout.designps_fragment;
    }

    public void setRoomInt(int roomInt) {
        this.roomInt = roomInt;
    }

    public void setStyleInt(int styleInt) {
        this.styleInt = styleInt;
    }

    public void setLayoutInt(int layoutInt) {
        this.layoutInt = layoutInt;
    }

    public void setColorInt(int colorInt) {
        this.colorInt = colorInt;
    }

    @Override
    protected void initViews() {
        adapter = new DesignPsAdapter(getContext());
        psRecyclerview.setAdapter(adapter);
        manager = new GridLayoutManager(getContext(), 2);
        GridSpacingItemDecoration decoration = new GridSpacingItemDecoration(2, 10, false);
        psRecyclerview.addItemDecoration(decoration);
        psRecyclerview.setLayoutManager(manager);
        designpsRoom.setOnClickListener(this);
        designpsStyle.setOnClickListener(this);
        designpsLayout.setOnClickListener(this);
        designpsColor.setOnClickListener(this);
        popupWindow = new MyPopupWindow(getContext(), this);
        map = new HashMap<>();
        psRefresh.setMaterialRefreshListener(new MaterialRefreshListener() {
            @Override
            public void onRefresh(MaterialRefreshLayout materialRefreshLayout) {
                presenter.loadDatas(map);
            }
        });
        psRecyclerview.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (totalCount == manager.findLastVisibleItemPosition()) {
                    Toast.makeText(getContext(), "没有更多数据了", Toast.LENGTH_SHORT).show();
                    isloading = true;
                    return;
                }
                if (!isloading && manager.findLastVisibleItemPosition() == adapter.getItemCount() - 1) {
                    isloading = true;
                    presenter.loadNextDatas(map);
                }
            }
        });
    }

    private boolean isloading;

    @Override
    protected void initDatas() {
        presenter = new DesignPsPresenterImpl(this);
        isloading = true;
        presenter.loadDatas(map);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    String room[];
    String style[];
    String layout[];
    String color[];
    private int roomInt;
    private int styleInt;
    private int layoutInt;
    private int colorInt;
    private Map<String, String> map;//用于ID的四级搜索

    public void onPopupWindowdismiss(int state) {
        ctv.setChecked(false);
        switch (state) {
            case MyPopupWindow.ROOM:
                if (roomInt == 0) {
                    ctv.setText("空间");
                    map.remove("空间");
                    return;
                }
                ctv.setText(room[roomInt]);
                map.put("空间", "id");
                break;
            case MyPopupWindow.STYLE:
                if (styleInt == 0) {
                    ctv.setText("风格");
                    map.remove("风格");
                    return;
                }
                ctv.setText(style[styleInt]);
                map.put("风格", "id");
                break;
            case MyPopupWindow.LAYOUT:
                if (layoutInt == 0) {
                    ctv.setText("局部");
                    map.remove("局部");
                    return;
                }
                ctv.setText(layout[layoutInt]);
                map.put("局部", "id");
                break;
            case MyPopupWindow.COLOR:
                if (colorInt == 0) {
                    ctv.setText("颜色");
                    map.remove("颜色");
                    return;
                }
                ctv.setText(color[colorInt]);
                map.put("颜色", "id");
                break;
        }
    }

    private CheckedTextView ctv;

    @Override
    public void onClick(View v) {
        ctv = (CheckedTextView) v;
        ctv.setChecked(true);
        if (ctv == designpsRoom) {
            if (room == null) {
                room = getContext().getResources().getStringArray(R.array.room);
            }
            popupWindow.setChoise(room, MyPopupWindow.ROOM);
            popupWindow.show(v, roomInt);
        } else if (ctv == designpsStyle) {
            if (style == null) {
                style = getContext().getResources().getStringArray(R.array.style);
            }
            popupWindow.setChoise(style, MyPopupWindow.STYLE);
            popupWindow.show(v, styleInt);
        } else if (ctv == designpsLayout) {
            if (layout == null) {
                layout = getContext().getResources().getStringArray(R.array.layout);
            }
            popupWindow.setChoise(layout, MyPopupWindow.LAYOUT);
            popupWindow.show(v, layoutInt);
        } else if (ctv == designpsColor) {
            if (color == null) {
                color = getContext().getResources().getStringArray(R.array.color);
            }
            popupWindow.setChoise(color, MyPopupWindow.COLOR);
            popupWindow.show(v, colorInt);
        }
    }

    @Override
    public void showSuccess(String response) {
        psRefresh.finishRefresh();
        isloading = false;
        ResponseDesignPs responseDesignPs = JSON.parseObject(response, ResponseDesignPs.class);
        if (0==responseDesignPs.getError()) {
            totalCount = Integer.parseInt(responseDesignPs.getData().getTotalCount());
            adapter.setDatas(responseDesignPs.getData().getList());
        }
    }

    @Override
    public void showFaild(Exception e) {
        psRefresh.finishRefresh();
        isloading = false;
        Toast.makeText(getContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showNextSuccess(String response) {
        psRefresh.finishRefresh();
        isloading = false;
        ResponseDesignPs responseDesignPs = JSON.parseObject(response, ResponseDesignPs.class);
        if (0==responseDesignPs.getError()) {
            adapter.addDatas(responseDesignPs.getData().getList());
        }
    }

    @Override
    public void showNextFaild(Exception e) {
        psRefresh.finishRefresh();
        isloading = false;
        Toast.makeText(getContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
    }
}
