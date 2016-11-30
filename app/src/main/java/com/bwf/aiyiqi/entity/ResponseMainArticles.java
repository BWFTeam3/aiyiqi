package com.bwf.aiyiqi.entity;

import java.util.List;

/**
 * Created by Administrator on 2016/11/24.
 */

public class ResponseMainArticles {


    /**
     * data : [{"type":3,"id":"1218286","title":"到底选择装修公司还是装修队？装修必看！","author":"burns","uid":"1513721","avtUrl":"http://bbs.17house.com/uc_server/avatar.php?uid=1513721&size=big","dateline":"2小时前","sort":"1480319144","views":"39","replies":"0","like_num":0,"path":"http://static-news.17house.com/bbs/forum/201611/28/112659ikcidi2ggigv9g4q.jpg!w720","forum":{"fid":"2","name":"北京装修论坛"},"followed":0},{"type":3,"id":"1218293","title":"虫哥和猫猫的书窝搭建小记之五十七\u2014\u2014日记大赛，情怀延续","author":"喝普洱的猫猫","uid":"1545248","avtUrl":"http://bbs.17house.com/uc_server/avatar.php?uid=1545248&size=big","dateline":"6小时前","sort":"1480305790","views":"302","replies":"13","like_num":8,"path":"http://static-news.17house.com/web/bbs/201611/28/1156407946.jpg!w720","forum":{"fid":"2","name":"北京装修论坛"},"followed":0},{"type":3,"id":"1218226","title":"程仪兵星级工长","author":"手机用户_1371560","uid":"1371560","avtUrl":"http://bbs.17house.com/uc_server/avatar.php?uid=1371560&size=big","dateline":"2天前","sort":"1480209421","views":"193","replies":"2","like_num":1,"path":null,"forum":{"fid":"2","name":"北京装修论坛"},"followed":0},{"type":3,"id":"1218224","title":"明年装修建材都要涨价了，今年团购会参加一场少一场了，还不快来订下实惠？","author":"怪兽","uid":"1482689","avtUrl":"http://bbs.17house.com/uc_server/avatar.php?uid=1482689&size=big","dateline":"2天前","sort":"1480208074","views":"334","replies":"11","like_num":0,"path":"http://static-news.17house.com/web/bbs/201611/27/0853085549.jpg!w720","forum":{"fid":"2","name":"北京装修论坛"},"followed":0},{"type":3,"id":"1218032","title":"8招选定装修公司，让您装修不后悔！","author":"burns","uid":"1513721","avtUrl":"http://bbs.17house.com/uc_server/avatar.php?uid=1513721&size=big","dateline":"4天前","sort":"1480062481","views":"353","replies":"1","like_num":1,"path":"http://static-news.17house.com/bbs/forum/201611/25/105506luzxzu4lmbunz4el.jpg!w720","forum":{"fid":"2","name":"北京装修论坛"},"followed":0},{"type":3,"id":"1218065","title":"收房验房必看七大要点，否则都没人给你装修！","author":"怪兽","uid":"1482689","avtUrl":"http://bbs.17house.com/uc_server/avatar.php?uid=1482689&size=big","dateline":"4天前","sort":"1480055057","views":"456","replies":"1","like_num":3,"path":"http://static-news.17house.com/bbs/forum/201611/25/141340lgpxqa9zagsadvq6.jpg!w720","forum":{"fid":"2","name":"北京装修论坛"},"followed":0},{"type":1,"id":"259179","title":"北京+上海 | 两个卫浴间 两段浴洗情","author":"","uid":0,"avtUrl":"","path":"http://static-news.17house.com/web/news/201611/25/201611251419508040.jpg","views":266,"like_num":0,"replies":"0","dateline":"4天前","sort":"1480054980","forum":{"fid":0,"name":""},"followed":0,"h5Url":"http://m.17house.com/news/259179.html"},{"type":1,"id":"259177","title":"拒绝平庸 潮范儿走起","author":"","uid":0,"avtUrl":"","path":"http://static-news.17house.com/web/news/201611/25/201611251358448542.jpg","views":341,"like_num":0,"replies":"0","dateline":"4天前","sort":"1480053540","forum":{"fid":0,"name":""},"followed":0,"h5Url":"http://m.17house.com/news/259177.html"},{"type":1,"id":"259172","title":"二手房改造的6大注意事项，你不容忽视","author":"","uid":0,"avtUrl":"","path":"http://static-news.17house.com/web/news/201611/25/201611251329338074.jpg","views":443,"like_num":0,"replies":"0","dateline":"4天前","sort":"1480051740","forum":{"fid":0,"name":""},"followed":0,"h5Url":"http://m.17house.com/news/259172.html"},{"type":3,"id":"1217995","title":"虫哥和猫猫的书窝搭建小记之五十六\u2014\u2014感恩节装了洗碗机","author":"喝普洱的猫猫","uid":"1545248","avtUrl":"http://bbs.17house.com/uc_server/avatar.php?uid=1545248&size=big","dateline":"5天前","sort":"1479977086","views":"658","replies":"7","like_num":6,"path":"http://static-news.17house.com/web/bbs/201611/24/1642127017.jpg!w720","forum":{"fid":"2","name":"北京装修论坛"},"followed":0}]
     * newCount : 2
     * currentPage : 1
     * totalCount : 150
     * error : 0
     * message : 成功
     */

