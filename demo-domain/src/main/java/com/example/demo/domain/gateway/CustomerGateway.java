package com.example.demo.domain.gateway;

import com.example.demo.domain.aggregate.customer.entity.Customer;

public interface CustomerGateway {
    void save(Customer customer);
    void update(Customer customer);
    Customer getByCustomerId(Long id);
}
