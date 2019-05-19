package edu.zut.cs.software.OSALS.order.service;

import edu.zut.cs.software.OSALS.order.domain.Order;
import edu.zut.cs.software.base.service.GenericTreeManager;

import java.util.List;

public interface OrderManager extends GenericTreeManager<Order, Long> {


    List<Order> findByName(String name);
}
