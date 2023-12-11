package com.arpit.user.service.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arpit.user.service.entities.User;
import com.arpit.user.service.entities.User.UserBuilder;
import com.arpit.user.service.services.UserService;
import com.arpit.user.service.services.impl.UserServiceImpl;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;
	private Logger logger = LoggerFactory.getLogger(UserController.class);

//	create
	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user) {
		User user1 = userService.saveUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(user1);
	}

//	get all user
	@GetMapping
	public ResponseEntity<List<User>> getAllUser() {
		List<User> allUser = userService.getAllUser();
		return ResponseEntity.ok(allUser);
	}

//	get one user
	@GetMapping("/{userId}")
	@CircuitBreaker(name = "ratingHotelBreaker", fallbackMethod = "ratingHotelFallback")
	public ResponseEntity<User> getSingleUser(@PathVariable String userId) {
//		 in the above path variable if in the mapping name was diff you should mention in bracket next to path variable
		User user = userService.getUser(userId);
		return ResponseEntity.ok(user);

	}

//	create fall back method for circuit breaker
	public ResponseEntity<User> ratingHotelFallback(String userId, Exception ex) {

		logger.info("Fall back is executed because service is down" + ex.getMessage());

		User user = User.builder().email("dummy@gmail.com").name("Dummy")
				.about("this is created beacuse some service is down").userId("123").build();

		return new ResponseEntity<>(user, HttpStatus.OK);

	}

}
