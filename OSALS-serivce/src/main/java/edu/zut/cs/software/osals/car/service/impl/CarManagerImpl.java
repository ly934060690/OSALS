package edu.zut.cs.software.osals.car.service.impl;

import edu.zut.cs.software.base.service.impl.GenericTreeManagerImpl;
import edu.zut.cs.software.osals.car.dao.CarDao;
import edu.zut.cs.software.osals.car.domain.Car;
import edu.zut.cs.software.osals.car.service.CarManager;
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
        this.treeDao = this.carDao;
        this.dao = this.treeDao;
    }
}
