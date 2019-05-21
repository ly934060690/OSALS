package com.osals.enwrap.admin.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.osals.base.domain.BaseEntity;

/**
 * @author:
 * @Description:卖家类
 * @date:2019年5月7日 下午8:46:35
 */
@Table(name="T_ADMIN_SELLER")
@Entity
//@NamedQuery(name="findAllSeller",query="SELECT S_NAME,S_TELEPHONE FROM T_ADMIN_SELLER")
public class Seller extends BaseEntity{
	
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public String getS_name() {
		return s_name;
	}

	public void setS_name(String s_name) {
		this.s_name = s_name;
	}

	public String getS_telephone() {
		return s_telephone;
	}

	public void setS_telephone(String s_telephone) {
		this.s_telephone = s_telephone;
	}

	//@Id
	//@GeneratedValue
	@Column(name="S_NAME")
	private String s_name;
	
	@Column(name="S_TELEPHONE")
	private String s_telephone;

}
