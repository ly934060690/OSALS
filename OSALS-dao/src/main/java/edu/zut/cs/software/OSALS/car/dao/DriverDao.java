package edu.zut.cs.software.OSALS.car.dao;

import edu.zut.cs.software.OSALS.car.domain.Driver;
import edu.zut.cs.software.base.dao.GenericDao;
import org.springframework.stereotype.Repository;

@Repository("driverDao")
public interface DriverDao extends GenericDao<Driver, Long> {

}
