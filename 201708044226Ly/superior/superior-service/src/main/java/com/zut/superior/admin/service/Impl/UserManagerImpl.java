package com.zut.superior.admin.service.Impl;

import org.springframework.stereotype.Service;

import com.zut.superior.admin.service.UserManager;

@Service("userManager")
public class UserManagerImpl implements UserManager {
	
	public String sayHello(String name) {
		// TODO Auto-generated method stub
		
		return "Hello," + name + "!";
	}

}
