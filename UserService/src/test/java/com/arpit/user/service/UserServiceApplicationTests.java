package com.arpit.user.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.arpit.user.service.entities.Rating;
import com.arpit.user.service.external.services.RatingService;

@SpringBootTest
class UserServiceApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Autowired
	private RatingService ratingService;
	
	@Test
	void createRating() {
		Rating rating = Rating.builder().Rating(10).userId("").hotelId("").remark("This is created using feign client").build();
		ResponseEntity<Rating> savedRating = ratingService.createRating(rating);
		
		System.out.println("new Rating created = " + savedRating.toString());
	}
}
