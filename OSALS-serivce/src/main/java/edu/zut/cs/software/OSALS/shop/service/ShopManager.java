package edu.zut.cs.software.OSALS.shop.service;

import edu.zut.cs.software.OSALS.shop.domain.Shop;
import edu.zut.cs.software.base.service.GenericTreeManager;

import java.util.List;

/**
 * 
 * @author 研哥哥
 *
 */
public interface ShopManager extends GenericTreeManager<Shop, Long> {

    List<Shop> findByCode(String code);

    List<Shop> findByName(String name);

}
