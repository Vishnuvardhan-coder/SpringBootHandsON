package com.trinetra.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.CollectionUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trinetra.dao.StudentDao;
import com.trinetra.model.Student;

@RestController
@RequestMapping("/company")
public class StudentController {

	@Autowired StudentDao studentDao;
	
	// to save
	
	@PostMapping("/students")
	public Student saveStudent(@RequestBody Student s) {
		
		return studentDao.studentsave(s);
	}
	
	// to list all
	
	
	@GetMapping("/students")
	public List getAll(){
		
		return studentDao.getAllStudents();
	}
	
	
	// to get one
	
	@GetMapping("/students/{id}")
	public ResponseEntity<Student> getOneStudent(@PathVariable(value = "id") Long id) {
		
		Student student =  studentDao.findById(id);
		
		if(student==null) {
			
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok().body(student);
	}
	
	
	// to update student
	
	@PutMapping("/students/{id}")
	public ResponseEntity<Student> update(@RequestBody Student student , @PathVariable Long id) {
		
		Student stud = studentDao.findById(id);
		
		if(stud == null) {
			
			return ResponseEntity.notFound().build();
		}
		
		stud.setName(student.getName());
		stud.setDesignation(student.getDesignation());
		stud.setExpertise(student.getExpertise());
		
		Student updateStudent = studentDao.studentsave(stud);
		
		return ResponseEntity.ok().body(updateStudent);
		// return ResponseEntity.ok("updated Suceesfully");
		 
	}
	
	
	// delete student
	@DeleteMapping("/students/{id}")
	public ResponseEntity<Object> deleteStudent(@PathVariable (value = "id") Long id) {
		
		Student stu = studentDao.findById(id);
		
		if(stu == null) {
			
			return ResponseEntity.notFound().build();
		}
		
		studentDao.deleteStudent(stu);
		
		return ResponseEntity.ok().build();
		
	}
	
	
	
	
}
