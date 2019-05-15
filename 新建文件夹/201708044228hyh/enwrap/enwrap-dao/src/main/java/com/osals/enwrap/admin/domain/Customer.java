package com.osals.enwrap.admin.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.osals.base.domain.BaseTreeEntity;

/**
 * @author:
 * @Description:客户类
 * @date:2019年5月7日 下午8:46:06
 */
@Table(name="T_ADMIN_CUSTOMER")
@Entity
//@NamedQuery(name = "", query = "")
public class Customer extends BaseTreeEntity<Customer>{

	public String getC_name() {
		return c_name;
	}

	public void setC_name(String c_name) {
		this.c_name = c_name;
	}

	public String getC_telephone() {
		return c_telephone;
	}

	public void setC_telephone(String c_telephone) {
		this.c_telephone = c_telephone;
	}

	public Set<Enwrap> getEnwraps() {
		return enwraps;
	}

	public void setEnwraps(Set<Enwrap> enwraps) {
		this.enwraps = enwraps;
	}

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	
	//@Id
	//@GeneratedValue
	@Column(name="C_NAME")
	private String c_name;
	
	@Column(name="C_TELEPHONE")
	private String c_telephone;
	
	@OneToMany(mappedBy = "customer", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
	Set<Enwrap> enwraps;

}
