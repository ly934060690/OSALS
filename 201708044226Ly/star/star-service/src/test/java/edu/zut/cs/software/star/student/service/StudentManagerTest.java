package edu.zut.cs.software.star.student.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import edu.zut.cs.software.star.student.domain.Student;

@ContextConfiguration(locations = { "classpath:applicationContextTest-service.xml" })
public class StudentManagerTest extends AbstractJUnit4SpringContextTests {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = LogManager.getLogger(StudentManagerTest.class.getName());

	StudentManager studentManager;

	@Autowired
	public void setStudentManager(StudentManager studentManager) {
		this.studentManager = studentManager;
	}
	
	@Test
	public void testGetAll() {
		List<Student> all = this.studentManager.getAll();
		if (logger.isInfoEnabled()) {
			logger.info("testGetAll() - List<Student> all={}", all); //$NON-NLS-1$
		}

		assertNotNull(all);
		assertEquals(71, all.size());

	}
}
