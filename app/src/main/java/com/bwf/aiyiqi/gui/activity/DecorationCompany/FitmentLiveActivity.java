package com.bwf.aiyiqi.gui.activity.DecorationCompany;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bwf.aiyiqi.R;
import com.bwf.aiyiqi.entity.ResponseBasicInformation;
import com.bwf.aiyiqi.entity.ResponseFitmentPorgress;
import com.bwf.aiyiqi.gui.activity.baseactivitys.BaseActivity;
import com.bwf.aiyiqi.gui.adapter.FitmentLiveGridViewAdapter;
import com.bwf.aiyiqi.gui.adapter.FitmentLiveRecyclerViewAdapter;
import com.bwf.aiyiqi.gui.view.MyRecyclerView;
import com.bwf.aiyiqi.mvp.presenter.FitmentLivePresenter;
import com.bwf.aiyiqi.mvp.presenter.Impl.FitmentLivePresenterImpl;
import com.bwf.aiyiqi.mvp.view.FitmentLiveView;
import com.cjj.MaterialRefreshLayout;
import com.cjj.MaterialRefreshListener;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2016/11/24.
 */

public class FitmentLiveActivity extends BaseActivity implements FitmentLiveView {


    @BindView(R.id.imageView_title)
    ImageView imageViewTitle;
    @BindView(R.id.textView_title)
    TextView textViewTitle;
    @BindView(R.id.simpleDraweeView_fitment_live)
    SimpleDraweeView simpleDraweeViewFitmentLive;
    @BindView(R.id.textView_fitment_live_top)
    TextView textViewFitmentLiveTop;
    @BindView(R.id.textView_fitment_live_bottom)
    TextView textViewFitmentLiveBottom;
    @BindView(R.id.linearLayout_basic_information)
    LinearLayout linearLayoutBasicInformation;
    @BindView(R.id.linearLayout_fitment_live)
    LinearLayout linearLayoutFitmentLive;
    @BindView(R.id.recycler_fitment_live)
    MyRecyclerView recyclerFitmentLive;
    @BindView(R.id.materialRefreshLayout_fitment_live)
    MaterialRefreshLayout materialRefreshLayoutFitmentLive;
    private String progressId;
    private String buildingId;
    private String imgUrl;
    private String tvTop;
    private String tvBottom;
    private FitmentLivePresenter fitmentLivePresenter;
    private LayoutInflater inflater;
    private final int STYLIST = 1701;//设计师
    private final int SUPERVISOR = 1702;//监理
    private final int FOREMAN = 1703; //工长
    private final int MATERIAL_COUNSELOR = 1705;//材料顾问
    private FitmentLiveRecyclerViewAdapter fitmentLiveRecyclerViewAdapter;
    private boolean noMoreData;
    private FitmentLiveGridViewAdapter fitmentLiveGridViewAdapter;

    @Override
    protected int getViewResId() {
        return R.layout.subview_fitment_live;
    }

    @Override
    protected void initViews() {
        ButterKnife.bind(this);
        Intent intent = getIntent();
        progressId = intent.getStringExtra("progressId");
        buildingId = intent.getStringExtra("buildingId");
        imgUrl = intent.getStringExtra("imgUrl");
        tvTop = intent.getStringExtra("tvTop");
        tvBottom = intent.getStringExtra("tvBottom");
        textViewTitle.setText("工地直播");
        simpleDraweeViewFitmentLive.setImageURI(imgUrl);
        textViewFitmentLiveTop.setText(tvTop);
        textViewFitmentLiveBottom.setText(tvBottom);
        inflater = LayoutInflater.from(this);
        materialRefreshLayoutFitmentLive.setLoadMore(true);
        materialRefreshLayoutFitmentLive.setMaterialRefreshListener(new MaterialRefreshListener() {
            @Override
            public void onRefresh(MaterialRefreshLayout materialRefreshLayout) {
                fitmentLiveRecyclerViewAdapter.clearData();
                fitmentLivePresenter.reLoadDatas(progressId, buildingId);
            }

            @Override
            public void onRefreshLoadMore(MaterialRefreshLayout materialRefreshLayout) {
                if (noMoreData) {
                    return;
                }
                super.onRefreshLoadMore(materialRefreshLayout);
                fitmentLivePresenter.loadDatas(progressId, buildingId);
            }
        });
        fitmentLiveRecyclerViewAdapter = new FitmentLiveRecyclerViewAdapter(this);
        final LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerFitmentLive.setLayoutManager(manager);
        recyclerFitmentLive.setAdapter(fitmentLiveRecyclerViewAdapter);
        fitmentLiveRecyclerViewAdapter.setClickListener(new FitmentLiveRecyclerViewAdapter.ClickListener() {
            @Override
            public void onClick(List<String> urls, int position) {
                Intent intent1 = new Intent(FitmentLiveActivity.this,PageAcitivity.class);
                intent1.putStringArrayListExtra("urls", (ArrayList<String>) urls);
                intent1.putExtra("position",position);
                startActivity(intent1);
            }
        });
    }