    private int newCount;
    private int currentPage;
    private int totalCount;
    private String error;
    private String message;
    /**
     * type : 3
     * id : 1218286
     * title : 到底选择装修公司还是装修队？装修必看！
     * author : burns
     * uid : 1513721
     * avtUrl : http://bbs.17house.com/uc_server/avatar.php?uid=1513721&size=big
     * dateline : 2小时前
     * sort : 1480319144
     * views : 39
     * replies : 0
     * like_num : 0
     * path : http://static-news.17house.com/bbs/forum/201611/28/112659ikcidi2ggigv9g4q.jpg!w720
     * forum : {"fid":"2","name":"北京装修论坛"}
     * followed : 0
     */

    private List<DataBean> data;

    public int getNewCount() {
        return newCount;
    }

    public void setNewCount(int newCount) {
        this.newCount = newCount;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        private int type;
        private String id;
        private String title;
        private String author;
        private String uid;
        private String avtUrl;
        private String dateline;
        private String sort;
        private String views;
        private String replies;
        private int like_num;
        private String path;
        /**
         * fid : 2
         * name : 北京装修论坛
         */

        private ForumBean forum;
        private int followed;

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getUid() {
            return uid;
        }

        public void setUid(String uid) {
            this.uid = uid;
        }

        public String getAvtUrl() {
            return avtUrl;
        }

        public void setAvtUrl(String avtUrl) {
            this.avtUrl = avtUrl;
        }

        public String getDateline() {
            return dateline;
        }

        public void setDateline(String dateline) {
            this.dateline = dateline;
        }

        public String getSort() {
            return sort;
        }

        public void setSort(String sort) {
            this.sort = sort;
        }

        public String getViews() {
            return views;
        }

        public void setViews(String views) {
            this.views = views;
        }

        public String getReplies() {
            return replies;
        }

        public void setReplies(String replies) {
            this.replies = replies;
        }

        public int getLike_num() {
            return like_num;
        }

        public void setLike_num(int like_num) {
            this.like_num = like_num;
        }

        public String getPath() {
            return path;
        }

        public void setPath(String path) {
            this.path = path;
        }

        public ForumBean getForum() {
            return forum;
        }

        public void setForum(ForumBean forum) {
            this.forum = forum;
        }

        public int getFollowed() {
            return followed;
        }

        public void setFollowed(int followed) {
            this.followed = followed;
        }

        public static class ForumBean {
            private String fid;
            private String name;

            public String getFid() {
                return fid;
            }

            public void setFid(String fid) {
                this.fid = fid;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }
    }
}
