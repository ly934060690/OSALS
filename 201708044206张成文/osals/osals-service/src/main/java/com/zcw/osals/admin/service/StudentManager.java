package com.zcw.osals.admin.service;

import java.util.List;

import com.zcw.osals.admin.domain.Student;
import com.zcw.osals.base.service.impl.GenericManager;

public interface StudentManager extends GenericManager<Student, Long> {

	List<Student> getAll();

	Student findByStudentname(String studentname);
}
