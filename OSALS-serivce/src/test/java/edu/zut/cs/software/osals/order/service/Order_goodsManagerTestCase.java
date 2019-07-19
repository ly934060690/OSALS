package edu.zut.cs.software.osals.order.service;

import edu.zut.cs.software.base.service.GenericManagerTestCase;
import edu.zut.cs.software.osals.order.domain.OrderGoods;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class Order_goodsManagerTestCase extends GenericManagerTestCase<Long, OrderGoods, OrderGoodsManager> {

    OrderGoodsManager orderGoodsManager;

    public Order_goodsManagerTestCase() {
        super(OrderGoods.class);
    }

    @Autowired
    public void setOrder_goodsManager(OrderGoodsManager orderGoodsManager) {
        this.orderGoodsManager = orderGoodsManager;
        this.manager = this.orderGoodsManager;
    }

    @Test
    public void testSave(){
        OrderGoods order_goods = new OrderGoods();
        this.orderGoodsManager.save(order_goods);
    }
}
