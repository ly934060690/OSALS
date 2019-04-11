package edu.zut.cs.software.sun.module.domain;

import edu.zut.cs.software.sun.module.dao.ShopDao;

public class Shop implements ShopDao {
	
	private String id;
	private String name;
	private Commodity[] commodity;
	private Shop[] shop;
	
	public Shop() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Shop(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Commodity[] getCommodity() {
		return commodity;
	}

	public void setCommodity(Commodity[] commodity) {
		this.commodity = commodity;
	}

	public Shop[] getShop() {
		return shop;
	}

	public void setShop(Shop[] shop) {
		this.shop = shop;
	}

	@Override
	public String toString() {
		return "Shop [id=" + id + ", name=" + name + "]";
	}
	
	

}
