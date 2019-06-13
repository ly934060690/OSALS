package edu.zut.cs.software.osals.order.service;

import edu.zut.cs.software.base.service.GenericGenerator;
import edu.zut.cs.software.osals.order.domain.Order;
import edu.zut.cs.software.osals.order.domain.OrderGoods;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.util.Date;

public class OrderEntityGenerator extends GenericGenerator {



    @Autowired
    OrderGoodsManager orderGoodsManager;
    @Autowired
    OrderManager orderManager;

    @Test
    public void gen_order() {
        for (int i = 0; i < 2; i++) {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            String nowTime = df.format(new Date());
            Order s = new Order();
            s.setName("order_" + i);
            s.setOrder_num(i);
            s.setPayment_method("支付宝");
            s.setPrice(i * 10);
            s.setSuccess_time(nowTime);
            s.setState("成功");
            s.setCreate_time(nowTime);
            s.setDeliver_time(nowTime);
            s.setPayment_time(nowTime);
            this.orderManager.save(s);
            for (int j = 0; j < 2; j++) {
                Order o = new Order();
                o.setName("order_" + i + "_" + j);
                o.setOrder_num(j);
                o.setParent(s);
                o.setPayment_method("支付宝");
                o.setPrice(j * 10);
                o.setSuccess_time(nowTime);
                o.setState("成功");
                o.setCreate_time(nowTime);
                o.setDeliver_time(nowTime);
                o.setPayment_time(nowTime);
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
