package edu.zut.cs.software.osals.order.dao;

import edu.zut.cs.software.base.dao.GenericDaoTestCase;
import edu.zut.cs.software.osals.order.domain.OrderGoods;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class OrderGoodsDaoTest extends GenericDaoTestCase<Long, OrderGoods, OrderGooodsDao> {

    private static final Logger logger = LogManager.getLogger(OrderGoodsDaoTest.class.getName());

    @Autowired
    OrderGooodsDao orderGooodsDao;

    @Test
    //@Rollback(false)
    public void testFindAll() {
        List<OrderGoods> all = this.orderGooodsDao.findAll();
        if (logger.isInfoEnabled()) {
            logger.info("testFindAll() - List<Commodity> all={}", all); //$NON-NLS-1$
        }

    }
}
