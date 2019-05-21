package edu.zut.cs.software.OSALS.courier.dao;

import edu.zut.cs.software.OSALS.courier.domain.CourierCompany;
import edu.zut.cs.software.base.dao.GenericTreeDao;
import org.springframework.stereotype.Repository;

@Repository("courierCompanyDao")
public interface CourierCompanyDao extends GenericTreeDao<CourierCompany, Long> {

}
