package edu.zut.cs.software.osals.order.service;

import edu.zut.cs.software.base.service.GenericTreeManagerTestCase;
import edu.zut.cs.software.osals.order.domain.Order;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

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
}
