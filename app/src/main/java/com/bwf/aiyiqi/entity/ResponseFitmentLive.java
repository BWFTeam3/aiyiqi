package com.bwf.aiyiqi.entity;

import java.util.List;

/**
 * Created by Administrator on 2016/11/23.
 */

public class ResponseFitmentLive {

    /**
     * code : 0
     * message : success
     */

    private BaseOutputBean baseOutput;
    /**
     * buildingSite : {"buildingId":1551771172698333187,"statusId":0,"progressId":1,"acceptanceProgressId":0,"orderId":1551771172698333187,"createTime":1479888057000,"updateTime":1479888057000,"userId":1550970011069202532,"startDisclosure":1,"startDisclosureTime":1479901377515,"splitAlter":0,"splitAlterTime":1479901377515,"waterElectricity":0,"waterElectricityTime":1479901377515,"cementWood":0,"cementWoodTime":1479901377515,"paString":0,"paStringTime":1479901377515,"installation":0,"installationTime":1479901377515,"finish":0,"finishTime":1479901377515,"buildingIdStr":"1551771172698333187","acceptanceStatus":0,"bespeakExpired":0,"messageNumber":1,"scheduleStatus":0,"isShow":1}
     * orderHouse : {"orderId":1551771172698333187,"layout":"二居室","area":"60","doorplate":"64343","community":"虹口区","address":"宝钢测试","newHouse":0,"deliveryHouse":2,"lat":0,"houseComment":"明楼"}
     * userDetail : {"userId":1550970011069202532,"realName":"bg-2","nickName":"bg-2","avatar":"http://bbs.17house.com/uc_server/avatar.php?uid=1627562&size=big","gender":0,"email":"15221944349@none.com","emailVerified":0,"provinceId":0,"cityId":0,"districtId":0,"userPoString":2510,"userLevel":0,"hasOrder":0,"updateTime":1479890515000,"userPoStringIncrement":10,"userPoStringDate":1479883779000,"mobile":"15221944349","userType":1,"bgCardNum":"55555000005"}
     * imageUrl : http://apptest-picture.oss-cn-beijing.aliyuncs.com/yiqizhuagnxiu-gongdizhibo/tu10.png
     * latestTrackProgressId : 0
     */

    private List<DataBean> data;

    public BaseOutputBean getBaseOutput() {
        return baseOutput;
    }

