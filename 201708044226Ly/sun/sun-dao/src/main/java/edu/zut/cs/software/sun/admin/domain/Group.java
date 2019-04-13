package edu.zut.cs.software.sun.admin.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import edu.zut.cs.software.sun.admin.dao.GroupDao;

@Table(name = "T_ADMIN_GROUP")
@Entity
@NamedQueries({ @NamedQuery(name = "Group.getRoot", query = "select g from Group g where g.parent is null") })
public class Group implements GroupDao {
	
	@Column(name = "id")
	private String id;
	
	@Column(name = "name")
	private String name;
	
	
	private User[] user;
	private Group[] group;
	
	@OneToMany(mappedBy = "group", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
	Set<User> users;
	
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
