package edu.zut.cs.software.OSALS.shop.domain;

import edu.zut.cs.software.OSALS.commodity.domain.Commodity;
import edu.zut.cs.software.base.domain.BaseTreeEntity;

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
@NamedQueries({ @NamedQuery(name = "Shop.getRoot", query = "select s from Shop s where s.parent is null") })
public class Shop extends BaseTreeEntity<Shop> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1017387340500414123L;
	
	@Column(name = "NAME")
	String name;
	
	@OneToMany(mappedBy = "shop", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
	Set<Commodity> commodities;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

}
