package edu.zut.cs.software.OSALS.shop.service;

import edu.zut.cs.software.OSALS.commodity.domain.Commodity;
import edu.zut.cs.software.OSALS.shop.domain.Shop;
import edu.zut.cs.software.OSALS.shop.service.ShopManager;
import edu.zut.cs.software.base.service.GenericGenerator;
import edu.zut.cs.software.OSALS.commodity.service.CommodityManager;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 
 * 无事物回滚
 * 商店 -- 商品
 * @author 研哥哥
 *
 */
public class ShopEntityGenerator extends GenericGenerator {

	
	@Autowired
	CommodityManager commodityManager;
	@Autowired
    ShopManager shopManager;
	
	@Test
	public void gen_shop() {
		for(int i = 1; i < 4; i++) {
			Shop s = new Shop();
			s.setName("shop_" + i);
			this.shopManager.save(s);
			for(int j = 1; j < 4; j++) {
				Shop shop = new Shop();
				shop.setName("shop_" + i + "_" + j);
				shop.setParent(s);
				s = this.shopManager.save(shop);
				this.gen_commodity(s);
			}
		}
	}
	
	public void gen_commodity(Shop s) {
		for(int i = 1; i < 4; i++) {
			Commodity c = new Commodity();
			c.setName("commodity_" + i);
			c.setPrice(i + 100);
			c.setShop(s);
			this.commodityManager.save(c);
		}
	}

	@Test
	public void test() {
		this.shopManager.findAll();
	}
}
