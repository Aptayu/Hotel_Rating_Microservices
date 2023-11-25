package com.arpit.user.service.external.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.arpit.user.service.entities.Rating;

@Service
@FeignClient(name = "RATING-SERVICE")
public interface RatingService {
	
//	GET
	
	
//	POST
	@PostMapping("/ratings")
	ResponseEntity<Rating> createRating(Rating values);
	
//	PUT
	@PutMapping("/ratings/{ratingId}")
	ResponseEntity<Rating> updateRating(@PathVariable("ratingId") String ratingId, Rating rating);
	
//	delete
	@DeleteMapping("/ratings/{ratingId}")
	public void deleteRating(@PathVariable String ratingId);
	
}
