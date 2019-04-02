package com.zut.star.admin.service.Impl;

import org.springframework.stereotype.Service;

import com.zut.star.admin.service.UserManager;
@Service("userManager")
public class UserManagerImpl implements UserManager {
	
	public String sayHello(String name) {
		// TODO Auto-generated method stub
		
		return "Hello," + name + "!";
	}

}
