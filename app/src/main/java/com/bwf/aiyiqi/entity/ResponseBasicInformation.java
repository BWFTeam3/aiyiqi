package com.bwf.aiyiqi.entity;

import java.util.List;

/**
 * Created by Administrator on 2016/11/28.
 */

public class ResponseBasicInformation {

    /**
     * code : 0
     * message : success
     */

    private BaseOutputBean baseOutput;
    /**
     * buildingSite : {"buildingId":1549734595803488474,"statusId":0,"progressId":1,"acceptanceProgressId":0,"orderId":1549734595803488474,"createTime":1479467059000,"updateTime":1480248392000,"userId":1549734595800342745,"startDisclosure":1,"startDisclosureTime":1479467059000,"splitAlter":0,"splitAlterTime":1479467059000,"waterElectricity":0,"waterElectricityTime":1479467059000,"cementWood":0,"cementWoodTime":1479467059000,"paint":0,"paintTime":1479467059000,"installation":0,"installationTime":1479467059000,"finish":0,"finishTime":1479467059000,"buildingIdStr":"","acceptanceStatus":0,"bespeakExpired":0,"messageNumber":0,"scheduleStatus":0,"isShow":1}
     * orderHouse : {"orderId":1549734595803488474,"layout":"一居室","area":"57","doorplate":"1103","community":"后沙峪","address":"金地悦景台","newHouse":1,"deliveryHouse":2,"lat":0,"houseComment":""}
     * userDetail : {"userId":1549734595800342745,"realName":"杜军","gender":0,"emailVerified":0,"provinceId":0,"cityId":0,"districtId":0,"userPoint":0,"userLevel":0,"hasOrder":0,"updateTime":1477942081000,"userPointIncrement":0,"userPointDate":1477942081000,"mobile":"18010180785","mobileLocation":"北京北京","userType":0}
     * imageUrl : http://apptest-picture.oss-cn-beijing.aliyuncs.com/yiqizhuagnxiu-gongdizhibo/tu10.png
     * members : [{"vendorId":1538349904822281002,"vendorName":"王杏杏","realName":"王杏杏","nickName":"王杏杏","avatar":"http://jiazhuangtest-picture.oss-cn-beijing.aliyuncs.com/user/1470281116599218921","lifePhoto":"http://jiazhuangtest-picture.oss-cn-beijing.aliyuncs.com/user/147028113779276521","signature":"用心做好每一件事","provinceId":1,"workYear":2011,"goodAt":"现代 欧式 简欧 东南亚","updateTime":1467084794000,"bossId":1701},{"vendorId":1549969683034164702,"vendorName":"何宇杰","realName":"何宇杰","nickName":"何宇杰","avatar":"http://jiazhuang-picture.oss-cn-beijing.aliyuncs.com/jiagenjin/f627b039-d730-42ec-a3b2-cb3bae7babdd","lifePhoto":"http://jiazhuang-picture.oss-cn-beijing.aliyuncs.com/jiagenjin/64e070d3-4c4b-4342-9a96-f4a406e5ba3f","signature":"业主您好，我是一起装修网监理，您的贴心管家；负责工地质量、辅材、施工节点验收，处理施工中任何疑问与投诉。","provinceId":1,"workYear":2009,"goodAt":"简欧,欧式,现代简约,北欧","updateTime":1478166278000,"bossId":1702},{"vendorId":1550071032683968200,"vendorName":"汪飞","realName":"汪飞","nickName":"汪飞","avatar":"http://jiazhuangtest-picture.oss-cn-beijing.aliyuncs.com/user/1478263299616206522","lifePhoto":"http://jiazhuangtest-picture.oss-cn-beijing.aliyuncs.com/user/147826332355169429","signature":"本人于2000年来北京从事装修行业至今.最初是从事油工工种.曾在各大公司做过班长.后在工长俱乐部及互联网公司任职工长多年.拥有众多的人力资源.及对工地管理模式，对互联网模式.也是轻车熟路。","provinceId":0,"workYear":2016,"updateTime":1478262932000,"bossId":1703},{"vendorId":1551313783137257302,"vendorName":"韩鹏","realName":"韩鹏","nickName":"韩鹏","provinceId":0,"workYear":0,"updateTime":1479448112000,"bossId":1705}]
     * progress : [{"progressId":1,"progressName":"开工","progressStatus":1,"createTime":1479467059000},{"progressId":3,"progressName":"水电","progressStatus":0,"createTime":1479467059000},{"progressId":4,"progressName":"泥木","progressStatus":0,"createTime":1479467059000},{"progressId":5,"progressName":"油漆","progressStatus":0,"createTime":1479467059000},{"progressId":6,"progressName":"安装","progressStatus":0,"createTime":1479467059000},{"progressId":7,"progressName":"竣工","progressStatus":0,"createTime":1479467059000}]
     * latestTrackProgressId : 1
     */

