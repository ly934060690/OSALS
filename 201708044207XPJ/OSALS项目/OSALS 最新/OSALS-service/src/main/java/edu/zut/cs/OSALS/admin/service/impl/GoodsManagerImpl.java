package edu.zut.cs.OSALS.admin.service.impl;

import edu.zut.cs.OSALS.admin.dao.GoodsDao;
import edu.zut.cs.OSALS.admin.domain.Goods;
import edu.zut.cs.OSALS.admin.service.GoodsManager;
import edu.zut.cs.OSALS.base.service.impl.GenericManagerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("goodsManager")
public class GoodsManagerImpl extends GenericManagerImpl<Goods, Long> implements GoodsManager{
    GoodsDao goodsDao;

    @Autowired
    public void setUserDao(GoodsDao goodsDao) {
        this.goodsDao = goodsDao;
        this.dao = this.goodsDao;
    }

    @Override
    public String sayHello(String name) {
        String result = "Hello, " + name + "!";
        if (logger.isInfoEnabled()) {
            logger.info("sayHello(String) - String result={}", result); //$NON-NLS-1$
        }

        return result;
    }

    @Override
    public List<Goods> getAll() {
        List<Goods> all = this.goodsDao.findAll();
        if (logger.isInfoEnabled()) {
            logger.info("getAll() - List<User> all={}", all); //$NON-NLS-1$
        }
        return all;
    }
}
