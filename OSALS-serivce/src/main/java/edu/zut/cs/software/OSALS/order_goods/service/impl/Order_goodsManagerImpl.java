package edu.zut.cs.software.OSALS.order_goods.service.impl;

import edu.zut.cs.software.OSALS.order_goods.Order_goodsManager;
import edu.zut.cs.software.OSALS.order_goods.dao.Order_goodsDao;
import edu.zut.cs.software.OSALS.order_goods.domain.Order_goods;
import edu.zut.cs.software.base.service.impl.GenericManagerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
@Transactional
public class Order_goodsManagerImpl extends GenericManagerImpl<Order_goods, Long> implements Order_goodsManager {


    Order_goodsDao order_goodsDao;



    @Autowired
    public void setOrder_goodsDao(Order_goodsDao order_goodsDao) {
        this.order_goodsDao = order_goodsDao;
        this.dao = this.order_goodsDao;
    }


    @Override
    public Order_goods findbyOrder_goodsname(String order_goodsname) {
        return null;
    }
}
