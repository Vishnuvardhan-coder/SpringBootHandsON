package com.trinetra.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trinetra.model.Student;
import com.trinetra.repository.StudentRepository;

@Service
public class StudentDao {

	@Autowired StudentRepository studentRepo;
	
	
// to save
	
	public Student studentsave(Student student) {
		
		return studentRepo.save(student);
	}
	
	
// to list all
	
	
	public List<Student> getAllStudents(){
		
		return studentRepo.findAll();
	}
	
// to getByID
	
	public Student findById(Long sid) {
		
		return studentRepo.getOne(sid);
	}
	
//to delete
	
	
	public void deleteStudent(Student stud) {
		
		this.studentRepo.delete(stud);
	}
	
	
}
