package edu.zut.cs.software.sun.admin.dao;

import java.util.List;

import edu.zut.cs.software.sun.admin.domain.User;

public interface UserDao {
	List<User> findAll();
}
