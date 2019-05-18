package edu.zut.cs.software.OSALS.commodity.dao;

import edu.zut.cs.software.base.dao.GenericDao;
import edu.zut.cs.software.OSALS.commodity.domain.Commodity;
import org.springframework.stereotype.Repository;

@Repository("commodityDao")
public interface CommodityDao extends GenericDao<Commodity, Long> {

}
