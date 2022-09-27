package com.frist.curd.springboot.repositary;

import org.springframework.data.jpa.repository.JpaRepository;

import com.frist.curd.springboot.model.Student;

public interface StudentRepositary extends JpaRepository<Student, Long>{

}
