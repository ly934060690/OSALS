package com.zcw.osals.student.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.zcw.osals.admin.domain.Student;
import com.zcw.osals.admin.service.StudentManager;
import com.zcw.osals.base.service.impl.GenericManagerTestCase;

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
