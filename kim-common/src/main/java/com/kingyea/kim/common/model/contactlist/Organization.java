package com.kingyea.kim.common.model.contactlist;

public class Organization {
//        "orgId": "4666bfdf-50f4-11e4-a123-d00d4e0f91a5",
    private String orgId;
//        "name": "外部企业",
    private String name;
//        "orgNum": "EXTERNAL_ENTERPRISE",
    private String orgNum;
//        "fullName": "外部企业",
    private String fullName;
//        "orderNo": 1000,
    private Integer orderNo;
//        "notes": "外部企业用户",
    private String notes;
//        "lastUpdatedDate": 1412995501000,
    private Long lastUpdatedDate;
//        "enableChat": 0,
    private Integer enableChat;
//        "isDeleted": false,
    private boolean isDeleted;
//        "keyword": "waibuqiye,wbqy",
    private String keyword;
//        "eCode": "bingosoft"
    private String eCode;

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrgNum() {
        return orgNum;
    }

    public void setOrgNum(String orgNum) {
        this.orgNum = orgNum;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Integer getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Integer orderNo) {
        this.orderNo = orderNo;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Long getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    public void setLastUpdatedDate(Long lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }

    public Integer getEnableChat() {
        return enableChat;
    }

    public void setEnableChat(Integer enableChat) {
        this.enableChat = enableChat;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String geteCode() {
        return eCode;
    }

    public void seteCode(String eCode) {
        this.eCode = eCode;
    }
}
