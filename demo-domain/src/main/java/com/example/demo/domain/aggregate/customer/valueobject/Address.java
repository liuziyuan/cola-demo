package com.example.demo.domain.aggregate.customer.valueobject;

import lombok.Data;

import javax.persistence.Embeddable;

@Embeddable
@Data
public class Address {
    private String street;
    private String city;
    private String state;
    private String country;
    private String zipcode;
}
