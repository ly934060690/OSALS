package edu.zut.cs.software.OSALS.car.service.impl;

import edu.zut.cs.software.OSALS.car.dao.DriverDao;
import edu.zut.cs.software.OSALS.car.domain.Driver;
import edu.zut.cs.software.OSALS.car.service.DriverManager;
import edu.zut.cs.software.base.service.impl.GenericManagerImpl;
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
