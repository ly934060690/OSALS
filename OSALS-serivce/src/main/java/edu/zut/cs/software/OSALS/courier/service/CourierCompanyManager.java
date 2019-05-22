package edu.zut.cs.software.OSALS.courier.service;

import edu.zut.cs.software.OSALS.courier.domain.CourierCompany;
import edu.zut.cs.software.base.service.GenericTreeManager;

import java.util.List;

public interface CourierCompanyManager extends GenericTreeManager<CourierCompany,Long> {

    List<CourierCompany> FindByName(String Name);

}
