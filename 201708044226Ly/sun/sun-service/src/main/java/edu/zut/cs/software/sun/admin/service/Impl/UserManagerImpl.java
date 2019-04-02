package edu.zut.cs.software.sun.admin.service.Impl;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.zut.cs.software.sun.admin.entity.User;
import edu.zut.cs.software.sun.admin.service.UserManager;

@Service("userManager")
public class UserManagerImpl implements UserManager {

	public String sayHello(String name) {
		// TODO Auto-generated method stub
		return "Hello, " + name + "!";
	}
	
	//@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
