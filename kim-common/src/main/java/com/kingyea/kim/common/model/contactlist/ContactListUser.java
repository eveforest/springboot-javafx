package com.kingyea.kim.common.model.contactlist;

import com.kingyea.kim.common.model.user.User;

import java.util.Arrays;

public class ContactListUser {
    private User user;
    private Integer isEnable;
    private String[] keyword;
    private Integer secretLevel;
    private String eCode;
    private Integer isFriend;
    private String avatar;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getIsEnable() {
        return isEnable;
    }

    public void setIsEnable(Integer isEnable) {
        this.isEnable = isEnable;
    }

    public String[] getKeyword() {
        return keyword;
    }

    public void setKeyword(String[] keyword) {
        this.keyword = keyword;
    }

    public Integer getSecretLevel() {
        return secretLevel;
    }

    public void setSecretLevel(Integer secretLevel) {
        this.secretLevel = secretLevel;
    }

    public String geteCode() {
        return eCode;
    }

    public void seteCode(String eCode) {
        this.eCode = eCode;
    }

    public Integer getIsFriend() {
        return isFriend;
    }

    public void setIsFriend(Integer isFriend) {
        this.isFriend = isFriend;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @Override
    public String toString() {
        return "ContactListUser{" +
                "user=" + user +
                ", isEnable=" + isEnable +
                ", keyword=" + Arrays.toString(keyword) +
                ", secretLevel=" + secretLevel +
                ", eCode='" + eCode + '\'' +
                ", isFriend=" + isFriend +
                ", avatar='" + avatar + '\'' +
                '}';
    }
}
