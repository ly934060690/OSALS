package edu.zut.cs.network.example.teach.dao;

import java.util.List;

import edu.zut.cs.network.example.teach.entity.Student;

public interface StudentDao {

	Student create(Student student);

	List<Student> findByName(String name);

	Student update(Student student);

	int remove(Student student);

	Student findById(Long Id);

}
