package com.frist.curd.springboot.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.frist.curd.springboot.model.Student;
import com.frist.curd.springboot.service.StudentService;

@RestController
@RequestMapping("/a/students")
public class StudentController {
 
	private StudentService studentService;

	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}
	// build create REST API
	@PostMapping
	public ResponseEntity<Student> saveStudent(@RequestBody Student student){
		return new ResponseEntity<Student>(studentService.saveStudent(student),HttpStatus.CREATED);
	}
	
	// Build get all employees Rest API
	@GetMapping()
	public List<Student> getAllStudents(){
		return studentService.getAllStudents();
	}
	@GetMapping("{id}")
	public ResponseEntity<Student> getStudentId(@PathVariable("id") long id){
		return new ResponseEntity<Student>(studentService.getStudentId(id),HttpStatus.OK);
	}
	@PutMapping("{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable("id") long id,@RequestBody Student student){
		return new ResponseEntity<Student>(studentService.updateStudent(student, id),HttpStatus.OK);
	}
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable("id") long id){
		studentService.deleteStudent(id);
		return new ResponseEntity<String>("student details delete successfull",HttpStatus.OK);
		
	}
}
