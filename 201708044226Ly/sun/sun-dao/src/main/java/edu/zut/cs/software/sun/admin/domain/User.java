package edu.zut.cs.software.sun.admin.domain;

import edu.zut.cs.software.sun.admin.dao.UserDao;

public class User implements UserDao {
	
	private String id;
	private String name;
	private Group group;
	
	
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Group getGroup() {
		return group;
	}
	public void setGroup(Group group) {
		this.group = group;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + "]";
	}
	
	
	
	

}
