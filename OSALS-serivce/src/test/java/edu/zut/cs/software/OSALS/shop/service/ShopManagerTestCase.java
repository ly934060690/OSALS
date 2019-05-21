package edu.zut.cs.software.OSALS.shop.service;

import edu.zut.cs.software.OSALS.shop.domain.Shop;
import edu.zut.cs.software.base.service.GenericTreeManagerTestCase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.openxmlformats.schemas.drawingml.x2006.main.STAdjCoordinate;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertNotNull;

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

    @Override
    public void setUp() {
        Shop shop = new Shop();
        shop.setName("研哥哥的小店");
        shop.setCode("10001");
        //setParent
        this.entity = this.manager.save(shop);
    }

    @Test
    public void findByCode() {
        String code = this.entity.getCode();
        List<Shop> result = this.shopManager.findByCode(code);
        Assert.assertEquals(code, result.get(0).getCode());
        if (logger.isInfoEnabled()) {
            logger.info("findByCode() - List<Shop> result={}", result); //$NON-NLS-1$
        }
    }
    @Test
    public void findByName() {
        List<Shop> result = this.shopManager.findByName("研哥哥");
        assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("研哥哥的小店", result.get(0).getName());
        if (logger.isInfoEnabled()) {
            logger.info("findByName() - List<Shop> result={}", result); //$NON-NLS-1$
        }
    }

    @Test
    public void testFindAll() {
        List<Shop> result = this.shopManager.findAll();
        if (logger.isInfoEnabled()) {
            logger.info("testFindAll() - List<Shop> result={}", result); //$NON-NLS-1$
        }
    }
}
