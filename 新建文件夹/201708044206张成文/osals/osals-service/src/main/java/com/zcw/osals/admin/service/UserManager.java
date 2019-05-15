package com.zcw.osals.admin.service;

import java.util.List;

import com.zcw.osals.admin.domain.User;
import com.zcw.osals.base.service.impl.GenericManager;

public interface UserManager extends GenericManager<User, Long> {

	List<User> findAll();

	User findbyUsername(String username);

}
