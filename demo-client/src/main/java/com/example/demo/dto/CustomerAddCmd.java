package com.example.demo.dto;

import com.example.demo.dto.clientobject.CustomerCO;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class CustomerAddCmd extends CommonCommand {
    @NotNull
    private CustomerCO customerCO;
}
