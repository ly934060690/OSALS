package edu.zut.cs.OSALS.admin.dao;

import edu.zut.cs.OSALS.admin.domain.Goods;
import edu.zut.cs.OSALS.base.dao.GenericDaoTestCase;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class GoodsDaoTest extends GenericDaoTestCase<Long, Goods, GoodsDao> {
	/**
	 * Logger for this class
	 */

	@Autowired
	GoodsDao goodsDao;

	@Test
	//@Rollback(false)
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

	@Test
	@Rollback(false)
	public void testGoodsDao(){
		Goods goods = new Goods();
		goods.setName("《既已选择，何必纠结》");
		this.goodsDao.save(goods);
	}
}
