package edu.zut.cs.software.OSALS.car.domain;

import edu.zut.cs.software.base.domain.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "t_car")
public class Car  extends BaseEntity {

    @Column(name = "car_num")
    String carNum;
    @Column(name = "car_load")
    String carLoad;

    public String getCarNum() {
        return carNum;
    }

    public void setCarNum(String carNum) {
        this.carNum = carNum;
    }

    public String getCarLoad() {
        return carLoad;
    }

    public void setCarLoad(String carLoad) {
        this.carLoad = carLoad;
    }
}
