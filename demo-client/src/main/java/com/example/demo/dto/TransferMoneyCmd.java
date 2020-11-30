package com.example.demo.dto;

import com.example.demo.dto.clientobject.AccountNoCO;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class TransferMoneyCmd extends CommonCommand{
    @NotNull
    private AccountNoCO payer;
    @NotNull
    private AccountNoCO payee;
    @NotNull
    private double amount;
}
