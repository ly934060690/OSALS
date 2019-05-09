package edu.zut.cs.software.star.commodity.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.zut.cs.software.base.service.impl.GenericManagerImpl;
import edu.zut.cs.software.star.commodity.dao.CommodityDao;
import edu.zut.cs.software.star.commodity.domain.Commodity;
import edu.zut.cs.software.star.commodity.service.CommodityManager;

/**
 * 
 * @author 研哥哥
 *
 */
@Component
@Transactional
public class CommodityManagerImpl extends GenericManagerImpl<Commodity, Long> implements CommodityManager {

	CommodityDao commodityDao;
	
	@Override
	public Commodity findbyCommodityname(String commodityname) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Autowired
	public void setCommodityDao(CommodityDao commodityDao) {
		this.commodityDao = commodityDao;
		this.dao = this.commodityDao;
	}

}
