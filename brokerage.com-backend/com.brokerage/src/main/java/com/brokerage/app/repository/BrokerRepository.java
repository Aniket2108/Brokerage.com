package com.brokerage.app.repository;

import com.brokerage.app.entities.Broker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrokerRepository extends JpaRepository<Broker,Long> {
}
