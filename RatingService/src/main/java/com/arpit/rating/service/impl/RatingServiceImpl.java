package com.arpit.rating.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arpit.rating.entities.Rating;
import com.arpit.rating.repository.RatingRepository;
import com.arpit.rating.service.RatingService;

@Service
public class RatingServiceImpl implements RatingService {
	
	@Autowired
	private RatingRepository ratingRepo;
	
	@Override
	public Rating create(Rating rating) {
		// TODO Auto-generated method stub
		return ratingRepo.save(rating);
	}

	@Override
	public List<Rating> getAllRatings() {
		// TODO Auto-generated method stub
		
		return ratingRepo.findAll();
	}

	@Override
	public List<Rating> getRatingByUserId(String userId) {
//		get from custom find method
		return ratingRepo.findByUserId(userId);
	}

	@Override
	public List<Rating> getRatingByHotelId(String hotelId) {
//		get from custom find method
		return ratingRepo.findByHotelId(hotelId);
	}

}
