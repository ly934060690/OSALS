package edu.zut.cs.software.OSALS.car.service;

import edu.zut.cs.software.OSALS.car.domain.Driver;
import edu.zut.cs.software.base.service.GenericManager;

import java.util.List;

public interface DriverManager extends GenericManager<Driver, Long> {
    List<Driver> findAll();

    Driver findDriverByName(String name);

}
