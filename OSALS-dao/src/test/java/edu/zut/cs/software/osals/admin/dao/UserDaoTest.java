package edu.zut.cs.software.osals.admin.dao;

import edu.zut.cs.software.base.dao.GenericDaoTestCase;
import edu.zut.cs.software.osals.admin.domain.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

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
