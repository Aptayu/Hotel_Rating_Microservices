package com.arpit.hotel.service.HotelService.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "Hotel")
public class Hotel {
	
	@Id
	private String hotelId;
	private String hotelName;
	private String location;
	private String about;
	
}
