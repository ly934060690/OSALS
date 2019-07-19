package edu.zut.cs.software.osals.order.service;

import edu.zut.cs.software.base.service.GenericTreeManager;
import edu.zut.cs.software.osals.order.domain.Order;

import java.util.List;

public interface OrderManager extends GenericTreeManager<Order, Long> {

    List<Order> findByName(String name);
    List<Order> findByState(String state);
    List<Order> createOrder(String success_time,String payment_method,float order_num);
    boolean modifyOrder(String state);
}
