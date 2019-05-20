package edu.zut.cs.software.OSALS.courier.service.impl;

import edu.zut.cs.software.OSALS.courier.dao.CourierDao;
import edu.zut.cs.software.OSALS.courier.domain.Courier;
import edu.zut.cs.software.OSALS.courier.service.CourierManager;
import edu.zut.cs.software.base.service.impl.GenericManagerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;


@Component
@Transactional
public class CourierManagerImpl extends GenericManagerImpl<Courier,Long> implements CourierManager {

    CourierDao courierDao;

    @Override
    public List<Courier> findbyCouriername(String couriername) {
        Courier queryObject = new Courier();
        queryObject.setName(couriername);

        queryObject.setDateCreated(null);
        queryObject.setDateModified(null);

//		ExampleMatcher exampleMatcher = ExampleMatcher.matching().withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING).withIgnoreCase(true).withMatcher("name", ExampleMatcher.GenericPropertyMatchers.startsWith());

        ExampleMatcher exampleMatcher = ExampleMatcher.matching().withMatcher("name", ExampleMatcher.GenericPropertyMatchers.startsWith());
        Example<Courier> example = Example.of(queryObject, exampleMatcher);
        List<Courier> result = this.dao.findAll(example);
        return result;
    }

    @Autowired
    public void setCourierDao(CourierDao courierDao) {
        this.courierDao = courierDao;
        this.dao = this.courierDao;
    }

}
