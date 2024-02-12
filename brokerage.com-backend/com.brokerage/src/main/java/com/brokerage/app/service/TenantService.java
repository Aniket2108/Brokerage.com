package com.brokerage.app.service;

import com.brokerage.app.custom_exceptions.TenantNotFoundException;
import com.brokerage.app.dto.TenantDTO;
import com.brokerage.app.dto.TenantDTOResponse;

public interface TenantService {
    TenantDTOResponse addNewTenant(TenantDTO tenant);

    String changePassword(Long mobile,String newPass);

    Boolean tenantLogin(Long mobile,String password);

    TenantDTOResponse getTenantByMobileNumber(Long mobile) throws TenantNotFoundException;
}
