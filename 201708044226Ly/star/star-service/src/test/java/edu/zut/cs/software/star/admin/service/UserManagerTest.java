package edu.zut.cs.software.star.admin.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import edu.zut.cs.software.star.admin.service.entity.User;

@ContextConfiguration ( locations = {"classpath:applicationContextTest-service.xml"} )
public class UserManagerTest extends AbstractJUnit4SpringContextTests {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = LogManager.getLogger(UserManagerTest.class.getName());

	UserManager userManager;

	@Autowired
	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}
	
	@Test
	public void testSayHello() {
		// TODO Auto-generated method stub
		String expected = "Hello, world!";
		String result = this.userManager.sayHello("world");
		if (logger.isInfoEnabled()) {
			logger.info("testSayHello() - String result={}", result); //$NON-NLS-1$
		}

		assertEquals(expected, result);
		//fail("Not yet implemented");
	}
	
	@Test
	public void testGerAll() {
		List<User> all = this.userManager.getAll();
		if (logger.isInfoEnabled()) {
			logger.info("testGerAll() - List<User> all={}", all); //$NON-NLS-1$
		}

		assertNotNull(all);
		assertEquals(100, all.size());
		
	}
	
}
