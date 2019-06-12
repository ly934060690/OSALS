package edu.zut.cs.software.osals.shop.dao;

import edu.zut.cs.software.base.dao.GenericDaoTestCase;
import edu.zut.cs.software.osals.shop.domain.Commodity;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 
 * 事务回滚
 * @author 研哥哥
 *
 */
public class CommodityDaoTest extends GenericDaoTestCase<Long, Commodity, CommodityDao> {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = LogManager.getLogger(CommodityDaoTest.class.getName());

	@Autowired
    CommodityDao commodityDao;
	
	@Test
	//@Rollback(false)
	public void testFindAll() {
		List<Commodity> all = this.commodityDao.findAll();
		if (logger.isInfoEnabled()) {
			logger.info("testFindAll() - List<Commodity> all={}", all); //$NON-NLS-1$
		}
		
	}
}
