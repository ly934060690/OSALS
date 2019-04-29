package com.zcw.osals.admin.service;

import java.util.List;
import java.util.logging.LogManager;
import java.util.logging.Logger;

@ContextConfiguration(locations = { "classpath:applicationContextTest-service.xml" })
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
		String expected = "Hello, world!";
		String result = this.userManager.sayHello("world");
		if (logger.isInfoEnabled()) {
			logger.info("testSayHello() - String result={}", result); //$NON-NLS-1$
		}

		assertEquals(expected, result);
	}

	@Test
	public void testGetAll() {
		List<User> all = this.userManager.getAll();
		assertNotNull(all);
		assertEquals(100, all.size());
		if (logger.isInfoEnabled()) {
			logger.info("testGetAll() - List<User> all={}", all); //$NON-NLS-1$
		}
	}
}
