package edu.zut.cs.software.sun.customer.dao;

import java.util.List;

import edu.zut.cs.software.sun.customer.domain.User;

public interface UserDao {
	List<User> findAll();
}
