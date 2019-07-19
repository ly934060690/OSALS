package edu.zut.cs.software.osals.car.service;

import edu.zut.cs.software.base.service.GenericTreeManager;
import edu.zut.cs.software.osals.car.domain.Car;

import java.util.List;

public interface CarManager  extends GenericTreeManager<Car, Long> {
    List<Car> findAll();

    Car findByCarName(String name);

}
