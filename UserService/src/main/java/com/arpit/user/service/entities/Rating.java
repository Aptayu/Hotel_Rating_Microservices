package com.arpit.user.service.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Rating {
	
	private String ratingId;
	private String userId;
	private String hotelId;
	private int Rating;
	private String remark;

}
