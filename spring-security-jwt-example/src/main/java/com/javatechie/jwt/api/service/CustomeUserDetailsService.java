package com.javatechie.jwt.api.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.javatechie.jwt.api.entity.Users;
import com.javatechie.jwt.api.repository.UserRepository;

@Service
public class CustomeUserDetailsService implements UserDetailsService
{
	@Autowired
	private UserRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users users = repository.findByUserName(username);
		return new User(users.getUserName(),users.getPassword(),new ArrayList<>());
		
	}

}
