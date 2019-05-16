package edu.zut.cs.software.OSALS.commodity.service;

import edu.zut.cs.software.OSALS.commodity.domain.Commodity;
import edu.zut.cs.software.base.service.GenericManager;

import java.util.List;

/**
 * 
 * @author 研哥哥
 *
 */
public interface CommodityManager extends GenericManager<Commodity, Long> {

	List<Commodity> findAll();

	Commodity findbyCommodityname(String commodityname);

}
