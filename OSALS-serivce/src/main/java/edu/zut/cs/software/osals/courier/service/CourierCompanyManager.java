package edu.zut.cs.software.osals.courier.service;

import edu.zut.cs.software.base.service.GenericTreeManager;
import edu.zut.cs.software.osals.courier.domain.CourierCompany;

import java.util.List;

public interface CourierCompanyManager extends GenericTreeManager<CourierCompany,Long> {

    List<CourierCompany> FindByName(String Name);
}
