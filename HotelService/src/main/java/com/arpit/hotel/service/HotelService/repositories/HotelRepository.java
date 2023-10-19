package com.arpit.hotel.service.HotelService.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arpit.hotel.service.HotelService.entities.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, String>{

}
