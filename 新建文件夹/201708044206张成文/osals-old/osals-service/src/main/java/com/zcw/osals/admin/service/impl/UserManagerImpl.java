package com.zcw.osals.admin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.zcw.osals.admin.dao.UserDao;
import com.zcw.osals.admin.domain.User;
import com.zcw.osals.admin.service.UserManager;
import com.zcw.osals.base.service.impl.GenericManagerImpl;

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
