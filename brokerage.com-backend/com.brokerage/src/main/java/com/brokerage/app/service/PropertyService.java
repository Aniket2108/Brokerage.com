package com.brokerage.app.service;

import com.brokerage.app.dto.PropertyDTO;
import com.brokerage.app.dto.PropertyDTOResponse;

import java.util.List;

public interface PropertyService {

    List<PropertyDTOResponse> getAllProperties();

    PropertyDTOResponse addNewProperty(PropertyDTO dto);



}
