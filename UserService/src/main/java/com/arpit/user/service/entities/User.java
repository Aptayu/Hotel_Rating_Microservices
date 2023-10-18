package com.arpit.user.service.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "user_details")
@Getter
@Setter@NoArgsConstructor
@AllArgsConstructor@Builder
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
	
	@Transient
	private List<Rating> ratings = new ArrayList<>();
}
