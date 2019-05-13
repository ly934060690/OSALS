package com.zcw.osals.admin.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.zcw.osals.base.domain.BaseTreeEntity;

@Table(name = "T_ADMIN_GROUP")
@Entity
// JPQL的命名查询
@NamedQueries({ @NamedQuery(name = "Group.getRoot", query = "select g from Group g where g.parent is null") })

public class Group extends BaseTreeEntity<Group> {

	/**
	 * 用来表明实现序列化类的不同版本间的兼容性,序列化时为了保持版本的兼容性，即在版本升级时反序列化仍保持对象的唯一性
	 */
	private static final long serialVersionUID = -5897273939747363395L;

	// ???怎么来的 -----
	// private static final long serialVersionUID = -1751952224371998469L;

	/*
	 * @Id private Long id;
	 */

	@Column(name = "NAME")
	String name;
	// 如果 mappedby指向 User 那么修改一个 Group对象要修改多个User那个很麻烦；
	// 所以我们一般都指定 mappedby Group 也就是当修改User关联修改 Group 这样的代价是最小的
	// 对users对象中的属性group将发生映射
	@OneToMany(mappedBy = "group", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
	Set<User> users;

	/*
	 * public Long getId() { return id; }
	 * 
	 * public void setId(Long id) { this.id = id; }
	 */

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
