package com.frist.curd.springboot.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.frist.curd.springboot.model.Student;
import com.frist.curd.springboot.repositary.StudentRepositary;
import com.frist.curd.springboot.service.StudentService;

@Service
public class StudentServiceimpl implements StudentService {

	private StudentRepositary studentRepositary;

	public StudentServiceimpl(StudentRepositary studentRepositary) {
		super();
		this.studentRepositary = studentRepositary;
	}

	@Override
	public Student saveStudent(Student student) {
		return studentRepositary.save(student);
	}

	@Override
	public List<Student> getAllStudents() {
		return studentRepositary.findAll();
	}

}
