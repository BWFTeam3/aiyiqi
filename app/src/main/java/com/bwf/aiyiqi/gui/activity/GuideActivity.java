package com.bwf.aiyiqi.gui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.bwf.aiyiqi.R;
import com.bwf.aiyiqi.gui.activity.baseactivitys.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2016/12/1.
 */
public class GuideActivity extends BaseActivity {
    @BindView(R.id.radioGroup_choice_sex)
    RadioGroup radioGroupChoiceSex;
    @BindView(R.id.datePicker_choice_birthday)
    DatePicker datePickerChoiceBirthday;
    @BindView(R.id.radioButton_plan_decorate)
    RadioButton radioButtonPlanDecorate;
    @BindView(R.id.radioGroup_fitment_stage)
    RadioGroup radioGroupFitmentStage;
    @BindView(R.id.textView_this_year)
    TextView textViewThisYear;
    @BindView(R.id.textView_next_year)
    TextView textViewNextYear;
    @BindView(R.id.textView_next_next_year)
    TextView textViewNextNextYear;
    @BindView(R.id.textView_go_to_decorate)
    TextView textViewGoToDecorate;
    private boolean isChecked;
    private boolean textViewIsChecked;
    private Intent intent;

    @Override
    protected int getViewResId() {
        return R.layout.guide_activity;
    }

    @Override
    protected void initViews() {
        ButterKnife.bind(this);
        radioGroupChoiceSex.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (radioGroupFitmentStage.getCheckedRadioButtonId() != -1 && !isChecked) {
                    isChecked = true;
                    textViewGoToDecorate.setEnabled(true);
                    textViewGoToDecorate.setBackgroundResource(R.color.main_switch_green);
                    textViewGoToDecorate.setTextColor(getResources().getColor(R.color.white));
                }
            }
        });
        radioGroupFitmentStage.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (radioGroupChoiceSex.getCheckedRadioButtonId() != -1 && !isChecked) {
                    isChecked = true;
                    textViewGoToDecorate.setEnabled(true);
                    textViewGoToDecorate.setBackgroundResource(R.color.main_switch_green);
                    textViewGoToDecorate.setTextColor(getResources().getColor(R.color.white));
                }
                if (!radioButtonPlanDecorate.isChecked() && textViewIsChecked) {
                    textViewIsChecked = false;
                    setTextViewColorToGray();
                }
                if (textViewIsChecked)
                    return;
                if (radioButtonPlanDecorate.isChecked()) {
                    textViewThisYear.setTextColor(getResources().getColor(R.color.main_switch_green));
                } else {
                    setTextViewColorToGray();
                }
            }
        });
    }

    private void setTextViewColorToGray() {
        textViewThisYear.setTextColor(getResources().getColor(R.color.text_color));
        textViewNextYear.setTextColor(getResources().getColor(R.color.text_color));
        textViewNextNextYear.setTextColor(getResources().getColor(R.color.text_color));
    }

    @Override
    protected void initDatas() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation

    }

    @OnClick({R.id.textView_guide_activity_title, R.id.textView_this_year, R.id.textView_next_year, R.id.textView_next_next_year, R.id.textView_go_to_decorate})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.textView_guide_activity_title:
                intent = new Intent(GuideActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.textView_this_year:
                isChecked();
                textViewThisYear.setTextColor(getResources().getColor(R.color.main_switch_green));
                textViewNextYear.setTextColor(getResources().getColor(R.color.text_color));
                textViewNextNextYear.setTextColor(getResources().getColor(R.color.text_color));
                break;
            case R.id.textView_next_year:
                isChecked();
                textViewThisYear.setTextColor(getResources().getColor(R.color.text_color));
                textViewNextYear.setTextColor(getResources().getColor(R.color.main_switch_green));
                textViewNextNextYear.setTextColor(getResources().getColor(R.color.text_color));
                break;
            case R.id.textView_next_next_year:
                isChecked();
                textViewThisYear.setTextColor(getResources().getColor(R.color.text_color));
                textViewNextYear.setTextColor(getResources().getColor(R.color.text_color));
                textViewNextNextYear.setTextColor(getResources().getColor(R.color.main_switch_green));
                break;
            case R.id.textView_go_to_decorate:
                intent = new Intent(GuideActivity.this,MainActivity.class);
                //向intent中加入数据
                startActivity(intent);
                finish();
                break;
        }
    }

    private void isChecked() {
        textViewIsChecked = true;
        radioButtonPlanDecorate.setChecked(true);
    }
}
