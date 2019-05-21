package edu.zut.cs.software.OSALS.courier.dao;

import edu.zut.cs.software.OSALS.shop.dao.CommodityDaoTest;
import edu.zut.cs.software.OSALS.courier.domain.Courier;
import edu.zut.cs.software.base.dao.GenericDaoTestCase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CourierDaoTest extends GenericDaoTestCase<Long, Courier,CourierDao> {

    /**
     * Logger for this class
     */
    private static final Logger logger = LogManager.getLogger(CommodityDaoTest.class.getName());

    @Autowired
    CourierDao courierDao;

    @Test
    //@Rollback(false)
    public void testFindAll() {
        List<Courier> all = this.courierDao.findAll();
        if (logger.isInfoEnabled()) {
            logger.info("testFindAll() - List<Courier> all={}", all); //$NON-NLS-1$
        }

    }
}
