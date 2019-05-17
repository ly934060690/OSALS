package edu.zut.cs.software.OSALS.admin.service;

import edu.zut.cs.software.OSALS.admin.domain.User;
import edu.zut.cs.software.base.service.GenericManager;

import java.util.List;

public interface UserManager extends GenericManager<User, Long> {

	List<User> findAll();
	
	User findbyUsername(String username);

}
