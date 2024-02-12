package com.brokerage.app.service;

import com.brokerage.app.custom_exceptions.BrokerNotFoundException;
import com.brokerage.app.dto.BrokerDTO;
import com.brokerage.app.dto.BrokerDTOResponse;
import com.brokerage.app.entities.Broker;

import java.util.List;

public interface BrokerService {
    List<BrokerDTOResponse> getAllBrokerList();
    BrokerDTOResponse addNewBroker(BrokerDTO broker);

    BrokerDTOResponse getBrokerByMobileNumber(Long mobile) throws BrokerNotFoundException;

    String changePassword(Long mobile,String newPass);

    Boolean brokerLogin(Long mobile,String password);
}
