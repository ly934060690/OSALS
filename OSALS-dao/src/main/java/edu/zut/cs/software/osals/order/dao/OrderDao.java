package edu.zut.cs.software.osals.order.dao;

import edu.zut.cs.software.base.dao.GenericTreeDao;
import edu.zut.cs.software.osals.order.domain.Order;
import org.springframework.stereotype.Repository;

//@repository是用来注解接口,这个注解是将接口的一个实现类交给spring管理
// (在spring中有开启对@repository注解的扫描),当哪些地方
// 需要用到这个实现类作为依赖时,就可以注入了
@Repository("orderDao")
public interface OrderDao extends GenericTreeDao<Order, Long> {

}
