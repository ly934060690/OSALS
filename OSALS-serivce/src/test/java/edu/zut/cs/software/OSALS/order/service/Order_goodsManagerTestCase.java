package edu.zut.cs.software.OSALS.order.service;

import edu.zut.cs.software.OSALS.order_goods.Order_goodsManager;
import edu.zut.cs.software.OSALS.order_goods.domain.Order_goods;
import edu.zut.cs.software.base.service.GenericManagerTestCase;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

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

    @Test
    public void testSave(){
        Order_goods order_goods = new Order_goods();
        this.order_goodsManager.save(order_goods);
    }
}
