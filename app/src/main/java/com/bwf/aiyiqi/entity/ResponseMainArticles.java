package com.bwf.aiyiqi.entity;

import java.util.List;

/**
 * Created by Administrator on 2016/11/24.
 */

public class ResponseMainArticles {

    /**
     * data : [{"type":3,"id":"1217885","title":"装修业主必看！您的装修费用都去哪了?","author":"疯子的鞋","uid":"1487957","avtUrl":"http://bbs.17house.com/uc_server/avatar.php?uid=1487957&size=big","dateline":"17小时前","sort":"1479897271","views":"136","replies":"0","like_num":1,"path":"http://static-news.17house.com/bbs/forum/201611/23/183404rlbpbw5gew5upjjb.png!w720","forum":{"fid":"2","name":null},"followed":0},{"type":3,"id":"1217851","title":"装修预算报价10大陷阱！装修必看","author":"张小雨","uid":"1425483","avtUrl":"http://bbs.17house.com/uc_server/avatar.php?uid=1425483&size=big","dateline":"20小时前","sort":"1479886861","views":"125","replies":"1","like_num":2,"path":"http://static-news.17house.com/bbs/forum/201611/23/153954w8nppie2l6w68pi1.jpg!w720","forum":{"fid":"2","name":null},"followed":0},{"type":1,"id":"258892","title":"房子这样布置变大10㎡","author":"","uid":0,"avtUrl":"","path":"http://static-news.17house.com/web/news/201611/23/201611231512479436.jpg","views":264,"like_num":0,"replies":"0","dateline":"21小时前","sort":"1479885360","forum":{"fid":0,"name":""},"followed":0,"h5Url":"http://m.17house.com/news/258892.html"},{"type":1,"id":"258889","title":"她用两面玻璃墙，给家打造了一个全景厨房","author":"","uid":0,"avtUrl":"","path":"http://static-news.17house.com/web/news/201611/23/201611231451166715.jpg","views":160,"like_num":0,"replies":"0","dateline":"21小时前","sort":"1479884160","forum":{"fid":0,"name":""},"followed":0,"h5Url":"http://m.17house.com/news/258889.html"},{"type":1,"id":"258888","title":"餐区选的妙，小户型也有大空间","author":"","uid":0,"avtUrl":"","path":"http://static-news.17house.com/web/news/201611/23/201611231432491124.jpg","views":121,"like_num":0,"replies":"0","dateline":"21小时前","sort":"1479882840","forum":{"fid":0,"name":""},"followed":0,"h5Url":"http://m.17house.com/news/258888.html"},{"type":3,"id":"1217787","title":"放大招！老房、二手房装修秘籍！","author":"burns","uid":"1513721","avtUrl":"http://bbs.17house.com/uc_server/avatar.php?uid=1513721&size=big","dateline":"22小时前","sort":"1479880826","views":"121","replies":"0","like_num":0,"path":"http://static-news.17house.com/bbs/forum/201611/23/103106o3kbn5151n8pnssn.jpg!w720","forum":{"fid":"2","name":null},"followed":0},{"type":1,"id":"258864","title":"理想的单身女生卧室就这样温暖而美好","author":"","uid":0,"avtUrl":"","path":"http://static-news.17house.com/web/news/201611/23/201611231109206914.jpg","views":278,"like_num":0,"replies":"0","dateline":"2天前","sort":"1479870574","forum":{"fid":0,"name":""},"followed":0,"h5Url":"http://m.17house.com/news/258864.html"},{"type":3,"id":"1217774","title":"巅峰对决，2016年度日记大赛总决赛粉丝总动员","author":"bujia","uid":"1490946","avtUrl":"http://bbs.17house.com/uc_server/avatar.php?uid=1490946&size=big","dateline":"2天前","sort":"1479831457","views":"411","replies":"1","like_num":4,"path":"http://static-news.17house.com/bbs/forum/201611/22/235830tpm9hu99wh5hooz9.jpg!w720","forum":{"fid":"2","name":null},"followed":0},{"type":3,"id":"1217754","title":"干货！网友装修一年后的31条血泪总结","author":"张小雨","uid":"1425483","avtUrl":"http://bbs.17house.com/uc_server/avatar.php?uid=1425483&size=big","dateline":"2天前","sort":"1479806631","views":"673","replies":"1","like_num":6,"path":"http://static-news.17house.com/bbs/forum/201611/22/171653r71s7m0dpoodxvvv.jpg!w720","forum":{"fid":"2","name":null},"followed":0},{"type":1,"id":"258780","title":"冬日之花 与暗色共舞","author":"","uid":0,"avtUrl":"","path":"http://static-news.17house.com/web/news/201611/22/201611221526507209.jpg","views":216,"like_num":0,"replies":"0","dateline":"2天前","sort":"1479799620","forum":{"fid":0,"name":""},"followed":0,"h5Url":"http://m.17house.com/news/258780.html"}]
     * newCount : 0
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
     * id : 1217885
     * title : 装修业主必看！您的装修费用都去哪了?
     * author : 疯子的鞋
     * uid : 1487957
     * avtUrl : http://bbs.17house.com/uc_server/avatar.php?uid=1487957&size=big
     * dateline : 17小时前
     * sort : 1479897271
     * views : 136
     * replies : 0
     * like_num : 1
     * path : http://static-news.17house.com/bbs/forum/201611/23/183404rlbpbw5gew5upjjb.png!w720
     * forum : {"fid":"2","name":null}
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
         * name : null
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
            private Object name;

            public String getFid() {
                return fid;
            }

            public void setFid(String fid) {
                this.fid = fid;
            }

            public Object getName() {
                return name;
            }

            public void setName(Object name) {
                this.name = name;
            }
        }
    }
}
