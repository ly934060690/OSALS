package edu.zut.cs.software.OSALS.car.dao;

import edu.zut.cs.software.OSALS.car.domain.Car;
import edu.zut.cs.software.base.dao.GenericDaoTestCase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CarDaoTest extends GenericDaoTestCase<Long, Car, CarDao> {

    private static final Logger logger = LogManager.getLogger(CarDaoTest.class.getName());

    @Autowired
    CarDao carDao;

    @Test
    public  void getAllCarTest() {
        List<Car> list = this.carDao.findAll();
        if (logger.isInfoEnabled()) {
            logger.info("testFindAll() - List<Commodity> all={}", list); //$NON-NLS-1$
        }
    }

}
