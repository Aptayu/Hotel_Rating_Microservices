package com.arpit.user.service.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.arpit.user.service.entities.Hotel;
import com.arpit.user.service.entities.Rating;
import com.arpit.user.service.entities.User;
import com.arpit.user.service.exceptions.ResourceNotFoundException;
import com.arpit.user.service.repositories.UserRepository;
import com.arpit.user.service.services.UserService;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private RestTemplate restTemplate;
	
	private Logger logger =  LoggerFactory.getLogger(UserServiceImpl.class);

	@Override
	public User saveUser(User user) {
//		lets generate ID
		String randomUserId = UUID.randomUUID().toString();
		user.setUserId(randomUserId);
		return userRepo.save(user);
		
	}

	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return userRepo.findAll();
	}

	@Override
	public User getUser(String userId) {
		// TODO Auto-generated method stub
		User user = userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User is not found with given id  "+ userId ));
//		fetch rating from rating service for that user
//		http://localhost:8083/ratings/users/16019b5b-dbb3-4828-bf1c-f2ba6092aec8
//		lets try with rest template, to autowire you need to have it's bean which you should make in cofig file
//		or declare bean in main class with @SpringBootApplication annotation whiohc is one config class also
		Rating[] ratingsOfUser = restTemplate.getForObject("http://localhost:8083/ratings/users/" + user.getUserId(), Rating[].class);
		logger.info("rating of user: []", ratingsOfUser);
		
		List<Rating> listOfRatingsOfUser = Arrays.asList(ratingsOfUser);
		
//		add hotel details to the rating
		listOfRatingsOfUser = listOfRatingsOfUser.stream().map(rating -> {
//			api call to hotel service to get Hotel from hotel Id
//			http://localhost:8082/hotels/1494dfd8-aeeb-4c49-94b4-88f28901351f
			logger.info("hotel id = " + rating.getHotelId());
			
			ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://localhost:8082/hotels/" + rating.getHotelId(), Hotel.class);
			
			Hotel hotel = forEntity.getBody();
			
			logger.info("response status code: {}", forEntity.getStatusCode());
//			set the hotel to rating
			rating.setHotel(hotel);
//			return new Rating
			return rating;
		}).collect(Collectors.toList());
//		set rating with hotel details to user api
		user.setRatings(listOfRatingsOfUser);
		

		return user;
	}

}
