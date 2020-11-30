package com.example.demo.domain.aggregate.customer.repository;

import com.example.demo.domain.aggregate.customer.entity.Customer;

public interface CustomerRepository {
    void save(Customer customer);
    void update(Customer customer);
    Customer getByCustomerId(Long id);
}
