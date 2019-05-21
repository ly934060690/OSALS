package edu.zut.cs.software.star.admin.dao;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import edu.zut.cs.software.base.dao.GenericDaoTestCase;
import edu.zut.cs.software.star.admin.domain.User;

/**
 * 
 * @author 研哥哥
 *
 */
public class UserDaoTest extends GenericDaoTestCase<Long, User, UserDao> {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = LogManager.getLogger(UserDaoTest.class.getName());
	
	@Autowired
	UserDao userDao;
	
	@Test
	public void testFindAll() {
		
		List<User> all = this.userDao.findAll();
		if (logger.isInfoEnabled()) {
			logger.info("testFindAll() - List<User> all={}", all); //$NON-NLS-1$
		}
		
		
	}
	
}
