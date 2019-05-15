package edu.zut.cs.software.OSALS.order_good.service.impl;


import edu.zut.cs.software.OSALS.commodity.dao.CommodityDao;
import edu.zut.cs.software.OSALS.order_good.Order_goodManager;
import edu.zut.cs.software.OSALS.order_good.dao.order_goodDao;
import edu.zut.cs.software.OSALS.order_good.domain.order_good;
import edu.zut.cs.software.base.service.impl.GenericManagerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
@Transactional
public class Order_goodManagerImpl extends GenericManagerImpl<order_good,Long> implements Order_goodManager {



    order_goodDao order_goodDao;

    @Override
    public order_good findbyorder_goodname(String order_goodname)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Autowired
    public void setorder_goodDao(order_goodDao order_goodDao) {
        this.order_goodDao = order_goodDao;
        this.dao = this.order_goodDao;
    }
}
