package edu.zut.cs.software.osals.warehouse.dao;


import edu.zut.cs.software.base.dao.GenericTreeDaoTestCase;
import edu.zut.cs.software.osals.shop.dao.ShopDaoTest;
import edu.zut.cs.software.osals.warehouse.dao.WarehouseDao;
import edu.zut.cs.software.osals.warehouse.daomain.Warehouse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @Auther: LBW
 * @Date: 2019/5/16
 * @Description: edu.zut.cs.software.OSALS.warehouse.dao
 * @version: 1.0
 */
public class WarehouseDaoTest extends GenericTreeDaoTestCase<Long, Warehouse, WarehouseDao> {

    //打印错误信息
    private static final Logger logger = LogManager.getLogger(ShopDaoTest.class.getName());


    WarehouseDao warehouseDao;

    @Autowired
    public void setWarehouseDao(WarehouseDao warehouseDao) {
        this.warehouseDao = warehouseDao;
        this.dao = this.warehouseDao;
    }

    //@Rollback(false) 无事务回滚
    @Test
    public void testGetRoot() {
        int root_size = 2;
        for(int i = 0; i < root_size; i++) {
            Warehouse warehouse = new Warehouse();
            warehouse.setHousename("warehouse_" + i);
            for(int j = 0; j < 2; j++) {
                Warehouse w = new Warehouse();
                w.setHousename("warehouse_" + i + "_" + j);
                w.setParent(warehouse);
            }
            this.warehouseDao.save(warehouse);
        }

        List<Warehouse> roots = this.warehouseDao.getRoot();
        assertEquals(root_size, roots.size());
        if (logger.isInfoEnabled()) {
            logger.info("testGetRoot() - List<Warehouse> roots={}", roots);
        }

    }

}
