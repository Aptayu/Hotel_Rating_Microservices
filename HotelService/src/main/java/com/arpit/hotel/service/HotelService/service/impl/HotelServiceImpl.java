package com.arpit.hotel.service.HotelService.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arpit.hotel.service.HotelService.entities.Hotel;
import com.arpit.hotel.service.HotelService.exceptions.ResourceNotFoundException;
import com.arpit.hotel.service.HotelService.repositories.HotelRepository;
import com.arpit.hotel.service.HotelService.service.HotelService;

@Service
public class HotelServiceImpl implements HotelService{
	
	@Autowired
	private HotelRepository hotelRepo;

	@Override
	public Hotel createHotel(Hotel hotel) {
		// TODO Auto-generated method stub
//		generate id
		String randomUUID = UUID.randomUUID().toString();
		hotel.setHotelId(randomUUID);
		return hotelRepo.save(hotel);
	}

	@Override
	public List<Hotel> getAllHotel() {
		// TODO Auto-generated method stub
		return hotelRepo.findAll();
	}

	@Override
	public Hotel getHotel(String hotel_Id) {
		// TODO Auto-generated method stub
		return hotelRepo.findById(hotel_Id).orElseThrow(() -> new ResourceNotFoundException("hotel is not found with given id"));
	}

}
