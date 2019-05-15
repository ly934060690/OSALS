package com.osals.enwrap.admin.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.osals.enwrap.admin.domain.Customer;
import com.osals.base.service.GenericGenerator;

public class CustomerGenerator extends GenericGenerator{
	
	CustomerManager customerManager;

	@Autowired
	public void setGroupManager(CustomerManager customerManager) {
		this.customerManager = customerManager;
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
				this.customerManager.save(subcustomer);
			}
			
		}

	}

}
