package edu.zut.cs.software.osals.order.dao;

import edu.zut.cs.software.base.dao.GenericDao;
import edu.zut.cs.software.osals.order.domain.Order_goods;
import org.springframework.stereotype.Repository;

@Repository("order_goodsDao")
public interface Order_goodsDao extends GenericDao<Order_goods, Long> {

}
