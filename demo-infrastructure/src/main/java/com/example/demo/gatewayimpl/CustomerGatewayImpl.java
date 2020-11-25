package com.example.demo.gatewayimpl;

import com.example.demo.domain.aggregate.customer.entity.Customer;
import com.example.demo.domain.gateway.CustomerGateway;
import com.example.demo.gatewayimpl.database.repository.CustomerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class CustomerGatewayImpl implements CustomerGateway {

    @Resource
    private CustomerRepository customerRepository;

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void update(Customer customer) {
        Customer customerDO = customerRepository.getOne(customer.getId());
        BeanUtils.copyProperties(customer, customerDO);
        customerRepository.save(customerDO);
    }

    @Override
    public Customer getByCustomerId(Long id) {
        return customerRepository.getOne(id);
    }
}
