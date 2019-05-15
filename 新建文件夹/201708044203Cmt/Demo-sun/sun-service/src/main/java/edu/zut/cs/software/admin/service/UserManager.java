package edu.zut.cs.software.admin.service;

import java.util.List;

import edu.zut.cs.software.admin.entity.User;

public interface UserManager {
	
	public String sayHello(String name);
	List<User>getAll();

}
