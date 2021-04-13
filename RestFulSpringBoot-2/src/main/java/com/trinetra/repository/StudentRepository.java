package com.trinetra.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trinetra.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{

}
