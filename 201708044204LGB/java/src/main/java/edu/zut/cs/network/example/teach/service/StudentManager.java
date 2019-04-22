package edu.zut.cs.network.example.teach.service;

import java.util.List;

import edu.zut.cs.network.example.base.service.BaseManager;
import edu.zut.cs.network.example.teach.entity.Student;

public interface StudentManager extends BaseManager<Long, Student> {

	void load(String data_file);

	List<Student> findByName(String name);

}
