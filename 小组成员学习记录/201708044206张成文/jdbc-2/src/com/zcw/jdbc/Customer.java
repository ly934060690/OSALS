package com.zcw.jdbc;
/**
 * 
 * ±Í≈‰
 * @author forever
 *
 */
public class Customer {

	private int Id;
	private String Name;
	private int Money;
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getMoney() {
		return Money;
	}
	public void setMoney(int money) {
		Money = money;
	}
	public Customer(int id, String name, int money) {
		super();
		Id = id;
		Name = name;
		Money = money;
	}
	public Customer() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Customer [Id=" + Id + ", Name=" + Name + ", Money=" + Money + "]";
	}
	
	
	
}
