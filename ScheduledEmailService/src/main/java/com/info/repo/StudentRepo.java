package com.info.repo;

import org.springframework.data.repository.CrudRepository;

import com.info.model.Student;

public interface StudentRepo extends CrudRepository<Student,Integer>{

}
