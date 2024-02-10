package com.brokerage.app.service;

import com.brokerage.app.custom_exceptions.TenantNotFoundException;
import com.brokerage.app.dto.TenantDTO;
import com.brokerage.app.dto.TenantDTOResponse;
import com.brokerage.app.entities.Tenant;
import com.brokerage.app.repository.TenantRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class TenantServiceImpl implements TenantService{

    @Autowired
    private TenantRepository tenantRepo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public TenantDTOResponse addNewTenant(TenantDTO tenant) {
        Tenant tenantEntity = mapper.map(tenant,Tenant.class);
        tenantRepo.save(tenantEntity);
        return mapper.map(tenantEntity,TenantDTOResponse.class);
    }

    @Override
    public TenantDTOResponse getBrokerByMobileNumber(Long mobile) throws TenantNotFoundException {
        Tenant tenant;
        try{
            tenant = tenantRepo.findById(mobile).orElseThrow(()->new TenantNotFoundException("No tenant found with mobile number:"+mobile));
        }
        catch (Exception e){
            return null;
        }
        return mapper.map(tenant,TenantDTOResponse.class);
    }
}
