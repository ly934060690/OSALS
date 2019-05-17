package edu.zut.cs.software.OSALS.shop.service;

import edu.zut.cs.software.OSALS.shop.domain.Shop;
import edu.zut.cs.software.base.service.GenericTreeManagerTestCase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ShopManagerTestCase extends GenericTreeManagerTestCase<Long, Shop, ShopManager> {

    /**
     * Logger for this class
     */
    private static final Logger logger = LogManager.getLogger(ShopManagerTestCase.class.getName());

    ShopManager shopManager;

    public ShopManagerTestCase() {
        super(Shop.class);
    }

    @Autowired
    public void setShopManager(ShopManager shopManager) {
        this.shopManager = shopManager;
        this.manager = this.shopManager;
    }

    @Test
    public void testFindAll() {
        List<Shop> result = this.shopManager.findAll();
        if (logger.isInfoEnabled()) {
            logger.info("testFindAll() - List<Shop> result={}", result); //$NON-NLS-1$
        }
    }
}
