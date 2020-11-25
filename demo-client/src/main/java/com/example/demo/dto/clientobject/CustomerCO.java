package com.example.demo.dto.clientobject;

import lombok.Data;

import java.sql.Date;

@Data
public class CustomerCO extends AbstractCustomerCO {

    private double totalAmount;
    // ID Card Info
    private String name;
    private Date birthday;
    private String nation;
    private String idNumber;
    // Address Info
    private String street;
    private String city;
    private String state;
    private String country;
    private String zipcode;
}
