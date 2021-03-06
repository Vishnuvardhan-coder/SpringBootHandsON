package com.vishnu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vishnu.entity.State;

public interface StateRepository extends JpaRepository<State, Integer> {

	List<State> findByCountryId(Integer countryId);

}
