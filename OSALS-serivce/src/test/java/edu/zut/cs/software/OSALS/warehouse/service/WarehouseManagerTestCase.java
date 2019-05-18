package edu.zut.cs.software.OSALS.warehouse.service;

import edu.zut.cs.software.OSALS.shop.domain.Shop;
import edu.zut.cs.software.OSALS.shop.service.ShopManager;
import edu.zut.cs.software.OSALS.shop.service.ShopManagerTestCase;
import edu.zut.cs.software.OSALS.warehouse.daomain.Warehouse;
import edu.zut.cs.software.base.service.GenericTreeManagerTestCase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Auther: LBW
 * @Date: 2019/5/17
 * @Description: edu.zut.cs.software.OSALS.warehouse.service
 * @version: 1.0
 */
public class WarehouseManagerTestCase extends GenericTreeManagerTestCase<Long, Warehouse, WarehouseManager> {


    /**
     * Logger for this class
     */
    private static final Logger logger = LogManager.getLogger(WarehouseManagerTestCase.class.getName());

    WarehouseManager warehouseManager;

    public WarehouseManagerTestCase() {
        super(Warehouse.class);
    }

    @Autowired
    public void setWarehouseManager(WarehouseManager warehouseManager) {
        this.warehouseManager = warehouseManager;
        this.manager = this.warehouseManager;
    }

    @Test
    public void testFindAll() {
        List<Warehouse> result = this.warehouseManager.findAll();
        if (logger.isInfoEnabled()) {
            logger.info("testFindAll() - List<Warehouse> result={}", result); //$NON-NLS-1$
        }
    }
}
