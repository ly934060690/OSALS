package edu.zut.cs.software.OSALS.car.service;

import edu.zut.cs.software.OSALS.car.domain.Car;

import edu.zut.cs.software.base.service.GenericTreeManagerTestCase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CarManagerTestCase  extends GenericTreeManagerTestCase<Long, Car, CarManager> {

    private static final Logger logger = LogManager.getLogger(CarManagerTestCase.class.getName());

    CarManager carManager;

    public CarManagerTestCase() {
        super(Car.class);
    }

    @Autowired
    public void setCarManager(CarManager carManager) {
        this.carManager = carManager;
        this.manager = this.carManager;
    }

    @Test
    public void testFindAll() {
        List<Car> result = this.carManager.findAll();
        if (logger.isInfoEnabled()) {
            logger.info("testFindAll() - List<Car> result={}", result); //$NON-NLS-1$
        }
    }
}
