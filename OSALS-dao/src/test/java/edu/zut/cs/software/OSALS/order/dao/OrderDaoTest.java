package edu.zut.cs.software.OSALS.order.dao;

import edu.zut.cs.software.OSALS.order.domain.Order;
import edu.zut.cs.software.base.dao.GenericTreeDaoTestCase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class OrderDaoTest extends GenericTreeDaoTestCase<Long, Order,OrderDao> {


    private static final Logger logger = LogManager.getLogger(OrderDaoTest.class.getName());

    OrderDao orderDao;

    @Autowired
    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
        this.dao = this.orderDao;
    }

    @Test
    //@Rollback(false)
    public void testGetRoot() {
        int root_size = 10;
        for (int i = 0; i < root_size; i++) {
            Order order = new Order();
            order.setName("order_" + i);
            for (int j = 0; j < 10; j++) {
                Order o = new Order();
                o.setName("order_" + i + "_" + j);
                o.setParent(order);
            }
            this.orderDao.save(order);
        }

        List<Order> roots = this.orderDao.getRoot();
        assertEquals(root_size, roots.size());
        if (logger.isInfoEnabled()) {
            logger.info("testGetRoot() - List<Shop> roots={}", roots); //$NON-NLS-1$
        }
    }
}
