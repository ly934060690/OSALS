package edu.zut.cs.OSALS.admin.service;

import edu.zut.cs.OSALS.admin.domain.Shop;
import edu.zut.cs.OSALS.base.service.GenericGenerator;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ShopGenerator extends GenericGenerator {
    ShopManager shopManager;

    @Autowired
    public void setGroupManager(ShopManager shopManager) {
        this.shopManager = shopManager;
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
                this.shopManager.save(subgroup);
            }

        }

    }
}
