package edu.zut.cs.software.osals.car.dao;

import edu.zut.cs.software.base.dao.GenericTreeDao;
import edu.zut.cs.software.osals.car.domain.Car;
import org.springframework.stereotype.Repository;

@Repository("carDao")
public interface CarDao extends GenericTreeDao<Car, Long> {
}
