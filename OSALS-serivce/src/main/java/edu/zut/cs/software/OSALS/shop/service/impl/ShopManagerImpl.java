package edu.zut.cs.software.OSALS.shop.service.impl;

import edu.zut.cs.software.OSALS.shop.dao.ShopDao;
import edu.zut.cs.software.OSALS.shop.domain.Shop;
import edu.zut.cs.software.base.service.impl.GenericTreeManagerImpl;
import edu.zut.cs.software.OSALS.shop.service.ShopManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * 注释待注解
 * @author 研哥哥
 *
 */
@Service("shopManager")
@Transactional
public class ShopManagerImpl extends GenericTreeManagerImpl<Shop, Long> implements ShopManager {

	ShopDao shopDao;

	@Autowired
	public void setShopDao(ShopDao shopDao) {
		this.shopDao = shopDao;
		this.treeDao = this.shopDao;
		this.dao = this.treeDao;
	}

	@Override
	public List<Shop> findByCode(String code) {
		Shop queryObject = new Shop();
		queryObject.setCode(code);
		queryObject.setDateCreated(null);
		queryObject.setDateModified(null);
		ExampleMatcher exampleMatcher = ExampleMatcher.matching().withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING).withIgnoreCase(true).withMatcher("code", ExampleMatcher.GenericPropertyMatchers.startsWith());
		Example<Shop> example = Example.of(queryObject, exampleMatcher);
		List<Shop> result = this.dao.findAll(example);
		return result;
	}

	@Override
	public List<Shop> findByName(String name) {
		Shop queryObject = new Shop();
		queryObject.setName(name);
		ExampleMatcher exampleMatcher = ExampleMatcher.matching().withMatcher("name", ExampleMatcher.GenericPropertyMatchers.startsWith()).withIgnorePaths("dateCreated", "dateModified");
		Example<Shop> example = Example.of(queryObject, exampleMatcher);
		List<Shop> result = this.dao.findAll(example);
		return result;

	}

}
