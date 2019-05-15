package edu.zut.cs.software.star.commodity.dao;

import edu.zut.cs.software.base.dao.GenericDao;
import edu.zut.cs.software.star.commodity.domain.Commodity;
import org.springframework.stereotype.Repository;

@Repository("commodityDao")
public interface CommodityDao extends GenericDao<Commodity, Long> {

}
