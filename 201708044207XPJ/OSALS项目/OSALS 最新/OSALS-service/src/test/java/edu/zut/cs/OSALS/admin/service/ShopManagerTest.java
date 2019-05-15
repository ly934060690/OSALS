package edu.zut.cs.OSALS.admin.service;

import edu.zut.cs.OSALS.admin.domain.Shop;
import edu.zut.cs.OSALS.base.service.GenericTreeManagerTestCase;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertEquals;

public class ShopManagerTest extends GenericTreeManagerTestCase<Long, Shop, ShopManager> {

    ShopManager shopManager;

    public ShopManagerTest(){
        super(Shop.class);
    }

    @Autowired
    public void setGroupManager(ShopManager shopManager) {
        this.shopManager = shopManager;
        this.manager = this.shopManager;
    }

    @Test
    public void testAddGroup() {
        for (int i = 0; i < 10; i++) {
            Shop shop = new Shop();
            shop.setName("group_" + i);
            shop = this.shopManager.save(shop);
            for (int j = 0; j < 10; j++) {
                Shop subgroup = new Shop();
                subgroup.setName("subgroup_" + i + "_" + j);
                subgroup.setParent(shop);
                subgroup = this.shopManager.save(subgroup);
            }
        }

        List<Shop> rootGroupList = this.shopManager.getRoot();
        assertNotNull(rootGroupList);
        assertEquals(10, rootGroupList.size());


    }
}
