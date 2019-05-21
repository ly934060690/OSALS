package com.zut.superior.admin.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.zut.superior.admin.service.UserManager;

@ContextConfiguration ( locations = {"classpath:applicationContextTest-service.xml"} )
public class UserManagerTest extends AbstractJUnit4SpringContextTests {
	//UserManager userManager = new UserManagerImpl();
	UserManager userManager;
	
	@Autowired
	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}
	
	@Test
	public void testSayHello() {
		// TODO Auto-generated method stub
		String expected = "Hello, world!";
		String result = this.userManager.sayHello(" world");
		assertEquals(expected, result);
		//fail("Not yet implemented");
	}

}
