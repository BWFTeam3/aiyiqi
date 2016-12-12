package com.bwf.aiyiqi.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by Administrator on 2016/12/12.
 */

@Entity
public class GreenDaoDb {
    private long id;
    private String content;
    private long time;
    @Generated(hash = 830096785)
    public GreenDaoDb(long id, String content, long time) {
        this.id = id;
        this.content = content;
        this.time = time;
    }
    @Generated(hash = 1224237355)
    public GreenDaoDb() {
    }
    public long getId() {
        return this.id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getContent() {
        return this.content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public long getTime() {
        return this.time;
    }
    public void setTime(long time) {
        this.time = time;
    }
}
