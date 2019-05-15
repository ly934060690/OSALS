package edu.zut.cs.software.OSALS.commodity.service.impl;

import edu.zut.cs.software.OSALS.commodity.dao.CommodityDao;
import edu.zut.cs.software.OSALS.commodity.domain.Commodity;
import edu.zut.cs.software.OSALS.commodity.service.CommodityManager;
import edu.zut.cs.software.base.service.impl.GenericManagerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

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
