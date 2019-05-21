package edu.zut.cs.software.OSALS.order.service;

import edu.zut.cs.software.OSALS.order.domain.Order;
import edu.zut.cs.software.OSALS.order.domain.Order_goods;
import edu.zut.cs.software.base.service.GenericGenerator;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class OrderEntityGenerator extends GenericGenerator {



    @Autowired
    Order_goodsManager order_goodsManager;
    @Autowired
    OrderManager orderManager;

    @Test
    public void gen_order() {
        for(int i = 0; i < 10; i++) {
            Order s = new Order();
            s.setName("order_" + i);
            this.orderManager.save(s);
            for(int j = 0; j < 10; j++) {
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
            Order_goods c = new Order_goods();
            c.setName("order_goods_" + i);
            c.setPrice(i + 100);
            c.setOrder(s);
            this.order_goodsManager.save(c);
        }
    }
}
