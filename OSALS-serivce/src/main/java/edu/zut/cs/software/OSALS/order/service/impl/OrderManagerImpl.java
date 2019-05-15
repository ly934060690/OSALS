package edu.zut.cs.software.OSALS.order.service.impl;

import edu.zut.cs.software.OSALS.order.dao.OrderDao;
import edu.zut.cs.software.OSALS.order.domain.Order;
import edu.zut.cs.software.OSALS.order.service.OrderManager;
import edu.zut.cs.software.base.service.impl.GenericTreeManagerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service("orderManager")
@Transactional
public class OrderManagerImpl extends GenericTreeManagerImpl<Order,Long> implements OrderManager {

    OrderDao orderDao;

    @Autowired
    public void setOrderDao(OrderDao orderDao)
    {
        this.orderDao=orderDao;
        this.treeDao=this.orderDao;
        this.dao=this.treeDao;
    }

}
