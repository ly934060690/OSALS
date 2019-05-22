package edu.zut.cs.software.osals.warehouse.service.impl;

import edu.zut.cs.software.base.service.impl.GenericTreeManagerImpl;
import edu.zut.cs.software.osals.warehouse.dao.WarehouseDao;
import edu.zut.cs.software.osals.warehouse.daomain.Warehouse;
import edu.zut.cs.software.osals.warehouse.service.WarehouseManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * @Auther: LBW
 * @Date: 2019/5/16
 * @Description: edu.zut.cs.software.OSALS.warehouse.service.impl
 * @version: 1.0
 */
@Service("WarehouseManager")
@Transactional
public class WarehouseManagerImpl extends GenericTreeManagerImpl<Warehouse, Long> implements WarehouseManager {


    WarehouseDao warehouseDao;

    @Autowired
    public void setWarehouseDao(WarehouseDao warehouseDao) {
        this.warehouseDao = warehouseDao;
        this.treeDao = this.warehouseDao;
        this.dao = this.treeDao;
    }
}
