package edu.zut.cs.software.osals.admin.service;

import edu.zut.cs.software.base.service.GenericManager;
import edu.zut.cs.software.osals.admin.domain.User;

import java.util.List;

public interface UserManager extends GenericManager<User, Long> {

	List<User> findAll();
	
	User findbyUsername(String username);

}
