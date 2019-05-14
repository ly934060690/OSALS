package edu.zut.cs.OSALS.admin.dao;

import edu.zut.cs.OSALS.admin.domain.Shop;
import edu.zut.cs.OSALS.base.dao.GenericTreeDaoTestCase;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import java.util.List;


public class ShopDaoTest extends GenericTreeDaoTestCase<Long, Shop, ShopDao> {

	ShopDao shopDao;

	@Autowired
	//用来装配bean
	public void setGroupDao(ShopDao shopDao) {
		this.shopDao = shopDao;
		this.dao = this.shopDao;
	}

	/*
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
	*/

	@Test
	@Rollback(false)			//事务回滚，否则数据库将会恢复原状，但主键生成策略中的主键会继续增长
	public void Save(){
		for(int i=1;i<10;i++) {
			Shop shop = new Shop();
			shop.setName("全家福"+i);
			Shop s = new Shop();
			s.setName("小全家福");
			s.setParent(shop);
			this.shopDao.save(shop);
		}
		List<Shop> shops = this.shopDao.getRoot();
		System.out.println(shops);
	}

	/*
	@Test
	@Rollback(false)
	public void Delete(){
		this.shopDao.deleteById(5l);
	}


	@Test
	@Rollback(false)
	public void Update(){
		Shop shop = new Shop();
		shop.setName("沃尔玛");
		shop.setId(7l);
		this.shopDao.saveAndFlush(shop);
	}

	@Test
	@Rollback(false)
	public void Find(){
		//System.out.println(this.shopDao.findById(6l));
		Shop shop = new Shop();
		shop = this.shopDao.findById(6l).get();
		System.out.println(shop);
//		List<Shop> shops = this.shopDao.getRoot();
//		System.out.println(shops);
	}
	*/
}
