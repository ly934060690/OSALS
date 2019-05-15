package edu.zut.cs.software.OSALS.admin.domain;

import edu.zut.cs.software.base.domain.BaseTreeEntity;

import javax.persistence.*;
import java.util.Set;

/**
 * OneToMany
 * Group -- User
 * @author 研哥哥
 *
 */
@Entity
@Table(name = "T_ADMIN_GROUP")
@NamedQueries({ @NamedQuery(name = "Group.getRoot", query = "select g from Group g where g.parent is null") })
public class Group extends BaseTreeEntity<Group> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8748825454057840907L;

	@Column(name = "NAME")
	String name;

	@OneToMany(mappedBy = "group", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
	Set<User> users;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
