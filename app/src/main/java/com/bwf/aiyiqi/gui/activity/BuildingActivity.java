package com.bwf.aiyiqi.gui.activity;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.bwf.aiyiqi.R;
import com.bwf.aiyiqi.entity.ResponseBuilding;
import com.bwf.aiyiqi.gui.activity.baseactivitys.BaseActivity;
import com.bwf.aiyiqi.gui.adapter.BuildingAdapter;
import com.bwf.aiyiqi.gui.view.MyBuildingGridView;
import com.bwf.aiyiqi.mvp.presenter.BuildinPresenter;
import com.bwf.aiyiqi.mvp.presenter.Impl.BuildingPresenterImpl;
import com.bwf.aiyiqi.mvp.view.BuildingView;
import com.cjj.MaterialRefreshLayout;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/11/25.
 */

public class BuildingActivity extends BaseActivity implements BuildingView{
    @BindView(R.id.imageView_title)
    ImageView imageViewTitle;
    @BindView(R.id.textView_title)
    TextView textViewTitle;
    @BindView(R.id.abf_linearlayout)
    LinearLayout abfLinearlayout;
    @BindView(R.id.MyScrollview)
    ScrollView MyScrollview;
    @BindView(R.id.myFresh)
    MaterialRefreshLayout myFresh;
    private BuildinPresenter mPresenter;

    @Override
    protected int getViewResId() {
        return R.layout.subview_building;
    }

    @Override
    protected void initViews() {
        ButterKnife.bind(this);
        mPresenter = new BuildingPresenterImpl(this);
        mPresenter.loadResponseDatas();
    }

    @Override
    protected void initDatas() {

    }

    private int index;

    public void addContentView(ResponseBuilding data) {
        final List<ResponseBuilding.DataBean> datas = data.getData();
        //避免重复添加
        abfLinearlayout.removeAllViews();

        for (int i = 0; i < datas.size(); i++) {
            View sonView = LayoutInflater.from(this).inflate
                    (R.layout.subview_building_commont, abfLinearlayout, false);
            ViewHolder mHolder = new ViewHolder(sonView);
            mHolder.abfTitle.setText(datas.get(i).getTitle());
            mHolder.abfIcon.setImageURI(Uri.parse(datas.get(i).getIcon()));
            BuildingAdapter mAdapter =
                    new BuildingAdapter(this, R.layout.subview_building_commont_item);
            //为每一个gridView 添加adapter 还有他的内容
            mHolder.abfMygridview.setAdapter(mAdapter);
            mAdapter.setData(datas.get(i).getChildren());
            final List<ResponseBuilding.DataBean.ChildrenBean> children
                    = datas.get(i).getChildren();
            //TODO 每一个GridView的监听在这里写
            mHolder.abfMygridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Toast.makeText(BuildingActivity.this, children.get(position).getTitle(), Toast.LENGTH_SHORT).show();
                }
            });

            //添加到容器
            abfLinearlayout.addView(sonView);
        }
    }


    @Override
    public void showResposeSuccess(ResponseBuilding data) {
        addContentView(data);

    }

    @Override
    public void ShowFailed() {
        Toast.makeText(this, "OnEorror", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void ShowNoMoreData() {

    }

    public void SHowNoMoreData() {
        Toast.makeText(this, "nodata:", Toast.LENGTH_SHORT).show();
    }

    static class ViewHolder {
        @BindView(R.id.abf_title)
        TextView abfTitle;
        @BindView(R.id.abf_icon)
        SimpleDraweeView abfIcon;
        @BindView(R.id.abf_mygridview)
        MyBuildingGridView abfMygridview;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
