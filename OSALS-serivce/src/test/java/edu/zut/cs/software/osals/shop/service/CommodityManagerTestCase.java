package edu.zut.cs.software.osals.shop.service;

import edu.zut.cs.software.base.service.GenericManagerTestCase;
import edu.zut.cs.software.osals.shop.domain.Commodity;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertNotNull;

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

    /**
     * setUp
     * Price属性set后
     * 匹配失败
     */
    @Override
    public void setUp() {
        Commodity commodity = new Commodity();
        commodity.setName("旺仔大牛奶");
        commodity.setCode("10001_101");
//        commodity.setPrice(8);
        this.entity = this.manager.save(commodity);
    }

    /**
     * 思考为何使用Before
     * 会出现Null
     */
//    @Before
//    public void testBefore(){
//        Commodity commodity = new Commodity();
//        commodity.setName("旺仔大牛奶");
//        commodity.setPrice(8);
//        this.manager.save(commodity);
//    }

    @Test
    public void testFindByCode() {
        String code = this.entity.getCode();
        List<Commodity> result = this.commodityManager.findByCode(code);
        Assert.assertEquals(code, result.get(0).getCode());
        if (logger.isInfoEnabled()) {
            logger.info("testFindByCode() - List<Commodity> result={}", result); //$NON-NLS-1$
        }
    }
    @Test
    public void testFindByName() {
        List<Commodity> result = this.commodityManager.findByName("旺仔");
        assertNotNull(result);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("旺仔大牛奶", result.get(0).getName());
        if (logger.isInfoEnabled()) {
            logger.info("testFindByName() - List<Commodity> result={}", result); //$NON-NLS-1$
        }
    }

    @Test
    public void testFindAll() {
        List<Commodity> result = this.commodityManager.findAll();
        if (logger.isInfoEnabled()) {
            logger.info("testFindAll() - List<Commodity> result={}", result); //$NON-NLS-1$
        }
    }
}
