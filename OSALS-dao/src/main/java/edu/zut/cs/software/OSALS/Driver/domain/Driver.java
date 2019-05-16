package edu.zut.cs.software.OSALS.Driver.domain;

import edu.zut.cs.software.OSALS.car.domain.Car;
import edu.zut.cs.software.base.domain.BaseEntity;

import javax.persistence.*;


@Entity
@Table(name="T_DRIVER")

public class Driver extends BaseEntity {

    @Column(name = "dri_num")
    String driNum;
    @Column(name = "dri_name")
    String driName;
    @Column(name = "dri_code")
    String driCode;
    @Column(name = "dri_sex")
    String driSex;
    @Column(name = "dri_tel")
    String driTel;
    @ManyToOne
    @JoinColumn(name = "car_id")
    Car car;

    public String getDriNum() {
        return driNum;
    }

    public void setDriNum(String driNum) {
        this.driNum = driNum;
    }

    public String getDriName() {
        return driName;
    }

    public void setDriName(String driName) {
        this.driName = driName;
    }

    public String getDriCode() {
        return driCode;
    }

    public void setDriCode(String driCode) {
        this.driCode = driCode;
    }

    public String getDriSex() {
        return driSex;
    }

    public void setDriSex(String driSex) {
        this.driSex = driSex;
    }

    public String getDriTel() {
        return driTel;
    }

    public void setDriTel(String driTel) {
        this.driTel = driTel;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
