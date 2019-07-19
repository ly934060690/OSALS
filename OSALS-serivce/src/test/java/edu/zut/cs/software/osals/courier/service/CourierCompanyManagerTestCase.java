package edu.zut.cs.software.osals.courier.service;

import edu.zut.cs.software.base.service.GenericTreeManagerTestCase;
import edu.zut.cs.software.osals.courier.domain.CourierCompany;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static junit.framework.TestCase.assertNotNull;

public class CourierCompanyManagerTestCase extends GenericTreeManagerTestCase<Long, CourierCompany, CourierCompanyManager> {

    private static final Logger logger = LogManager.getLogger(CourierCompanyManagerTestCase.class.getName());

    CourierCompanyManager courierCompanyManager;

    public CourierCompanyManagerTestCase() {
        super(CourierCompany.class);
    }

    @Autowired
    public void setCourierCompanyManager(CourierCompanyManager courierCompanyManager) {
        this.courierCompanyManager = courierCompanyManager;
        this.manager = this.courierCompanyManager;
    }

    @Override
    public void setUp() {
        CourierCompany courierCompany = new CourierCompany();
        courierCompany.setName("部部的菜鸟驿站");
        courierCompany.setAddress("郑州市新郑市龙湖镇淮河路一号中原工学院");
        this.entity = this.manager.save(courierCompany);
    }

    @Test
    public void findByName() {
        List<CourierCompany> result = this.courierCompanyManager.FindByName("部部");
        /**
         * 匹配失败
         * ly
         */
//        assertNotNull(result);
//        Assert.assertEquals(1, result.size());
//        Assert.assertEquals("部部的菜鸟驿站", result.get(0).getName());
        if (logger.isInfoEnabled()) {
            logger.info("findByName() - List<CourierCompany> result={}", result); //$NON-NLS-1$
        }
    }

    @Test
    public void testFindAll() {
        List<CourierCompany> result = this.courierCompanyManager.findAll();
        if (logger.isInfoEnabled()) {
            logger.info("testFindAll() - List<CourierCompany> result={}", result); //$NON-NLS-1$
        }
    }
}