    @Override
    protected void initDatas() {
        fitmentLivePresenter = new FitmentLivePresenterImpl(this);
        fitmentLivePresenter.loadDatas(progressId, buildingId);
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

    @Override
    public void loadBaseInformationDatasSuccess(ResponseBasicInformation responseBasicInformation) {
        linearLayoutBasicInformation.removeAllViews();
        linearLayoutFitmentLive.removeAllViews();
        List<ResponseBasicInformation.DataBean.MembersBean> members = responseBasicInformation.getData().getMembers();
        for (int i = 0; i < members.size(); i++) {
            View view = inflater.inflate(R.layout.item_basic_information, null);
            SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(R.id.simpleDraweeView_basicInformation);
            TextView textViewTop = (TextView) view.findViewById(R.id.textView_top_basicInformation);
            TextView textViewBottom = (TextView) view.findViewById(R.id.textView_bottom_basicInformation);
            simpleDraweeView.setImageURI(members.get(i).getAvatar());
            textViewTop.setText(members.get(i).getVendorName());
            String str;
            switch (members.get(i).getBossId()) {
                case STYLIST:
                    str = "设计师";
                    break;
                case SUPERVISOR:
                    str = "监理";
                    break;
                case FOREMAN:
                    str = "工长";
                    break;
                case MATERIAL_COUNSELOR:
                    str = "材料顾问";
                    break;
                default:
                    str = "其他";
            }
            textViewBottom.setText(str);
            linearLayoutBasicInformation.addView(view);
        }
        final List<ResponseBasicInformation.DataBean.ProgressBean> progress = responseBasicInformation.getData().getProgress();
        for (int i = 0; i < progress.size(); i++) {
            View view = inflater.inflate(R.layout.item_fitment_live, linearLayoutFitmentLive, false);
            TextView textViewIsPlaying = (TextView) view.findViewById(R.id.textView_is_playing);
            TextView textViewFinish = (TextView) view.findViewById(R.id.textView_finish);
            TextView textViewNoAccomplish = (TextView) view.findViewById(R.id.textView_no_accomplish);
            ImageView imageViewWorking = (ImageView) view.findViewById(R.id.imageView_working);
            ImageView imageViewNotFinish = (ImageView) view.findViewById(R.id.imageView_not_finish);
            ImageView imageViewFinish = (ImageView) view.findViewById(R.id.imageView_finish);
            TextView textViewState = (TextView) view.findViewById(R.id.textView_state);
            view.findViewById(R.id.view_working).setVisibility(progress.get(i).getProgressId().equals("7") ? View.GONE : View.VISIBLE);
            textViewState.setText(progress.get(i).getProgressName());
            if (progress.get(i).getProgressStatus().equals("1")) {
                textViewIsPlaying.setVisibility(View.VISIBLE);
                textViewFinish.setVisibility(View.GONE);
                textViewNoAccomplish.setVisibility(View.GONE);
                imageViewWorking.setVisibility(View.VISIBLE);
                imageViewFinish.setVisibility(View.GONE);
                imageViewNotFinish.setVisibility(View.GONE);
            } else if (progress.get(i).getProgressStatus().equals("0")) {
                textViewIsPlaying.setVisibility(View.GONE);
                textViewFinish.setVisibility(View.GONE);
                textViewNoAccomplish.setVisibility(View.VISIBLE);
                imageViewWorking.setVisibility(View.GONE);
                imageViewFinish.setVisibility(View.GONE);
                imageViewNotFinish.setVisibility(View.VISIBLE);
            } else {
                textViewIsPlaying.setVisibility(View.GONE);
                textViewFinish.setVisibility(View.VISIBLE);
                textViewNoAccomplish.setVisibility(View.GONE);
                imageViewWorking.setVisibility(View.GONE);
                imageViewFinish.setVisibility(View.VISIBLE);
                imageViewNotFinish.setVisibility(View.GONE);
            }
            final int j = i;
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    fitmentLiveRecyclerViewAdapter.clearData();
                    fitmentLivePresenter.reLoadDatas(progress.get(j).getProgressId(), buildingId);
                }
            });
            linearLayoutFitmentLive.addView(view);
        }
    }

    @Override
    public void loadBaseInformationDatasFailed(Exception e) {
        Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loadFitmentProgressSuccess(ResponseFitmentPorgress responseFitmentPorgress) {
        materialRefreshLayoutFitmentLive.finishRefresh();
        materialRefreshLayoutFitmentLive.finishRefreshLoadMore();
        fitmentLiveRecyclerViewAdapter.addDatas(responseFitmentPorgress.getData());
//        Print1.Print(this, JSON.toJSONString(responseFitmentPorgress));
    }

    @Override
    public void loadFitmentProgressFailed(Exception e) {
        Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void noMoreData() {
        noMoreData = true;
        materialRefreshLayoutFitmentLive.setLoadMore(false);
    }
}
