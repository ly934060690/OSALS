package edu.zut.cs.software.osals.warehouse.service;


import edu.zut.cs.software.base.service.GenericGenerator;
import edu.zut.cs.software.osals.warehouse.daomain.Goods;
import edu.zut.cs.software.osals.warehouse.daomain.Warehouse;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Auther: LBW
 * @Date: 2019/5/16
 * @Description: edu.zut.cs.software.OSALS.warehouse.service
 * @version: 1.0
 */
public class WarehouseEntityGenerator  extends GenericGenerator {


    @Autowired
    GoodsManager goodsManager;

    @Autowired
    WarehouseManager warehouseManager;

    @Test
    public void test_warehouse() {
        for(int i = 0; i < 2; i++) {
            Warehouse w = new Warehouse();
            w.setHousename("house_" + i);
            this.warehouseManager.save(w);
            for(int j = 0; j < 2; j++) {
                Warehouse warehouse = new Warehouse();
                warehouse.setHousename("house_" + i + "_" + j);
                warehouse.setParent(w);
                w = this.warehouseManager.save(warehouse);
                this.gen_commodity(w);
            }
        }
    }

    public void gen_commodity(Warehouse w) {
        for(int i = 0; i < 2; i++) {
            Goods g = new Goods();
            g.setGoodNames("good_" + i);
            g.setNumbers(i + 100);
            g.setWarehouse(w);
            this.goodsManager.save(g);
        }
    }

}
