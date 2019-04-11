package edu.zut.cs.software.sun.admin.domain;

import edu.zut.cs.software.sun.admin.dao.GroupDao;

public class Group implements GroupDao {
	
	private String id;
	private String name;
	private User[] user;
	private Group[] group;
	
	public Group() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Group(String id, String name) {
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

	public User[] getUser() {
		return user;
	}

	public void setUser(User[] user) {
		this.user = user;
	}

	public Group[] getGroup() {
		return group;
	}

	public void setGroup(Group[] group) {
		this.group = group;
	}

	@Override
	public String toString() {
		return "Group [id=" + id + ", name=" + name + "]";
	}
	
	

}
