package com.bwf.aiyiqi.gui.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;

import com.bwf.aiyiqi.R;
import com.bwf.aiyiqi.utils.AppVersion;

/**
 * Created by Administrator on 2016/12/1.
 */

public class IntroduceActivity extends FragmentActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (isVisitFist()) {
            skipToGuide();
        } else {
            setContentView(R.layout.activity_introduce);
            new Thread() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(2500);
                        skipToMain();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }.start();
        }
    }

    private void skipToMain() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }


    private void skipToGuide() {
        startActivity(new Intent(this, GuideActivity.class));
        finish();
    }

    private boolean isVisitFist() {
        SharedPreferences version = getSharedPreferences("Aiyiqi_Version", MODE_PRIVATE);
        String str = version.getString("version", null);
        String versionName = AppVersion.getAppViewsionName(this);
        if (versionName.equals(str))
            return false;
        version.edit().putString("version", versionName).commit();
        return true;
    }
}
