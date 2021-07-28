package com.javatechie.jwt.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javatechie.jwt.api.entity.Users;


public interface UserRepository extends JpaRepository <Users, Integer>
{

	Users findByUserName(String username);

	

}
