package com.bwf.aiyiqi.entity;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

/**
 * Created by Administrator on 2016/11/25.
 */

public class TabBatchingData {
   

    /**
     * error : 0
     * message : ok
     * data : [{"id":"2,21,23,22,24,25","name":"装修公司","data":[{"business_id":"843529","business_name":"新房整装套餐","business_order":"0","new_brand_id":"0","brand_name":"","cityname":"北京市","discount_info":"新房整装套餐：677元每平米从设计到入住全程托管无负担！ 包设计、包主材、包施工、零增项 一、设计+基础施工+辅材+12大超高性价比主材（室内门，瓷砖，洁具，橱柜，地板，吊顶，开关插座，烟机灶具，地漏，卫生间五金四件套，吸顶灯） 二、新房装修从毛坯到精装无任何\u201c绝对\u201d增项 三、 套餐服务标准为：建筑面积70平米以上。 限时活动：200抵500，签合同款时可用； 量完房不满意？点击\u201c取消订单\u201d，1秒退款！","groupon_name":"","groupon_id":"2632","groupon_date":"2016年11月05日","groupon_address":"海淀区首体南路6号新世纪日航酒店","isPublish":"1","logo":"http://static.17house.com/upload/biz_info/2016-05/biz_info_logo/source_572961465822e.png"}]}]
     */

    private int error;
    private String message;
    /**
     * id : 2,21,23,22,24,25
     * name : 装修公司
     * data : [{"business_id":"843529","business_name":"新房整装套餐","business_order":"0","new_brand_id":"0","brand_name":"","cityname":"北京市","discount_info":"新房整装套餐：677元每平米从设计到入住全程托管无负担！ 包设计、包主材、包施工、零增项 一、设计+基础施工+辅材+12大超高性价比主材（室内门，瓷砖，洁具，橱柜，地板，吊顶，开关插座，烟机灶具，地漏，卫生间五金四件套，吸顶灯） 二、新房装修从毛坯到精装无任何\u201c绝对\u201d增项 三、 套餐服务标准为：建筑面积70平米以上。 限时活动：200抵500，签合同款时可用； 量完房不满意？点击\u201c取消订单\u201d，1秒退款！","groupon_name":"","groupon_id":"2632","groupon_date":"2016年11月05日","groupon_address":"海淀区首体南路6号新世纪日航酒店","isPublish":"1","logo":"http://static.17house.com/upload/biz_info/2016-05/biz_info_logo/source_572961465822e.png"}]
     */

    private List<DataBean> data;

    public int getError() {
        return error;
    }

    public void setError(int error) {
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
        private String id;
        private String name;
        /**
         * business_id : 843529
         * business_name : 新房整装套餐
         * business_order : 0
         * new_brand_id : 0
         * brand_name :
         * cityname : 北京市
         * discount_info : 新房整装套餐：677元每平米从设计到入住全程托管无负担！ 包设计、包主材、包施工、零增项 一、设计+基础施工+辅材+12大超高性价比主材（室内门，瓷砖，洁具，橱柜，地板，吊顶，开关插座，烟机灶具，地漏，卫生间五金四件套，吸顶灯） 二、新房装修从毛坯到精装无任何“绝对”增项 三、 套餐服务标准为：建筑面积70平米以上。 限时活动：200抵500，签合同款时可用； 量完房不满意？点击“取消订单”，1秒退款！
         * groupon_name :
         * groupon_id : 2632
         * groupon_date : 2016年11月05日
         * groupon_address : 海淀区首体南路6号新世纪日航酒店
         * isPublish : 1
         * logo : http://static.17house.com/upload/biz_info/2016-05/biz_info_logo/source_572961465822e.png
         */

        @JSONField(name = "data")
        private List<DataBean1> data1;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<DataBean1> getData1() {
            return data1;
        }

        public void setData1(List<DataBean1> data1) {
            this.data1 = data1;
        }

        public static class DataBean1 {
            private String business_id;
            private String business_name;
            private String business_order;
            private String new_brand_id;
            private String brand_name;
            private String cityname;
            private String discount_info;
            private String groupon_name;
            private String groupon_id;
            private String groupon_date;
            private String groupon_address;
            private String isPublish;
            private String logo;

            public String getBusiness_id() {
                return business_id;
            }

            public void setBusiness_id(String business_id) {
                this.business_id = business_id;
            }

            public String getBusiness_name() {
                return business_name;
            }

            public void setBusiness_name(String business_name) {
                this.business_name = business_name;
            }

            public String getBusiness_order() {
                return business_order;
            }

            public void setBusiness_order(String business_order) {
                this.business_order = business_order;
            }

            public String getNew_brand_id() {
                return new_brand_id;
            }

            public void setNew_brand_id(String new_brand_id) {
                this.new_brand_id = new_brand_id;
            }

            public String getBrand_name() {
                return brand_name;
            }

            public void setBrand_name(String brand_name) {
                this.brand_name = brand_name;
            }

            public String getCityname() {
                return cityname;
            }

            public void setCityname(String cityname) {
                this.cityname = cityname;
            }

            public String getDiscount_info() {
                return discount_info;
            }

            public void setDiscount_info(String discount_info) {
                this.discount_info = discount_info;
            }

            public String getGroupon_name() {
                return groupon_name;
            }

            public void setGroupon_name(String groupon_name) {
                this.groupon_name = groupon_name;
            }

            public String getGroupon_id() {
                return groupon_id;
            }

            public void setGroupon_id(String groupon_id) {
                this.groupon_id = groupon_id;
            }

            public String getGroupon_date() {
                return groupon_date;
            }

            public void setGroupon_date(String groupon_date) {
                this.groupon_date = groupon_date;
            }

            public String getGroupon_address() {
                return groupon_address;
            }

            public void setGroupon_address(String groupon_address) {
                this.groupon_address = groupon_address;
            }

            public String getIsPublish() {
                return isPublish;
            }

            public void setIsPublish(String isPublish) {
                this.isPublish = isPublish;
            }

            public String getLogo() {
                return logo;
            }

            public void setLogo(String logo) {
                this.logo = logo;
            }
        }
    }
}
