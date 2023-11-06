package com.arpit.user.service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arpit.user.service.entities.User;

public interface UserRepository extends JpaRepository<User, String> {
//	in the above method User is class for which you want to perform database operation and String is 
//	its primary key column type

	
//	make any custom method or query here as per your needs
	
}
