package edu.zut.cs.software.osals.shop.domain;

import edu.zut.cs.software.base.domain.BaseTreeEntity;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.util.Set;

/**
 * 商店类
 * 商店 -- 商品：OneToMany
 * @author 研哥哥
 *
 */
@Entity
@Table(name = "T_SHOP")
@Proxy(lazy = false)
@NamedQueries({ @NamedQuery(name = "Shop.getRoot", query = "select s from Shop s where s.parent is null") })
public class Shop extends BaseTreeEntity<Shop> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1017387340500414123L;

	@Column(name = "CODE")
	String code;
	@Column(name = "NAME")
	String name;

	@OneToMany(mappedBy = "shop", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
	Set<Commodity> commodities;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Commodity> getCommodities() {
		return commodities;
	}

	public void setCommodities(Set<Commodity> commodities) {
		this.commodities = commodities;
	}

}
