package edu.zut.cs.software.osals.courier.dao;

import edu.zut.cs.software.base.dao.GenericTreeDao;
import edu.zut.cs.software.osals.courier.domain.CourierCompany;
import org.springframework.stereotype.Repository;

@Repository("courierCompanyDao")
public interface CourierCompanyDao extends GenericTreeDao<CourierCompany, Long> {

}
