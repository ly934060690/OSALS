package edu.zut.cs.software.osals.warehouse.service;

import edu.zut.cs.software.base.service.GenericManager;
import edu.zut.cs.software.osals.warehouse.daomain.Goods;

import java.util.List;

/**
 * @Auther: LBW
 * @Date: 2019/5/16
 * @Description: edu.zut.cs.software.OSALS.goods.service
 * @version: 1.0
 */
public interface GoodsManager extends GenericManager<Goods, Long> {


    List<Goods> findAll();

    Goods findByGoodNames(String GoodNames);

}
