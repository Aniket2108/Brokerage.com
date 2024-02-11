package com.brokerage.app.controller;

import com.brokerage.app.dto.BrokerDTO;
import com.brokerage.app.dto.BrokerDTOResponse;
import com.brokerage.app.service.BrokerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/brokers")
@CrossOrigin(origins = "http://localhost:3000")
public class BrokerController {

    @Autowired
    private BrokerService brokerService;

    @GetMapping("/")
    public ResponseEntity<?> getAllBrokers(){
        List<BrokerDTOResponse> brokers = brokerService.getAllBrokerList();
        if(brokers.isEmpty()){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(brokers);
        }
        return ResponseEntity.status(HttpStatus.OK).body(brokers);
    }

    @GetMapping("/{mobile}")
    public ResponseEntity<?> getBrokerByMobileNumber(@PathVariable Long mobile){
        try {
            BrokerDTOResponse broker = brokerService.getBrokerByMobileNumber(mobile);
            if (broker == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Broker not found for mobile number: " + mobile);
            }
            return ResponseEntity.status(HttpStatus.OK).body(broker);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal server error");
        }
    }
    @PostMapping("/signup")
    public ResponseEntity<?> addNewBroker(@RequestBody @Valid BrokerDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(brokerService.addNewBroker(dto));
    }

    @PutMapping("/{mobile}/{newPass}")
    public ResponseEntity<?> changePassword(@PathVariable Long mobile, @PathVariable String newPass){

        if(brokerService.changePassword(mobile,newPass) == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Broker not found for mobile number: " + mobile);
        }
        return ResponseEntity.status(HttpStatus.OK).body("Password Updated Successfully!!!");
    }
}
