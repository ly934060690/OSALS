package edu.zut.cs.software.OSALS.shop.dao;

import edu.zut.cs.software.base.dao.GenericDao;
import edu.zut.cs.software.OSALS.shop.domain.Commodity;
import org.springframework.stereotype.Repository;

@Repository("commodityDao")
public interface CommodityDao extends GenericDao<Commodity, Long> {

}
