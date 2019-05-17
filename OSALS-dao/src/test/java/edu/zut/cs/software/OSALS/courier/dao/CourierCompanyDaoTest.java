package edu.zut.cs.software.OSALS.courier.dao;


import edu.zut.cs.software.OSALS.courier.domain.CourierCompany;
import edu.zut.cs.software.base.dao.GenericTreeDaoTestCase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertEquals;


public class CourierCompanyDaoTest extends GenericTreeDaoTestCase<Long, CourierCompany, CourierCompanyDao> {


    private static final Logger logger = LogManager.getLogger(CourierCompanyDaoTest.class.getName());

    CourierCompanyDao courierCompanyDao;

    @Autowired
    public void setCourierCompanyDao(CourierCompanyDao courierCompanyDao) {
        this.courierCompanyDao = courierCompanyDao;
        this.dao = this.courierCompanyDao;
    }

    @Test
    //@Rollback(false)
    public void testGetRoot() {
        int root_size = 10;
        for(int i = 0; i < root_size; i++) {
            CourierCompany courierCompany = new CourierCompany();
            courierCompany.setName("courierCompany_" + i);
            for(int j = 0; j < 10; j++) {
                CourierCompany c = new CourierCompany();
                c.setName("c_" + i + "_" + j);
                c.setParent(courierCompany);
            }
            this.courierCompanyDao.save(courierCompany);
        }

        List<CourierCompany> roots = this.courierCompanyDao.getRoot();
//        assertEquals(root_size,roots.size());
        if (logger.isInfoEnabled()) {
            logger.info("testGetRoot() - List<CourierCompany> roots={}", roots); //$NON-NLS-1$
        }


    }
}
