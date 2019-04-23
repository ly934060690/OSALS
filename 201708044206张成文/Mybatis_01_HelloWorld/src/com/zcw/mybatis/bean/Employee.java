  package com.zcw.mybatis.bean;

public class Employee {

	private Integer id;
	private String name;
	private int money;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", money=" + money + "]";
	}
	
}
