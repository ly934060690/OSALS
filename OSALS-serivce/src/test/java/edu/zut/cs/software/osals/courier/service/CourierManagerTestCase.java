package edu.zut.cs.software.osals.courier.service;

import edu.zut.cs.software.base.service.GenericManagerTestCase;
import edu.zut.cs.software.osals.courier.domain.Courier;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static junit.framework.TestCase.assertNotNull;

public class CourierManagerTestCase extends GenericManagerTestCase<Long, Courier,CourierManager> {


    CourierManager courierManager;
    public CourierManagerTestCase(){super(Courier.class);}


    @Autowired
    public void setCourierManager(CourierManager courierManager)
    {
        this.courierManager =courierManager;
        this.manager = this.courierManager;
    }

    @Override
    public void setUp(){
        Courier courier=new Courier();
        courier.setName("邢朋举");
        courier.setSex("男");
        courier.setPhoneNumber("17339453033");
        this.entity=this.manager.save(courier);
    }

    @Test
    public void testFindByName() {
        List<Courier> result = this.courierManager.findbyCouriername("邢朋举");
        assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("邢朋举", result.get(0).getName());
        if (logger.isInfoEnabled()) {
            logger.info("testFindByName() - List<Courier> result={}", result); //$NON-NLS-1$
        }
    }
    @Test
    public void testFindAll() {
        List<Courier> result = this.courierManager.findAll();
        if (logger.isInfoEnabled()) {
            logger.info("testFindAll() - List<Courier> result={}", result); //$NON-NLS-1$
        }
    }
}
