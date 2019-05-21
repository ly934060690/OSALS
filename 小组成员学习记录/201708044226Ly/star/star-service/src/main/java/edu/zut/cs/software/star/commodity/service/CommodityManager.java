package edu.zut.cs.software.star.commodity.service;

import java.util.List;

import edu.zut.cs.software.base.service.GenericManager;
import edu.zut.cs.software.star.commodity.domain.Commodity;

/**
 * 
 * @author 研哥哥
 *
 */
public interface CommodityManager extends GenericManager<Commodity, Long> {

	List<Commodity> findAll();
	
	Commodity findbyCommodityname(String commodityname);
	
}
