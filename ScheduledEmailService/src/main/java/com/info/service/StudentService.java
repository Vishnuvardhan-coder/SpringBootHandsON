package com.info.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.info.model.Student;
import com.info.repo.StudentRepo;

@Service
public class StudentService {

	@Autowired
	private StudentRepo repo;

	public Student add(Student student) {

		return repo.save(student);
	}

	public Map<String, Object> getAll() {

		Map<String, Object> map = new HashMap<>();
		TreeMap<String, Object> lmap = new TreeMap<>();
		List<Student> alist = (List<Student>) repo.findAll();
		
		
		  alist.forEach(o->{ 
			  map.put(o.getSid().toString(), o); });
		 

		
//		  for (Student student : alist) { map.put(student.getSid().toString(),
//		  student);
//		  
//		  }
		 
		lmap.put("students", map);

		
		return lmap;
	}

}
