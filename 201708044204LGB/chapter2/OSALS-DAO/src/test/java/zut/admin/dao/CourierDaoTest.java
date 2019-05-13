package zut.admin.dao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import zut.admin.domain.Courier;
import zut.base.dao.GenericTreeDaoTestCase;

public class CourierDaoTest extends GenericTreeDaoTestCase<Long, Courier,CourierDao> {

    CourierDao courierDao;
    @Autowired

    public void setCourierDao(CourierDao courierDao) {
        this.courierDao = courierDao;
    }

}
