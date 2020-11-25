package com.example.demo.domain.aggregate.customer.factory;

import com.example.demo.domain.aggregate.customer.entity.Customer;
import com.example.demo.domain.aggregate.customer.valueobject.Address;
import com.example.demo.domain.aggregate.customer.valueobject.IdentityCard;

public class CustomerFactory {
    public static Customer getCustomer() {
        Customer customer = new Customer();
        IdentityCard identityCard = new IdentityCard();
        Address address = new Address();
        identityCard.setAddress(address);
        customer.setIdInfo(identityCard);
        return customer;
    }
}
