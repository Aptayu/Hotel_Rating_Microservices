package com.arpit.hotel.service.HotelService.service;

import java.util.List;

import com.arpit.hotel.service.HotelService.entities.Hotel;

public interface HotelService {
	
//	create hotel
	public Hotel createHotel(Hotel hotel);
	
//	get all hotel
	public List<Hotel> getAllHotel();
	
// get a single hotel
	public Hotel getHotel(String hotel_Id);
}
