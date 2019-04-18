package com.zcw.jdbc;

import static org.junit.Assert.*;

import org.junit.Test;

public class DAOTest {

	
	DAO dao = new DAO();
	@Test
	public void testUpdate() {
		String sql = "insert into account(name,money) values(?,?)";
		dao.update(sql, "VVV","1000");
		//time¿‡–Õµƒ  new Date(new java.util,Date().getTime())
	}

	@Test
	public void testGet() {
		String sql = "select id,name,money from account where id=?";
		Customer customer = dao.get(Customer.class, sql, 1);
		System.out.println(customer);
	}

//	@Test
//	public void testGetForList() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testGetForValue() {
//		fail("Not yet implemented");
//	}

}
