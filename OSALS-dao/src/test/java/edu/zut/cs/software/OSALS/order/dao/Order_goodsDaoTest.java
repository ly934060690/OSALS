package edu.zut.cs.software.OSALS.order.dao;

import edu.zut.cs.software.OSALS.order.domain.Order_goods;
import edu.zut.cs.software.base.dao.GenericDaoTestCase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class Order_goodsDaoTest extends GenericDaoTestCase<Long, Order_goods, Order_goodsDao> {

    private static final Logger logger = LogManager.getLogger(Order_goodsDaoTest.class.getName());

    @Autowired
    Order_goodsDao order_goodsDao;

    @Test
    //@Rollback(false)
    public void testFindAll() {
        List<Order_goods> all = this.order_goodsDao.findAll();
        if (logger.isInfoEnabled()) {
            logger.info("testFindAll() - List<Commodity> all={}", all); //$NON-NLS-1$
        }

    }
}
