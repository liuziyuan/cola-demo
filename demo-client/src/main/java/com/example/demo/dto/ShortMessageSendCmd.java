package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ShortMessageSendCmd {
    private String username;
    private String accountNo;
    private String accountTypeCode;
    private double amount;
}
