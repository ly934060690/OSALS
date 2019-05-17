package edu.zut.cs.software.OSALS.shop.dao;

import edu.zut.cs.software.base.dao.GenericTreeDao;
import edu.zut.cs.software.OSALS.shop.domain.Shop;
import org.springframework.stereotype.Repository;

@Repository("shopDao")
public interface ShopDao extends GenericTreeDao<Shop, Long> {

}
