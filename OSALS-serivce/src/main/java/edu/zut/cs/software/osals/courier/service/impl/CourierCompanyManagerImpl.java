package edu.zut.cs.software.osals.courier.service.impl;

import edu.zut.cs.software.base.service.impl.GenericTreeManagerImpl;
import edu.zut.cs.software.osals.courier.dao.CourierCompanyDao;
import edu.zut.cs.software.osals.courier.domain.CourierCompany;
import edu.zut.cs.software.osals.courier.service.CourierCompanyManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

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

    @Override
    public List<CourierCompany> FindByName(String name) {
        CourierCompany queryObject = new CourierCompany();
        queryObject.setName(name);
        ExampleMatcher exampleMatcher = ExampleMatcher.matching().withMatcher("name", ExampleMatcher.GenericPropertyMatchers.startsWith()).withIgnorePaths("dateCreated", "dateModified");
        Example<CourierCompany> example = Example.of(queryObject, exampleMatcher);
        List<CourierCompany> result = this.dao.findAll(example);
        return result;
    }
}
