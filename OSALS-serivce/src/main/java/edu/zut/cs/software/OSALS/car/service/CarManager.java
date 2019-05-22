package edu.zut.cs.software.OSALS.car.service;

import edu.zut.cs.software.OSALS.car.domain.Car;
import edu.zut.cs.software.base.service.GenericTreeManager;

import java.util.List;

public interface CarManager  extends GenericTreeManager<Car, Long> {
    List<Car> findAll();

    Car findByCarName(String name);

}
