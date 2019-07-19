package edu.zut.cs.software.osals.order.dao;


import edu.zut.cs.software.base.dao.GenericDao;
import edu.zut.cs.software.osals.order.domain.OrderGoods;
import org.springframework.stereotype.Repository;

@Repository("order_goodsDao")
public interface OrderGooodsDao extends GenericDao<OrderGoods, Long> {

}
