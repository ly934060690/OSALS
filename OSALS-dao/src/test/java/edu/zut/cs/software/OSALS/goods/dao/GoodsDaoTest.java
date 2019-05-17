package edu.zut.cs.software.OSALS.goods.dao;

import edu.zut.cs.software.OSALS.goods.dao.GoodsDao;
import edu.zut.cs.software.OSALS.goods.daomain.Goods;
import edu.zut.cs.software.base.dao.GenericDaoTestCase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Auther: LBW
 * @Date: 2019/5/15
 * @Description: edu.zut.cs.software.OSALS.goods.dao
 * @version: 1.0
 */
public class GoodsDaoTest  extends GenericDaoTestCase<Long, Goods,GoodsDao>
{
     //打印错位信息
    private static final Logger logger = LogManager.getLogger(GoodsDaoTest.class.getName());

    @Autowired
    GoodsDao goodsDao;


    //@Rollback(false)  无事务回滚
    @Test
    public void testFindAll() {
        List<Goods> all = this.goodsDao.findAll();
        if (logger.isInfoEnabled()) {
            logger.info("testFindAll() - List<Goods> all={}", all);
        }

    }
}
