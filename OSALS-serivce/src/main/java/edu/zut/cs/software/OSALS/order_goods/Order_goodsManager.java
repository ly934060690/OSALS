package edu.zut.cs.software.OSALS.order_goods;

import edu.zut.cs.software.OSALS.order_goods.domain.Order_goods;
import edu.zut.cs.software.base.service.GenericManager;

import java.util.List;

public interface Order_goodsManager extends GenericManager<Order_goods, Long> {


    List<Order_goods> findAll();

    List<Order_goods> findByName(String name);
    Order_goods findbyOrder_goodsname(String order_goodsname);
}
