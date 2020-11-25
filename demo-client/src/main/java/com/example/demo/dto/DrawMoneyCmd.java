package com.example.demo.dto;

import com.example.demo.dto.clientobject.TransactionCO;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class DrawMoneyCmd extends CommonCommand {

    @NotNull
    private TransactionCO transactionCO;
}
