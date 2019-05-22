package edu.zut.cs.software.osals.goods.dao;

import edu.zut.cs.software.base.dao.GenericDao;
import edu.zut.cs.software.osals.goods.daomain.Goods;
import org.springframework.stereotype.Repository;

/**
 * @Auther: LBW
 * @Date: 2019/5/15
 * @Description: edu.zut.cs.software.OSALS.Goods.dao
 * @version: 1.0
 */
@Repository("goodsDao")
public interface GoodsDao extends GenericDao<Goods, Long> {

}
