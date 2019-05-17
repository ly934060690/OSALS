package edu.zut.cs.software.OSALS.driver.dao;

import edu.zut.cs.software.OSALS.driver.domain.Driver;
import edu.zut.cs.software.base.dao.GenericDao;
import org.springframework.stereotype.Repository;

@Repository("driverDao")
public interface DriverDao extends GenericDao<Driver, Long> {

}
