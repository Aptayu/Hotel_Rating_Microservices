package com.arpit.user.service.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arpit.user.service.entities.User;
import com.arpit.user.service.exceptions.ResourceNotFoundException;
import com.arpit.user.service.repositories.UserRepository;
import com.arpit.user.service.services.UserService;

import antlr.collections.List;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepo;

	@Override
	public User saveUser(User user) {
		// TODO Auto-generated method stub
		return userRepo.save(user);
		
	}

	@Override
	public List getAllUser() {
		// TODO Auto-generated method stub
		return (List) userRepo.findAll();
	}

	@Override
	public User getUser(String userId) {
		// TODO Auto-generated method stub
		return userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User is not found with given id  "+ userId ));
	}

}