    private DataBean data;

    public BaseOutputBean getBaseOutput() {
        return baseOutput;
    }

    public void setBaseOutput(BaseOutputBean baseOutput) {
        this.baseOutput = baseOutput;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class BaseOutputBean {
        private int code;
        private String message;

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }

    public static class DataBean {
        /**
         * buildingId : 1549734595803488474
         * statusId : 0
         * progressId : 1
         * acceptanceProgressId : 0
         * orderId : 1549734595803488474
         * createTime : 1479467059000
         * updateTime : 1480248392000
         * userId : 1549734595800342745
         * startDisclosure : 1
         * startDisclosureTime : 1479467059000
         * splitAlter : 0
         * splitAlterTime : 1479467059000
         * waterElectricity : 0
         * waterElectricityTime : 1479467059000
         * cementWood : 0
         * cementWoodTime : 1479467059000
         * paint : 0
         * paintTime : 1479467059000
         * installation : 0
         * installationTime : 1479467059000
         * finish : 0
         * finishTime : 1479467059000
         * buildingIdStr :
         * acceptanceStatus : 0
         * bespeakExpired : 0
         * messageNumber : 0
         * scheduleStatus : 0
         * isShow : 1
         */

        private BuildingSiteBean buildingSite;
        /**
         * orderId : 1549734595803488474
         * layout : 一居室
         * area : 57
         * doorplate : 1103
         * community : 后沙峪
         * address : 金地悦景台
         * newHouse : 1
         * deliveryHouse : 2
         * lat : 0
         * houseComment :
         */

        private OrderHouseBean orderHouse;
        /**
         * userId : 1549734595800342745
         * realName : 杜军
         * gender : 0
         * emailVerified : 0
         * provinceId : 0
         * cityId : 0
         * districtId : 0
         * userPoint : 0
         * userLevel : 0
         * hasOrder : 0
         * updateTime : 1477942081000
         * userPointIncrement : 0
         * userPointDate : 1477942081000
         * mobile : 18010180785
         * mobileLocation : 北京北京
         * userType : 0
         */

        private UserDetailBean userDetail;
        private String imageUrl;
        private int latestTrackProgressId;
        /**
         * vendorId : 1538349904822281002
         * vendorName : 王杏杏
         * realName : 王杏杏
         * nickName : 王杏杏
         * avatar : http://jiazhuangtest-picture.oss-cn-beijing.aliyuncs.com/user/1470281116599218921
         * lifePhoto : http://jiazhuangtest-picture.oss-cn-beijing.aliyuncs.com/user/147028113779276521
         * signature : 用心做好每一件事
         * provinceId : 1
         * workYear : 2011
         * goodAt : 现代 欧式 简欧 东南亚
         * updateTime : 1467084794000
         * bossId : 1701
         */

        private List<MembersBean> members;
        /**
         * progressId : 1
         * progressName : 开工
         * progressStatus : 1
         * createTime : 1479467059000
         */

        private List<ProgressBean> progress;

        public BuildingSiteBean getBuildingSite() {
            return buildingSite;
        }

        public void setBuildingSite(BuildingSiteBean buildingSite) {
            this.buildingSite = buildingSite;
        }

        public OrderHouseBean getOrderHouse() {
            return orderHouse;
        }

        public void setOrderHouse(OrderHouseBean orderHouse) {
            this.orderHouse = orderHouse;
        }

        public UserDetailBean getUserDetail() {
            return userDetail;
        }

        public void setUserDetail(UserDetailBean userDetail) {
            this.userDetail = userDetail;
        }

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }

        public int getLatestTrackProgressId() {
            return latestTrackProgressId;
        }

        public void setLatestTrackProgressId(int latestTrackProgressId) {
            this.latestTrackProgressId = latestTrackProgressId;
        }

        public List<MembersBean> getMembers() {
            return members;
        }

        public void setMembers(List<MembersBean> members) {
            this.members = members;
        }

        public List<ProgressBean> getProgress() {
            return progress;
        }

        public void setProgress(List<ProgressBean> progress) {
            this.progress = progress;
        }

        public static class BuildingSiteBean {
            private long buildingId;
            private int statusId;
            private int progressId;
            private int acceptanceProgressId;
            private long orderId;
            private long createTime;
            private long updateTime;
            private long userId;
            private int startDisclosure;
            private long startDisclosureTime;
            private int splitAlter;
            private long splitAlterTime;
            private int waterElectricity;
            private long waterElectricityTime;
            private int cementWood;
            private long cementWoodTime;
            private int paint;
            private long paintTime;
            private int installation;
            private long installationTime;
            private int finish;
            private long finishTime;
            private String buildingIdStr;
            private int acceptanceStatus;
            private int bespeakExpired;
            private int messageNumber;
            private int scheduleStatus;
            private int isShow;

            public long getBuildingId() {
                return buildingId;
            }

            public void setBuildingId(long buildingId) {
                this.buildingId = buildingId;
            }

            public int getStatusId() {
                return statusId;
            }

            public void setStatusId(int statusId) {
                this.statusId = statusId;
            }

            public int getProgressId() {
                return progressId;
            }

            public void setProgressId(int progressId) {
                this.progressId = progressId;
            }

            public int getAcceptanceProgressId() {
                return acceptanceProgressId;
            }

            public void setAcceptanceProgressId(int acceptanceProgressId) {
                this.acceptanceProgressId = acceptanceProgressId;
            }

            public long getOrderId() {
                return orderId;
            }

            public void setOrderId(long orderId) {
                this.orderId = orderId;
            }

            public long getCreateTime() {
                return createTime;
            }

            public void setCreateTime(long createTime) {
                this.createTime = createTime;
            }

            public long getUpdateTime() {
                return updateTime;
            }

            public void setUpdateTime(long updateTime) {
                this.updateTime = updateTime;
            }

            public long getUserId() {
                return userId;
            }

            public void setUserId(long userId) {
                this.userId = userId;
            }

            public int getStartDisclosure() {
                return startDisclosure;
            }

            public void setStartDisclosure(int startDisclosure) {
                this.startDisclosure = startDisclosure;
            }

            public long getStartDisclosureTime() {
                return startDisclosureTime;
            }

            public void setStartDisclosureTime(long startDisclosureTime) {
                this.startDisclosureTime = startDisclosureTime;
            }

            public int getSplitAlter() {
                return splitAlter;
            }

            public void setSplitAlter(int splitAlter) {
                this.splitAlter = splitAlter;
            }

            public long getSplitAlterTime() {
                return splitAlterTime;
            }

            public void setSplitAlterTime(long splitAlterTime) {
                this.splitAlterTime = splitAlterTime;
            }

            public int getWaterElectricity() {
                return waterElectricity;
            }

            public void setWaterElectricity(int waterElectricity) {
                this.waterElectricity = waterElectricity;
            }

            public long getWaterElectricityTime() {
                return waterElectricityTime;
            }

            public void setWaterElectricityTime(long waterElectricityTime) {
                this.waterElectricityTime = waterElectricityTime;
            }

            public int getCementWood() {
                return cementWood;
            }

            public void setCementWood(int cementWood) {
                this.cementWood = cementWood;
            }

            public long getCementWoodTime() {
                return cementWoodTime;
            }

            public void setCementWoodTime(long cementWoodTime) {
                this.cementWoodTime = cementWoodTime;
            }

            public int getPaint() {
                return paint;
            }

            public void setPaint(int paint) {
                this.paint = paint;
            }

            public long getPaintTime() {
                return paintTime;
            }

            public void setPaintTime(long paintTime) {
                this.paintTime = paintTime;
            }

            public int getInstallation() {
                return installation;
            }

            public void setInstallation(int installation) {
                this.installation = installation;
            }

            public long getInstallationTime() {
                return installationTime;
            }

            public void setInstallationTime(long installationTime) {
                this.installationTime = installationTime;
            }

            public int getFinish() {
                return finish;
            }

            public void setFinish(int finish) {
                this.finish = finish;
            }

            public long getFinishTime() {
                return finishTime;
            }

            public void setFinishTime(long finishTime) {
                this.finishTime = finishTime;
            }

            public String getBuildingIdStr() {
                return buildingIdStr;
            }

            public void setBuildingIdStr(String buildingIdStr) {
                this.buildingIdStr = buildingIdStr;
            }

            public int getAcceptanceStatus() {
                return acceptanceStatus;
            }

            public void setAcceptanceStatus(int acceptanceStatus) {
                this.acceptanceStatus = acceptanceStatus;
            }

            public int getBespeakExpired() {
                return bespeakExpired;
            }

            public void setBespeakExpired(int bespeakExpired) {
                this.bespeakExpired = bespeakExpired;
            }

            public int getMessageNumber() {
                return messageNumber;
            }

            public void setMessageNumber(int messageNumber) {
                this.messageNumber = messageNumber;
            }

            public int getScheduleStatus() {
                return scheduleStatus;
            }

            public void setScheduleStatus(int scheduleStatus) {
                this.scheduleStatus = scheduleStatus;
            }

            public int getIsShow() {
                return isShow;
            }

            public void setIsShow(int isShow) {
                this.isShow = isShow;
            }
        }

        public static class OrderHouseBean {
            private long orderId;
            private String layout;
            private String area;
            private String doorplate;
            private String community;
            private String address;
            private int newHouse;
            private int deliveryHouse;
            private int lat;
            private String houseComment;

            public long getOrderId() {
                return orderId;
            }

            public void setOrderId(long orderId) {
                this.orderId = orderId;
            }

            public String getLayout() {
                return layout;
            }

            public void setLayout(String layout) {
                this.layout = layout;
            }

            public String getArea() {
                return area;
            }

            public void setArea(String area) {
                this.area = area;
            }

            public String getDoorplate() {
                return doorplate;
            }

            public void setDoorplate(String doorplate) {
                this.doorplate = doorplate;
            }

            public String getCommunity() {
                return community;
            }

            public void setCommunity(String community) {
                this.community = community;
            }

            public String getAddress() {
                return address;
            }

            public void setAddress(String address) {
                this.address = address;
            }

            public int getNewHouse() {
                return newHouse;
            }

            public void setNewHouse(int newHouse) {
                this.newHouse = newHouse;
            }

            public int getDeliveryHouse() {
                return deliveryHouse;
            }

            public void setDeliveryHouse(int deliveryHouse) {
                this.deliveryHouse = deliveryHouse;
            }

            public int getLat() {
                return lat;
            }

            public void setLat(int lat) {
                this.lat = lat;
            }

            public String getHouseComment() {
                return houseComment;
            }

            public void setHouseComment(String houseComment) {
                this.houseComment = houseComment;
            }
        }

        public static class UserDetailBean {
            private long userId;
            private String realName;
            private int gender;
            private int emailVerified;
            private int provinceId;
            private int cityId;
            private int districtId;
            private int userPoint;
            private int userLevel;
            private int hasOrder;
            private long updateTime;
            private int userPointIncrement;
            private long userPointDate;
            private String mobile;
            private String mobileLocation;
            private int userType;

            public long getUserId() {
                return userId;
            }

            public void setUserId(long userId) {
                this.userId = userId;
            }

            public String getRealName() {
                return realName;
            }

            public void setRealName(String realName) {
                this.realName = realName;
            }

            public int getGender() {
                return gender;
            }

            public void setGender(int gender) {
                this.gender = gender;
            }

            public int getEmailVerified() {
                return emailVerified;
            }

            public void setEmailVerified(int emailVerified) {
                this.emailVerified = emailVerified;
            }

            public int getProvinceId() {
                return provinceId;
            }

            public void setProvinceId(int provinceId) {
                this.provinceId = provinceId;
            }

            public int getCityId() {
                return cityId;
            }

            public void setCityId(int cityId) {
                this.cityId = cityId;
            }

            public int getDistrictId() {
                return districtId;
            }

            public void setDistrictId(int districtId) {
                this.districtId = districtId;
            }

            public int getUserPoint() {
                return userPoint;
            }

            public void setUserPoint(int userPoint) {
                this.userPoint = userPoint;
            }

            public int getUserLevel() {
                return userLevel;
            }

            public void setUserLevel(int userLevel) {
                this.userLevel = userLevel;
            }

            public int getHasOrder() {
                return hasOrder;
            }

            public void setHasOrder(int hasOrder) {
                this.hasOrder = hasOrder;
            }

            public long getUpdateTime() {
                return updateTime;
            }

            public void setUpdateTime(long updateTime) {
                this.updateTime = updateTime;
            }

            public int getUserPointIncrement() {
                return userPointIncrement;
            }

            public void setUserPointIncrement(int userPointIncrement) {
                this.userPointIncrement = userPointIncrement;
            }

            public long getUserPointDate() {
                return userPointDate;
            }

            public void setUserPointDate(long userPointDate) {
                this.userPointDate = userPointDate;
            }

            public String getMobile() {
                return mobile;
            }

            public void setMobile(String mobile) {
                this.mobile = mobile;
            }

            public String getMobileLocation() {
                return mobileLocation;
            }

            public void setMobileLocation(String mobileLocation) {
                this.mobileLocation = mobileLocation;
            }

            public int getUserType() {
                return userType;
            }

            public void setUserType(int userType) {
                this.userType = userType;
            }
        }

        public static class MembersBean {
            private long vendorId;
            private String vendorName;
            private String realName;
            private String nickName;
            private String avatar;
            private String lifePhoto;
            private String signature;
            private int provinceId;
            private int workYear;
            private String goodAt;
            private long updateTime;
            private int bossId;

            public long getVendorId() {
                return vendorId;
            }

            public void setVendorId(long vendorId) {
                this.vendorId = vendorId;
            }

            public String getVendorName() {
                return vendorName;
            }

            public void setVendorName(String vendorName) {
                this.vendorName = vendorName;
            }

            public String getRealName() {
                return realName;
            }

            public void setRealName(String realName) {
                this.realName = realName;
            }

            public String getNickName() {
                return nickName;
            }

            public void setNickName(String nickName) {
                this.nickName = nickName;
            }

            public String getAvatar() {
                return avatar;
            }

            public void setAvatar(String avatar) {
                this.avatar = avatar;
            }

            public String getLifePhoto() {
                return lifePhoto;
            }

            public void setLifePhoto(String lifePhoto) {
                this.lifePhoto = lifePhoto;
            }

            public String getSignature() {
                return signature;
            }

            public void setSignature(String signature) {
                this.signature = signature;
            }

            public int getProvinceId() {
                return provinceId;
            }

            public void setProvinceId(int provinceId) {
                this.provinceId = provinceId;
            }

            public int getWorkYear() {
                return workYear;
            }

            public void setWorkYear(int workYear) {
                this.workYear = workYear;
            }

            public String getGoodAt() {
                return goodAt;
            }

            public void setGoodAt(String goodAt) {
                this.goodAt = goodAt;
            }

            public long getUpdateTime() {
                return updateTime;
            }

            public void setUpdateTime(long updateTime) {
                this.updateTime = updateTime;
            }

            public int getBossId() {
                return bossId;
            }

            public void setBossId(int bossId) {
                this.bossId = bossId;
            }
        }

        public static class ProgressBean {
            private String progressId;
            private String progressName;
            private String progressStatus;
            private String createTime;

            public String getProgressId() {
                return progressId;
            }

            public void setProgressId(String progressId) {
                this.progressId = progressId;
            }

            public String getProgressName() {
                return progressName;
            }

            public void setProgressName(String progressName) {
                this.progressName = progressName;
            }

            public String getProgressStatus() {
                return progressStatus;
            }

            public void setProgressStatus(String progressStatus) {
                this.progressStatus = progressStatus;
            }

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }
        }
    }
}
