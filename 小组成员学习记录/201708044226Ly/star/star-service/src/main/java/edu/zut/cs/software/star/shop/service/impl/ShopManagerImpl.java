package edu.zut.cs.software.star.shop.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.zut.cs.software.base.service.impl.GenericTreeManagerImpl;
import edu.zut.cs.software.star.shop.dao.ShopDao;
import edu.zut.cs.software.star.shop.domain.Shop;
import edu.zut.cs.software.star.shop.service.ShopManager;

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
	
	
}
