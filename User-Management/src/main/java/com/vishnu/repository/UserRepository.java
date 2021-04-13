package com.vishnu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vishnu.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	User findByEmailIdAndPassword(String email, String pwd);

	User findByEmailId(String emailId);

}
