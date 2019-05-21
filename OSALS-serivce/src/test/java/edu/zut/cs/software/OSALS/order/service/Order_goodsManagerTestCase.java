package edu.zut.cs.software.OSALS.order.service;

import edu.zut.cs.software.OSALS.order_goods.Order_goodsManager;
import edu.zut.cs.software.OSALS.order.domain.Order_goods;
import edu.zut.cs.software.base.service.GenericManagerTestCase;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static junit.framework.TestCase.assertNotNull;

public class Order_goodsManagerTestCase extends GenericManagerTestCase<Long, Order_goods, Order_goodsManager> {

    Order_goodsManager order_goodsManager;

    public Order_goodsManagerTestCase() {
        super(Order_goods.class);
    }

    @Autowired
    public void setOrder_goodsManager(Order_goodsManager order_goodsManager) {
        this.order_goodsManager = order_goodsManager;
        this.manager = this.order_goodsManager;
    }

    @Override
    public void setUp() {
        Order_goods order_goods = new Order_goods();
        order_goods.setName("三只熊");
        this.entity = this.manager.save(order_goods);
    }
    @Test
    public void testSave(){
        Order_goods order_goods = new Order_goods();
        this.order_goodsManager.save(order_goods);
    }
    @Test
    public void testFindByName() {
        List<Order_goods> result = this.order_goodsManager.findByName("三只熊");
        assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("三只熊", result.get(0).getName());
        if (logger.isInfoEnabled()) {
            logger.info("testFindByName() - List<Commodity> result={}", result); //$NON-NLS-1$
        }
    }
}