    public void setBaseOutput(BaseOutputBean baseOutput) {
        this.baseOutput = baseOutput;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class BaseOutputBean {
        private String code;
        private String message;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
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
         * buildingId : 1551771172698333187
         * statusId : 0
         * progressId : 1
         * acceptanceProgressId : 0
         * orderId : 1551771172698333187
         * createTime : 1479888057000
         * updateTime : 1479888057000
         * userId : 1550970011069202532
         * startDisclosure : 1
         * startDisclosureTime : 1479901377515
         * splitAlter : 0
         * splitAlterTime : 1479901377515
         * waterElectricity : 0
         * waterElectricityTime : 1479901377515
         * cementWood : 0
         * cementWoodTime : 1479901377515
         * paString : 0
         * paStringTime : 1479901377515
         * installation : 0
         * installationTime : 1479901377515
         * finish : 0
         * finishTime : 1479901377515
         * buildingIdStr : 1551771172698333187
         * acceptanceStatus : 0
         * bespeakExpired : 0
         * messageNumber : 1
         * scheduleStatus : 0
         * isShow : 1
         */

        private BuildingSiteBean buildingSite;
        /**
         * orderId : 1551771172698333187
         * layout : 二居室
         * area : 60
         * doorplate : 64343
         * community : 虹口区
         * address : 宝钢测试
         * newHouse : 0
         * deliveryHouse : 2
         * lat : 0
         * houseComment : 明楼
         */

        private OrderHouseBean orderHouse;
        /**
         * userId : 1550970011069202532
         * realName : bg-2
         * nickName : bg-2
         * avatar : http://bbs.17house.com/uc_server/avatar.php?uid=1627562&size=big
         * gender : 0
         * email : 15221944349@none.com
         * emailVerified : 0
         * provinceId : 0
         * cityId : 0
         * districtId : 0
         * userPoString : 2510
         * userLevel : 0
         * hasOrder : 0
         * updateTime : 1479890515000
         * userPoStringIncrement : 10
         * userPoStringDate : 1479883779000
         * mobile : 15221944349
         * userType : 1
         * bgCardNum : 55555000005
         */

        private UserDetailBean userDetail;
        private String imageUrl;
        private String latestTrackProgressId;

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

        public String getLatestTrackProgressId() {
            return latestTrackProgressId;
        }

        public void setLatestTrackProgressId(String latestTrackProgressId) {
            this.latestTrackProgressId = latestTrackProgressId;
        }

        public static class BuildingSiteBean {
            private String buildingId;
            private String statusId;
            private String progressId;
            private String acceptanceProgressId;
            private long orderId;
            private long createTime;
            private long updateTime;
            private long userId;
            private String startDisclosure;
            private long startDisclosureTime;
            private String splitAlter;
            private long splitAlterTime;
            private String waterElectricity;
            private long waterElectricityTime;
            private String cementWood;
            private long cementWoodTime;
            private String paString;
            private long paStringTime;
            private String installation;
            private long installationTime;
            private String finish;
            private long finishTime;
            private String buildingIdStr;
            private String acceptanceStatus;
            private String bespeakExpired;
            private String messageNumber;
            private String scheduleStatus;
            private String isShow;

            public String getBuildingId() {
                return buildingId;
            }

            public void setBuildingId(String buildingId) {
                this.buildingId = buildingId;
            }

            public String getStatusId() {
                return statusId;
            }

            public void setStatusId(String statusId) {
                this.statusId = statusId;
            }

            public String getProgressId() {
                return progressId;
            }

            public void setProgressId(String progressId) {
                this.progressId = progressId;
            }

            public String getAcceptanceProgressId() {
                return acceptanceProgressId;
            }

            public void setAcceptanceProgressId(String acceptanceProgressId) {
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

            public String getStartDisclosure() {
                return startDisclosure;
            }

            public void setStartDisclosure(String startDisclosure) {
                this.startDisclosure = startDisclosure;
            }

            public long getStartDisclosureTime() {
                return startDisclosureTime;
            }

            public void setStartDisclosureTime(long startDisclosureTime) {
                this.startDisclosureTime = startDisclosureTime;
            }

            public String getSplitAlter() {
                return splitAlter;
            }

            public void setSplitAlter(String splitAlter) {
                this.splitAlter = splitAlter;
            }

            public long getSplitAlterTime() {
                return splitAlterTime;
            }

            public void setSplitAlterTime(long splitAlterTime) {
                this.splitAlterTime = splitAlterTime;
            }

            public String getWaterElectricity() {
                return waterElectricity;
            }

            public void setWaterElectricity(String waterElectricity) {
                this.waterElectricity = waterElectricity;
            }

            public long getWaterElectricityTime() {
                return waterElectricityTime;
            }

            public void setWaterElectricityTime(long waterElectricityTime) {
                this.waterElectricityTime = waterElectricityTime;
            }

            public String getCementWood() {
                return cementWood;
            }

            public void setCementWood(String cementWood) {
                this.cementWood = cementWood;
            }

            public long getCementWoodTime() {
                return cementWoodTime;
            }

            public void setCementWoodTime(long cementWoodTime) {
                this.cementWoodTime = cementWoodTime;
            }

            public String getPaString() {
                return paString;
            }

            public void setPaString(String paString) {
                this.paString = paString;
            }

            public long getPaStringTime() {
                return paStringTime;
            }

            public void setPaStringTime(long paStringTime) {
                this.paStringTime = paStringTime;
            }

            public String getInstallation() {
                return installation;
            }

            public void setInstallation(String installation) {
                this.installation = installation;
            }

            public long getInstallationTime() {
                return installationTime;
            }

            public void setInstallationTime(long installationTime) {
                this.installationTime = installationTime;
            }

            public String getFinish() {
                return finish;
            }

            public void setFinish(String finish) {
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

            public String getAcceptanceStatus() {
                return acceptanceStatus;
            }

            public void setAcceptanceStatus(String acceptanceStatus) {
                this.acceptanceStatus = acceptanceStatus;
            }

            public String getBespeakExpired() {
                return bespeakExpired;
            }

            public void setBespeakExpired(String bespeakExpired) {
                this.bespeakExpired = bespeakExpired;
            }

            public String getMessageNumber() {
                return messageNumber;
            }

            public void setMessageNumber(String messageNumber) {
                this.messageNumber = messageNumber;
            }

            public String getScheduleStatus() {
                return scheduleStatus;
            }

            public void setScheduleStatus(String scheduleStatus) {
                this.scheduleStatus = scheduleStatus;
            }

            public String getIsShow() {
                return isShow;
            }

            public void setIsShow(String isShow) {
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
            private String newHouse;
            private String deliveryHouse;
            private String lat;
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

            public String getNewHouse() {
                return newHouse;
            }

            public void setNewHouse(String newHouse) {
                this.newHouse = newHouse;
            }

            public String getDeliveryHouse() {
                return deliveryHouse;
            }

            public void setDeliveryHouse(String deliveryHouse) {
                this.deliveryHouse = deliveryHouse;
            }

            public String getLat() {
                return lat;
            }

            public void setLat(String lat) {
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
            private String nickName;
            private String avatar;
            private String gender;
            private String email;
            private String emailVerified;
            private String provinceId;
            private String cityId;
            private String districtId;
            private String userPoString;
            private String userLevel;
            private String hasOrder;
            private long updateTime;
            private String userPoStringIncrement;
            private long userPoStringDate;
            private String mobile;
            private String userType;
            private String bgCardNum;

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

            public String getGender() {
                return gender;
            }

            public void setGender(String gender) {
                this.gender = gender;
            }

            public String getEmail() {
                return email;
            }

            public void setEmail(String email) {
                this.email = email;
            }

            public String getEmailVerified() {
                return emailVerified;
            }

            public void setEmailVerified(String emailVerified) {
                this.emailVerified = emailVerified;
            }

            public String getProvinceId() {
                return provinceId;
            }

            public void setProvinceId(String provinceId) {
                this.provinceId = provinceId;
            }

            public String getCityId() {
                return cityId;
            }

            public void setCityId(String cityId) {
                this.cityId = cityId;
            }

            public String getDistrictId() {
                return districtId;
            }

            public void setDistrictId(String districtId) {
                this.districtId = districtId;
            }

            public String getUserPoString() {
                return userPoString;
            }

            public void setUserPoString(String userPoString) {
                this.userPoString = userPoString;
            }

            public String getUserLevel() {
                return userLevel;
            }

            public void setUserLevel(String userLevel) {
                this.userLevel = userLevel;
            }

            public String getHasOrder() {
                return hasOrder;
            }

            public void setHasOrder(String hasOrder) {
                this.hasOrder = hasOrder;
            }

            public long getUpdateTime() {
                return updateTime;
            }

            public void setUpdateTime(long updateTime) {
                this.updateTime = updateTime;
            }

            public String getUserPoStringIncrement() {
                return userPoStringIncrement;
            }

            public void setUserPoStringIncrement(String userPoStringIncrement) {
                this.userPoStringIncrement = userPoStringIncrement;
            }

            public long getUserPoStringDate() {
                return userPoStringDate;
            }

            public void setUserPoStringDate(long userPoStringDate) {
                this.userPoStringDate = userPoStringDate;
            }

            public String getMobile() {
                return mobile;
            }

            public void setMobile(String mobile) {
                this.mobile = mobile;
            }

            public String getUserType() {
                return userType;
            }

            public void setUserType(String userType) {
                this.userType = userType;
            }

            public String getBgCardNum() {
                return bgCardNum;
            }

            public void setBgCardNum(String bgCardNum) {
                this.bgCardNum = bgCardNum;
            }
        }
    }
}
