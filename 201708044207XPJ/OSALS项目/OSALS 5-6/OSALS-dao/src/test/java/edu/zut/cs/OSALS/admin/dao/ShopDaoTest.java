package edu.zut.cs.OSALS.admin.dao;

import edu.zut.cs.OSALS.admin.domain.Shop;
import edu.zut.cs.OSALS.base.dao.GenericTreeDaoTestCase;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertEquals;


public class ShopDaoTest extends GenericTreeDaoTestCase<Long, Shop, ShopDao> {

	ShopDao shopDao;

	@Autowired
	public void setGroupDao(ShopDao shopDao) {
		this.shopDao = shopDao;
		this.dao = this.shopDao;
	}

	@Test
	//@Rollback(true)                                             //事务回滚,并且此处好像并没有事务回滚
	public void testGetRoot() {
		int root_size = 10;
		for (int i = 0; i < root_size; i++) {
			Shop shop = new Shop();
			shop.setName("shop_" + i);
			for (int j = 0; j < 10; j++) {
				Shop s = new Shop();
				s.setName("shop_" + i + "_" + j);
				s.setParent(shop);
			}
			this.shopDao.save(shop);
		}

		List<Shop> roots = this.shopDao.getRoot();
		assertEquals(root_size, roots.size());						//断言

		if (logger.isInfoEnabled()) {
			logger.info("testGetRoot() - List<Shop> roots=" + roots); //$NON-NLS-1$
		}
	}

}
