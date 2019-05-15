package edu.zut.cs.software.OSALS.order.service;

import edu.zut.cs.software.OSALS.order.domain.Order;
import edu.zut.cs.software.OSALS.order_good.Order_goodManager;
import edu.zut.cs.software.OSALS.order_good.domain.order_good;
import edu.zut.cs.software.base.service.GenericGenerator;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class OrderEntityGenerator extends GenericGenerator {



    @Autowired
    Order_goodManager order_goodManager;
    @Autowired
    OrderManager orderManager;

    @Test
    public void gen_order() {
        for(int i = 0; i < 10; i++) {
            Order o = new Order();
            o.setName("order_" + i);
            this.orderManager.save(o);
            for(int j = 0; j < 10; j++) {
                Order order = new Order();
                order.setName("order_" + i + "_" + j);
                order.setParent(o);
                o = this.orderManager.save(order);
                this.gen_order_good(o);
            }
        }
    }

    public void gen_order_good(Order o) {
        for(int i = 0; i < 10; i++) {
            order_good c = new order_good();
            c.setName("order_good_" + i);
            c.setPrice(i + 100);
            c.setOrder(o);
            this.order_goodManager.save(c);
        }
    }
}
