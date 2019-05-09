package edu.zut.cs.software.star.admin.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.zut.cs.software.base.service.impl.GenericManagerImpl;
import edu.zut.cs.software.star.admin.dao.UserDao;
import edu.zut.cs.software.star.admin.domain.User;
import edu.zut.cs.software.star.admin.service.UserManager;

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
