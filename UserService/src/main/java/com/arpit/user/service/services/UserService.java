package com.arpit.user.service.services;

import com.arpit.user.service.entities.User;

import antlr.collections.List;

public interface UserService {

//	create
	User saveUser(User user);
	
//Read(Get)
	
	List getAllUser();
//	get single user
	User getUser(String userId);
	
// update
	
// Delete
	
	
	
}
