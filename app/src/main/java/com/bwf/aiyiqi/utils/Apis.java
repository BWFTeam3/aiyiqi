package com.bwf.aiyiqi.utils;

/**
 * Created by Administrator on 2016/11/24.
 */

public interface Apis {
    //  装修公司
    String URL_FLASHVIEW = "http://appapi.17house.com/AppManagerApi.php?version=1&action=integratedpackage&model=android&app_version=android_com.aiyiqi.galaxy_1.1";
    String URL_FITMENT_LIVE = "http://hui.17house.com/svc/payment-facade/housekeep/listLatestLiveBuildingSites";
    String URL_NEW_HOUSE_OVERALL_DECORATION = "http://hui.17house.com/svc/payment-facade/h5/activity677/index.html?model=android";
    String URL_OLD_HOUSE_OVERALL_DECORATION = "http://hui.17house.com/svc/payment-facade/h5/activity177/index.html?model=android";
    String URL_SITE_PLAYING_BASIC_INFORMATION = "http://hui.17house.com/svc/payment-facade/housekeep/getLiveBuildingSite";
    String URL_FITMENT_PROGRESS = "http://hui.17house.com/svc/payment-facade/housekeep/listBuildingSiteTrackByProgress";
    String URL_YIQIGROUP = "http://hui.17house.com/svc/payment-facade/housekeep/listBuildingSiteVendors\n";
    // 同城活动
    String URL_CITY_EVENT = "http://bbs.17house.com/motnt/index.php?a=activityThreadlist&c=forumThreadList&uuid=a444d1b2af4f&pageSize=10&uid=1633055&cityName=%E6%88%90%E9%83%BD&m=forum&page=1&model=android&sessionToken=6U49kCYKE260RqvPqEdFsBGskNQStKhm&app_version=android_com.aiyiqi.galaxy_1.1";
    // 业主说
    String URL_OWNER_TALK = "http://bbs.17house.com/motnt/index.php?";

    public final String AUTOPAGER =  "http://appapi.17house.com/AppManagerApi.php?version=1&action=getownerinfo&cityId=2&model=android";
    public final String ARTICLE = "http://bbs.17house.com/motnt/index.php?a=appindex&c=index&id=1218226&uuid=86305803367590&pageSize=10&uid=1633055&m=misc&type=3&page=1&haspermission=yes&model=android&sessionToken=6U49kCYKE260RqvPqEdFsBGskNQStKhm&app_version=android_com.aiyiqi.galaxy_1.1";
    public final String NEXTARTICLE = "http://bbs.17house.com/motnt/index.php?a=appindex&c=index&id={2}&uuid=86305803367590&pageSize=10&uid=1633055&m=misc&type={1}&page={0}&haspermission=yes&model=android&sessionToken=6U49kCYKE260RqvPqEdFsBGskNQStKhm&app_version=android_com.aiyiqi.galaxy_1.1";
    public final String FITTAG = "http://appapi.17house.com/StageApi.php?version=1&action=getTagsByStage&stage={0}&model=android";
    public final String FITNEWS = "http://appapi.17house.com/NewsApi.php?version=1&action=getNewsByStage&stage={0}&page={1}&pagesize=10&model=android";
    public final String SEARCH = "http://bbs.17house.com/motnt/index.php?a=searchForum&c=search&uuid=86305803367590&pageSize=10&m=search&page={0}&haspermission=yes&kw={1}&model=android&sessionToken=&app_version=android_com.aiyiqi.galaxy_1.1";
    //装修预算接口
    String DECORATIONBUDGET = "http://m.beijing.17house.com/baojia/?sem=android&model=android";
    //建材家具接口
    String BUILDING = "http://bbs.17house.com/motnt/index.php?a=product&m=misc&model=android&uuid=a444d1b2af4f&app_version=android_com.aiyiqi.galaxy_1.1";
    public final String DESIGNTOPIC = "http://appapi.17house.com/xiaoguotuApi.php?version=1&page={0}&action=albumList2&pageSize=10&tagid=1&model=android";
    public final String DESIGNPS = "http://appapi.17house.com/xiaoguotuApi.php?version=1&page={0}&action=imageList2&pageSize=10&tagid={1}&model=android";
    public final String ARTICLES = "http://appapi.17house.com/NewsApi.php?version=1&newsId={0}&page=1&action=newsDetail&relatedNum=3&model=android";
    public final String ARTICLESREPLYS = "http://appapi.17house.com/newsApi.php?version=1&page=1&dataId={0}&action=commentList&limit=10&model=android";


    public final String NOTES = "http://bbs.17house.com/motnt/index.php?a=viewThread&c=forumThread&imgwidth=330&uuid=86305803367590&tid={0}&m=forum&haspermission=yes&model=android&app_version=android_com.aiyiqi.galaxy_1.1";
    public final String NOTESREPLYS = "http://bbs.17house.com/motnt/index.php?a=viewThread&c=forumThread&imgwidth=270&uuid=86305803367590&pageSize=10&tid={0}&uid=1633055&m=forum&type=post&page=1&haspermission=yes&model=android&sessionToken=6U49kCYKE260RqvPqEdFsBGskNQStKhm&app_version=android_com.aiyiqi.galaxy_1.1";
    public final String NOTESLIKES = "http://bbs.17house.com/motnt/index.php?a=threadZan&c=forumThread&uuid=86305803367590&tid={0}&uid=1633055&m=forum&haspermission=yes&model=android&sessionToken=6U49kCYKE260RqvPqEdFsBGskNQStKhm&app_version=android_com.aiyiqi.galaxy_1.1";
}
