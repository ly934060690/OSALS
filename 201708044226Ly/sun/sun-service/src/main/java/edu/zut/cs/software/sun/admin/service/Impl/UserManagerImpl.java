package edu.zut.cs.software.sun.admin.service.Impl;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import edu.zut.cs.software.sun.admin.domain.User;
import edu.zut.cs.software.sun.admin.service.UserManager;

@Service("userManager")
public class UserManagerImpl implements UserManager {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = LogManager.getLogger(UserManagerImpl.class.getName());

	public String sayHello(String name) {
		// TODO Auto-generated method stub
		String result = "Hello, " + name + "!";
		if (logger.isInfoEnabled()) {
			logger.info("sayHello(String) - String result={}", result); //$NON-NLS-1$
		}
		
		return result;
	}
	
	//@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		List<User> all = new ArrayList<User>();
		for(int i = 0; i < 100; i++) {
			User user = new User();
			user.setUsername("User_" + i);
			all.add(user);
			if (logger.isInfoEnabled()) {
				logger.info("getAll() - List<User> all={}", all); //$NON-NLS-1$
			}
		}
		
		if (logger.isInfoEnabled()) {
			logger.info("getAll() - List<User> all={}", all); //$NON-NLS-1$
		}
		return all;
	}

}
