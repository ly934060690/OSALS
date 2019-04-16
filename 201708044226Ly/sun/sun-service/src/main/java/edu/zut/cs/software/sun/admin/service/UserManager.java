package edu.zut.cs.software.sun.admin.service;

import java.util.List;

import edu.zut.cs.software.sun.admin.domain.User;


public interface UserManager {
	
	String sayHello(String name);
	
	List<User> getAll();
}
