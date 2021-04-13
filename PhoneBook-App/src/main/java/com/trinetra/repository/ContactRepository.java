package com.trinetra.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trinetra.entity.Contact;

public interface ContactRepository extends JpaRepository<Contact,Integer>{
	
	public List<Contact> findByActiveSwitch(String activeSw);

}
