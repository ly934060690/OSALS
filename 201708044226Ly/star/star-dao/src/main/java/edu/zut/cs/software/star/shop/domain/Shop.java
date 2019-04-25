package edu.zut.cs.software.star.shop.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import edu.zut.cs.software.base.domain.BaseTreeEntity;
import edu.zut.cs.software.star.commodity.domain.Commodity;
import edu.zut.cs.software.star.shop.dao.ShopDao;

/**
 * 商店类
 * 商店对商品：OneToMany
 * @author 研哥哥
 *
 */
@Entity
@Table(name = "T_SHOP")
@NamedQueries({ @NamedQuery(name = "Shop.getRoot", query = "select s from Shop s where s.parent is null") })
public class Shop extends BaseTreeEntity<Shop> implements ShopDao {

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
