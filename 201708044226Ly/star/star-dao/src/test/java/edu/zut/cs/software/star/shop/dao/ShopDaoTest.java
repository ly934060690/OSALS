package edu.zut.cs.software.star.shop.dao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import edu.zut.cs.software.base.dao.GenericTreeDaoTestCase;
import edu.zut.cs.software.star.shop.domain.Shop;

/**
 * 
 * 事务回滚
 * @author 研哥哥
 *
 */
public class ShopDaoTest extends GenericTreeDaoTestCase<Long, Shop, ShopDao> {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = LogManager.getLogger(ShopDaoTest.class.getName());

	ShopDao shopDao;

	@Autowired
	public void setShopDao(ShopDao shopDao) {
		this.shopDao = shopDao;
		this.dao = this.shopDao;
	}
	
	@Test
	//@Rollback(false)
	public void testGetRoot() {
		int root_size = 10;
		for(int i = 0; i < root_size; i++) {
			Shop shop = new Shop();
			shop.setName("shop_" + i);
			for(int j = 0; j < 10; j++) {
				Shop s = new Shop();
				s.setName("shop_" + i + "_" + j);
				s.setParent(shop);
			}
			this.shopDao.save(shop);
		}
		
		List<Shop> roots = this.shopDao.getRoot();
		assertEquals(root_size, roots.size());
		if (logger.isInfoEnabled()) {
			logger.info("testGetRoot() - List<Shop> roots={}", roots); //$NON-NLS-1$
		}

		
	}
	
}
