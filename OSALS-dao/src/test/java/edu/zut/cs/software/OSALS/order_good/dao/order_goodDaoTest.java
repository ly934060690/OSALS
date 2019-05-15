package edu.zut.cs.software.OSALS.order_good.dao;


import edu.zut.cs.software.OSALS.order_good.domain.order_good;
import edu.zut.cs.software.base.dao.GenericDaoTestCase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class order_goodDaoTest extends GenericDaoTestCase<Long, order_good,order_goodDao> {


    private static final Logger logger = LogManager.getLogger(order_goodDaoTest.class.getName());
    @Autowired
    order_goodDao order_goodDao;

    @Test
    public void testFindAll() {
        List<order_good> all = this.order_goodDao.findAll();
        if (logger.isInfoEnabled()) {
            logger.info("testFindAll() - List<Commodity> all={}", all); //$NON-NLS-1$
        }

    }
}
