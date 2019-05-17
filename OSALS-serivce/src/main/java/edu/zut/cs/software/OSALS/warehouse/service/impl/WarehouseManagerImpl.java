package edu.zut.cs.software.OSALS.warehouse.service.impl;

import edu.zut.cs.software.OSALS.shop.domain.Shop;
import edu.zut.cs.software.OSALS.shop.service.ShopManager;
import edu.zut.cs.software.OSALS.warehouse.dao.WarehouseDao;
import edu.zut.cs.software.OSALS.warehouse.daomain.Warehouse;
import edu.zut.cs.software.OSALS.warehouse.service.WarehouseManager;
import edu.zut.cs.software.base.service.impl.GenericTreeManagerImpl;
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
