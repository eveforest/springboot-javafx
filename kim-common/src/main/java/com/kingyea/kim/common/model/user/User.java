package com.kingyea.kim.common.model.user;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Mr.Lin
 * @version v1.0.0
 * @description User 实体类
 * 用户表
 * @date Created in 2018-03-30 15:28:58
 */
public class User implements Serializable {

    /**
     * id
     */
    private Integer id;
    /**
     * 用户唯一标识
     */
    private String userId;
    /**
     * 组织ID
     */
    private Integer orgId;
    /**
     * 组织唯一标识
     */
    private String orgSerialNo;
    /**
     * 用户名
     */
    private String name;
    /**
     * 用户编号，公安行业表示 警号
     */
    private String userNum;
    /**
     * 登陆名
     */
    private String loginId;
    /**
     * 头像
     */
    private String picture;
    /**
     * 身份证
     */
    private String idCard;
    /**
     * 出生年月
     */
    private Date birthday;
    /**
     * 密码
     */
    private String password;
    /**
     * 民族
     */
    private String nationality;
    /**
     * 名字简拼：每个字的首字母，查询时用
     */
    private String namePy;
    /**
     * 名字拼音
     */
    private String namePinyin;
    /**
     * 性别，0：未定义，1：男，2：女
     */
    private Integer sex;
    /**
     * 显示顺序，数字小在前面
     */
    private Integer orderNo;
    /**
     * 移动电话
     */
    private String mobile;
    /**
     * 手机号2
     */
    private String mobile2;
    /**
     * 手机号3
     */
    private String mobile3;
    /**
     * 办公电话
     */
    private String telephone;
    /**
     * 邮件
     */
    private String email;
    /**
     * 传真
     */
    private String fax;
    /**
     * 家庭住址
     */
    private String address;
    /**
     * 描述
     */
    private String description;
    /**
     * 用户标签，逗号隔开字符串
     */
    private String lable;
    /**
     * 用户状态，0:禁用，1:启用，2:未审核
     */
    private Integer status;
    /**
     * 用户类型，1 内部用户 2 其他用户，公安内部用户也就是公安用户
     */
    private String type;
    /**
     * 1 编制 2 合同 3第三方
     */
    private String hireWay;
    /**
     * 职务类别，例如：民警，刑警，特警，清洁工，IT工程师
     */
    private String jobCategory;
    /**
     * 是否修改密码(0 默认，还未修改密码 1 已经修改密码)
     */
    private Integer isInit;
    /**
     * 创建人
     */
    private String createdBy;
    /**
     * 创建时间
     */
    private Date createdDate;
    /**
     * 最后更新人
     */
    private String lastUpdatedBy;
    /**
     * 最后更新时间
     */
    private Date lastUpdatedDate;
    /**
     * 删除标识，1是 0否
     */
    private Integer isDeleted;
    /**
     * 数据来源对应的系统中用户的唯一ID
     */
    private String sourceId;
    /**
     * 数据来源（hr:HR，self：自增数据，jz:警综）
     */
    private String source;


    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getOrgId() {
        return this.orgId;
    }

    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }

    public String getOrgSerialNo() {
        return this.orgSerialNo;
    }

    public void setOrgSerialNo(String orgSerialNo) {
        this.orgSerialNo = orgSerialNo;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserNum() {
        return this.userNum;
    }

    public void setUserNum(String userNum) {
        this.userNum = userNum;
    }

    public String getLoginId() {
        return this.loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getPicture() {
        return this.picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getIdCard() {
        return this.idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public Date getBirthday() {
        return this.birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNationality() {
        return this.nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getNamePy() {
        return this.namePy;
    }

    public void setNamePy(String namePy) {
        this.namePy = namePy;
    }

    public String getNamePinyin() {
        return this.namePinyin;
    }

    public void setNamePinyin(String namePinyin) {
        this.namePinyin = namePinyin;
    }

    public Integer getSex() {
        return this.sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getOrderNo() {
        return this.orderNo;
    }

    public void setOrderNo(Integer orderNo) {
        this.orderNo = orderNo;
    }

    public String getMobile() {
        return this.mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getMobile2() {
        return this.mobile2;
    }

    public void setMobile2(String mobile2) {
        this.mobile2 = mobile2;
    }

    public String getMobile3() {
        return this.mobile3;
    }

    public void setMobile3(String mobile3) {
        this.mobile3 = mobile3;
    }

    public String getTelephone() {
        return this.telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFax() {
        return this.fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLable() {
        return this.lable;
    }

    public void setLable(String lable) {
        this.lable = lable;
    }

    public Integer getStatus() {
        return this.status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getHireWay() {
        return this.hireWay;
    }

    public void setHireWay(String hireWay) {
        this.hireWay = hireWay;
    }

    public String getJobCategory() {
        return this.jobCategory;
    }

    public void setJobCategory(String jobCategory) {
        this.jobCategory = jobCategory;
    }

    public Integer getIsInit() {
        return this.isInit;
    }

    public void setIsInit(Integer isInit) {
        this.isInit = isInit;
    }

    public String getCreatedBy() {
        return this.createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedDate() {
        return this.createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getLastUpdatedBy() {
        return this.lastUpdatedBy;
    }

    public void setLastUpdatedBy(String lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public Date getLastUpdatedDate() {
        return this.lastUpdatedDate;
    }

    public void setLastUpdatedDate(Date lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }

    public Integer getIsDeleted() {
        return this.isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    public String getSourceId() {
        return this.sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    public String getSource() {
        return this.source;
    }

    public void setSource(String source) {
        this.source = source;
    }


}
