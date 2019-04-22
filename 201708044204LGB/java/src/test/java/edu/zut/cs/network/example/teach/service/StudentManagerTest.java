package edu.zut.cs.network.example.teach.service;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import edu.zut.cs.network.example.base.BaseTestCase;
import edu.zut.cs.network.example.teach.entity.Student;
import edu.zut.cs.network.example.teach.service.impl.StudentManagerImpl;

public class StudentManagerTest extends BaseTestCase {

	StudentManager studentManager;

	@Before
	public void setUp() throws Exception {
		this.studentManager = new StudentManagerImpl();
		String student_data_file = "/network_2016.xlsx";
		this.studentManager.load(student_data_file);
	}

	@Test
	public void testFindByFullname() {
		String studentName = "李瑞林 ";
		List<Student> list = this.studentManager.findByName(studentName);
		logger.info(list);

	}

//	@Test
	public void testFindById() {
		Long id = Long.valueOf(1093);
		Student student = this.studentManager.findbyId(id);
		logger.info(student);
		assertNotNull(student);
	}

}
