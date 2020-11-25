package com.example.demo.dto.clientobject;

import lombok.Data;

@Data
public class DealInfoCO {
    private String accountNo;
    private double amount;
    private int accountOperationTypeCode;
}
