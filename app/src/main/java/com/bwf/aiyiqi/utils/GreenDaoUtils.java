package com.bwf.aiyiqi.utils;

import android.database.sqlite.SQLiteDatabase;

import com.bwf.aiyiqi.App;
import com.bwf.aiyiqi.entity.DaoMaster;
import com.bwf.aiyiqi.entity.DaoSession;

/**
 * Created by Administrator on 2016/12/12.
 */

public class GreenDaoUtils {
    private DaoMaster.DevOpenHelper mhelper;
    private SQLiteDatabase db;
    private DaoSession session;
    private DaoMaster master;
    private static GreenDaoUtils utils;

    public static GreenDaoUtils getUtils() {
        if (utils == null) {
            utils = new GreenDaoUtils();
        }
        return utils;
    }

    private GreenDaoUtils() {
    }

    private void initGreenDao() {
        mhelper = new DaoMaster.DevOpenHelper(App.getApp(), "history", null);
        db = mhelper.getWritableDatabase();
        master = new DaoMaster(db);
        session = master.newSession();
    }

    public DaoSession getSession() {
        if (session == null) {
            initGreenDao();
        }
        return session;
    }
    public SQLiteDatabase getDb(){
        if (db==null){
            initGreenDao();
        }
        return db;
    }
}
