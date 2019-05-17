package edu.zut.cs.software.OSALS.car.domain;

import edu.zut.cs.software.OSALS.driver.domain.Driver;
import edu.zut.cs.software.base.domain.BaseTreeEntity;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name = "T_CAR")
@NamedQueries({@NamedQuery(name="Car.getRoot",query = "select c from Car c where c.parent is null")})
public class Car  extends BaseTreeEntity<Car>{

    @Column(name = "car_num")
    String carNum;
    @Column(name = "car_load")
    String carLoad;

    @OneToMany(mappedBy = "car", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    Set<Driver> drivers;

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
