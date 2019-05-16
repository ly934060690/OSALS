package edu.zut.cs.software.OSALS.shop.service;

import edu.zut.cs.software.OSALS.commodity.domain.Commodity;
import edu.zut.cs.software.OSALS.commodity.service.CommodityManager;
import edu.zut.cs.software.base.service.GenericManagerTestCase;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class CommodityManagerTestCase extends GenericManagerTestCase<Long, Commodity, CommodityManager> {

    CommodityManager commodityManager;

    public CommodityManagerTestCase() {
        super(Commodity.class);
    }

    @Autowired
    public void setCommodityManager(CommodityManager commodityManager) {
        this.commodityManager = commodityManager;
        this.manager = this.commodityManager;
    }

    @Test
    public void testSave(){
        Commodity commodity = new Commodity();
        this.commodityManager.save(commodity);
    }
}
