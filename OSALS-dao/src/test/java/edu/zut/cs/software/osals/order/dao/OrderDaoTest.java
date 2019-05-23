package edu.zut.cs.software.osals.order.dao;

import edu.zut.cs.software.base.dao.GenericTreeDaoTestCase;
import edu.zut.cs.software.osals.order.domain.Order;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class OrderDaoTest extends GenericTreeDaoTestCase<Long, Order, OrderDao> {

    private static final Logger logger = LogManager.getLogger(OrderDaoTest.class.getName());

    OrderDao orderDao;

    @Autowired
    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
        this.dao = this.orderDao;
    }

    @Test
    public void testRoot() {
        int root_size = 2;
        for(int i = 0; i < root_size; i++) {
            Order order = new Order();
            order.setName("order_" + i);
            for(int j = 0; j < 2; j++) {
                Order s = new Order();
                s.setName("order_" + i + "_" + j);
                s.setParent(order);
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
