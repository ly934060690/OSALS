package edu.zut.cs.software.osals.car.service;

import edu.zut.cs.software.base.service.GenericManagerTestCase;
import edu.zut.cs.software.osals.car.domain.Driver;
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
