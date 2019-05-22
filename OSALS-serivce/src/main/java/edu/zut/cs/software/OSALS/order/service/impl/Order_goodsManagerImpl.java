package edu.zut.cs.software.OSALS.order.service.impl;

import edu.zut.cs.software.OSALS.order.service.Order_goodsManager;
import edu.zut.cs.software.OSALS.order.dao.Order_goodsDao;
import edu.zut.cs.software.OSALS.order.domain.Order_goods;
import edu.zut.cs.software.base.service.impl.GenericManagerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

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
    public List<Order_goods> findByName(String name) {
        Order_goods queryObject = new Order_goods();
        queryObject.setName(name);

        queryObject.setDateCreated(null);
        queryObject.setDateModified(null);
        ExampleMatcher exampleMatcher = ExampleMatcher.matching().withMatcher("name", ExampleMatcher.GenericPropertyMatchers.startsWith());
        Example<Order_goods> example = Example.of(queryObject, exampleMatcher);
        List<Order_goods> result = this.dao.findAll(example);
        return result;
    }

    @Override
    public Order_goods findbyOrder_goodsname(String order_goodsname) {
        return null;
    }
}
