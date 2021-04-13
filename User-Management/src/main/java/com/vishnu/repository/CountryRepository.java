package com.vishnu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vishnu.entity.Country;

public interface CountryRepository extends JpaRepository<Country, Integer>{

}
