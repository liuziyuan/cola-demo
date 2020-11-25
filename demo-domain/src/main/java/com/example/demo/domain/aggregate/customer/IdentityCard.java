package com.example.demo.domain.aggregate.customer;

import lombok.Data;

import javax.persistence.Embeddable;
import java.sql.Date;

@Embeddable
@Data
public class IdentityCard {
    private String name;
    private Date birthday;
    private String nation;
    private Address address;
    private String idNumber;
}
