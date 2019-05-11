package com.zcw.osals.admin.service;

import java.util.List;

import com.zcw.osals.admin.domain.User;

public interface UserManager {

	String sayHello(String name);

	List<User> getAll();
}
