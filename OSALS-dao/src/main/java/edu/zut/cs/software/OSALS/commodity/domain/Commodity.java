package edu.zut.cs.software.OSALS.commodity.domain;

import edu.zut.cs.software.base.domain.BaseEntity;
import edu.zut.cs.software.OSALS.shop.domain.Shop;

import javax.persistence.*;

/**
 * 商品类
 * 商品 -- 商店：ManyToOne
 * @author 研哥哥
 *
 */
@Entity
@Table(name = "T_COMMODITY")
public class Commodity extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2393699715680994416L;

	@Column(name = "NAME")
	String name;
	
	@Column(name = "PRICE")
	float price;
	
	@ManyToOne
	@JoinColumn(name = "SHOP_ID")
	Shop shop;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Shop getShop() {
		return shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}
	
	
}
