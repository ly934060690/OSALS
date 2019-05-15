package com.osals.enwrap.admin.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.osals.base.service.GenericTreeManagerTestCase;
import com.osals.enwrap.admin.domain.Customer;

public class CustomerManagerTest extends GenericTreeManagerTestCase<Long, Customer, CustomerManager>{
	
	CustomerManager customerManager;

	public CustomerManagerTest() {
		super(Customer.class);
	}

	@Autowired
	public void setCustomerManager(CustomerManager customerManager) {
		this.customerManager = customerManager;
		this.manager = this.customerManager;
	}

	@Test
	public void testAddCustomer() {
		for (int i = 0; i < 10; i++) {
			Customer customer = new Customer();
			customer.setC_name("customer_" + i);
			customer = this.customerManager.save(customer);
			for (int j = 0; j < 10; j++) {
				Customer subcustomer = new Customer();
				subcustomer.setC_name("subcustomer_" + i + "_" + j);
				subcustomer.setParent(customer);
				subcustomer = this.customerManager.save(subcustomer);
			}
		}

		List<Customer> rootCustomerList = this.customerManager.getRoot();
		assertNotNull(rootCustomerList);
		assertEquals(10, rootCustomerList.size());

	}

}
