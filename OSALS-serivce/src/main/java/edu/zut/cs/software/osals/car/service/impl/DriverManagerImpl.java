package edu.zut.cs.software.osals.car.service.impl;

import edu.zut.cs.software.base.service.impl.GenericManagerImpl;
import edu.zut.cs.software.osals.car.dao.DriverDao;
import edu.zut.cs.software.osals.car.domain.Driver;
import edu.zut.cs.software.osals.car.service.DriverManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
@Transactional
public class DriverManagerImpl extends GenericManagerImpl<Driver, Long> implements DriverManager {

    DriverDao driverDao;

    @Override
    public Driver findDriverByName(String name) {

        return null;
    }

    @Autowired
    public void setDriverDao(DriverDao driverDao) {
        this.driverDao = driverDao;
        this.dao = this.driverDao;
    }


}
