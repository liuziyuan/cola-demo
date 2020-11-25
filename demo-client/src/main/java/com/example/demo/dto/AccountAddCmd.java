package com.example.demo.dto;

import com.example.demo.dto.clientobject.AccountCO;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class AccountAddCmd extends CommonCommand {
    @NotNull
    private AccountCO accountCO;
}
