package edu.zut.cs.software.star.admin.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;


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
	

	
}
