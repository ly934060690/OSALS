package edu.zut.cs.software.star.admin.dao;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import edu.zut.cs.software.base.dao.GenericDaoTestCase;
import edu.zut.cs.software.star.admin.domain.Role;


/**
 * 
 * @author 研哥哥
 *
 */

public class RoleDaoTest extends GenericDaoTestCase<Long, Role, RoleDao> {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = LogManager.getLogger(RoleDaoTest.class.getName());
	
	@Autowired
	RoleDao roleDao;

	@Test
	public void test() {
		Role r = new Role();
		r.setName("test_role");
//		System.out.println(Date.valueOf("2019-4-28 23:10:59"));
//		r.setDateCreated(null);
//		r.setDateModified(null);
//		System.out.println(r);

		
		
		
//		this.roleDao.findAll();
		this.roleDao.save(r);
		this.roleDao.flush();
//		Role test_role = this.roleDao.save(r);
//		if (logger.isInfoEnabled()) {
//			logger.info("test() - Role test_role={}", test_role); //$NON-NLS-1$
//		}
//		Role test_role = this.roleDao.saveAndFlush(r);
//		if (logger.isInfoEnabled()) {
//			logger.info("test() - Role test_role={}", test_role); //$NON-NLS-1$
//		}
		
//		Long role_id = test_role.getId();
//		Role result = this.roleDao.getOne(role_id);
//		assertEquals(test_role, result);
		List<Role> all = this.roleDao.findAll();
		if (logger.isInfoEnabled()) {
			logger.info("test() - List<Role> all={}", all); //$NON-NLS-1$
		}

	}
	
}
