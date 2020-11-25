package com.example.demo.dto;

import com.example.demo.dto.clientobject.DealInfoCO;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * 交易CommandBean
 */
@Data
public class DealAddCmd extends CommonCommand{
    @NotNull
    private DealInfoCO dealInfoCO;
}
