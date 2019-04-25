package edu.zut.cs.software.star.admin.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import edu.zut.cs.software.base.domain.BaseEntity;
import edu.zut.cs.software.star.admin.dao.RoleDao;

@Entity
@Table(name = "T_ADMIN_ROLE")
public class Role extends BaseEntity implements RoleDao {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name = "NAME")
	String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	
	
	

}
