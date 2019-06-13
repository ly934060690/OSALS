package edu.zut.cs.software.osals.order.service.impl;


import edu.zut.cs.software.base.service.impl.GenericManagerImpl;
import edu.zut.cs.software.osals.order.dao.OrderGooodsDao;
import edu.zut.cs.software.osals.order.domain.OrderGoods;
import edu.zut.cs.software.osals.order.service.OrderGoodsManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
public class OrderGoodsManagerImpl extends GenericManagerImpl<OrderGoods, Long> implements OrderGoodsManager {


    OrderGooodsDao orderGooodsDao;



    @Autowired
    public void setOrderGoodsDao(OrderGooodsDao orderGoodsDao) {
        this.orderGooodsDao = orderGoodsDao;
        this.dao = this.orderGooodsDao;
    }

    @Override
    public List<OrderGoods> findByName(String name) {
        OrderGoods queryObject = new OrderGoods();
        queryObject.setName(name);

        queryObject.setDateCreated(null);
        queryObject.setDateModified(null);
        ExampleMatcher exampleMatcher = ExampleMatcher.matching().withMatcher("name", ExampleMatcher.GenericPropertyMatchers.startsWith());
        Example<OrderGoods> example = Example.of(queryObject, exampleMatcher);
        List<OrderGoods> result = this.dao.findAll(example);
        return result;
    }
    @Override
    public boolean modifyOrderGoods(String name) {
        List<OrderGoods> orderList = this.findByName(name);
        if(orderList.size() == 0) {
            return false;
        }
        else {
            for(int i = 0; i < orderList.size(); i++) {
                this.dao.delete(orderList.get(i));
            }
            return true;
        }
    }

}
