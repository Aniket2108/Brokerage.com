package com.brokerage.app.service;

import com.brokerage.app.custom_exceptions.BrokerNotFoundException;
import com.brokerage.app.dto.BrokerDTO;
import com.brokerage.app.dto.BrokerDTOResponse;
import com.brokerage.app.entities.Broker;
import com.brokerage.app.repository.BrokerRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class BrokerServiceImpl implements BrokerService{

    @Autowired
    private BrokerRepository brokerRepo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public List<BrokerDTOResponse> getAllBrokerList() {
        List<Broker> brokers = brokerRepo.findAll();
        return brokers.stream().map(broker -> mapper.map(broker, BrokerDTOResponse.class)).collect(Collectors.toList());
    }

    @Override
    public BrokerDTOResponse addNewBroker(BrokerDTO dto) {
        Broker brokerEntity = mapper.map(dto,Broker.class);
        brokerRepo.save(brokerEntity);
        return mapper.map(brokerEntity, BrokerDTOResponse.class);
    }

    @Override
    public BrokerDTOResponse getBrokerByMobileNumber(Long mobile){
        Broker broker;
        try{
        broker = brokerRepo.findById(mobile).orElseThrow(()->new BrokerNotFoundException("No broker found with mobile number:"+mobile));
        }
        catch (BrokerNotFoundException exception){
            return null;
        }
        return mapper.map(broker, BrokerDTOResponse.class);
    }

    @Override
    public String changePassword(Long mobile, String newPass) {
        Broker broker;
        try{
            broker = brokerRepo.findById(mobile).orElseThrow(()->new BrokerNotFoundException("No broker found with mobile number:"+mobile));
            broker.setPassword(newPass);
            brokerRepo.save(broker);
        }
        catch (BrokerNotFoundException exception) {
            return null;
        }
        return "Success";
    }
}
