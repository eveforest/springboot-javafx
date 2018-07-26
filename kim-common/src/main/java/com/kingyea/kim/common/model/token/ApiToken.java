package com.kingyea.kim.common.model.token;

public class ApiToken extends Token {
    private String scope;
    private Integer expiresIn;

    public ApiToken() {
        this.setExpires(expiresIn);
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public Integer getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(Integer expiresIn) {
        this.expiresIn = expiresIn;
        setExpires(expiresIn);
    }

    @Override
    public String toString() {
        return "ApiToken{" +
                "scope='" + scope + '\'' +
                ", expiresIn=" + expiresIn +
                '}';
    }
}
