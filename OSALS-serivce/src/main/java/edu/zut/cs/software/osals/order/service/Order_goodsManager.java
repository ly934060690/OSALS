package edu.zut.cs.software.osals.order.service;

import edu.zut.cs.software.base.service.GenericManager;
import edu.zut.cs.software.osals.order.domain.Order_goods;

import java.util.List;

public interface Order_goodsManager extends GenericManager<Order_goods, Long> {


    List<Order_goods> findAll();

    List<Order_goods> findByName(String name);
    Order_goods findbyOrder_goodsname(String order_goodsname);
}
