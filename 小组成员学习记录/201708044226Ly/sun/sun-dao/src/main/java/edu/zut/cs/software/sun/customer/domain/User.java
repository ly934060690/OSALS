package edu.zut.cs.software.sun.customer.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import edu.zut.cs.software.sun.customer.dao.UserDao;

@Table(name = "T_ADMIN_USER")
@Entity
public class User implements UserDao {
	
	@Column(name = "id")
	private String id;
	
	@Column(name = "name")
	private String name;
	
	@ManyToOne
	@JoinColumn(name = "GROUP")
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
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	

}
