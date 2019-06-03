package edu.zut.cs.software.osals.warehouse.service.impl;



import edu.zut.cs.software.base.service.impl.GenericManagerImpl;
import edu.zut.cs.software.osals.shop.domain.Commodity;
import edu.zut.cs.software.osals.warehouse.dao.GoodsDao;
import edu.zut.cs.software.osals.warehouse.daomain.Goods;
import edu.zut.cs.software.osals.warehouse.daomain.Warehouse;
import edu.zut.cs.software.osals.warehouse.service.GoodsManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Auther: LBW
 * @Date: 2019/5/16
 * @Description: edu.zut.cs.software.OSALS.goods.service.impl
 * @version: 1.0
 */
@Component
@Transactional
public class GoodsManagerImpl extends GenericManagerImpl<Goods, Long> implements GoodsManager {

    GoodsDao goodsDao;
    @Autowired
    public void setGoodsDao(GoodsDao goodsDao) {
        this.goodsDao = goodsDao;
        this.dao = this.goodsDao;
    }

    @Override
    public List<Goods> findByGoodNames(String GoodNames) {
        Goods queryObject = new Goods();
        queryObject.setGoodNames(GoodNames);
        queryObject.setDateCreated(null);
        queryObject.setDateModified(null);
        ExampleMatcher exampleMatcher = ExampleMatcher.matching().withMatcher("GoodsNames", ExampleMatcher.GenericPropertyMatchers.startsWith());
        Example<Goods> example = Example.of(queryObject, exampleMatcher);
        List<Goods> result = this.dao.findAll(example);
        return result;
    }

    @Override
    public List<Goods> findByNumbers(String Numbers) {
        Goods queryObject = new Goods();
        queryObject.setGoodNames(Numbers);
        queryObject.setDateCreated(null);
        queryObject.setDateModified(null);
        ExampleMatcher exampleMatcher = ExampleMatcher.matching().withMatcher("Numbers", ExampleMatcher.GenericPropertyMatchers.startsWith());
        Example<Goods> example = Example.of(queryObject, exampleMatcher);
        List<Goods> result = this.dao.findAll(example);
        return result;
    }
}
