package edu.zut.cs.software.sun.shop.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import edu.zut.cs.software.sun.shop.dao.ShopDao;

@Entity
@Table(name = "T_SHOP")
public class Shop  extends BaseEntity implements ShopDao{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4539046592460664289L;

	@Column(name = "T_NO")
	String no;
	
	@Column(name = "T_NAME")
	String name;

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

}
