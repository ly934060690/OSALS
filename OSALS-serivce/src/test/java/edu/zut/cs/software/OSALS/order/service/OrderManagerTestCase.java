package edu.zut.cs.software.OSALS.order.service;


import edu.zut.cs.software.OSALS.order.domain.Order;
import edu.zut.cs.software.base.service.GenericTreeManagerTestCase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static junit.framework.TestCase.assertNotNull;

public class OrderManagerTestCase extends GenericTreeManagerTestCase<Long, Order, OrderManager> {

    /**
     * Logger for this class
     */
    private static final Logger logger = LogManager.getLogger(OrderManagerTestCase.class.getName());

    OrderManager orderManager;

    public OrderManagerTestCase() {
        super(Order.class);
    }

    @Autowired
    public void setOrderManager(OrderManager orderManager) {
        this.orderManager = orderManager;
        this.manager = this.orderManager;
    }

    @Test
    public void testFindAll() {
        List<Order> result = this.orderManager.findAll();
        if (logger.isInfoEnabled()) {
            logger.info("testFindAll() - List<Shop> result={}", result); //$NON-NLS-1$
        }
    }

    @Override
    public void setUp() {
        Order order = new Order();
        order.setName("熊的订单");
        this.entity = this.manager.save(order);
    }


    @Test
    public void findByName() {
        List<Order> result = this.orderManager.findByName("熊的订单");
        assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("熊的订单", result.get(0).getName());
        if (logger.isInfoEnabled()) {
            logger.info("findByName() - List<Shop> result={}", result); //$NON-NLS-1$
        }
    }
}
