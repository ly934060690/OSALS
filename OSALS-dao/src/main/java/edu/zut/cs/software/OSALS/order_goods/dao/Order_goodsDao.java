package edu.zut.cs.software.OSALS.order_goods.dao;


import edu.zut.cs.software.OSALS.order_goods.domain.Order_goods;
import edu.zut.cs.software.base.dao.GenericDao;
import org.springframework.stereotype.Repository;

@Repository("order_goodsDao")
public interface Order_goodsDao extends GenericDao<Order_goods, Long> {

}
