package com.arpit.user.service.services;

import com.arpit.user.service.entities.User;

import java.util.*;

public interface UserService {

//	create
	User saveUser(User user);
	
//Read(Get)
	
	List<User> getAllUser();
//	get single user
	User getUser(String userId);
	
// update
	
// Delete
	
	
	
}
