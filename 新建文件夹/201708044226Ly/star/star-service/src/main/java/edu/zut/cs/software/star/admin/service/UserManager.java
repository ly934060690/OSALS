package edu.zut.cs.software.star.admin.service;

import java.util.List;

import edu.zut.cs.software.base.service.GenericManager;
import edu.zut.cs.software.star.admin.domain.User;

public interface UserManager extends GenericManager<User, Long> {

	List<User> findAll();
	
	User findbyUsername(String username);

}
