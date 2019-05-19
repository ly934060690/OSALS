package edu.zut.cs.software.OSALS.courier.service.impl;

import edu.zut.cs.software.OSALS.courier.dao.CourierDao;
import edu.zut.cs.software.OSALS.courier.domain.Courier;
import edu.zut.cs.software.OSALS.courier.service.CourierManager;
import edu.zut.cs.software.base.service.impl.GenericManagerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;


@Component
@Transactional
public class CourierManagerImpl extends GenericManagerImpl<Courier,Long> implements CourierManager {

    CourierDao courierDao;

    @Override
    public Courier findbyCouriername(String couriername) {
        // TODO Auto-generated method stub
        return null;
    }

    @Autowired
    public void setCourierDao(CourierDao courierDao) {
        this.courierDao = courierDao;
        this.dao = this.courierDao;
    }

}
