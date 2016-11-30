package com.bwf.aiyiqi.utils;

/**
 * Created by Administrator on 2016/11/24.
 */

public interface Apis {
    public final String AUTOPAGER =  "http://118.178.142.34/YiQiHouse/HomeAD";
    public final String ARTICLE = "http://118.178.142.34/YiQiHouse/HomeBBS?page=1";
    public final String NEXTARTICLE = "http://118.178.142.34/YiQiHouse/HomeBBS?page={0}&type={1}&id={2}";
    //  装修公司
    String URL_FLASHVIEW = "http://appapi.17house.com/AppManagerApi.php?version=1&action=integratedpackage&model=android&app_version=android_com.aiyiqi.galaxy_1.1";
    String URL_FITMENT_LIVE = "http://hui.17house.com/svc/payment-facade/housekeep/listLatestLiveBuildingSites";
    String URL_NEW_HOUSE_OVERALL_DECORATION = "http://hui.17house.com/svc/payment-facade/h5/activity677/index.html?model=android";
    String URL_OLD_HOUSE_OVERALL_DECORATION = "http://hui.17house.com/svc/payment-facade/h5/activity177/index.html?model=android";
    String URL_LOOK_SITE = "http://118.178.142.34/YiQiHouse/OnSite";
    String URL_SITE_PLAYING_BASIC_INFORMATION = "http://hui.17house.com/svc/payment-facade/housekeep/getLiveBuildingSite";
    String URL_FITMENT_PROGRESS = "http://hui.17house.com/svc/payment-facade/housekeep/listBuildingSiteTrackByProgress";
    String URL_YIQIGROUP = "http://hui.17house.com/svc/payment-facade/housekeep/listBuildingSiteVendors\n";
    String URL_CITY_EVENT = "http://bbs.17house.com/motnt/index.php?a=activityThreadlist&c=forumThreadList&uuid=a444d1b2af4f&pageSize=10&uid=1633055&cityName=%E6%88%90%E9%83%BD&m=forum&page=1&model=android&sessionToken=6U49kCYKE260RqvPqEdFsBGskNQStKhm&app_version=android_com.aiyiqi.galaxy_1.1";
}
