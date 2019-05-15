package com.osals.enwrap.admin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.osals.base.service.impl.GenericTreeManagerImpl;
import com.osals.enwrap.admin.dao.CustomerDao;
import com.osals.enwrap.admin.domain.Customer;
import com.osals.enwrap.admin.service.CustomerManager;

@Service(value = "customerManager")
public class CustomerManagerImpl extends GenericTreeManagerImpl<Customer, Long> implements CustomerManager{
	
	CustomerDao customerDao;

	@Autowired
	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
		this.treeDao = this.customerDao;
		this.dao = this.treeDao;
	}
}
