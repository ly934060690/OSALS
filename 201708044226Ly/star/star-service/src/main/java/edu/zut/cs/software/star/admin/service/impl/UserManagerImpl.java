package edu.zut.cs.software.star.admin.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import edu.zut.cs.software.star.admin.service.UserManager;
import edu.zut.cs.software.star.admin.service.entity.User;

@Service("userManager")
public class UserManagerImpl implements UserManager {

	@Override
	public String sayHello(String name) {
		// TODO Auto-generated method stub
		String result = "Hello, " + name + "!";
		return result;
	}

	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		List<User> all = new ArrayList<User>();
		for(int i = 0; i < 100; i++) {
			User user = new User();
			user.setName("User_" + i);
			all.add(user);
		}
		return all;
	}

}
