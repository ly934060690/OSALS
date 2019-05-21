package com.osals.enwrap.admin.dao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.osals.base.dao.GenericDaoTestCase;
import com.osals.enwrap.admin.domain.Seller;

public class SellerDaoTest extends GenericDaoTestCase<Long,Seller, SellerDao>{
	/**
	 * Logger for this class
	 */

	@Autowired
	SellerDao sellerDao;

	@Test
	public void test() {
		Seller s = new Seller();
		s.setS_name("test_seller");
		Seller test_seller = this.sellerDao.save(s);
		Long seller_id = test_seller.getId();
		Seller result = this.sellerDao.getOne(seller_id);
		assertEquals(test_seller, result);
		List<Seller> all = this.sellerDao.findAll();
		if (logger.isInfoEnabled()) {
			logger.info("test() - List<Seller> all size ={}", all.size()); //$NON-NLS-1$
		}
	}
}
