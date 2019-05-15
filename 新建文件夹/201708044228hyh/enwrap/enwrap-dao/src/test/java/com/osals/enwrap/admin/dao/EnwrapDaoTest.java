package com.osals.enwrap.admin.dao;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.osals.base.dao.GenericDaoTestCase;
import com.osals.enwrap.admin.domain.Enwrap;

public class EnwrapDaoTest extends  GenericDaoTestCase<Long, Enwrap, EnwrapDao>{
	/**
	 * Logger for this class
	 */
	private static final Logger logger = LogManager.getLogger(EnwrapDaoTest.class.getName());

	@Autowired
	EnwrapDao userDao;

	@Test
	public void testFindAll() {

		List<Enwrap> result = this.userDao.findAll();
		if (logger.isInfoEnabled()) {
			logger.info("testFindAll() - List<Enwrap> result={}", result); //$NON-NLS-1$
		}

	}
}
