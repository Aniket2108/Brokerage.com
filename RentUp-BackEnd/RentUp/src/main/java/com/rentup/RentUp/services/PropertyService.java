package com.rentup.RentUp.services;

import com.rentup.RentUp.dto.PropertyDTO;

import java.util.List;


public interface PropertyService {
    List<PropertyDTO> getAllProperties();
    PropertyDTO getPropertyById(Integer id);
    PropertyDTO saveProperty(PropertyDTO propertyDTO);
    void deleteProperty(Integer id);
}

