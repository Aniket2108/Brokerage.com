package com.brokerage.app.repository;

import com.brokerage.app.entities.Tenant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TenantRepository extends JpaRepository<Tenant,Long> {
}
