package edu.zut.cs.software.osals.courier.dao;

import edu.zut.cs.software.base.dao.GenericDaoTestCase;
import edu.zut.cs.software.osals.courier.domain.Courier;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CourierDaoTest extends GenericDaoTestCase<Long, Courier, CourierDao> {

    /**
     * Logger for this class
     */
    private static final Logger logger = LogManager.getLogger(CourierDaoTest.class.getName());

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
