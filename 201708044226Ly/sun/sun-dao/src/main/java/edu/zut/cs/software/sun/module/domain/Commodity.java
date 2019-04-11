package edu.zut.cs.software.sun.module.domain;

import edu.zut.cs.software.sun.module.dao.CommodityDao;

public class Commodity implements CommodityDao {
	
	private String id;
	private String name;
	private Shop shop;
	
	public Commodity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Commodity(String id, String name) {
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

	public Shop getShop() {
		return shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}

	@Override
	public String toString() {
		return "Commodity [id=" + id + ", name=" + name + "]";
	}
	
	
	

}
