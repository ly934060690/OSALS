package com.smart.domain;

import java.io.Serializable;

public class Courier implements Serializable {
    private String CourierName;
    private String CourierNum;
    private String phone;
    private String sex;
    private String adress;

    public String getCourierName() {
        return CourierName;
    }

    public void setCourierName(String courierName) {
        CourierName = courierName;
    }

    public String getCourierNum() {
        return CourierNum;
    }

    public void setCourierNum(String courierNum) {
        CourierNum = courierNum;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }
}
