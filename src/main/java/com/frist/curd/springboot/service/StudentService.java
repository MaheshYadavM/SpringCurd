package com.frist.curd.springboot.service;

import java.util.List;

import com.frist.curd.springboot.model.Student;

public interface StudentService {
	Student saveStudent(Student student);
	List<Student> getAllStudents();
	Student getStudentId(long id);
	Student updateStudent(Student student,long id);
	void deleteStudent(long id);
}
