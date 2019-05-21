package edu.zut.cs.software.OSALS.courier.dao;


import edu.zut.cs.software.OSALS.courier.domain.Courier;

import edu.zut.cs.software.base.dao.GenericDao;
import org.springframework.stereotype.Repository;

@Repository("courierDao")
public interface CourierDao extends GenericDao<Courier, Long> {

}
