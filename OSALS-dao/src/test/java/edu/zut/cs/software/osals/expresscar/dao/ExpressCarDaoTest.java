package edu.zut.cs.software.osals.expresscar.dao;

import edu.zut.cs.software.base.dao.GenericTreeDaoTestCase;
import edu.zut.cs.software.osals.expresscar.domain.ExpressCar;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author: hyh
 * @Description: ExpressCarDao测试类
 * @Date:Created in 19:51 2019/5/16
 * @Modified By:
 */
public class ExpressCarDaoTest extends GenericTreeDaoTestCase<Long, ExpressCar, ExpressCarDao> {

    /**
     * Logger for this class
     */
    private static final Logger logger = LogManager.getLogger(ExpressCarDaoTest.class.getName());

    ExpressCarDao expressCarDao;

    @Autowired
    public void setExpressCarDao(ExpressCarDao expressCarDao){
        this.expressCarDao=expressCarDao;
        this.dao=this.expressCarDao;
    }

    @Test
    public void testGetRoot() {
        int root_size = 10;
        for(int i = 0; i < root_size; i++) {
            ExpressCar expressCar = new ExpressCar();
            expressCar.setName("expressCar_" + i);
            for(int j = 0; j < 10; j++) {
                ExpressCar e = new ExpressCar();
                e.setName("shop_" + i + "_" + j);
                e.setParent(expressCar);
            }
            this.expressCarDao.save(expressCar);
        }

        List<ExpressCar> roots = this.expressCarDao.getRoot();
        assertEquals(root_size, roots.size());
        if (logger.isInfoEnabled()) {
            logger.info("testGetRoot() - List<ExpressCar> roots={}", roots); //$NON-NLS-1$
        }

    }


}