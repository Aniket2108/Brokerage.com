package com.rentup.RentUp.services;

import java.util.List;
import java.util.stream.Collectors;

import com.rentup.RentUp.dto.PropertyDTO;
import com.rentup.RentUp.entities.Property;
import com.rentup.RentUp.mapper.PropertyMapper;
import com.rentup.RentUp.repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PropertyServiceImpl implements PropertyService {
    @Autowired
    private PropertyRepository propertyRepository;

    @Autowired
    private PropertyMapper propertyMapper;

    @Override
    public List<PropertyDTO> getAllProperties() {
        List<Property> properties = propertyRepository.findAll();
        properties.forEach(property-> property.getArea().getCity());
        return properties.stream()
                .map(propertyMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public PropertyDTO getPropertyById(Integer id) {
        Property propertyOptional = propertyRepository.findById(id).orElseThrow();

        return propertyMapper.toDTO(propertyOptional);

    }

    @Override
    public PropertyDTO saveProperty(PropertyDTO propertyDTO) {
        Property property = propertyMapper.toEntity(propertyDTO);
        Property savedProperty = propertyRepository.save(property);
        return propertyMapper.toDTO(savedProperty);
    }

    @Override
    public void deleteProperty(Integer id) {
        propertyRepository.deleteById(id);
    }
}

