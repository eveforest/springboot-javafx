package com.kingyea.kim.common.model.token;

public class UamToken extends Token {
//    ex.service_ticket:ST1fffea7359c146e493c876b600079066
    private String exServiceTicket;
//    ex.auth_type:jdbc
    private String exAuthType;
//    ex.token:TGT8329678ada4147a181b8afbe8e8787d1
    private String exToken;
//    ex.spec_secret:kdx0h9hf1b6vjc4n7sabsu1a24d4mrapsr0vvn6p9hhsduvvi93ze5pa185idjk8mxr2j5orzsl7brkglthr612nhg4fyycfbstrylykh1tg0ghoo0hp6zdpi7ysxrov
    private String exSpecSecret;
//    ex.spec_secret_expires:27447752246529
    private Long exSpecSecretExpires;
//    ex.oauth_access_token:b8bb0744-fd7c-4760-9646-fa6a2464f654
    private String exOauthAccessToken;
//    mode:ok
    private String mode;
//    ex.oauth_refresh_token:2abeded4-2924-45ea-8ee0-5abf1b76a33c
    private String exOauthRefreshToken;
//    ex.status:1
    private Integer exStatus;
//    identity:even
    private String identity;
//    ex.token_expires:1528302153410
    private Long exTokenExpires;
//    ex.oauth_access_token_expires:43199
    private Integer exOauthAccessTokenExpires;
//    ex.login_session_ticket:AtQ2Yte0Q+2qk7vBCKtU7g==
    private String exLoginSessionTicket;
//    ex.uid:7cafa640-85e3-40ec-8132-75b92006e1cc
    private String exUid;

    public UamToken() {
        this.setAccessToken(this.exOauthAccessToken);
        this.setRefreshToken(this.exOauthRefreshToken);
        this.setTokenType(this.exAuthType);
        this.setExpires(this.exOauthAccessTokenExpires);
    }

    public String getExServiceTicket() {
        return exServiceTicket;
    }

    public void setExServiceTicket(String exServiceTicket) {
        this.exServiceTicket = exServiceTicket;
    }

    public String getExAuthType() {
        return exAuthType;
    }

    public void setExAuthType(String exAuthType) {
        this.exAuthType = exAuthType;
        setTokenType(exAuthType);
    }

    public String getExToken() {
        return exToken;
    }

    public void setExToken(String exToken) {
        this.exToken = exToken;
    }

    public String getExSpecSecret() {
        return exSpecSecret;
    }

    public void setExSpecSecret(String exSpecSecret) {
        this.exSpecSecret = exSpecSecret;
    }

    public Long getExSpecSecretExpires() {
        return exSpecSecretExpires;
    }

    public void setExSpecSecretExpires(Long exSpecSecretExpires) {
        this.exSpecSecretExpires = exSpecSecretExpires;
    }

    public String getExOauthAccessToken() {
        return exOauthAccessToken;
    }

    public void setExOauthAccessToken(String exOauthAccessToken) {
        this.exOauthAccessToken = exOauthAccessToken;
        setAccessToken(exOauthAccessToken);
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getExOauthRefreshToken() {
        return exOauthRefreshToken;
    }

    public void setExOauthRefreshToken(String exOauthRefreshToken) {
        this.exOauthRefreshToken = exOauthRefreshToken;
        setRefreshToken(exOauthRefreshToken);
    }

    public Integer getExStatus() {
        return exStatus;
    }

    public void setExStatus(Integer exStatus) {
        this.exStatus = exStatus;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public Long getExTokenExpires() {
        return exTokenExpires;
    }

    public void setExTokenExpires(Long exTokenExpires) {
        this.exTokenExpires = exTokenExpires;
    }

    public Integer getExOauthAccessTokenExpires() {
        return exOauthAccessTokenExpires;
    }

    public void setExOauthAccessTokenExpires(Integer exOauthAccessTokenExpires) {
        this.exOauthAccessTokenExpires = exOauthAccessTokenExpires;
        setExpires(exOauthAccessTokenExpires);
    }

    public String getExLoginSessionTicket() {
        return exLoginSessionTicket;
    }

    public void setExLoginSessionTicket(String exLoginSessionTicket) {
        this.exLoginSessionTicket = exLoginSessionTicket;
    }

    public String getExUid() {
        return exUid;
    }

    public void setExUid(String exUid) {
        this.exUid = exUid;
    }

}
