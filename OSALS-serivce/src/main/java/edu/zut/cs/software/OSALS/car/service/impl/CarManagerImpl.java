package edu.zut.cs.software.OSALS.car.service.impl;

import edu.zut.cs.software.OSALS.car.dao.CarDao;
import edu.zut.cs.software.OSALS.car.domain.Car;
import edu.zut.cs.software.OSALS.car.service.CarManager;
import edu.zut.cs.software.base.service.impl.GenericTreeManagerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service("CarManager")
@Transactional
public class CarManagerImpl extends GenericTreeManagerImpl<Car, Long> implements CarManager {
    CarDao carDao;

    @Override
    public Car findByCarName(String name) {
        // TODO Auto-generated method stub
        return null;
    }

    @Autowired
    public void setCarDao(CarDao carDao) {
        this.carDao = carDao;
        this.dao = this.carDao;
    }
}
