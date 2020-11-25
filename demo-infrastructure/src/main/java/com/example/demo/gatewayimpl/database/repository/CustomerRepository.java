package com.example.demo.gatewayimpl.database.repository;

import com.example.demo.domain.aggregate.customer.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
