package com.arpit.rating.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.arpit.rating.entities.Rating;


public interface RatingService {
	
//	create
	Rating create(Rating rating);
	
//	get all ratings
	List<Rating> getAllRatings();
	
//	get all by userID
	List<Rating> getRatingByUserId(String userId);
	
	
//	get all by hotel
	List<Rating> getRatingByHotelId(String hotelId);
}
