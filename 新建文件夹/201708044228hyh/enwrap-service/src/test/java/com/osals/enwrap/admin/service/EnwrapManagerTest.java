package com.osals.enwrap.admin.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.osals.base.service.GenericManagerTestCase;
import com.osals.enwrap.admin.domain.Enwrap;

public class EnwrapManagerTest  extends GenericManagerTestCase<Long, Enwrap, EnwrapManager>{
	
	/**
	 * Logger for this class
	 */
	private static final Logger logger = LogManager.getLogger(EnwrapManagerTest.class.getName());

	EnwrapManager enwrapManager;

	public EnwrapManagerTest() {
		super(Enwrap.class);
	}

	@Autowired
	public void setEnwrapManager(EnwrapManager enwrapManager) {
		this.enwrapManager = enwrapManager;
	}

	@Test
	public void testGetAll() {
		List<Enwrap> all = this.enwrapManager.getAll();
		assertNotNull(all);
//		assertEquals(100, all.size());
		if (logger.isInfoEnabled()) {
			logger.info("testGetAll() - List<Enwrap> all={}", all); //$NON-NLS-1$
		}
	}

	@Test
	public void testSayHello() {
		String expected = "Hello, world!";
		String result = this.enwrapManager.sayHello("world");
		if (logger.isInfoEnabled()) {
			logger.info("testSayHello() - String result={}", result); //$NON-NLS-1$
		}

		assertEquals(expected, result);
	}

}
