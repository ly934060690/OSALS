package com.osals.enwrap.admin.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.osals.base.domain.BaseEntity;

/**
 * @author:
 * @Description:包裹类
 * @date:2019年5月7日 下午8:47:01
 */
@Table(name="T_ADMIN_ENWRAP")
@Entity
//@NamedQueries({@NamedQuery(name="findAllEnwrap",query="SELECT ENWRAP_ID,ENWRAP_TYPE FROM T_ADMIN_ENWRAP"),
//@NamedQuery(name="findAllAddress",query="SELECT ADDRESS_ORIGIN,ADDRESS_END FROM T_ADMIN_ENWRAP")})
public class Enwrap extends BaseEntity{
	
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public String getEnwrap_id() {
		return enwrap_id;
	}

	public void setEnwrap_id(String enwrap_id) {
		this.enwrap_id = enwrap_id;
	}

	public String getAddress_origin() {
		return address_origin;
	}

	public void setAddress_origin(String address_origin) {
		this.address_origin = address_origin;
	}

	public String getAddress_end() {
		return address_end;
	}

	public void setAddress_end(String address_end) {
		this.address_end = address_end;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Seller getSeller() {
		return seller;
	}

	public void setSeller(Seller seller) {
		this.seller = seller;
	}

	//@Id
	//@GeneratedValue
	@Column(name="ENWRAP_ID")
	private String enwrap_id;
	
	@Column(name="ENWRAP_TYPE")
	private String enwrap_type;
	
	@Column(name="ADDRESS_ORIGIN")
	private String address_origin;
	
	@Column(name="ADDRESS_END")
	private String address_end;
	
	@ManyToOne
	@JoinColumn(name = "CUSTOMER_ID")
	private Customer customer;
	
	@OneToOne
	@JoinColumn(name="SELLER_ID")
	private Seller seller;

}
