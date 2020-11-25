package com.example.demo.dto;

import com.example.demo.dto.clientobject.ConsumeCO;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class ConsumeAddCmd extends CommonCommand {
    @NotNull
    private ConsumeCO payer;
    @NotNull
    private ConsumeCO payee;
    @NotNull
    private double amount;


}
