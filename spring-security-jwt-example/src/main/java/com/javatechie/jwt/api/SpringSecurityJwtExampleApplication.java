package com.javatechie.jwt.api;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.javatechie.jwt.api.entity.Users;
import com.javatechie.jwt.api.repository.UserRepository;


@SpringBootApplication
public class SpringSecurityJwtExampleApplication {

	@Autowired
	private UserRepository repository;
	
	@PostConstruct
	public void initUsers ()
	{
		List <Users> users = Stream.of(
			new Users (101,"javatechie", "password", "mark@yahoo.com"),
			new Users (102,"user1", "pwd1", "jack@yahoo.com"),
			new Users (103,"user2", "pwd2", "sveta@yahoo.com"),
			new Users (104,"user3", "pwd3", "sasha@yahoo.com")			
		).collect(Collectors.toList());
		
		repository.saveAll(users);
		
		
	}

	
	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityJwtExampleApplication.class, args);
	}

}
