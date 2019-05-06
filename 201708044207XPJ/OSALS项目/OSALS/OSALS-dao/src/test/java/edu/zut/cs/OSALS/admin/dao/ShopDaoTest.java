package edu.zut.cs.OSALS.admin.dao;

import edu.zut.cs.OSALS.admin.domain.Goods;
import edu.zut.cs.OSALS.base.dao.GenericDaoTestCase;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class ShopDaoTest extends GenericDaoTestCase<Long, Goods, GoodsDao> {
	/**
	 * Logger for this class
	 */

	@Autowired
	GoodsDao goodsDao;

	@Test
	public void test() {
		Goods goods = new Goods();
		goods.setName("test_role");
		Goods test_role = this.goodsDao.save(goods);
		Long role_id = test_role.getId();
		Goods result = this.goodsDao.getOne(role_id);
		assertEquals(test_role, result);
		List<Goods> all = this.goodsDao.findAll();
		if (logger.isInfoEnabled()) {
			logger.info("test() - List<Role> all size ={}", all.size()); //$NON-NLS-1$
		}
	}

}
