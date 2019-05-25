package edu.zut.cs.software.osals.car.dao;

import edu.zut.cs.software.base.dao.GenericDao;
import edu.zut.cs.software.osals.car.domain.Driver;
import org.springframework.stereotype.Repository;

@Repository("driverDao")
public interface DriverDao extends GenericDao<Driver, Long> {

}
