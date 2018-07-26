package com.kingyea.kim.common.model.contactlist;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;

public class UAMApiResult<T> {
    private Integer s ;
    private Integer count ;
    private String m;
    private Date t;
    private List<T> r;

    public Integer getS() {
        return s;
    }

    public void setS(Integer s) {
        this.s = s;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getM() {
        return m;
    }

    public void setM(String m) {
        this.m = m;
    }

    public Date getT() {
        return t;
    }

    public void setT(Date t) {
        this.t = t;
    }

    public List<T> getR() {
        return r;
    }

    public void setR(List<T> r) {
        this.r = r;
    }
}
