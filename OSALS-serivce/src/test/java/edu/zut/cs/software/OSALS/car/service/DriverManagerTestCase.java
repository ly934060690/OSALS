package edu.zut.cs.software.OSALS.car.service;

import edu.zut.cs.software.OSALS.driver.domain.Driver;
import edu.zut.cs.software.OSALS.driver.service.DriverManager;
import edu.zut.cs.software.base.service.GenericManagerTestCase;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class DriverManagerTestCase  extends GenericManagerTestCase<Long, Driver, DriverManager> {

    DriverManager driverManager;

    public DriverManagerTestCase() {
        super(Driver.class);
    }

    @Autowired
    public void setDriverManager(DriverManager driverManager) {
        this.driverManager = driverManager;
        this.manager = this.driverManager;
    }

    @Test
    public void testSave(){
        Driver driver = new Driver();
        this.driverManager.save(driver);
    }

}
