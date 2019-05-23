package edu.zut.cs.software.osals.order.service;

import edu.zut.cs.software.base.service.GenericGenerator;
import edu.zut.cs.software.osals.order.domain.Order;
import edu.zut.cs.software.osals.order.domain.OrderGoods;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class OrderEntityGenerator extends GenericGenerator {



    @Autowired
    OrderGoodsManager orderGoodsManager;
    @Autowired
    OrderManager orderManager;

    @Test
    public void gen_order() {
        for(int i = 0; i < 2; i++) {
            Order s = new Order();
            s.setName("order_" + i);
            this.orderManager.save(s);
            for(int j = 0; j < 2; j++) {
                Order o = new Order();
                o.setName("order_" + i + "_" + j);
                o.setParent(s);
                s = this.orderManager.save(o);
                this.gen_order_goods(s);
            }
        }
    }

    public void gen_order_goods(Order s) {
        for(int i = 0; i < 10; i++) {
            OrderGoods c = new OrderGoods();
            c.setName("order_goods_" + i);
            c.setPrice(i + 100);
            c.setOrder(s);
            this.orderGoodsManager.save(c);
        }
    }
}
