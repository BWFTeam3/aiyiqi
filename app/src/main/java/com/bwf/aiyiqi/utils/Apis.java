package com.bwf.aiyiqi.utils;

/**
 * Created by Administrator on 2016/11/24.
 */

public interface Apis {
    public final String AUTOPAGER =  "http://appapi.17house.com/AppManagerApi.php?version=1&action=getownerinfo&cityId=2&model=android";
    public final String ARTICLE = "http://bbs.17house.com/motnt/index.php?a=appindex&c=index&id=1218226&uuid=86305803367590&pageSize=10&uid=1633055&m=misc&type=3&page=1&haspermission=yes&model=android&sessionToken=6U49kCYKE260RqvPqEdFsBGskNQStKhm&app_version=android_com.aiyiqi.galaxy_1.1";
    public final String NEXTARTICLE = "http://bbs.17house.com/motnt/index.php?a=appindex&c=index&id={2}&uuid=86305803367590&pageSize=10&uid=1633055&m=misc&type={1}&page={0}&haspermission=yes&model=android&sessionToken=6U49kCYKE260RqvPqEdFsBGskNQStKhm&app_version=android_com.aiyiqi.galaxy_1.1";
    public final String FITTAG = "http://appapi.17house.com/StageApi.php?version=1&action=getTagsByStage&stage={0}&model=android";
    public final String FITNEWS = "http://appapi.17house.com/NewsApi.php?version=1&action=getNewsByStage&stage={0}&page={1}&pagesize=10&model=android";
    public final String SEARCH = "http://bbs.17house.com/motnt/index.php?a=searchForum&c=search&uuid=86305803367590&pageSize=10&m=search&page={0}&haspermission=yes&kw={1}&model=android&sessionToken=&app_version=android_com.aiyiqi.galaxy_1.1";
}
