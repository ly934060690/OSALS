package edu.zut.cs.network.example.teach.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import edu.zut.cs.network.example.teach.dao.impl.StudentDaoImpl;
import edu.zut.cs.network.example.teach.entity.Student;

public class StudentDaoTest {

	protected Logger logger = LogManager.getLogger(this.getClass().getName());
	
	StudentDao studentDao;

	@Before
	public void before() {
		this.studentDao  = new StudentDaoImpl();
	}

	@Test
	public void testFindByName() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testFindById() {
		Long id = Long.valueOf(15182);
		Student student = this.studentDao.findById(id);
		logger.info(student);;
		assertNotNull(student);
		assertEquals(id, student.getId());
	}

}
