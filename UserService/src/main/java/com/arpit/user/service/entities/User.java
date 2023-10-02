package com.arpit.user.service.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_details")
public class User {
	
	@Id
	@Column(name = "USER_ID")
	private String userId;
	
	@Column(name = "USER_NAME")
	private String name;
	
	@Column(name = "USER_EMAIL")
	private String email;
	
	@Column(name = "USER_ABOUT")
	private String about;
	
}
