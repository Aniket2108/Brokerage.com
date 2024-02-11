package com.brokerage.app.service;

import com.brokerage.app.dto.PropertyDTO;
import com.brokerage.app.dto.PropertyDTOResponse;
import com.brokerage.app.entities.Property;
import com.brokerage.app.repository.PropertyRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class PropertyServiceIml implements PropertyService{

    @Autowired
    private PropertyRepository propertyRepo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public List<PropertyDTOResponse> getAllProperties() {
        List<Property> properties = propertyRepo.findAll();
        return properties.stream().map(property -> mapper.map(property,PropertyDTOResponse.class)).collect(Collectors.toList());
    }

    @Override
    public PropertyDTOResponse addNewProperty(PropertyDTO dto) {
        Property propertyEntity = mapper.map(dto,Property.class);
        propertyRepo.save(propertyEntity);
        return mapper.map(propertyEntity,PropertyDTOResponse.class);
    }
}
