package edu.zut.cs.software.admin.service;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import edu.zut.cs.software.admin.entity.User;

//import impl.UserManagerImpl;
@ContextConfiguration(locations= "classpath:applicationContext-service.xml")
public  class UserManagerTest extends AbstractJUnit4SpringContextTests  {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = LogManager.getLogger(UserManagerTest.class.getName());
	

	//UserManager userManager=new UserManagerImpl();
	
	//set×¢Èë
	UserManager userManager;
	@Autowired 
	public void setUserManger(UserManager userManger) {
		
		this.userManager=userManger;	
	}
    @Test
	public void TestsayHello() {
		// TODO Auto-generated method stub
		String expected= "Hello, world!";
      String result=this.userManager.sayHello("world");
		if (logger.isInfoEnabled()) {
			logger.info("TestsayHello() - String result={}", result); //$NON-NLS-1$
		}
      
	//	String result= userManager.sayHello("world");
		assertEquals(expected,result);
		
	}
    @Test
public void testGetAll() {
	List<User>all=this.userManager.getAll();
		if (logger.isInfoEnabled()) {
			logger.info("testGetAll() - List<User> all={}", all); //$NON-NLS-1$
		}
	
}
}
