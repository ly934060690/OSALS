package edu.zut.cs.software.osals.courier.service;

import edu.zut.cs.software.base.service.GenericManager;
import edu.zut.cs.software.osals.courier.domain.Courier;

import java.util.List;

public interface CourierManager extends GenericManager<Courier,Long> {


    List<Courier> findbyCouriername(String couriername);
}
