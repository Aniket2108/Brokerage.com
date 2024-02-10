package com.brokerage.app.controller;

import com.brokerage.app.dto.TenantDTO;
import com.brokerage.app.dto.TenantDTOResponse;
import com.brokerage.app.service.TenantService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tenants")
@CrossOrigin(origins = "http://localhost:3000")
public class TenantController {

    @Autowired
    private TenantService tenantService;

    @GetMapping("/{mobile}")
    public ResponseEntity<?> getTenantByMobileNumber(@PathVariable Long mobile){
        try {
            TenantDTOResponse tenant = tenantService.getBrokerByMobileNumber(mobile);
            if (tenant == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tenant not found for mobile number: " + mobile);
            }
            return ResponseEntity.status(HttpStatus.OK).body(tenant);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal server error");
        }
    }

    @PostMapping("/signup")
    public ResponseEntity<?> addNewBroker(@RequestBody @Valid TenantDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(tenantService.addNewTenant(dto));
    }
}
