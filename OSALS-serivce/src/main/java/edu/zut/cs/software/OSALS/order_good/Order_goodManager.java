package edu.zut.cs.software.OSALS.order_good;

import edu.zut.cs.software.OSALS.commodity.domain.Commodity;
import edu.zut.cs.software.OSALS.order_good.domain.order_good;
import edu.zut.cs.software.base.service.GenericManager;

import java.util.List;

public interface Order_goodManager extends GenericManager<order_good, Long> {
    List<order_good> findAll();
    order_good findbyorder_goodname(String order_goodname);
}
