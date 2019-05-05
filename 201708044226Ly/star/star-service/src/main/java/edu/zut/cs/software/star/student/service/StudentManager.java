package edu.zut.cs.software.star.student.service;

import java.util.List;

import edu.zut.cs.software.base.service.GenericManager;
import edu.zut.cs.software.star.student.domain.Student;

public interface StudentManager extends GenericManager<Student, Long> {
	
	List<Student> getAll();

	Student findByStudentname(String studentname);
}
