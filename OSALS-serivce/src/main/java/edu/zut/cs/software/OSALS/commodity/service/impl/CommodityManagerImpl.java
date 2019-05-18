package edu.zut.cs.software.OSALS.commodity.service.impl;

import edu.zut.cs.software.OSALS.commodity.dao.CommodityDao;
import edu.zut.cs.software.OSALS.commodity.domain.Commodity;
import edu.zut.cs.software.OSALS.commodity.service.CommodityManager;
import edu.zut.cs.software.base.service.impl.GenericManagerImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

/**
 * 
 * @author 研哥哥
 *
 */
@Component
@Transactional
public class CommodityManagerImpl extends GenericManagerImpl<Commodity, Long> implements CommodityManager {

	CommodityDao commodityDao;
	
	@Autowired
	public void setCommodityDao(CommodityDao commodityDao) {
		this.commodityDao = commodityDao;
		this.dao = this.commodityDao;
	}

	@Override
	public List<Commodity> findByCode(String code) {
		Commodity queryObject = new Commodity();
		queryObject.setCode(code);
		queryObject.setDateCreated(null);
		queryObject.setDateModified(null);
		ExampleMatcher exampleMatcher = ExampleMatcher.matching().withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING).withIgnoreCase(true).withMatcher("code", ExampleMatcher.GenericPropertyMatchers.startsWith());
		Example<Commodity> example = Example.of(queryObject, exampleMatcher);
		List<Commodity> result = this.dao.findAll(example);
		return result;
	}

	@Override
	public List<Commodity> findByName(String name) {
		Commodity queryObject = new Commodity();
		queryObject.setName(name);

		queryObject.setDateCreated(null);
		queryObject.setDateModified(null);

//		ExampleMatcher exampleMatcher = ExampleMatcher.matching().withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING).withIgnoreCase(true).withMatcher("name", ExampleMatcher.GenericPropertyMatchers.startsWith());

		ExampleMatcher exampleMatcher = ExampleMatcher.matching().withMatcher("name", ExampleMatcher.GenericPropertyMatchers.startsWith());
		Example<Commodity> example = Example.of(queryObject, exampleMatcher);
		List<Commodity> result = this.dao.findAll(example);
		return result;
	}

	/**
	 * 提供商品价格区间，find符合条件的Commdity存入List中return
	 *
	 * @param minPrice
	 * @param maxPrice
	 */
	@Override
	public List<Commodity> findByPrice(String minPrice, String maxPrice) {
		return null;
	}
}
