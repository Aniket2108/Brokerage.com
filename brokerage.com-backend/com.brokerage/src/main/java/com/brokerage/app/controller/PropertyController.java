package com.brokerage.app.controller;

import com.brokerage.app.dto.PropertyDTO;
import com.brokerage.app.dto.PropertyDTOResponse;
import com.brokerage.app.service.PropertyService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/property")
@CrossOrigin(origins = "http://localhost:3000")
public class PropertyController {

    @Autowired
    private PropertyService propertyService;

    @GetMapping("/")
    public ResponseEntity<?> getAllProperties(){
        List<PropertyDTOResponse> properties = propertyService.getAllProperties();
        if(properties.isEmpty()){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(properties);
        }
        return ResponseEntity.status(HttpStatus.OK).body(properties);
    }

    @PostMapping("/")
    public ResponseEntity<?> addNewProperty(@RequestBody @Valid PropertyDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(propertyService.addNewProperty(dto));
    }
}
