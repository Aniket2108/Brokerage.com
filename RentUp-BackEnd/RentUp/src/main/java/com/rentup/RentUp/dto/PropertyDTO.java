package com.rentup.RentUp.dto;


import com.rentup.RentUp.entities.Area;
import com.rentup.RentUp.entities.User;
import lombok.Data;

@Data
public class PropertyDTO {
	private Integer propertyId;

	private String propertyAddress;
	private Area areaId;
	private User userId;
	private String propertyStatus;
	private byte[] propertyImages;

	// getters and setters
}
