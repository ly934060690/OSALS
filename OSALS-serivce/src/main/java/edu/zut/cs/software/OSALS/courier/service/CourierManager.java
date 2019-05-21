package edu.zut.cs.software.OSALS.courier.service;

import edu.zut.cs.software.OSALS.courier.domain.Courier;
import edu.zut.cs.software.base.service.GenericManager;

import java.util.List;

public interface CourierManager extends GenericManager<Courier,Long> {

    List<Courier> findAll();

    List<Courier> findbyCouriername(String couriername);
}
