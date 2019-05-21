package edu.zut.cs.software.OSALS.car.dao;

import edu.zut.cs.software.OSALS.car.domain.Car;
import edu.zut.cs.software.base.dao.GenericTreeDao;
import org.springframework.stereotype.Repository;

@Repository("carDao")
public interface CarDao extends GenericTreeDao<Car, Long> {
}
