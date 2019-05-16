package edu.zut.cs.software.OSALS.driver.service;

import edu.zut.cs.software.OSALS.Driver.domain.Driver;
import edu.zut.cs.software.base.service.GenericManager;

import java.util.List;

public interface DriverManager extends GenericManager<Driver, Long> {
    List<Driver> findAll();

    Driver findDriverByName(String name);

}
