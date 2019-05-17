package edu.zut.cs.software.OSALS.goods.service.impl;

import edu.zut.cs.software.OSALS.goods.dao.GoodsDao;
import edu.zut.cs.software.OSALS.goods.daomain.Goods;
import edu.zut.cs.software.OSALS.goods.service.GoodsManager;
import edu.zut.cs.software.base.service.impl.GenericManagerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

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

    @Override
    public Goods findByGoodNames(String GoodNames) {
        // TODO Auto-generated method stub
        return null;
    }

    @Autowired
    public void setGoodsDao(GoodsDao goodsDao) {
        this.goodsDao = goodsDao;
        this.dao = this.goodsDao;
    }
}
