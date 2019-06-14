package edu.zut.cs.software.osals.order.service;

import edu.zut.cs.software.base.service.GenericManager;
import edu.zut.cs.software.osals.order.domain.OrderGoods;

import java.util.List;

public interface OrderGoodsManager extends GenericManager<OrderGoods, Long> {


    List<OrderGoods> findAll();

    List<OrderGoods> findByName(String name);
    boolean modifyOrderGoods(String name);
}
