package com.bwf.aiyiqi;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.uuzuche.lib_zxing.activity.ZXingLibrary;

/**
 * Created by Administrator on 2016/11/23.
 */

public class App extends Application {
    public static App instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance=this;
        Fresco.initialize(this);
//        initDisplayOpinion();
        ZXingLibrary.initDisplayOpinion(this);
    }
//    private void initDisplayOpinion() {
//        DisplayMetrics dm = getResources().getDisplayMetrics();
//        DisplayUtil.density = dm.density;
//        DisplayUtil.densityDPI = dm.densityDpi;
//        DisplayUtil.screenWidthPx = dm.widthPixels;
//        DisplayUtil.screenhightPx = dm.heightPixels;
//        DisplayUtil.screenWidthDip = DisplayUtil.px2dip(getApplicationContext(), dm.widthPixels);
//        DisplayUtil.screenHightDip = DisplayUtil.px2dip(getApplicationContext(), dm.heightPixels);
//    }

}
