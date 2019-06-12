package edu.zut.cs.software.osals.warehouse.service;



import edu.zut.cs.software.base.service.GenericTreeManager;
import edu.zut.cs.software.osals.warehouse.daomain.Warehouse;

import java.util.List;

/**
 * @Auther: LBW
 * @Date: 2019/5/16
 * @Description: edu.zut.cs.software.OSALS.warehouse.service
 * @version: 1.0
 */
public interface WarehouseManager extends GenericTreeManager<Warehouse, Long> {

    List<Warehouse> findByName(String name);
}
