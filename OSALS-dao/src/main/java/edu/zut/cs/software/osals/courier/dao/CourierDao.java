package edu.zut.cs.software.osals.courier.dao;

import edu.zut.cs.software.base.dao.GenericDao;
import edu.zut.cs.software.osals.courier.domain.Courier;
import org.springframework.stereotype.Repository;

@Repository("courierDao")
public interface CourierDao extends GenericDao<Courier, Long> {

}
