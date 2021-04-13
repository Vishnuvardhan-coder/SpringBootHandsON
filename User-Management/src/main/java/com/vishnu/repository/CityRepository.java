package com.vishnu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vishnu.entity.City;

public interface CityRepository extends JpaRepository<City, Integer> {

	List<City> findByStateId(Integer stateId);


}
