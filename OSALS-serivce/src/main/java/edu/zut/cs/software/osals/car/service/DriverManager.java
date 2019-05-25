package edu.zut.cs.software.osals.car.service;

import edu.zut.cs.software.base.service.GenericManager;
import edu.zut.cs.software.osals.car.domain.Driver;

import java.util.List;

public interface DriverManager extends GenericManager<Driver, Long> {
    List<Driver> findAll();

    Driver findDriverByName(String name);

}
