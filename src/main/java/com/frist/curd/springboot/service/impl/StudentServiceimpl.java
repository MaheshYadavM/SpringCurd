package com.frist.curd.springboot.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.frist.curd.springboot.exception.ResourceNotFoundException;
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

	@Override
	public Student getStudentId(long id) {
		// TODO Auto-generated method stub
		
		  Optional<Student> student = studentRepositary.findById(id); if
		  (student.isPresent()) { return student.get(); } else { throw new
		  ResourceNotFoundException("Student", "Id", id); }
		 
//return studentRepositary.findById(id).orElseThrow(()-> new ResourceNotFoundException("Student", "Id", id));
		
		
	}

	@Override
	public Student updateStudent(Student student, long id) {
		// TODO Auto-generated method stub
	Student student2=	studentRepositary.findById(id).orElseThrow(()-> new ResourceNotFoundException("Student", "Id", id));
	student2.setFristName(student.getFristName());
	student2.setLastName(student.getLastName());
	student2.setEmail(student.getEmail());
	studentRepositary.save(student2);
	
		return student2;
	}

	@Override
	public void deleteStudent(long id) {
		studentRepositary.findById(id).orElseThrow(()-> new ResourceNotFoundException("Student", "Id", id));
	 studentRepositary.deleteById(id);
	}

}
