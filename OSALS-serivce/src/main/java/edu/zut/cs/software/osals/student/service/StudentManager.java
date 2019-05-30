package edu.zut.cs.software.osals.student.service;

import edu.zut.cs.software.base.service.GenericManager;
import edu.zut.cs.software.osals.student.domain.Student;

import java.util.List;

public interface StudentManager extends GenericManager<Student, Long> {
	
	List<Student> getAll();

	List<Student> findBySno(String sno);

	List<Student> findByName(String name);

	Boolean deleteBySno(String sno);

}
