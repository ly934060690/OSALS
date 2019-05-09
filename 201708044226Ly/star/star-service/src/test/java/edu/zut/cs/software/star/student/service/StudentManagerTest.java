package edu.zut.cs.software.star.student.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import edu.zut.cs.software.base.service.GenericManagerTestCase;
import edu.zut.cs.software.star.student.domain.Student;

public class StudentManagerTest extends GenericManagerTestCase<Long, Student, StudentManager> {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = LogManager.getLogger(StudentManagerTest.class.getName());

	
	StudentManager studentManager;

	public StudentManagerTest() {
		super(Student.class);
	}

	@Autowired
	public void setStudentManager(StudentManager studentManager) {
		this.studentManager = studentManager;
		this.manager = this.studentManager;
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
