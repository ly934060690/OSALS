package edu.zut.cs.software.OSALS.shop.service.impl;

import edu.zut.cs.software.OSALS.shop.dao.ShopDao;
import edu.zut.cs.software.OSALS.shop.domain.Shop;
import edu.zut.cs.software.base.service.impl.GenericTreeManagerImpl;
import edu.zut.cs.software.OSALS.shop.service.ShopManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

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
