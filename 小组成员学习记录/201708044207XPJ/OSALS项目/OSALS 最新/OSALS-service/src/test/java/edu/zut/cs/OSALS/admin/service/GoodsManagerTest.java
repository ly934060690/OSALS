package edu.zut.cs.OSALS.admin.service;

import edu.zut.cs.OSALS.admin.domain.Goods;
import edu.zut.cs.OSALS.base.service.GenericManagerTestCase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GoodsManagerTest extends GenericManagerTestCase<Long, Goods, GoodsManager> {

    private static final Logger logger = LogManager.getLogger(GoodsManagerTest.class.getName());

    GoodsManager goodsManager;

    public GoodsManagerTest() {
        super(Goods.class);
    }
}
