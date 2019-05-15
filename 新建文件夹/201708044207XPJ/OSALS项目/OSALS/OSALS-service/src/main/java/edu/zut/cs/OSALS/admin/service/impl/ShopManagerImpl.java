package edu.zut.cs.OSALS.admin.service.impl;

import edu.zut.cs.OSALS.admin.dao.ShopDao;
import edu.zut.cs.OSALS.admin.domain.Shop;
import edu.zut.cs.OSALS.admin.service.ShopManager;
import edu.zut.cs.OSALS.base.service.impl.GenericTreeManagerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "shopManager")
public class ShopManagerImpl extends GenericTreeManagerImpl<Shop, Long> implements ShopManager {
    ShopDao shopDao;

    @Autowired
    public void setGropuDao(ShopDao shopDao) {
        this.shopDao = shopDao;
        this.treeDao = this.shopDao;
        this.dao = this.treeDao;
    }
}
