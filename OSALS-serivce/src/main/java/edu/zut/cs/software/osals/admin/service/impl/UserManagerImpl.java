package edu.zut.cs.software.osals.admin.service.impl;

import edu.zut.cs.software.base.service.impl.GenericManagerImpl;


import edu.zut.cs.software.osals.admin.dao.UserDao;
import edu.zut.cs.software.osals.admin.domain.User;
import edu.zut.cs.software.osals.admin.service.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
@Transactional
public class UserManagerImpl extends GenericManagerImpl<User, Long> implements UserManager {

	UserDao userDao;

	@Override
	public User findbyUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Autowired
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
		this.dao = this.userDao;
	}

}
