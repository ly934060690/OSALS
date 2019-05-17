package edu.zut.cs.software.OSALS.courier.service.impl;

import edu.zut.cs.software.OSALS.courier.dao.CourierCompanyDao;
import edu.zut.cs.software.OSALS.courier.domain.CourierCompany;
import edu.zut.cs.software.OSALS.courier.service.CourierCompanyManager;
import edu.zut.cs.software.OSALS.courier.service.CourierManager;
import edu.zut.cs.software.base.service.GenericTreeManager;
import edu.zut.cs.software.base.service.impl.GenericTreeManagerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service("courierCompanyManager")
@Transactional


public class CourierCompanyManagerImpl extends GenericTreeManagerImpl<CourierCompany,Long> implements CourierCompanyManager {

    CourierCompanyDao courierCompanyDao;

    @Autowired
    public void setCourierCompanyDao(CourierCompanyDao courierCompanyDao) {
        this.courierCompanyDao=courierCompanyDao;
        this.treeDao = this.courierCompanyDao;
        this.dao = this.treeDao;
    }
}
